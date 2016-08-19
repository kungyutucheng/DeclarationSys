package com.gpl.module.entry.model;

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
@Table(name = "entry_good")
public class EntryGood implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 入境表id
	 */
	private Integer eid;
	/**
	 * 箱号id
	 */
	private Integer contId;
	/**
	 * 跨境电商企业id
	 */
	private Integer cbeComId;
	/**
	 * hs编码
	 */
	private String hsCode;
	/**
	 * 商品备案号
	 */
	private String ciqGoodsNo;
	/**
	 * 商品货号
	 */
	private String gCode;
	/**
	 * 商品材质
	 */
	private String goodsMaterial;
	/**
	 * 包装方式
	 */
	private String packType;
	/**
	 * 币种
	 */
	private String fCode;
	/**
	 * 单价
	 */
	@NumberFormat(style = Style.NUMBER)
	private BigDecimal uPric;
	/**
	 * 采购城市
	 */
	private String buyFromCity;
	/**
	 * 第二数量
	 */
	@NumberFormat(style = Style.NUMBER)
	private BigDecimal qtp;
	/**
	 * 第二数量单位
	 */
	private String qtpUnit;
	/**
	 * 数量
	 */
	@NumberFormat(style = Style.NUMBER)
	private BigDecimal qty;
	/**
	 * 单位描述
	 */
	private String qtyDesc;
	/**
	 * 毛重
	 */
	@NumberFormat(style = Style.NUMBER)
	private BigDecimal kgs;
	/**
	 * 净重
	 */
	@NumberFormat(style = Style.NUMBER)
	private BigDecimal net;
	/**
	 * 总价
	 */
	private BigDecimal fcy;
	/**
	 * 重量单位
	 */
	private String kgsUnit;
	/**
	 * 包装数量
	 */
	@NumberFormat(style = Style.NUMBER)
	private BigDecimal packNum;
	/**
	 * 商品批次号
	 */
	private String goodsBatchNo;
	/**
	 * 包装件数
	 */
	private Integer packPieceNum;
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
	public String getCiqGoodsNo() {
		return ciqGoodsNo;
	}
	public void setCiqGoodsNo(String ciqGoodsNo) {
		this.ciqGoodsNo = ciqGoodsNo;
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
	public Integer getPackPieceNum() {
		return packPieceNum;
	}
	public void setPackPieceNum(Integer packPieceNum) {
		this.packPieceNum = packPieceNum;
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
		return "EntryGood [id=" + id + ", eid=" + eid + ", contId=" + contId + ", cbeComId=" + cbeComId + ", hsCode="
				+ hsCode + ", ciqGoodsNo=" + ciqGoodsNo + ", gCode=" + gCode + ", goodsMaterial=" + goodsMaterial
				+ ", packType=" + packType + ", fCode=" + fCode + ", uPric=" + uPric + ", buyFromCity=" + buyFromCity
				+ ", qtp=" + qtp + ", qtpUnit=" + qtpUnit + ", qty=" + qty + ", qtyDesc=" + qtyDesc + ", kgs=" + kgs
				+ ", net=" + net + ", fcy=" + fcy + ", kgsUnit=" + kgsUnit + ", packNum=" + packNum + ", goodsBatchNo="
				+ goodsBatchNo + ", packPieceNum=" + packPieceNum + ", createTime=" + createTime + "]";
	}
	
}
