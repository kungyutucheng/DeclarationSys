package com.gpl.module.entry.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entry")
public class Entry implements Serializable{

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
	 * 目的港
	 */
	private String portDis;
	/**
	 * 币种
	 */
	private String fCode;
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
	 * 起运国
	 */
	private String countryLoad;
	/**
	 * 经停港港口编码
	 */
	private String portStop;
	/**
	 * 贸易方式
	 */
	private String tradeType;
	/**
	 * 监管方式
	 */
	private String chargeType;
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
	 * ICIP平台唯一标识符
	 */
	private Integer eportInoundNo;
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
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column
	public String getEntInboundNo() {
		return entInboundNo;
	}
	public void setEntInboundNo(String entInboundNo) {
		this.entInboundNo = entInboundNo;
	}
	@Column
	public String getOperType() {
		return operType;
	}
	public void setOperType(String operType) {
		this.operType = operType;
	}
	@Column
	public Date getDeclarationDate() {
		return declarationDate;
	}
	public void setDeclarationDate(Date declarationDate) {
		this.declarationDate = declarationDate;
	}
	@Column
	public String getCiqbCode() {
		return ciqbCode;
	}
	public void setCiqbCode(String ciqbCode) {
		this.ciqbCode = ciqbCode;
	}
	@Column
	public String getBargainNo() {
		return bargainNo;
	}
	public void setBargainNo(String bargainNo) {
		this.bargainNo = bargainNo;
	}
	@Column
	public String getShipperName() {
		return shipperName;
	}
	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}
	@Column
	public String getShipperNameEn() {
		return shipperNameEn;
	}
	public void setShipperNameEn(String shipperNameEn) {
		this.shipperNameEn = shipperNameEn;
	}
	@Column
	public String getShipperAddr() {
		return shipperAddr;
	}
	public void setShipperAddr(String shipperAddr) {
		this.shipperAddr = shipperAddr;
	}
	@Column
	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	@Column
	public String getConsigneeNameEn() {
		return consigneeNameEn;
	}
	public void setConsigneeNameEn(String consigneeNameEn) {
		this.consigneeNameEn = consigneeNameEn;
	}
	@Column
	public String getConsigneeAddr() {
		return consigneeAddr;
	}
	public void setConsigneeAddr(String consigneeAddr) {
		this.consigneeAddr = consigneeAddr;
	}
	@Column
	public String getPortLoad() {
		return portLoad;
	}
	public void setPortLoad(String portLoad) {
		this.portLoad = portLoad;
	}
	@Column
	public String getPortDis() {
		return portDis;
	}
	public void setPortDis(String portDis) {
		this.portDis = portDis;
	}
	@Column
	public String getfCode() {
		return fCode;
	}
	public void setfCode(String fCode) {
		this.fCode = fCode;
	}
	@Column
	public Integer getTool() {
		return tool;
	}
	public void setTool(Integer tool) {
		this.tool = tool;
	}
	@Column
	public String getToolName() {
		return toolName;
	}
	public void setToolName(String toolName) {
		this.toolName = toolName;
	}
	@Column
	public String getToolNo() {
		return toolNo;
	}
	public void setToolNo(String toolNo) {
		this.toolNo = toolNo;
	}
	@Column
	public String getBlNo() {
		return blNo;
	}
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	@Column
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	@Column
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	@Column
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	@Column
	public String getStockLocation() {
		return stockLocation;
	}
	public void setStockLocation(String stockLocation) {
		this.stockLocation = stockLocation;
	}
	@Column
	public String getTradeCode() {
		return tradeCode;
	}
	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}
	@Column
	public String getCountryLoad() {
		return countryLoad;
	}
	public void setCountryLoad(String countryLoad) {
		this.countryLoad = countryLoad;
	}
	@Column
	public String getPortStop() {
		return portStop;
	}
	public void setPortStop(String portStop) {
		this.portStop = portStop;
	}
	@Column
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	@Column
	public String getChargeType() {
		return chargeType;
	}
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}
	@Column
	public String getTblType() {
		return tblType;
	}
	public void setTblType(String tblType) {
		this.tblType = tblType;
	}
	@Column
	public String getTblReportType() {
		return tblReportType;
	}
	public void setTblReportType(String tblReportType) {
		this.tblReportType = tblReportType;
	}
	@Column
	public String getMarkNo() {
		return markNo;
	}
	public void setMarkNo(String markNo) {
		this.markNo = markNo;
	}
	@Column
	public Integer getClaimDays() {
		return claimDays;
	}
	public void setClaimDays(Integer claimDays) {
		this.claimDays = claimDays;
	}
	@Column
	public String getSpecRequire() {
		return specRequire;
	}
	public void setSpecRequire(String specRequire) {
		this.specRequire = specRequire;
	}
	@Column
	public String getCustomDeclareNo() {
		return customDeclareNo;
	}
	public void setCustomDeclareNo(String customDeclareNo) {
		this.customDeclareNo = customDeclareNo;
	}
	@Column
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	@Column
	public String getDeclCode() {
		return declCode;
	}
	public void setDeclCode(String declCode) {
		this.declCode = declCode;
	}
	@Column
	public Integer getEditId() {
		return editId;
	}
	public void setEditId(Integer editId) {
		this.editId = editId;
	}
	@Column
	public Integer getEportInoundNo() {
		return eportInoundNo;
	}
	public void setEportInoundNo(Integer eportInoundNo) {
		this.eportInoundNo = eportInoundNo;
	}
	@Column
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Column
	public String getRegStatusDesc() {
		return regStatusDesc;
	}
	public void setRegStatusDesc(String regStatusDesc) {
		this.regStatusDesc = regStatusDesc;
	}
	@Column(insertable = false,updatable = false)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Override
	public String toString() {
		return "Entry [id=" + id + ", entInboundNo=" + entInboundNo + ", operType=" + operType + ", declarationDate="
				+ declarationDate + ", ciqbCode=" + ciqbCode + ", bargainNo=" + bargainNo + ", shipperName="
				+ shipperName + ", shipperNameEn=" + shipperNameEn + ", shipperAddr=" + shipperAddr + ", consigneeName="
				+ consigneeName + ", consigneeNameEn=" + consigneeNameEn + ", consigneeAddr=" + consigneeAddr
				+ ", portLoad=" + portLoad + ", portDis=" + portDis + ", fCode=" + fCode + ", tool=" + tool
				+ ", toolName=" + toolName + ", toolNo=" + toolNo + ", blNo=" + blNo + ", arrivalDate=" + arrivalDate
				+ ", uploadDate=" + uploadDate + ", destination=" + destination + ", stockLocation=" + stockLocation
				+ ", tradeCode=" + tradeCode + ", countryLoad=" + countryLoad + ", portStop=" + portStop
				+ ", tradeType=" + tradeType + ", chargeType=" + chargeType + ", tblType=" + tblType
				+ ", tblReportType=" + tblReportType + ", markNo=" + markNo + ", claimDays=" + claimDays
				+ ", specRequire=" + specRequire + ", customDeclareNo=" + customDeclareNo + ", reportType=" + reportType
				+ ", declCode=" + declCode + ", editId=" + editId + ", eportInoundNo=" + eportInoundNo + ", status="
				+ status + ", regStatusDesc=" + regStatusDesc + ", createTime=" + createTime + "]";
	}
	
	
	

}
