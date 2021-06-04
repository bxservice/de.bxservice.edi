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

import java.util.List;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MTable;
import org.compiere.model.PO;
import org.compiere.util.Util;

import de.bxservice.edi.util.DocumentValueParser;
import de.bxservice.edi.util.EDIParseableRecord;

public class EDIDocument {
	
	private final static String DEFAULT_LINE_SUFFIX = "'";
	
	private EDIParseableRecord ediRecord;
	private DocumentValueParser docParser;
	private MEDIFormat ediFormat;
	private StringBuffer ediDocumentTxt;
	
	private String lineSeparator;
	
	public EDIDocument(PO po, MEDIFormat ediFormat) {
		if (ediFormat == null) {
			throw new AdempiereException("NO EDI Format defined for this document.");
		}
		
		this.ediFormat = ediFormat;
		ediRecord = new EDIParseableRecord(po, MTable.get(ediFormat.getAD_Table_ID()));
		docParser = new DocumentValueParser(ediFormat.getEDIDocType(), ediFormat.consumeNextMessageReferenceSeq(po));
		setLineSeparator();
	}
	
	private void setLineSeparator() {
		lineSeparator = !Util.isEmpty(ediFormat.getEDI_LineSeparator()) ? ediFormat.getEDI_LineSeparator() : DEFAULT_LINE_SUFFIX;
		
		if (ediFormat.isBreakLine()) {
			lineSeparator = lineSeparator + System.lineSeparator();
		}
	}
	
	public String getDocumentInEDIFormat() {
		if (ediDocumentTxt == null) {
			generateEDI();
		}

		return ediDocumentTxt.toString();
	}
	
	private void generateEDI() {
		ediDocumentTxt = new StringBuffer();

		for (MEDISection ediSection : ediFormat.getSections()) {
			writeDocumentSection(ediSection);
		}
	}
	
	private void writeDocumentSection(MEDISection ediSection) {
		if (MEDISection.BXS_EDISECTION_DetailSection.equals(ediSection.getBXS_EDISection())) {
			writeDetailSection(ediSection);
		} else {
			writeSegmentLines(ediSection.getLines(), ediRecord.getParseableRecord());
		}
	}
	
	private void writeDetailSection(MEDISection ediSection) {
		List<PO> detailRecords = ediRecord.getDetailRecords(MTable.get(ediSection.getAD_Table_ID()), ediSection.getOrderByClause());

		if (detailRecords.size() <= 0) {
			throw new AdempiereException("No detail records found - EDI Document must have at least one detail line");
		}
		
		for (PO detailRecord : detailRecords) {
			writeSegmentLines(ediSection.getLines(), detailRecord);
		}
	}
	
	private void writeSegmentLines(List<MEDILine> lines, PO parseableRecord) {
		for (MEDILine ediLine : lines) {
			String messageLine = docParser.parseMessageLine(ediLine.getMsgText(), parseableRecord);
			appendEDIMessageLine(messageLine);
		}
	}
	
	private void appendEDIMessageLine(String message) {
		String ediMsgLine = Util.isEmpty(message) ? "" : message + lineSeparator;
		ediDocumentTxt.append(ediMsgLine);
	}

}
