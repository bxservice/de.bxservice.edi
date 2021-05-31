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

import java.util.List;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MTable;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.Env;

public class EDIParseableRecord {
	
	private MTable masterTable;
	private PO originalRecord;
	private PO parseableRecord;
	
	public EDIParseableRecord(PO originalPO, MTable sourceTable) {
		originalRecord = originalPO;
		masterTable = sourceTable;
		setParseableRecord();
	}
	
	private void setParseableRecord() {
		if (isFormatTableEqualsToRecordTable()) {
			parseableRecord = originalRecord;
		} else {
			parseableRecord = getRecordFromFormatTable(masterTable);
		}
	}
	
	private boolean isFormatTableEqualsToRecordTable() {
		return masterTable != null && masterTable.getAD_Table_ID() == originalRecord.get_Table_ID();
	}
	
	private PO getRecordFromFormatTable(MTable ediFormatTable) {
		String parentKeyColumnName = getParentKeyColumnName();
		
		return new Query(Env.getCtx(), ediFormatTable.getTableName(), parentKeyColumnName + " = ?", originalRecord.get_TrxName())
				.setParameters(originalRecord.get_ID())
				.setOnlyActiveRecords(true)
				.first();
	}
	
	private String getParentKeyColumnName() {
		String parentKeyColumnName = null;
		
		if (masterTable.getKeyColumns().length > 0) {
			parentKeyColumnName = masterTable.getKeyColumns()[0];
		} else {
			parentKeyColumnName = originalRecord.get_KeyColumns()[0];
		}

		return parentKeyColumnName;
	}
	
	public PO getParseableRecord() {
		return parseableRecord;
	}
	
	public List<PO> getDetailRecords(MTable detailTable, String orderBy) {
		String parentKeyColumnName = getParentKeyColumnName();
		
		if (!isDetailTableValid(detailTable, parentKeyColumnName)) {
			throw new AdempiereException("Invalid detail table - it does not contain a FK to the parent table");
		}

		return new Query(Env.getCtx(), detailTable.getTableName(), parentKeyColumnName + "= ?", originalRecord.get_TrxName())
				.setParameters(originalRecord.get_ID())
				.setOnlyActiveRecords(true)
				.setOrderBy(orderBy)
				.list();
	}
	
	private boolean isDetailTableValid(MTable detailTable, String parentKeyColumnName) {
		return detailTable.getColumnIndex(parentKeyColumnName) > 0;
	}

}
