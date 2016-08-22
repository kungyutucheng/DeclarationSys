package com.gpl.module.entry.biz;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.framework.util.Page;
import com.gpl.module.entry.dao.EntryDao;
import com.gpl.module.entry.model.Entry;

@Service
public class EntryBiz extends BaseBiz<Entry, Integer>{

	@Autowired
	private EntryDao entryDao;

	public Page queryPage(Page page) {
		String hql = "select new EntryVO("
				+ "id,"
				+ "entInboundNo,"
				+ "operType,"
				+ "declarationDate,"
				+ "ciqbCode,"
				+ "(select name from Organization o where o.code = ciqbCode),"
				+ "bargainNo,"
				+ "shipperName,"
				+ "shipperNameEn,"
				+ "shipperAddr,"
				+ "consigneeName,"
				+ "consigneeNameEn,"
				+ "consigneeAddr,"
				+ "portLoad,"
				+ "(select name from Port p where p.code = portLoad),"
				+ "portDis,"
				+ "(select name from Port p where p.code = portDis),"
				+ "fCode,"
				+ "(select name from Currency c where c.code = fCode),"
				+ "tool,"
				+ "toolName,"
				+ "toolNo,"
				+ "blNo,"
				+ "arrivalDate,"
				+ "uploadDate,"
				+ "destination,"
				+ "stockLocation,"
				+ "tradeCode,"
				+ "(select name from Region r where r.code = tradeCode),"
				+ "countryLoad,"
				+ "portStop,"
				+ "(select name from Port p where p.code = portStop),"
				+ "tradeType,"
				+ "(select name from TradeType tt where tt.code = tradeType),"
				+ "chargeType,"
				+ "(select name from ChargeType ct where ct.code = chargeType),"
				+ "tblType,"
				+ "tblReportType,"
				+ "markNo,"
				+ "claimDays,"
				+ "specRequire,"
				+ "customDeclareNo,"
				+ "reportType,"
				+ "declCode,"
				+ "editId,"
				+ "(select ename from Enterprise e where e.id = editId),"
				+ "eportInboundNo,"
				+ "status,"
				+ "regStatusDesc,"
				+ "createTime) from Entry where 1=1";
		if(page.getParams().get("ciqbCode") != null){
			hql += " and ciqbCode ='" + page.getParams().get("ciqbCode") + "'";
		}
		if(page.getParams().get("status") != null){
			hql += " and status =" + page.getParams().get("status"); 
		}
		if(page.getParams().get("entInboundNo") != null){
			hql += " and entInboundNo like '%" + page.getParams().get("entInboundNo") + "%'";
		}
		if(page.getParams().get("operType") != null){
			hql += " and operType='" + page.getParams().get("operType") + "'";
		}
		if(page.getParams().get("startDeclarationDate") != null){
			hql += " and declarationDate>='" + page.getParams().get("startDeclarationDate") + "'";
		}
		if(page.getParams().get("endDeclarationDate") != null){
			hql += " and declarationDate<='" + page.getParams().get("endDeclarationDate") + "'";
		}
		if(page.getParams().get("tool") != null){
			hql += " and tool=" + page.getParams().get("tool");
		}
		if(page.getParams().get("toolName") != null){
			hql += " and toolName like '%" + page.getParams().get("toolName") + "%'";
		}
		if(page.getParams().get("toolNo") != null){
			hql += " and toolNo like '%" + page.getParams().get("toolNo") + "%'";
		}
		if(page.getParams().get("startArrivalDate") != null){
			hql += " and arrivalDate>='" + page.getParams().get("startArrivalDate") + "'";
		}
		if(page.getParams().get("endArrivalDate") != null){
			hql += " and arrivalDate<='" + page.getParams().get("endArrivalDate") + "'";
		}
		if(page.getParams().get("destination") != null){
			hql += " and destination like '%" + page.getParams().get("destination") + "%'";
		}
		if(page.getParams().get("startUploadDate") != null){
			hql += " and uploadDate>='" + page.getParams().get("startUploadDate") +"'";
		}
		if(page.getParams().get("endUploadDate") != null){
			hql += " and uploadDate<='" + page.getParams().get("endUploadDate") + "'";
		}
		if(page.getParams().get("stockLocation") != null){
			hql += " and stockLocation like '%" + page.getParams().get("stockLocation") + "%'";
		}
		if(page.getParams().get("tblType") != null){
			hql += " and tblType=" + page.getParams().get("tblType");
		}
		if(page.getParams().get("tblReportType") != null){
			hql += " and tblReportType=" + page.getParams().get("tblReportType");
		}
		if(page.getParams().get("specRequire") != null){
			hql += " and specRequire like '%" + page.getParams().get("specRequire") + "%'";
		}
		if(page.getParams().get("startClaimDays") != null){
			hql += " and claimDays>=" + page.getParams().get("startClaimDays");
		}
		if(page.getParams().get("endClaimDays") != null){
			hql += " and claimDays<=" + page.getParams().get("endClaimDays");
		}
		if(page.getParams().get("customDeclareNo") != null){
			hql += " and customDeclareNo like '%" + page.getParams().get("customDeclareNo") + "%'";
		}
		if(page.getParams().get("editId") != null){
			hql += " and editId=" + page.getParams().get("editId");
		}
		if(page.getParams().get("bargainNo") != null){
			hql += " and bargainNo like '%" + page.getParams().get("bargainNo") + "%'";
		}
		if(page.getParams().get("shipperName") != null){
			hql += " and shipperName like '%" + page.getParams().get("shipperName") + "%'";
		}
		if(page.getParams().get("consigneeName") != null){
			hql += " and consigneeName like '%" + page.getParams().get("consigneeName") + "%'";
		}
		if(page.getParams().get("shipperNameEn") != null){
			hql += " and shipperNameEn like '%" + page.getParams().get("shipperNameEn") + "%'";
		}
		if(page.getParams().get("consigneeNameEn") != null){
			hql += " and consigneeNameEn like '%" + page.getParams().get("consigneeNameEn") + "%'";
		}
		if(page.getParams().get("shipperAddr") != null){
			hql += " and shipperAddr like '%" + page.getParams().get("shipperAddr") + "%'";
		}
		if(page.getParams().get("consigneeAddr") != null){
			hql += " and consigneeAddr like '%" + page.getParams().get("consigneeAddr") + "%'";
		}
		if(page.getParams().get("blNo") != null){
			hql += " and blNo like '%" + page.getParams().get("blNo") + "%'";
		}
		if(page.getParams().get("tradeType") != null){
			hql += " and tradeType=" + page.getParams().get("tradeType");
		}
		if(page.getParams().get("chargeType") != null){
			hql += " and chargeType=" + page.getParams().get("chargeType");
		}
		if(page.getParams().get("tradeCode") != null){
			hql += " and tradeCode=" + page.getParams().get("tradeCode");
		}
		if(page.getParams().get("portLoad") != null){
			hql += " and portLoad=" + page.getParams().get("portLoad");
		}
		if(page.getParams().get("countryLoad") != null){
			hql += " and countryLoad like '%" + page.getParams().get("countryLoad") + "%'";
		}
		if(page.getParams().get("portStop") != null){
			hql += " and portStop=" + page.getParams().get("portStop");
		}
		if(page.getParams().get("portDis") != null){
			hql += " and portDis=" + page.getParams().get("portDis");
		}
		if(page.getParams().get("markNo") != null){
			hql += " and markNo like '%" + page.getParams().get("markNo") + "%'";
		}
		if(page.getParams().get("fCode") != null){
			hql += " and fCode=" + page.getParams().get("fCode");
		}
		if(page.getParams().get("reportType") != null){
			hql += " and reportType=" + page.getParams().get("reportType");
		}
		if(page.getParams().get("declCode") != null){
			hql += " and declCode like '%" + page.getParams().get("declCode") + "%'";
		}
		hql += " order by createTime desc";
		return entryDao.findPage(page, hql, new HashMap<String,Object>());
	}
	
}
