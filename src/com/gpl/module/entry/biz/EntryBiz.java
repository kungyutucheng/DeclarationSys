package com.gpl.module.entry.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.gpl.framework.annotation.SystemBizLog;
import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.framework.util.Page;
import com.gpl.module.entry.dao.EntryDao;
import com.gpl.module.entry.model.Entry;

@Service

public class EntryBiz extends BaseBiz<Entry, Integer>{

	@Autowired
	private EntryDao entryDao;

	/**
	 * 分页查询
	 * @param page
	 * @return
	 */
	@SystemBizLog(desc = "分页查询")
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
				+ "createTime,"
				+ "applicant) from Entry where 1=1";
		List<Object> params = new ArrayList<Object>();
		if(page.getParams().get("ciqbCode") != null){
			hql += " and ciqbCode = ?";
			params.add(page.getParams().get("ciqbCode"));
		}
		if(page.getParams().get("status") != null){
			hql += " and status = ?";
			params.add(Integer.valueOf(page.getParams().get("status").toString())); 
		}
		if(page.getParams().get("entInboundNo") != null){
			hql += " and entInboundNo like ?";
			params.add("%" + page.getParams().get("entInboundNo") + "%");
		}
		if(page.getParams().get("operType") != null){
			hql += " and operType = ?";
			params.add(page.getParams().get("operType"));
		}
		if(page.getParams().get("startDeclarationDate") != null){
			hql += " and declarationDate >= STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s')";
			params.add(page.getParams().get("startDeclarationDate"));
		}
		if(page.getParams().get("endDeclarationDate") != null){
			hql += " and declarationDate <= STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s')";
			params.add(page.getParams().get("endDeclarationDate"));
		}
		if(page.getParams().get("tool") != null){
			hql += " and tool = ?";
			params.add(Integer.valueOf(page.getParams().get("tool").toString()));
		}
		if(page.getParams().get("toolName") != null){
			hql += " and toolName like ?";
			params.add("%" + page.getParams().get("toolName") + "%");
		}
		if(page.getParams().get("toolNo") != null){
			hql += " and toolNo like ?";
			params.add("%" + page.getParams().get("toolNo") + "%");
		}
		if(page.getParams().get("startArrivalDate") != null){
			hql += " and arrivalDate >= STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s')";
			params.add(page.getParams().get("startArrivalDate"));
		}
		if(page.getParams().get("endArrivalDate") != null){
			hql += " and arrivalDate <= STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s')";
			params.add(page.getParams().get("endArrivalDate"));
		}
		if(page.getParams().get("destination") != null){
			hql += " and destination like ?";
			params.add("%" + page.getParams().get("destination") + "%");
		}
		if(page.getParams().get("startUploadDate") != null){
			hql += " and uploadDate >= STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s')";
			params.add(page.getParams().get("startUploadDate"));
		}
		if(page.getParams().get("endUploadDate") != null){
			hql += " and uploadDate <= STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s')";
			params.add(page.getParams().get("endUploadDate"));
		}
		if(page.getParams().get("stockLocation") != null){
			hql += " and stockLocation like ?";
			params.add("%" + page.getParams().get("stockLocation") + "%");
		}
		if(page.getParams().get("tblType") != null){
			hql += " and tblType = ?";
			params.add(page.getParams().get("tblType"));
		}
		if(page.getParams().get("tblReportType") != null){
			hql += " and tblReportType = ?";
			params.add(page.getParams().get("tblReportType"));
		}
		if(page.getParams().get("specRequire") != null){
			hql += " and specRequire like ?";
			params.add("%" + page.getParams().get("specRequire") + "%");
		}
		if(page.getParams().get("startClaimDays") != null){
			hql += " and claimDays >= ?";
			params.add(Integer.valueOf(page.getParams().get("startClaimDays").toString()));
		}
		if(page.getParams().get("endClaimDays") != null){
			hql += " and claimDays <= ?";
			params.add(Integer.valueOf(page.getParams().get("endClaimDays").toString()));
		}
		if(page.getParams().get("customDeclareNo") != null){
			hql += " and customDeclareNo like ?";
			params.add("%" + page.getParams().get("customDeclareNo") + "%");
		}
		if(page.getParams().get("editId") != null){
			hql += " and editId = ?";
			params.add(Integer.valueOf(page.getParams().get("editId").toString()));
		}
		if(page.getParams().get("bargainNo") != null){
			hql += " and bargainNo like ?";
			params.add("%" + page.getParams().get("bargainNo") + "%");
		}
		if(page.getParams().get("shipperName") != null){
			hql += " and shipperName like ?";
			params.add("%" + page.getParams().get("shipperName") + "%");
		}
		if(page.getParams().get("consigneeName") != null){
			hql += " and consigneeName like ?";
			params.add("%" + page.getParams().get("consigneeName") + "%");
		}
		if(page.getParams().get("shipperNameEn") != null){
			hql += " and shipperNameEn like ?";
			params.add("%" + page.getParams().get("shipperNameEn") + "%");
		}
		if(page.getParams().get("consigneeNameEn") != null){
			hql += " and consigneeNameEn like ?";
			params.add("%" + page.getParams().get("consigneeNameEn") + "%");
		}
		if(page.getParams().get("shipperAddr") != null){
			hql += " and shipperAddr like ?";
			params.add("%" + page.getParams().get("shipperAddr") + "%");
		}
		if(page.getParams().get("consigneeAddr") != null){
			hql += " and consigneeAddr like ?";
			params.add("%" + page.getParams().get("consigneeAddr") + "%");
		}
		if(page.getParams().get("blNo") != null){
			hql += " and blNo like ?";
			params.add("%" + page.getParams().get("blNo") + "%");
		}
		if(page.getParams().get("tradeType") != null){
			hql += " and tradeType = ?";
			params.add(page.getParams().get("tradeType"));
		}
		if(page.getParams().get("chargeType") != null){
			hql += " and chargeType = ?";
			params.add(page.getParams().get("chargeType"));
		}
		if(page.getParams().get("tradeCode") != null){
			hql += " and tradeCode = ?";
			params.add(page.getParams().get("tradeCode"));
		}
		if(page.getParams().get("portLoad") != null){
			hql += " and portLoad = ?";
			params.add(page.getParams().get("portLoad"));
		}
		if(page.getParams().get("countryLoad") != null){
			hql += " and countryLoad like ?";
			params.add("%" + page.getParams().get("countryLoad") + "%");
		}
		if(page.getParams().get("portStop") != null){
			hql += " and portStop = ?";
			params.add(page.getParams().get("portStop"));
		}
		if(page.getParams().get("portDis") != null){
			hql += " and portDis = ?";
			params.add(page.getParams().get("portDis"));
		}
		if(page.getParams().get("markNo") != null){
			hql += " and markNo like ?";
			params.add("%" + page.getParams().get("markNo") + "%");
		}
		if(page.getParams().get("fCode") != null){
			hql += " and fCode = ?";
			params.add(page.getParams().get("fCode"));
		}
		if(page.getParams().get("reportType") != null){
			hql += " and reportType = ?";
			params.add(page.getParams().get("reportType"));
		}
		if(page.getParams().get("declCode") != null){
			hql += " and declCode like ?";
			params.add("%" + page.getParams().get("declCode") + "%");
		}
		if(page.getParams().get("applicant") != null){
			hql += " and applicant like ?";
			params.add("%" + page.getParams().get("applicant") + "%");
		}
		hql += " order by createTime desc";
		return entryDao.findPage(page, hql, params.toArray());
	}
	
}
