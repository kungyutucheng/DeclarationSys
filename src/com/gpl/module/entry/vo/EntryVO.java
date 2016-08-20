package com.gpl.module.entry.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class EntryVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 企业自编号
	 */
	private String entInboundNo;
	/**
	 * 操作类型
	 * A-新增
	 * M-变更
	 */
	private String operType;
	/**
	 * 申报日期
	 */
	private Date declarationDate;
	/**
	 * 申报机构
	 */
	private String ciqbCode;
	/**
	 * 申报机构名称
	 */
	private String ciqbName;
	/**
	 * 合同号
	 */
	private String bargainNo;
	/**
	 * 发货人姓名
	 */
	private String shipperName;
	/**
	 * 发货人英文名
	 */
	private String shipperNameEn;
	/**
	 * 发货人地址
	 */
	private String shipperAddr;
	/**
	 * 收货人姓名
	 */
	private String consigneeName;
	/**
	 * 收货人英文名
	 */
	private String consigneeNameEn;
	/**
	 * 收货人地址
	 */
	private String consigneeAddr;
	/**
	 * 起运港
	 */
	private String portLoad;
	/**
	 * 起运港名称
	 */
	private String portLoadName;
	/**
	 * 目的港
	 */
	private String portDis;
	/**
	 * 目的港名称
	 */
	private String portDisName;
	/**
	 * 币种
	 */
	private String fCode;
	/**
	 * 币种名称
	 */
	private String fName;
	/**
	 * 运输工具
	 * 0-默认
	 * 1-飞机
	 * 2-卡车
	 * 3-火车
	 * 4-船
	 * 5-其他
	 * 6-海运集装箱
	 * 7-陆运集装箱
	 * 8-空运集装箱
	 */
	private Integer tool;
	/**
	 * 运输工具名称
	 */
	private String toolName;
	/**
	 * 运输工具号
	 */
	private String toolNo;
	/**
	 * 提单号
	 */
	private String blNo;
	/**
	 * 到货日期
	 */
	private Date arrivalDate;
	/**
	 * 卸毕日期
	 */
	private Date uploadDate;
	/**
	 * 目的地
	 */
	private String destination;
	/**
	 * 存货地点
	 */
	private String stockLocation;
	/**
	 * 贸易国别
	 */
	private String tradeCode;
	/**
	 * 贸易国别名称
	 */
	private String tradeName;
	/**
	 * 起运国
	 */
	private String countryLoad;
	/**
	 * 经停港港口编码
	 */
	private String portStop;
	/**
	 * 经停港港口编码
	 */
	private String portStopName;
	/**
	 * 贸易方式
	 */
	private String tradeType;
	/**
	 * 贸易方式名称
	 */
	private String tradeTypeName;
	/**
	 * 监管方式
	 */
	private String chargeType;
	/**
	 * 监管方式名称
	 */
	private String chargeTypeName;
	/**
	 * 报检类别
	 */
	private String tblType;
	/**
	 * 报检申报类别
	 */
	private String tblReportType;
	/**
	 * 唛头
	 */
	private String markNo;
	/**
	 * 索赔期
	 */
	private Integer claimDays;
	/**
	 * 特殊要求
	 */
	private String specRequire;
	/**
	 * 报关单号
	 */
	private String customDeclareNo;
	/**
	 * 申报类别
	 */
	private String reportType;
	/**
	 * 预申报编码
	 */
	private String declCode;
	/**
	 * 外贸综合服务企业id
	 */
	private Integer editId;
	/**
	 * 外贸综合服务企业名称
	 */
	private String editName; 
	/**
	 * ICIP平台唯一标识符
	 */
	private Integer eportInboundNo;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 审核备注
	 */
	private String regStatusDesc;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	
	public EntryVO(Integer id, String entInboundNo, String operType, Date declarationDate, String ciqbCode,
			String ciqbName, String bargainNo, String shipperName, String shipperNameEn, String shipperAddr,
			String consigneeName, String consigneeNameEn, String consigneeAddr, String portLoad, String portLoadName,
			String portDis, String portDisName, String fCode, String fName, Integer tool, String toolName,
			String toolNo, String blNo, Date arrivalDate, Date uploadDate, String destination, String stockLocation,
			String tradeCode, String tradeName, String countryLoad, String portStop, String portStopName,
			String tradeType, String tradeTypeName, String chargeType, String chargeTypeName, String tblType,
			String tblReportType, String markNo, Integer claimDays, String specRequire, String customDeclareNo,
			String reportType, String declCode, Integer editId,String editName, Integer eportInboundNo, Integer status,
			String regStatusDesc, Date createTime) {
		super();
		this.id = id;
		this.entInboundNo = entInboundNo;
		this.operType = operType;
		this.declarationDate = declarationDate;
		this.ciqbCode = ciqbCode;
		this.ciqbName = ciqbName;
		this.bargainNo = bargainNo;
		this.shipperName = shipperName;
		this.shipperNameEn = shipperNameEn;
		this.shipperAddr = shipperAddr;
		this.consigneeName = consigneeName;
		this.consigneeNameEn = consigneeNameEn;
		this.consigneeAddr = consigneeAddr;
		this.portLoad = portLoad;
		this.portLoadName = portLoadName;
		this.portDis = portDis;
		this.portDisName = portDisName;
		this.fCode = fCode;
		this.fName = fName;
		this.tool = tool;
		this.toolName = toolName;
		this.toolNo = toolNo;
		this.blNo = blNo;
		this.arrivalDate = arrivalDate;
		this.uploadDate = uploadDate;
		this.destination = destination;
		this.stockLocation = stockLocation;
		this.tradeCode = tradeCode;
		this.tradeName = tradeName;
		this.countryLoad = countryLoad;
		this.portStop = portStop;
		this.portStopName = portStopName;
		this.tradeType = tradeType;
		this.tradeTypeName = tradeTypeName;
		this.chargeType = chargeType;
		this.chargeTypeName = chargeTypeName;
		this.tblType = tblType;
		this.tblReportType = tblReportType;
		this.markNo = markNo;
		this.claimDays = claimDays;
		this.specRequire = specRequire;
		this.customDeclareNo = customDeclareNo;
		this.reportType = reportType;
		this.declCode = declCode;
		this.editId = editId;
		this.editName = editName;
		this.eportInboundNo = eportInboundNo;
		this.status = status;
		this.regStatusDesc = regStatusDesc;
		this.createTime = createTime;
	}
	
	public EntryVO(Integer id, String entInboundNo, String operType, Date declarationDate, String ciqbCode,
			 String bargainNo, String shipperName, String shipperNameEn, String shipperAddr,
			String consigneeName, String consigneeNameEn, String consigneeAddr, String portLoad,
			String portDis, String portDisName, String fCode, Integer tool, String toolName,
			String toolNo, String blNo, Date arrivalDate, Date uploadDate, String destination, String stockLocation,
			String tradeCode, String countryLoad, String portStop,
			String tradeType, String chargeType, String tblType,
			String tblReportType, String markNo, Integer claimDays, String specRequire, String customDeclareNo,
			String reportType, String declCode, Integer editId,Integer eportInboundNo, Integer status,
			String regStatusDesc, Date createTime) {
		super();
		this.id = id;
		this.entInboundNo = entInboundNo;
		this.operType = operType;
		this.declarationDate = declarationDate;
		this.ciqbCode = ciqbCode;
		this.bargainNo = bargainNo;
		this.shipperName = shipperName;
		this.shipperNameEn = shipperNameEn;
		this.shipperAddr = shipperAddr;
		this.consigneeName = consigneeName;
		this.consigneeNameEn = consigneeNameEn;
		this.consigneeAddr = consigneeAddr;
		this.portLoad = portLoad;
		this.portDis = portDis;
		this.portDisName = portDisName;
		this.fCode = fCode;
		this.tool = tool;
		this.toolName = toolName;
		this.toolNo = toolNo;
		this.blNo = blNo;
		this.arrivalDate = arrivalDate;
		this.uploadDate = uploadDate;
		this.destination = destination;
		this.stockLocation = stockLocation;
		this.tradeCode = tradeCode;
		this.countryLoad = countryLoad;
		this.portStop = portStop;
		this.tradeType = tradeType;
		this.chargeType = chargeType;
		this.tblType = tblType;
		this.tblReportType = tblReportType;
		this.markNo = markNo;
		this.claimDays = claimDays;
		this.specRequire = specRequire;
		this.customDeclareNo = customDeclareNo;
		this.reportType = reportType;
		this.declCode = declCode;
		this.editId = editId;
		this.eportInboundNo = eportInboundNo;
		this.status = status;
		this.regStatusDesc = regStatusDesc;
		this.createTime = createTime;
	}
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEntInboundNo() {
		return entInboundNo;
	}
	public void setEntInboundNo(String entInboundNo) {
		this.entInboundNo = entInboundNo;
	}
	public String getOperType() {
		return operType;
	}
	public void setOperType(String operType) {
		this.operType = operType;
	}
	public Date getDeclarationDate() {
		return declarationDate;
	}
	public void setDeclarationDate(Date declarationDate) {
		this.declarationDate = declarationDate;
	}
	public String getCiqbCode() {
		return ciqbCode;
	}
	public void setCiqbCode(String ciqbCode) {
		this.ciqbCode = ciqbCode;
	}
	public String getCiqbName() {
		return ciqbName;
	}
	public void setCiqbName(String ciqbName) {
		this.ciqbName = ciqbName;
	}
	public String getBargainNo() {
		return bargainNo;
	}
	public void setBargainNo(String bargainNo) {
		this.bargainNo = bargainNo;
	}
	public String getShipperName() {
		return shipperName;
	}
	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}
	public String getShipperNameEn() {
		return shipperNameEn;
	}
	public void setShipperNameEn(String shipperNameEn) {
		this.shipperNameEn = shipperNameEn;
	}
	public String getShipperAddr() {
		return shipperAddr;
	}
	public void setShipperAddr(String shipperAddr) {
		this.shipperAddr = shipperAddr;
	}
	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	public String getConsigneeNameEn() {
		return consigneeNameEn;
	}
	public void setConsigneeNameEn(String consigneeNameEn) {
		this.consigneeNameEn = consigneeNameEn;
	}
	public String getConsigneeAddr() {
		return consigneeAddr;
	}
	public void setConsigneeAddr(String consigneeAddr) {
		this.consigneeAddr = consigneeAddr;
	}
	public String getPortLoad() {
		return portLoad;
	}
	public void setPortLoad(String portLoad) {
		this.portLoad = portLoad;
	}
	public String getPortLoadName() {
		return portLoadName;
	}
	public void setPortLoadName(String portLoadName) {
		this.portLoadName = portLoadName;
	}
	public String getPortDis() {
		return portDis;
	}
	public void setPortDis(String portDis) {
		this.portDis = portDis;
	}
	public String getPortDisName() {
		return portDisName;
	}
	public void setPortDisName(String portDisName) {
		this.portDisName = portDisName;
	}
	public String getfCode() {
		return fCode;
	}
	public void setfCode(String fCode) {
		this.fCode = fCode;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public Integer getTool() {
		return tool;
	}
	public void setTool(Integer tool) {
		this.tool = tool;
	}
	public String getToolName() {
		return toolName;
	}
	public void setToolName(String toolName) {
		this.toolName = toolName;
	}
	public String getToolNo() {
		return toolNo;
	}
	public void setToolNo(String toolNo) {
		this.toolNo = toolNo;
	}
	public String getBlNo() {
		return blNo;
	}
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getStockLocation() {
		return stockLocation;
	}
	public void setStockLocation(String stockLocation) {
		this.stockLocation = stockLocation;
	}
	public String getTradeCode() {
		return tradeCode;
	}
	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}
	public String getTradeName() {
		return tradeName;
	}
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	public String getCountryLoad() {
		return countryLoad;
	}
	public void setCountryLoad(String countryLoad) {
		this.countryLoad = countryLoad;
	}
	public String getPortStop() {
		return portStop;
	}
	public void setPortStop(String portStop) {
		this.portStop = portStop;
	}
	public String getPortStopName() {
		return portStopName;
	}
	public void setPortStopName(String portStopName) {
		this.portStopName = portStopName;
	}
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	public String getTradeTypeName() {
		return tradeTypeName;
	}
	public void setTradeTypeName(String tradeTypeName) {
		this.tradeTypeName = tradeTypeName;
	}
	public String getChargeType() {
		return chargeType;
	}
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}
	public String getChargeTypeName() {
		return chargeTypeName;
	}
	public void setChargeTypeName(String chargeTypeName) {
		this.chargeTypeName = chargeTypeName;
	}
	public String getTblType() {
		return tblType;
	}
	public void setTblType(String tblType) {
		this.tblType = tblType;
	}
	public String getTblReportType() {
		return tblReportType;
	}
	public void setTblReportType(String tblReportType) {
		this.tblReportType = tblReportType;
	}
	public String getMarkNo() {
		return markNo;
	}
	public void setMarkNo(String markNo) {
		this.markNo = markNo;
	}
	public Integer getClaimDays() {
		return claimDays;
	}
	public void setClaimDays(Integer claimDays) {
		this.claimDays = claimDays;
	}
	public String getSpecRequire() {
		return specRequire;
	}
	public void setSpecRequire(String specRequire) {
		this.specRequire = specRequire;
	}
	public String getCustomDeclareNo() {
		return customDeclareNo;
	}
	public void setCustomDeclareNo(String customDeclareNo) {
		this.customDeclareNo = customDeclareNo;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public String getDeclCode() {
		return declCode;
	}
	public void setDeclCode(String declCode) {
		this.declCode = declCode;
	}
	public Integer getEditId() {
		return editId;
	}
	public void setEditId(Integer editId) {
		this.editId = editId;
	}
	public String getEditName() {
		return editName;
	}
	public void setEditName(String editName) {
		this.editName = editName;
	}
	public Integer getEportInboundNo() {
		return eportInboundNo;
	}
	public void setEportInboundNo(Integer eportInboundNo) {
		this.eportInboundNo = eportInboundNo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRegStatusDesc() {
		return regStatusDesc;
	}
	public void setRegStatusDesc(String regStatusDesc) {
		this.regStatusDesc = regStatusDesc;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "EntryVO [id=" + id + ", entInboundNo=" + entInboundNo + ", operType=" + operType + ", declarationDate="
				+ declarationDate + ", ciqbCode=" + ciqbCode + ", ciqbName=" + ciqbName + ", bargainNo=" + bargainNo
				+ ", shipperName=" + shipperName + ", shipperNameEn=" + shipperNameEn + ", shipperAddr=" + shipperAddr
				+ ", consigneeName=" + consigneeName + ", consigneeNameEn=" + consigneeNameEn + ", consigneeAddr="
				+ consigneeAddr + ", portLoad=" + portLoad + ", portLoadName=" + portLoadName + ", portDis=" + portDis
				+ ", portDisName=" + portDisName + ", fCode=" + fCode + ", fName=" + fName + ", tool=" + tool
				+ ", toolName=" + toolName + ", toolNo=" + toolNo + ", blNo=" + blNo + ", arrivalDate=" + arrivalDate
				+ ", uploadDate=" + uploadDate + ", destination=" + destination + ", stockLocation=" + stockLocation
				+ ", tradeCode=" + tradeCode + ", tradeName=" + tradeName + ", countryLoad=" + countryLoad
				+ ", portStop=" + portStop + ", portStopName=" + portStopName + ", tradeType=" + tradeType
				+ ", tradeTypeName=" + tradeTypeName + ", chargeType=" + chargeType + ", chargeTypeName="
				+ chargeTypeName + ", tblType=" + tblType + ", tblReportType=" + tblReportType + ", markNo=" + markNo
				+ ", claimDays=" + claimDays + ", specRequire=" + specRequire + ", customDeclareNo=" + customDeclareNo
				+ ", reportType=" + reportType + ", declCode=" + declCode + ", editId=" + editId + ", eportInboundNo="
				+ eportInboundNo + ", status=" + status + ", regStatusDesc=" + regStatusDesc + ", createTime="
				+ createTime + "]";
	}
	
	
}
