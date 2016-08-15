package com.gpl.module.entry.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entry_good")
public class EntryGood implements Serializable{

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
	 * �羳������ҵid
	 */
	private Integer cbeComId;
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
	 * ����
	 */
	private String fCode;
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
	private int packPieceNum;
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	@Column
	public Integer getContId() {
		return contId;
	}
	public void setContId(Integer contId) {
		this.contId = contId;
	}
	@Column
	public Integer getCbeComId() {
		return cbeComId;
	}
	public void setCbeComId(Integer cbeComId) {
		this.cbeComId = cbeComId;
	}
	@Column
	public String getHsCode() {
		return hsCode;
	}
	public void setHsCode(String hsCode) {
		this.hsCode = hsCode;
	}
	@Column
	public String getCiqGoodsCode() {
		return ciqGoodsCode;
	}
	public void setCiqGoodsCode(String ciqGoodsCode) {
		this.ciqGoodsCode = ciqGoodsCode;
	}
	@Column
	public String getgCode() {
		return gCode;
	}
	public void setgCode(String gCode) {
		this.gCode = gCode;
	}
	@Column
	public String getGoodsMaterial() {
		return goodsMaterial;
	}
	public void setGoodsMaterial(String goodsMaterial) {
		this.goodsMaterial = goodsMaterial;
	}
	@Column
	public String getPackType() {
		return packType;
	}
	public void setPackType(String packType) {
		this.packType = packType;
	}
	@Column
	public String getfCode() {
		return fCode;
	}
	public void setfCode(String fCode) {
		this.fCode = fCode;
	}
	@Column
	public BigDecimal getuPric() {
		return uPric;
	}
	public void setuPric(BigDecimal uPric) {
		this.uPric = uPric;
	}
	@Column
	public String getBuyFromCity() {
		return buyFromCity;
	}
	public void setBuyFromCity(String buyFromCity) {
		this.buyFromCity = buyFromCity;
	}
	@Column
	public BigDecimal getQtp() {
		return qtp;
	}
	public void setQtp(BigDecimal qtp) {
		this.qtp = qtp;
	}
	@Column
	public String getQtpUnit() {
		return qtpUnit;
	}
	public void setQtpUnit(String qtpUnit) {
		this.qtpUnit = qtpUnit;
	}
	@Column
	public BigDecimal getQty() {
		return qty;
	}
	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}
	@Column
	public String getQtyDesc() {
		return qtyDesc;
	}
	public void setQtyDesc(String qtyDesc) {
		this.qtyDesc = qtyDesc;
	}
	@Column
	public BigDecimal getKgs() {
		return kgs;
	}
	public void setKgs(BigDecimal kgs) {
		this.kgs = kgs;
	}
	@Column
	public BigDecimal getNet() {
		return net;
	}
	public void setNet(BigDecimal net) {
		this.net = net;
	}
	@Column
	public BigDecimal getFcy() {
		return fcy;
	}
	public void setFcy(BigDecimal fcy) {
		this.fcy = fcy;
	}
	@Column
	public String getKgsUnit() {
		return kgsUnit;
	}
	public void setKgsUnit(String kgsUnit) {
		this.kgsUnit = kgsUnit;
	}
	@Column
	public BigDecimal getPackNum() {
		return packNum;
	}
	public void setPackNum(BigDecimal packNum) {
		this.packNum = packNum;
	}
	@Column
	public String getGoodsBatchNo() {
		return goodsBatchNo;
	}
	public void setGoodsBatchNo(String goodsBatchNo) {
		this.goodsBatchNo = goodsBatchNo;
	}
	@Column
	public int getPackPieceNum() {
		return packPieceNum;
	}
	public void setPackPieceNum(int packPieceNum) {
		this.packPieceNum = packPieceNum;
	}
	@Override
	public String toString() {
		return "EntryGood [id=" + id + ", eid=" + eid + ", contId=" + contId + ", cbeComId=" + cbeComId + ", hsCode="
				+ hsCode + ", ciqGoodsCode=" + ciqGoodsCode + ", gCode=" + gCode + ", goodsMaterial=" + goodsMaterial
				+ ", packType=" + packType + ", fCode=" + fCode + ", uPric=" + uPric + ", buyFromCity=" + buyFromCity
				+ ", qtp=" + qtp + ", qtpUnit=" + qtpUnit + ", qty=" + qty + ", qtyDesc=" + qtyDesc + ", kgs=" + kgs
				+ ", net=" + net + ", fcy=" + fcy + ", kgsUnit=" + kgsUnit + ", packNum=" + packNum + ", goodsBatchNo="
				+ goodsBatchNo + ", packPieceNum=" + packPieceNum + "]";
	}
	
	
	
}
