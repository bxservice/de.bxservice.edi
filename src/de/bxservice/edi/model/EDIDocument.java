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
package de.bxservice.edi.model;

import java.util.ArrayList;
import java.util.List;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MTable;
import org.compiere.model.PO;
import org.compiere.util.Util;

import de.bxservice.edi.util.DocumentValueParser;
import de.bxservice.edi.util.EDIParseableRecord;

public class EDIDocument {
	
	private List<PO> documentsToParse;
	private EDIParseableRecord currentEDIRecord;
	private DocumentValueParser currentDocParser;
	private MEDIFormat ediFormat;
	private StringBuffer ediDocumentTxt;
	
	private String lineSeparator;
	
	public EDIDocument(PO po, MEDIFormat ediFormat) {
		initVariables(ediFormat);

		documentsToParse = new ArrayList<PO>();
		documentsToParse.add(po);
	}

	public EDIDocument(List<PO> poList, MEDIFormat ediFormat) {
		initVariables(ediFormat);
		this.documentsToParse = poList;
	}
	
	private void initVariables(MEDIFormat ediFormat) {
		if (ediFormat == null) {
			throw new AdempiereException("NO EDI Format defined for this document.");
		}
		this.ediFormat = ediFormat;
		lineSeparator = ediFormat.getLineSeparator();
	}
	
	public String getDocumentInEDIFormat() {
		if (ediDocumentTxt == null) {
			generateEDI();
		}

		return ediDocumentTxt.toString();
	}
	
	private void generateEDI() {
		ediDocumentTxt = new StringBuffer();

		PO basePO = documentsToParse.get(0);
		setCurrentDocumentParser(basePO);
		writeDocumentHeader(basePO);
		for (PO currentPO : documentsToParse) {
			currentDocParser.startNewMessage();
			writeMessage(currentPO);
		}
		writeDocumentFooter(basePO);
	}
	
	private void writeDocumentHeader(PO currentPO) {
		currentEDIRecord = new EDIParseableRecord(currentPO, MTable.get(ediFormat.getAD_Table_ID()));
		MEDISection interchangeHeader = ediFormat.getInterchangeHeader();
		writeSegment(interchangeHeader);
	}
	
	private void writeDocumentFooter(PO currentPO) {
		MEDISection interchangeFooter = ediFormat.getInterchangeTrailer();
		writeSegment(interchangeFooter);
	}
	
	private void writeMessage(PO currentPO) {
		currentEDIRecord = new EDIParseableRecord(currentPO, MTable.get(ediFormat.getAD_Table_ID()));
		for (MEDISection ediSection : ediFormat.getMessageSections()) {
			writeSegment(ediSection);
		}
	}
	
	private void setCurrentDocumentParser(PO currentPO) {
		String messageReference = MEDIBPartner.consumeNextMessageReferenceSeq(ediFormat.getBXS_EDIFormat_ID(), currentPO);
		currentDocParser = new DocumentValueParser(ediFormat.getEDIDocType(), messageReference);
	}
	
	private void writeSegment(MEDISection ediSection) {
		if (MEDISection.BXS_EDISECTION_MessageDetail.equals(ediSection.getBXS_EDISection())) {
			writeDetailSection(ediSection);
		} else {
			writeSegmentLines(ediSection.getLines(), currentEDIRecord.getParseableRecord());
		}
	}
	
	private void writeDetailSection(MEDISection ediSection) {
		List<PO> detailRecords = currentEDIRecord.getDetailRecords(MTable.get(ediSection.getAD_Table_ID()), ediSection.getOrderByClause());

		if (detailRecords.size() <= 0) {
			throw new AdempiereException("No detail records found - EDI Document must have at least one detail line");
		}
		
		for (PO detailRecord : detailRecords) {
			writeSegmentLines(ediSection.getLines(), detailRecord);
		}
	}
	
	private void writeSegmentLines(List<MEDILine> lines, PO parseableRecord) {
		for (MEDILine ediLine : lines) {
			String messageLine = currentDocParser.parseMessageLine(ediLine.getMsgText(), parseableRecord);
			appendEDIMessageLine(messageLine);
		}
	}
	
	private void appendEDIMessageLine(String message) {
		String ediMsgLine = Util.isEmpty(message) ? "" : message + lineSeparator;
		ediDocumentTxt.append(ediMsgLine);
	}

}
