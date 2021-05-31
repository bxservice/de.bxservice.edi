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

import org.compiere.model.Query;

public class MEDISection extends X_BXS_EDISection {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9041048689233718186L;

	public MEDISection(Properties ctx, int BXS_EDISection_ID, String trxName) {
		super(ctx, BXS_EDISection_ID, trxName);
	}

	public MEDISection(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
	
	
	public List<MEDILine> getLines() {
		String whereClauseFinal = COLUMNNAME_BXS_EDISection_ID + "=? ";
		List<MEDILine> lines = new Query(getCtx(), MEDILine.Table_Name, whereClauseFinal, get_TrxName())
										.setParameters(getBXS_EDISection_ID())
										.setOrderBy("LineNo")
										.list();
		return lines;
	}
	
}
