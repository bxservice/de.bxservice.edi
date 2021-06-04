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

/** Generated Model for BXS_EDILine
 *  @author iDempiere (generated) 
 *  @version Release 8.2 - $Id$ */
public class X_BXS_EDILine extends PO implements I_BXS_EDILine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20210604L;

    /** Standard Constructor */
    public X_BXS_EDILine (Properties ctx, int BXS_EDILine_ID, String trxName)
    {
      super (ctx, BXS_EDILine_ID, trxName);
      /** if (BXS_EDILine_ID == 0)
        {
			setBXS_EDILine_ID (0);
			setBXS_EDISection_ID (0);
			setMsgText (null);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_BXS_EDILine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BXS_EDILine[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set EDI Line.
		@param BXS_EDILine_ID EDI Line	  */
	public void setBXS_EDILine_ID (int BXS_EDILine_ID)
	{
		if (BXS_EDILine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BXS_EDILine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BXS_EDILine_ID, Integer.valueOf(BXS_EDILine_ID));
	}

	/** Get EDI Line.
		@return EDI Line	  */
	public int getBXS_EDILine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BXS_EDILine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BXS_EDILine_UU.
		@param BXS_EDILine_UU BXS_EDILine_UU	  */
	public void setBXS_EDILine_UU (String BXS_EDILine_UU)
	{
		set_Value (COLUMNNAME_BXS_EDILine_UU, BXS_EDILine_UU);
	}

	/** Get BXS_EDILine_UU.
		@return BXS_EDILine_UU	  */
	public String getBXS_EDILine_UU () 
	{
		return (String)get_Value(COLUMNNAME_BXS_EDILine_UU);
	}

	public I_BXS_EDISection getBXS_EDISection() throws RuntimeException
    {
		return (I_BXS_EDISection)MTable.get(getCtx(), I_BXS_EDISection.Table_Name)
			.getPO(getBXS_EDISection_ID(), get_TrxName());	}

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

	/** Set Comment/Help.
		@param Help 
		Comment or Hint
	  */
	public void setHelp (String Help)
	{
		set_Value (COLUMNNAME_Help, Help);
	}

	/** Get Comment/Help.
		@return Comment or Hint
	  */
	public String getHelp () 
	{
		return (String)get_Value(COLUMNNAME_Help);
	}

	/** Set Line.
		@param LineNo 
		Line No
	  */
	public void setLineNo (int LineNo)
	{
		set_Value (COLUMNNAME_LineNo, Integer.valueOf(LineNo));
	}

	/** Get Line.
		@return Line No
	  */
	public int getLineNo () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LineNo);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Message Text.
		@param MsgText 
		Textual Informational, Menu or Error Message
	  */
	public void setMsgText (String MsgText)
	{
		set_Value (COLUMNNAME_MsgText, MsgText);
	}

	/** Get Message Text.
		@return Textual Informational, Menu or Error Message
	  */
	public String getMsgText () 
	{
		return (String)get_Value(COLUMNNAME_MsgText);
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