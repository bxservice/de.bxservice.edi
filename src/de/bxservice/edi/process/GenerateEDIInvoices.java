/**********************************************************************
 * This file is part of iDempiere ERP Open Source                      *
 * http://www.idempiere.org                                            *
 *                                                                     *
 * Copyright (C) Contributors                                          *
 *                                                                     *
 * This program is free software; you can redistribute it and/or       *
 * modify it under the terms of the GNU General Public License         *
 * as published by the Free Software Foundation; either version 2      *
 * of the License, or (at your option) any later version.              *
 *                                                                     *
 * This program is distributed in the hope that it will be useful,     *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of      *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the        *
 * GNU General Public License for more details.                        *
 *                                                                     *
 * You should have received a copy of the GNU General Public License   *
 * along with this program; if not, write to the Free Software         *
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,          *
 * MA 02110-1301, USA.                                                 *
 *                                                                     *
 * Contributors:                                                       *
 * - Diego Ruiz - BX Service GmbH                                      *
 **********************************************************************/
package de.bxservice.edi.process;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MClient;
import org.compiere.model.MInvoice;
import org.compiere.model.MMailText;
import org.compiere.model.MUser;
import org.compiere.model.MUserMail;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.AdempiereUserError;
import org.compiere.util.EMail;
import org.compiere.util.Env;

import de.bxservice.edi.model.EDIDocument;
import de.bxservice.edi.model.MEDIBPartner;
import de.bxservice.edi.model.MEDIFormat;

public class GenerateEDIInvoices extends SvrProcess {
	
	private static final String SUBMITTED_COLUMN_NAME = "IsEDISubmitted";
	
	private int C_BPartner_ID = 0;
	private boolean isSendMail = false;
	private int R_MailText_ID = 0;

	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++)
		{
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null);
			else if (name.equals("C_BPartner_ID"))
				C_BPartner_ID = para[i].getParameterAsInt();
			else if (name.equals("R_MailText_ID"))
				R_MailText_ID = para[i].getParameterAsInt();
			else if (name.equals("SendEMail"))
				isSendMail = para[i].getParameterAsBoolean();
		}
	}

	@Override
	protected String doIt() throws Exception {
		if (log.isLoggable(Level.INFO)) log.info("Creating EDI Invoices for =" + C_BPartner_ID);
		if (isSendMail && R_MailText_ID == 0)
			throw new AdempiereUserError ("@NotFound@: @R_MailText_ID@");
		
		MEDIFormat ediFormat =getMEDIFormat();
		List<PO> invoices = getInvoicesToProcess();
		if (invoices == null || invoices.size() == 0) {
			return "No invoices to process";
		}
 		
		EDIDocument document = new EDIDocument(invoices, ediFormat);
		String ediText = document.getDocumentInEDIFormat();
		File ediFile = createFile(ediText);
		
		if (isSendMail) {
			sendEDIFileByMail(ediFile);
		} else {
			if (processUI != null)
				processUI.download(ediFile);
		}
		
		for (PO invoice : invoices) {
			markDocumentAsEDISubmitted(invoice);
		}
		
		return "OK";
	}
	
	private MEDIFormat getMEDIFormat() {
		MEDIBPartner ediBPartner = MEDIBPartner.get(C_BPartner_ID, MInvoice.Table_ID);
		if (ediBPartner == null)
			throw new AdempiereException("No EDI Format defined for this Business Partner");
			
		return MEDIFormat.get(ediBPartner.getBXS_EDIFormat_ID());
	}
	
	private List<PO> getInvoicesToProcess() {
		String whereClause = SUBMITTED_COLUMN_NAME + " = ? AND " + MInvoice.COLUMNNAME_C_BPartner_ID + " = ? AND " +
				MInvoice.COLUMNNAME_DocStatus + "= ?";
		
		return new Query(Env.getCtx(), MInvoice.Table_Name, whereClause, get_TrxName())
				.setParameters(false, C_BPartner_ID, "CO")
				.setOnlyActiveRecords(true)
				.list();
	}
	
	private File createFile(String fileContent) {
		String fileName = "EDI_" + new Date().getTime();
		File file;
		try {
			file = File.createTempFile(fileName, ".txt");
			FileWriter myWriter = new FileWriter(file);
			myWriter.write(fileContent);
		    myWriter.close();
		} catch (IOException e) {
			throw new AdempiereException("Error creating EDI file: " + e, e);
		}

		return file;
	}
	
	private void sendEDIFileByMail(File file) {
		MMailText mText = getMMailText();
		EMail email = getConfiguredEmail(mText, file);
		String msg = email.send();
		createMailLogRecord(mText, email);

		if (msg.equals(EMail.SENT_OK)) {
			throw new AdempiereException("@RequestActionEMailOK@ - " + mText.getUser().getEMail());
		}
	}
	
	private MMailText getMMailText() {
		MMailText mText = new MMailText(getCtx(), R_MailText_ID, get_TrxName());
		MUser to = getToUser();
		mText.setBPartner(C_BPartner_ID);
		mText.setUser(to);
		
		return mText;
	}
	
	private EMail getConfiguredEmail(MMailText mText, File attachment) {
		MClient client = MClient.get(getCtx());
		String subject = mText.getMailHeader();
		
		MUser receipient = mText.getUser();
		
		EMail email = client.createEMail(receipient.getEMail(), subject, null);
		if (!email.isValid()) {
			throw new AdempiereException(" @RequestActionEMailError@ Invalid EMail: " + receipient.getName());
		}

		String message = mText.getMailText(true);
		if (mText.isHtml())
			email.setMessageHTML(subject, message);
		else {
			email.setSubject(subject);
			email.setMessageText(message);
		}
		email.addAttachment(attachment);
		
		return email;
	}
	
	private void createMailLogRecord(MMailText mText, EMail email) {
		MUserMail um = new MUserMail(mText, getAD_User_ID(), email);
		um.saveEx();
	}
	
	private MUser getToUser() {
		String whereClause = MUser.COLUMNNAME_C_BPartner_ID + " = ? AND " + MUser.COLUMNNAME_IsBillTo + " =? AND " +
				MUser.COLUMNNAME_EMail + " IS NOT NULL";
		MUser invoiceContact = new Query(Env.getCtx(), MUser.Table_Name, whereClause, get_TrxName())
				.setParameters(C_BPartner_ID, true)
				.setOnlyActiveRecords(true)
				.first();
		
		if (invoiceContact == null)
			throw new AdempiereException(" @RequestActionEMailNoTo@");
		
		return invoiceContact;
	}
	
	private void markDocumentAsEDISubmitted(PO po) {
		if (po.get_ColumnIndex(SUBMITTED_COLUMN_NAME) > 0) {
			po.set_ValueOfColumn(SUBMITTED_COLUMN_NAME, true);
			po.saveEx();
		}
	}

}
