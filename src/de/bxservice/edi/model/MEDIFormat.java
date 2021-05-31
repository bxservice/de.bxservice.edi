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

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.CCache;
import org.compiere.util.Env;

public class MEDIFormat extends X_BXS_EDIFormat {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8879592481945097128L;
	private static final CCache<Integer, MEDIFormat> s_cache = new CCache<>(null, "MEDIFormat", 30, 120, false, 50);
	
	private MEDIDocType docType;

	public MEDIFormat(Properties ctx, int BXS_EDIFormat_ID, String trxName) {
		super(ctx, BXS_EDIFormat_ID, trxName);
		docType = new MEDIDocType(ctx, getBXS_EDI_DocType_ID(), trxName);
	}

	public MEDIFormat(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		docType = new MEDIDocType(ctx, getBXS_EDI_DocType_ID(), trxName);
	}
	
	public List<MEDISection> getSections() {
		String whereClauseFinal = COLUMNNAME_BXS_EDIFormat_ID + "=? ";
		List<MEDISection> sections = new Query(getCtx(), MEDISection.Table_Name, whereClauseFinal, get_TrxName())
										.setParameters(getBXS_EDIFormat_ID())
										.setOrderBy("SeqNo")
										.list();
		return  sections;
	}
	
	public MEDIDocType getEDIDocType() {
		return docType;
	}
	
	public static MEDIFormat get(PO record) {
		String whereClause = COLUMNNAME_AD_Table_ID + " =?";
		
		return new Query(Env.getCtx(), Table_Name, whereClause, null)
				.setParameters(record.get_Table_ID())
				.setOnlyActiveRecords(true)
				.first();
	}

	public static MEDIFormat get(int BXS_EDI_Format_ID) {
		MEDIFormat ediFormat = s_cache.get(BXS_EDI_Format_ID);
		if (ediFormat != null)
			return ediFormat;
		
		ediFormat = new MEDIFormat (Env.getCtx(), BXS_EDI_Format_ID, (String)null);
		s_cache.put(BXS_EDI_Format_ID, ediFormat);
		return ediFormat;
	}
}
