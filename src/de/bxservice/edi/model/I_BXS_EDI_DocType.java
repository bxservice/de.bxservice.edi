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

/** Generated Interface for BXS_EDI_DocType
 *  @author iDempiere (generated) 
 *  @version Release 8.2
 */
@SuppressWarnings("all")
public interface I_BXS_EDI_DocType 
{

    /** TableName=BXS_EDI_DocType */
    public static final String Table_Name = "BXS_EDI_DocType";

    /** AD_Table_ID=1000052 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 4 - System 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(4);

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

    /** Column name BXS_EDI_DocType_ID */
    public static final String COLUMNNAME_BXS_EDI_DocType_ID = "BXS_EDI_DocType_ID";

	/** Set EDI Document Type	  */
	public void setBXS_EDI_DocType_ID (int BXS_EDI_DocType_ID);

	/** Get EDI Document Type	  */
	public int getBXS_EDI_DocType_ID();

    /** Column name BXS_EDI_DocType_UU */
    public static final String COLUMNNAME_BXS_EDI_DocType_UU = "BXS_EDI_DocType_UU";

	/** Set BXS_EDI_DocType_UU	  */
	public void setBXS_EDI_DocType_UU (String BXS_EDI_DocType_UU);

	/** Get BXS_EDI_DocType_UU	  */
	public String getBXS_EDI_DocType_UU();

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

    /** Column name EDI_DocumentCode */
    public static final String COLUMNNAME_EDI_DocumentCode = "EDI_DocumentCode";

	/** Set Document Name Code.
	  * Code specifying the document name in the D96A standard.
	  */
	public void setEDI_DocumentCode (String EDI_DocumentCode);

	/** Get Document Name Code.
	  * Code specifying the document name in the D96A standard.
	  */
	public String getEDI_DocumentCode();

    /** Column name EDI_MessageType */
    public static final String COLUMNNAME_EDI_MessageType = "EDI_MessageType";

	/** Set Message Type.
	  * EDIFACT uniform message type. 
	  */
	public void setEDI_MessageType (String EDI_MessageType);

	/** Get Message Type.
	  * EDIFACT uniform message type. 
	  */
	public String getEDI_MessageType();

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
