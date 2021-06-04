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
package de.bxservice.edi.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for BXS_EDIFormat
 *  @author iDempiere (generated) 
 *  @version Release 8.2
 */
@SuppressWarnings("all")
public interface I_BXS_EDIFormat 
{

    /** TableName=BXS_EDIFormat */
    public static final String Table_Name = "BXS_EDIFormat";

    /** AD_Table_ID=1000060 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 6 - System - Client 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(6);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name AD_Table_ID */
    public static final String COLUMNNAME_AD_Table_ID = "AD_Table_ID";

	/** Set Table.
	  * Database Table information
	  */
	public void setAD_Table_ID (int AD_Table_ID);

	/** Get Table.
	  * Database Table information
	  */
	public int getAD_Table_ID();

	public org.compiere.model.I_AD_Table getAD_Table() throws RuntimeException;

    /** Column name BXS_EDI_DocType_ID */
    public static final String COLUMNNAME_BXS_EDI_DocType_ID = "BXS_EDI_DocType_ID";

	/** Set EDI Document Type	  */
	public void setBXS_EDI_DocType_ID (int BXS_EDI_DocType_ID);

	/** Get EDI Document Type	  */
	public int getBXS_EDI_DocType_ID();

	public I_BXS_EDI_DocType getBXS_EDI_DocType() throws RuntimeException;

    /** Column name BXS_EDIFormat_ID */
    public static final String COLUMNNAME_BXS_EDIFormat_ID = "BXS_EDIFormat_ID";

	/** Set EDI Format	  */
	public void setBXS_EDIFormat_ID (int BXS_EDIFormat_ID);

	/** Get EDI Format	  */
	public int getBXS_EDIFormat_ID();

    /** Column name BXS_EDIFormat_UU */
    public static final String COLUMNNAME_BXS_EDIFormat_UU = "BXS_EDIFormat_UU";

	/** Set BXS_EDIFormat_UU	  */
	public void setBXS_EDIFormat_UU (String BXS_EDIFormat_UU);

	/** Get BXS_EDIFormat_UU	  */
	public String getBXS_EDIFormat_UU();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name EDI_LineSeparator */
    public static final String COLUMNNAME_EDI_LineSeparator = "EDI_LineSeparator";

	/** Set Line Separator.
	  * Line Separator Character
	  */
	public void setEDI_LineSeparator (String EDI_LineSeparator);

	/** Get Line Separator.
	  * Line Separator Character
	  */
	public String getEDI_LineSeparator();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name IsBreakLine */
    public static final String COLUMNNAME_IsBreakLine = "IsBreakLine";

	/** Set Break Line.
	  * Break each document line
	  */
	public void setIsBreakLine (boolean IsBreakLine);

	/** Get Break Line.
	  * Break each document line
	  */
	public boolean isBreakLine();

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();
}
