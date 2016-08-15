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
	 * ����
	 */
	private Integer id;
	/**
	 * ��ҵ�Ա��
	 */
	private String entInboundNo;
	/**
	 * ��������
	 * A-����
	 * M-���
	 */
	private String operType;
	/**
	 * �걨����
	 */
	private Date declarationDate;
	/**
	 * �걨����
	 */
	private String ciqbCode;
	/**
	 * ��ͬ��
	 */
	private String bargainNo;
	/**
	 * ����������
	 */
	private String shipperName;
	/**
	 * ������Ӣ����
	 */
	private String shipperNameEn;
	/**
	 * �����˵�ַ
	 */
	private String shipperAddr;
	/**
	 * �ջ�������
	 */
	private String consigneeName;
	/**
	 * �ջ���Ӣ����
	 */
	private String consigneeNameEn;
	/**
	 * �ջ��˵�ַ
	 */
	private String consigneeAddr;
	/**
	 * ���˸�
	 */
	private String portLoad;
	/**
	 * Ŀ�ĸ�
	 */
	private String portDis;
	/**
	 * ����
	 */
	private String fCode;
	/**
	 * ���乤��
	 * 0-Ĭ��
	 * 1-�ɻ�
	 * 2-����
	 * 3-��
	 * 4-��
	 * 5-����
	 * 6-���˼�װ��
	 * 7-½�˼�װ��
	 * 8-���˼�װ��
	 */
	private Integer tool;
	/**
	 * ���乤������
	 */
	private String toolName;
	/**
	 * ���乤�ߺ�
	 */
	private String toolNo;
	/**
	 * �ᵥ��
	 */
	private String blNo;
	/**
	 * ��������
	 */
	private Date arrivalDate;
	/**
	 * ж������
	 */
	private Date uploadDate;
	/**
	 * Ŀ�ĵ�
	 */
	private String destination;
	/**
	 * ����ص�
	 */
	private String stockLocation;
	/**
	 * ó�׹���
	 */
	private String tradeCode;
	/**
	 * ���˹�
	 */
	private String countryLoad;
	/**
	 * ��ͣ�۸ۿڱ���
	 */
	private String portStop;
	/**
	 * ó�׷�ʽ
	 */
	private String tradeType;
	/**
	 * ��ܷ�ʽ
	 */
	private String chargeType;
	/**
	 * �������
	 */
	private String tblType;
	/**
	 * �����걨���
	 */
	private String tblReportType;
	/**
	 * ��ͷ
	 */
	private String markNo;
	/**
	 * ������
	 */
	private Integer claimDays;
	/**
	 * ����Ҫ��
	 */
	private String specRequire;
	/**
	 * ���ص���
	 */
	private String customDeclareNo;
	/**
	 * �걨���
	 */
	private String reportType;
	/**
	 * Ԥ�걨����
	 */
	private String declCode;
	/**
	 * ��ó�ۺϷ�����ҵid
	 */
	private Integer editId;
	/**
	 * ICIPƽ̨Ψһ��ʶ��
	 */
	private Integer eportInoundNo;
	/**
	 * ״̬
	 */
	private Integer status;
	/**
	 * ��˱�ע
	 */
	private String regStatusDesc;
	/**
	 * ����ʱ��
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
