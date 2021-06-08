package de.bxservice.edi.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.Env;

public class MEDIBPartner extends X_BXS_EDI_BPartner {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4288003311559512892L;
	
	public static final String DEFAULT_SEQ_NO = "1";

	public MEDIBPartner(Properties ctx, int BXS_EDI_BPartner_ID, String trxName) {
		super(ctx, BXS_EDI_BPartner_ID, trxName);
	}
	
	public MEDIBPartner(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
	
	private static MEDIBPartner get(int BXS_EDIFormat_ID, PO po) {
		String whereClause = COLUMNNAME_BXS_EDIFormat_ID + " =? AND " + COLUMNNAME_C_BPartner_ID + " =? AND "
				+ COLUMNNAME_AD_Table_ID + " =?";
		
		return new Query(Env.getCtx(), Table_Name, whereClause, null)
				.setParameters(BXS_EDIFormat_ID, po.get_Value(COLUMNNAME_C_BPartner_ID), po.get_Table_ID())
				.setOnlyActiveRecords(true)
				.first();
	}
	
	public static MEDIBPartner get(int C_BPartner_ID, int AD_Table_ID) {
		String whereClause = COLUMNNAME_C_BPartner_ID + " =? AND "
				+ COLUMNNAME_AD_Table_ID + " =?";
		
		return new Query(Env.getCtx(), Table_Name, whereClause, null)
				.setParameters(C_BPartner_ID, AD_Table_ID)
				.setOnlyActiveRecords(true)
				.first();
	}
	
	public static String consumeNextMessageReferenceSeq(int BXS_EDIFormat_ID, PO po) {
		MEDIBPartner ediBPartner = get(BXS_EDIFormat_ID, po);
		return ediBPartner != null ? ediBPartner.consumeNextReferenceSeq() : DEFAULT_SEQ_NO;
	}
	
	public String consumeNextReferenceSeq() {
		String nextRef = String.valueOf(getCurrentNext());
		setCurrentNext(getCurrentNext() + getIncrementNo());
		saveEx();
		return nextRef;
	}

}
