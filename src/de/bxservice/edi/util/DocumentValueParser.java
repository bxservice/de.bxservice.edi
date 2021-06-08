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
package de.bxservice.edi.util;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.PO;
import org.compiere.util.Env;

import de.bxservice.edi.model.MEDIDocType;

public class DocumentValueParser {
	
	private final static String EDI_VARIABLE_PREFIX = "@EDI_";
	private final static String EDI_MESSAGE_TYPE_VARIABLE = EDI_VARIABLE_PREFIX + "MESSAGE_TYPE@";
	private final static String EDI_DOCUMENT_CODE_VARIABLE = EDI_VARIABLE_PREFIX +  "DOCUMENT_CODE@";
	private final static String EDI_SEGMENTS_NO = EDI_VARIABLE_PREFIX +  "SEGMENTS_NO@";
	private final static String EDI_BP_REFERENCE_SEQ = EDI_VARIABLE_PREFIX +  "BP_SEQ@";
	private final static String EDI_MESSAGE_NUMBER = EDI_VARIABLE_PREFIX +  "MESSAGE_NUMBER@";
	
	private MEDIDocType documentType;
	private String messageSequenceReference;
	private int lineCounter = 0;
	private int messageCounter = 0;
	
	public DocumentValueParser(MEDIDocType documentType, String messageSequenceReference) {
		this.documentType = documentType;
		this.messageSequenceReference = messageSequenceReference;
	}
	
	public String parseMessageLine(String messageTxt, PO parseableRecord) {
		if (parseableRecord == null)
			throw new AdempiereException("No valid document to parse");
		
		String parsedLine = parseEDIVariables(messageTxt);
		parsedLine = parseContextVariables(parsedLine, parseableRecord);
		lineCounter++;
		return parsedLine;
	}
	
	private String parseEDIVariables(String originalMessage) {
		if (documentType == null || !originalMessage.contains(EDI_VARIABLE_PREFIX))
			return originalMessage;
		
		String newMessage = originalMessage;
		if (originalMessage.contains(EDI_MESSAGE_TYPE_VARIABLE))
			newMessage = newMessage.replace(EDI_MESSAGE_TYPE_VARIABLE, documentType.getEDI_MessageType());
		if (originalMessage.contains(EDI_DOCUMENT_CODE_VARIABLE))
			newMessage = newMessage.replace(EDI_DOCUMENT_CODE_VARIABLE, documentType.getEDI_DocumentCode());
		if (originalMessage.contains(EDI_SEGMENTS_NO))
			newMessage = newMessage.replace(EDI_SEGMENTS_NO, String.valueOf(lineCounter+1));
		if (originalMessage.contains(EDI_BP_REFERENCE_SEQ))
			newMessage = newMessage.replace(EDI_BP_REFERENCE_SEQ, messageSequenceReference);
		if (originalMessage.contains(EDI_MESSAGE_NUMBER))
			newMessage = newMessage.replace(EDI_MESSAGE_NUMBER, String.valueOf(messageCounter));

		return newMessage;
	}
	
	private String parseContextVariables(String originalMessage, PO parseableRecord) {
		if (!originalMessage.contains("@"))
			return originalMessage;

		return Env.parseVariable(originalMessage, parseableRecord, parseableRecord.get_TrxName(), false);
	}
	
	public void startNewMessage() {
		lineCounter = 0;
		messageCounter++;
	}
}
