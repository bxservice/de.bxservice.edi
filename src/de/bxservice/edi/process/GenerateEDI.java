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

import java.util.Date;

import org.compiere.model.MAttachment;
import org.compiere.model.MTable;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;

import de.bxservice.edi.model.EDIDocument;
import de.bxservice.edi.model.MEDIFormat;

public class GenerateEDI extends SvrProcess {
	
	private int EDI_Format_ID = 0;

	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++)
		{
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
				;
			else if (name.equals("BXS_EDIFormat_ID"))
				EDI_Format_ID = para[i].getParameterAsInt();
		}
	}

	@Override
	protected String doIt() throws Exception {
 		MEDIFormat ediFormat = MEDIFormat.get(EDI_Format_ID);
 		PO currentPO = getCurrentPO();
		EDIDocument document = new EDIDocument(currentPO, ediFormat);
		String fileName = addAttachment(currentPO, document.getDocumentInEDIFormat());
 		
		return fileName + " attached to the current record.";
	}
	
	private PO getCurrentPO() {
		MTable table = MTable.get(getTable_ID());
		String keyColumnName = table.getKeyColumns()[0];

		return new Query(Env.getCtx(), table.getTableName(), keyColumnName + "= ?", get_TrxName())
				.setParameters(getRecord_ID())
				.setOnlyActiveRecords(true)
				.first();
	}
	
	private String addAttachment(PO po, String fileContent) {
		MAttachment attachment = po.createAttachment();
		Date date = new Date();
		String fileName = "EDI_" + date.getTime() + ".txt";
		attachment.addEntry(fileName, fileContent.getBytes());
		attachment.save();
		
		return fileName;
	}
	
}
