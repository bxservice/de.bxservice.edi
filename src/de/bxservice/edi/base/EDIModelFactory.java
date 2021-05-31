package de.bxservice.edi.base;

import java.sql.ResultSet;
import org.adempiere.base.IModelFactory;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.osgi.service.component.annotations.Component;

import de.bxservice.edi.model.MEDIDocType;
import de.bxservice.edi.model.MEDIFormat;
import de.bxservice.edi.model.MEDILine;
import de.bxservice.edi.model.MEDISection;

@Component(
		property= {"service.ranking:Integer=100"},
		service = org.adempiere.base.IModelFactory.class
		)
public class EDIModelFactory implements IModelFactory {

	@Override
	public Class<?> getClass(String tableName) {
		if (MEDIDocType.Table_Name.equals(tableName))
			return MEDIDocType.class;
		if (MEDIFormat.Table_Name.equals(tableName))
			return MEDIFormat.class;
		if (MEDISection.Table_Name.equals(tableName))
			return MEDISection.class;
		if (MEDILine.Table_Name.equals(tableName))
			return MEDILine.class;
		return null;
	}

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName) {
		if (MEDIDocType.Table_Name.equals(tableName))
			return new MEDIDocType(Env.getCtx(), Record_ID, trxName);
		if (MEDIFormat.Table_Name.equals(tableName))
			return new MEDIFormat(Env.getCtx(), Record_ID, trxName);
		if (MEDISection.Table_Name.equals(tableName))
			return new MEDISection(Env.getCtx(), Record_ID, trxName);
		if (MEDILine.Table_Name.equals(tableName))
			return new MEDILine(Env.getCtx(), Record_ID, trxName);
		return null;
	}

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName) {
		if (MEDIDocType.Table_Name.equals(tableName))
			return new MEDIDocType(Env.getCtx(), rs, trxName);
		if (MEDIFormat.Table_Name.equals(tableName))
			return new MEDIFormat(Env.getCtx(), rs, trxName);
		if (MEDISection.Table_Name.equals(tableName))
			return new MEDISection(Env.getCtx(), rs, trxName);
		if (MEDILine.Table_Name.equals(tableName))
			return new MEDILine(Env.getCtx(), rs, trxName);
		return null;
	}

}
