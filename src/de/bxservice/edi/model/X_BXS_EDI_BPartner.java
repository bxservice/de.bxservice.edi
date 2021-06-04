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

/** Generated Model for BXS_EDI_BPartner
 *  @author iDempiere (generated) 
 *  @version Release 8.2 - $Id$ */
public class X_BXS_EDI_BPartner extends PO implements I_BXS_EDI_BPartner, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20210604L;

    /** Standard Constructor */
    public X_BXS_EDI_BPartner (Properties ctx, int BXS_EDI_BPartner_ID, String trxName)
    {
      super (ctx, BXS_EDI_BPartner_ID, trxName);
      /** if (BXS_EDI_BPartner_ID == 0)
        {
			setBXS_EDI_BPartner_ID (0);
			setBXS_EDIFormat_ID (0);
			setC_BPartner_ID (0);
        } */
    }

    /** Load Constructor */
    public X_BXS_EDI_BPartner (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BXS_EDI_BPartner[")
        .append(get_ID()).append("]");
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

	/** Set EDI Business Partner.
		@param BXS_EDI_BPartner_ID EDI Business Partner	  */
	public void setBXS_EDI_BPartner_ID (int BXS_EDI_BPartner_ID)
	{
		if (BXS_EDI_BPartner_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BXS_EDI_BPartner_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BXS_EDI_BPartner_ID, Integer.valueOf(BXS_EDI_BPartner_ID));
	}

	/** Get EDI Business Partner.
		@return EDI Business Partner	  */
	public int getBXS_EDI_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BXS_EDI_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BXS_EDI_BPartner_UU.
		@param BXS_EDI_BPartner_UU BXS_EDI_BPartner_UU	  */
	public void setBXS_EDI_BPartner_UU (String BXS_EDI_BPartner_UU)
	{
		set_Value (COLUMNNAME_BXS_EDI_BPartner_UU, BXS_EDI_BPartner_UU);
	}

	/** Get BXS_EDI_BPartner_UU.
		@return BXS_EDI_BPartner_UU	  */
	public String getBXS_EDI_BPartner_UU () 
	{
		return (String)get_Value(COLUMNNAME_BXS_EDI_BPartner_UU);
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

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getC_BPartner_ID(), get_TrxName());	}

	/** Set Business Partner .
		@param C_BPartner_ID 
		Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner .
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Current Next.
		@param CurrentNext 
		The next number to be used
	  */
	public void setCurrentNext (int CurrentNext)
	{
		set_Value (COLUMNNAME_CurrentNext, Integer.valueOf(CurrentNext));
	}

	/** Get Current Next.
		@return The next number to be used
	  */
	public int getCurrentNext () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_CurrentNext);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Increment.
		@param IncrementNo 
		The number to increment the last document number by
	  */
	public void setIncrementNo (int IncrementNo)
	{
		set_Value (COLUMNNAME_IncrementNo, Integer.valueOf(IncrementNo));
	}

	/** Get Increment.
		@return The number to increment the last document number by
	  */
	public int getIncrementNo () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_IncrementNo);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}