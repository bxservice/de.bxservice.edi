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

/** Generated Model for BXS_EDISection
 *  @author iDempiere (generated) 
 *  @version Release 8.2 - $Id$ */
public class X_BXS_EDISection extends PO implements I_BXS_EDISection, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20210607L;

    /** Standard Constructor */
    public X_BXS_EDISection (Properties ctx, int BXS_EDISection_ID, String trxName)
    {
      super (ctx, BXS_EDISection_ID, trxName);
      /** if (BXS_EDISection_ID == 0)
        {
			setBXS_EDIFormat_ID (0);
			setBXS_EDISection (null);
			setBXS_EDISection_ID (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_BXS_EDISection (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BXS_EDISection[")
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

	public I_BXS_EDIFormat getBXS_EDIFormat() throws RuntimeException
    {
		return (I_BXS_EDIFormat)MTable.get(getCtx(), I_BXS_EDIFormat.Table_Name)
			.getPO(getBXS_EDIFormat_ID(), get_TrxName());	}

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

	/** Interchange Header = M */
	public static final String BXS_EDISECTION_InterchangeHeader = "M";
	/** Message Header = H */
	public static final String BXS_EDISECTION_MessageHeader = "H";
	/** Message Detail = D */
	public static final String BXS_EDISECTION_MessageDetail = "D";
	/** Message Summary = S */
	public static final String BXS_EDISECTION_MessageSummary = "S";
	/** Interchange Trailer = F */
	public static final String BXS_EDISECTION_InterchangeTrailer = "F";
	/** Set EDI Section.
		@param BXS_EDISection EDI Section	  */
	public void setBXS_EDISection (String BXS_EDISection)
	{

		set_Value (COLUMNNAME_BXS_EDISection, BXS_EDISection);
	}

	/** Get EDI Section.
		@return EDI Section	  */
	public String getBXS_EDISection () 
	{
		return (String)get_Value(COLUMNNAME_BXS_EDISection);
	}

	/** Set EDI Section.
		@param BXS_EDISection_ID EDI Section	  */
	public void setBXS_EDISection_ID (int BXS_EDISection_ID)
	{
		if (BXS_EDISection_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BXS_EDISection_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BXS_EDISection_ID, Integer.valueOf(BXS_EDISection_ID));
	}

	/** Get EDI Section.
		@return EDI Section	  */
	public int getBXS_EDISection_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BXS_EDISection_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BXS_EDISection_UU.
		@param BXS_EDISection_UU BXS_EDISection_UU	  */
	public void setBXS_EDISection_UU (String BXS_EDISection_UU)
	{
		set_Value (COLUMNNAME_BXS_EDISection_UU, BXS_EDISection_UU);
	}

	/** Get BXS_EDISection_UU.
		@return BXS_EDISection_UU	  */
	public String getBXS_EDISection_UU () 
	{
		return (String)get_Value(COLUMNNAME_BXS_EDISection_UU);
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

	/** Set Sql ORDER BY.
		@param OrderByClause 
		Fully qualified ORDER BY clause
	  */
	public void setOrderByClause (String OrderByClause)
	{
		set_Value (COLUMNNAME_OrderByClause, OrderByClause);
	}

	/** Get Sql ORDER BY.
		@return Fully qualified ORDER BY clause
	  */
	public String getOrderByClause () 
	{
		return (String)get_Value(COLUMNNAME_OrderByClause);
	}

	/** Set Sequence.
		@param SeqNo 
		Method of ordering records; lowest number comes first
	  */
	public void setSeqNo (int SeqNo)
	{
		set_Value (COLUMNNAME_SeqNo, Integer.valueOf(SeqNo));
	}

	/** Get Sequence.
		@return Method of ordering records; lowest number comes first
	  */
	public int getSeqNo () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SeqNo);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}