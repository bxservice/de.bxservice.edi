/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package de.bxservice.edi.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Model for BXS_EDIFormat
 *  @author iDempiere (generated) 
 *  @version Release 8.2 - $Id$ */
public class X_BXS_EDIFormat extends PO implements I_BXS_EDIFormat, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20210608L;

    /** Standard Constructor */
    public X_BXS_EDIFormat (Properties ctx, int BXS_EDIFormat_ID, String trxName)
    {
      super (ctx, BXS_EDIFormat_ID, trxName);
      /** if (BXS_EDIFormat_ID == 0)
        {
			setAD_Table_ID (0);
			setBXS_EDI_DocType_ID (0);
			setBXS_EDIFormat_ID (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_BXS_EDIFormat (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 6 - System - Client 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_BXS_EDIFormat[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Table getAD_Table() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Table)MTable.get(getCtx(), org.compiere.model.I_AD_Table.Table_Name)
			.getPO(getAD_Table_ID(), get_TrxName());	}

	/** Set Table.
		@param AD_Table_ID 
		Database Table information
	  */
	public void setAD_Table_ID (int AD_Table_ID)
	{
		if (AD_Table_ID < 1) 
			set_Value (COLUMNNAME_AD_Table_ID, null);
		else 
			set_Value (COLUMNNAME_AD_Table_ID, Integer.valueOf(AD_Table_ID));
	}

	/** Get Table.
		@return Database Table information
	  */
	public int getAD_Table_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Table_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Windows = CRLF */
	public static final String BXS_BREAKLINESEPARATOR_Windows = "CRLF";
	/** Unix = LF */
	public static final String BXS_BREAKLINESEPARATOR_Unix = "LF";
	/** Set End of Line.
		@param BXS_BreakLineSeparator End of Line	  */
	public void setBXS_BreakLineSeparator (String BXS_BreakLineSeparator)
	{

		set_Value (COLUMNNAME_BXS_BreakLineSeparator, BXS_BreakLineSeparator);
	}

	/** Get End of Line.
		@return End of Line	  */
	public String getBXS_BreakLineSeparator () 
	{
		return (String)get_Value(COLUMNNAME_BXS_BreakLineSeparator);
	}

	public I_BXS_EDI_DocType getBXS_EDI_DocType() throws RuntimeException
    {
		return (I_BXS_EDI_DocType)MTable.get(getCtx(), I_BXS_EDI_DocType.Table_Name)
			.getPO(getBXS_EDI_DocType_ID(), get_TrxName());	}

	/** Set EDI Document Type.
		@param BXS_EDI_DocType_ID EDI Document Type	  */
	public void setBXS_EDI_DocType_ID (int BXS_EDI_DocType_ID)
	{
		if (BXS_EDI_DocType_ID < 1) 
			set_Value (COLUMNNAME_BXS_EDI_DocType_ID, null);
		else 
			set_Value (COLUMNNAME_BXS_EDI_DocType_ID, Integer.valueOf(BXS_EDI_DocType_ID));
	}

	/** Get EDI Document Type.
		@return EDI Document Type	  */
	public int getBXS_EDI_DocType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BXS_EDI_DocType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set EDI Format.
		@param BXS_EDIFormat_ID EDI Format	  */
	public void setBXS_EDIFormat_ID (int BXS_EDIFormat_ID)
	{
		if (BXS_EDIFormat_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BXS_EDIFormat_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BXS_EDIFormat_ID, Integer.valueOf(BXS_EDIFormat_ID));
	}

	/** Get EDI Format.
		@return EDI Format	  */
	public int getBXS_EDIFormat_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BXS_EDIFormat_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BXS_EDIFormat_UU.
		@param BXS_EDIFormat_UU BXS_EDIFormat_UU	  */
	public void setBXS_EDIFormat_UU (String BXS_EDIFormat_UU)
	{
		set_Value (COLUMNNAME_BXS_EDIFormat_UU, BXS_EDIFormat_UU);
	}

	/** Get BXS_EDIFormat_UU.
		@return BXS_EDIFormat_UU	  */
	public String getBXS_EDIFormat_UU () 
	{
		return (String)get_Value(COLUMNNAME_BXS_EDIFormat_UU);
	}

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Line Separator.
		@param EDI_LineSeparator 
		Line Separator Character
	  */
	public void setEDI_LineSeparator (String EDI_LineSeparator)
	{
		set_Value (COLUMNNAME_EDI_LineSeparator, EDI_LineSeparator);
	}

	/** Get Line Separator.
		@return Line Separator Character
	  */
	public String getEDI_LineSeparator () 
	{
		return (String)get_Value(COLUMNNAME_EDI_LineSeparator);
	}

	/** Set Break Line.
		@param IsBreakLine 
		Break each document line
	  */
	public void setIsBreakLine (boolean IsBreakLine)
	{
		set_Value (COLUMNNAME_IsBreakLine, Boolean.valueOf(IsBreakLine));
	}

	/** Get Break Line.
		@return Break each document line
	  */
	public boolean isBreakLine () 
	{
		Object oo = get_Value(COLUMNNAME_IsBreakLine);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Name.
		@param Name 
		Alphanumeric identifier of the entity
	  */
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName () 
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), getName());
    }
}