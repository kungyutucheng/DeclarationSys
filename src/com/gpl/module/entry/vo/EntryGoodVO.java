package com.gpl.module.entry.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
public class EntryGoodVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ����
	 */
	private Integer id;
	/**
	 * �뾳��id
	 */
	private Integer eid;
	/**
	 * ���id
	 */
	private Integer contId;
	/**
	 * ���no
	 */
	private String conNo;
	/**
	 * �羳������ҵid
	 */
	private Integer cbeComId;
	/**
	 * �羳��ҵ��������
	 */
	private String cbeComName;
	/**
	 * hs����
	 */
	private String hsCode;
	/**
	 * ��Ʒ������
	 */
	private String ciqGoodsCode;
	/**
	 * ��Ʒ����
	 */
	private String gCode;
	/**
	 * ��Ʒ����
	 */
	private String goodsMaterial;
	/**
	 * ��װ��ʽ
	 */
	private String packType;
	/**
	 * ��װ��ʽ����
	 */
	private String packTypeName;
	/**
	 * ����
	 */
	private String fCode;
	/**
	 * ��������
	 */
	private String fName;
	/**
	 * ����
	 */
	private BigDecimal uPric;
	/**
	 * �ɹ�����
	 */
	private String buyFromCity;
	/**
	 * �ڶ�����
	 */
	private BigDecimal qtp;
	/**
	 * �ڶ�������λ
	 */
	private String qtpUnit;
	/**
	 * �ڶ�������λ����
	 */
	private String qtpUnitName;
	/**
	 * ����
	 */
	private BigDecimal qty;
	/**
	 * ��λ����
	 */
	private String qtyDesc;
	/**
	 * ë��
	 */
	private BigDecimal kgs;
	/**
	 * ����
	 */
	private BigDecimal net;
	/**
	 * �ܼ�
	 */
	private BigDecimal fcy;
	/**
	 * ������λ
	 */
	private String kgsUnit;
	/**
	 * ��װ����
	 */
	private BigDecimal packNum;
	/**
	 * ��Ʒ���κ�
	 */
	private String goodsBatchNo;
	/**
	 * ��װ����
	 */
	private Integer packPieceNum;
	/**
	 * ����ʱ��
	 */
	private Date createTime;
	
	public EntryGoodVO(Integer id, Integer eid, Integer contId, String conNo){
		super();
		this.id = id;
		this.eid = eid;
		this.contId = contId;
		this.conNo = conNo;
	}
	public EntryGoodVO(Integer id, Integer eid, Integer contId, String conNo, Integer cbeComId, String cbeComName,
			String hsCode, String ciqGoodsCode, String gCode, String goodsMaterial, String packType,
			String packTypeName, String fCode, String fName, BigDecimal uPric, String buyFromCity, BigDecimal qtp,
			String qtpUnit,String qtpUnitName, BigDecimal qty, String qtyDesc, BigDecimal kgs, BigDecimal net, BigDecimal fcy,
			String kgsUnit, BigDecimal packNum, String goodsBatchNo, Integer packPieceNum, Date createTime) {
		super();
		this.id = id;
		this.eid = eid;
		this.contId = contId;
		this.conNo = conNo;
		this.cbeComId = cbeComId;
		this.cbeComName = cbeComName;
		this.hsCode = hsCode;
		this.ciqGoodsCode = ciqGoodsCode;
		this.gCode = gCode;
		this.goodsMaterial = goodsMaterial;
		this.packType = packType;
		this.packTypeName = packTypeName;
		this.fCode = fCode;
		this.fName = fName;
		this.uPric = uPric;
		this.buyFromCity = buyFromCity;
		this.qtp = qtp;
		this.qtpUnit = qtpUnit;
		this.qtpUnitName = qtpUnitName;
		this.qty = qty;
		this.qtyDesc = qtyDesc;
		this.kgs = kgs;
		this.net = net;
		this.fcy = fcy;
		this.kgsUnit = kgsUnit;
		this.packNum = packNum;
		this.goodsBatchNo = goodsBatchNo;
		this.packPieceNum = packPieceNum;
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
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public Integer getContId() {
		return contId;
	}
	public void setContId(Integer contId) {
		this.contId = contId;
	}
	public String getConNo() {
		return conNo;
	}
	public void setConNo(String conNo) {
		this.conNo = conNo;
	}
	public Integer getCbeComId() {
		return cbeComId;
	}
	public void setCbeComId(Integer cbeComId) {
		this.cbeComId = cbeComId;
	}
	public String getCbeComName() {
		return cbeComName;
	}
	public void setCbeComName(String cbeComName) {
		this.cbeComName = cbeComName;
	}
	public String getHsCode() {
		return hsCode;
	}
	public void setHsCode(String hsCode) {
		this.hsCode = hsCode;
	}
	public String getCiqGoodsCode() {
		return ciqGoodsCode;
	}
	public void setCiqGoodsCode(String ciqGoodsCode) {
		this.ciqGoodsCode = ciqGoodsCode;
	}
	public String getgCode() {
		return gCode;
	}
	public void setgCode(String gCode) {
		this.gCode = gCode;
	}
	public String getGoodsMaterial() {
		return goodsMaterial;
	}
	public void setGoodsMaterial(String goodsMaterial) {
		this.goodsMaterial = goodsMaterial;
	}
	public String getPackType() {
		return packType;
	}
	public void setPackType(String packType) {
		this.packType = packType;
	}
	public String getPackTypeName() {
		return packTypeName;
	}
	public void setPackTypeName(String packTypeName) {
		this.packTypeName = packTypeName;
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
	public BigDecimal getuPric() {
		return uPric;
	}
	public void setuPric(BigDecimal uPric) {
		this.uPric = uPric;
	}
	public String getBuyFromCity() {
		return buyFromCity;
	}
	public void setBuyFromCity(String buyFromCity) {
		this.buyFromCity = buyFromCity;
	}
	public BigDecimal getQtp() {
		return qtp;
	}
	public void setQtp(BigDecimal qtp) {
		this.qtp = qtp;
	}
	public String getQtpUnit() {
		return qtpUnit;
	}
	public void setQtpUnit(String qtpUnit) {
		this.qtpUnit = qtpUnit;
	}
	public String getQtpUnitName() {
		return qtpUnitName;
	}
	public void setQtpUnitName(String qtpUnitName) {
		this.qtpUnitName = qtpUnitName;
	}
	public BigDecimal getQty() {
		return qty;
	}
	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}
	public String getQtyDesc() {
		return qtyDesc;
	}
	public void setQtyDesc(String qtyDesc) {
		this.qtyDesc = qtyDesc;
	}
	public BigDecimal getKgs() {
		return kgs;
	}
	public void setKgs(BigDecimal kgs) {
		this.kgs = kgs;
	}
	public BigDecimal getNet() {
		return net;
	}
	public void setNet(BigDecimal net) {
		this.net = net;
	}
	public BigDecimal getFcy() {
		return fcy;
	}
	public void setFcy(BigDecimal fcy) {
		this.fcy = fcy;
	}
	public String getKgsUnit() {
		return kgsUnit;
	}
	public void setKgsUnit(String kgsUnit) {
		this.kgsUnit = kgsUnit;
	}
	public BigDecimal getPackNum() {
		return packNum;
	}
	public void setPackNum(BigDecimal packNum) {
		this.packNum = packNum;
	}
	public String getGoodsBatchNo() {
		return goodsBatchNo;
	}
	public void setGoodsBatchNo(String goodsBatchNo) {
		this.goodsBatchNo = goodsBatchNo;
	}
	public Integer getPackPieceNum() {
		return packPieceNum;
	}
	public void setPackPieceNum(Integer packPieceNum) {
		this.packPieceNum = packPieceNum;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "EntryGood [id=" + id + ", eid=" + eid + ", contId=" + contId + ", conNo=" + conNo + ", cbeComId="
				+ cbeComId + ", cbeComName=" + cbeComName + ", hsCode=" + hsCode + ", ciqGoodsCode=" + ciqGoodsCode
				+ ", gCode=" + gCode + ", goodsMaterial=" + goodsMaterial + ", packType=" + packType + ", packTypeName="
				+ packTypeName + ", fCode=" + fCode + ", fName=" + fName + ", uPric=" + uPric + ", buyFromCity="
				+ buyFromCity + ", qtp=" + qtp + ", qtpUnit=" + qtpUnit + ", qty=" + qty + ", qtyDesc=" + qtyDesc
				+ ", kgs=" + kgs + ", net=" + net + ", fcy=" + fcy + ", kgsUnit=" + kgsUnit + ", packNum=" + packNum
				+ ", goodsBatchNo=" + goodsBatchNo + ", packPieceNum=" + packPieceNum + ", createTime=" + createTime
				+ "]";
	}
	
	
}
