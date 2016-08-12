package com.gpl.module.good.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "good")
public class Good implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 商品货号
	 */
	private String gCode;
	/**
	 * 商品名称
	 */
	private String gname;
	/**
	 * 规格型号
	 */
	private String spec;
	/**
	 * 商品hs编码
	 */
	private String hsCode;
	/**
	 * 计量单位
	 */
	private String unit;
	/**
	 * 商品条形码
	 */
	private String goodsBarCode;
	/**
	 * 商品描述
	 */
	private String goodsDesc;
	/**
	 * 商品备注
	 */
	private String gRemark;
	/**
	 * 生产厂家
	 */
	private String comName;
	/**
	 * 生产厂家地址
	 */
	private String manufactureAddr;
	/**
	 * 品牌
	 */
	private String brand;
	/**
	 * 原产国/地区
	 */
	private String assemCountry;
	/**
	 * 成分
	 */
	private String ingredient;
	/**
	 * 超范围使用食品添加剂
	 */
	private String additiveFlag;
	/**
	 * 含有毒害物质，为空时默认为0
	 */
	private String poisonFlag;
	/**
	 * 商品库存数量
	 */
	private BigDecimal num;
	/**
	 * 商品备案号
	 */
	private String ciqGoodsNo;
	/**
	 * 商品审核状态：
	 * 10：通过
	 * 20：不通过
	 */
	private String regStatus;
	/**
	 * iciq回执信息
	 */
	private String regNotes;
	/**
	 * 商品备案申请主表id
	 */
	private Integer gmid;
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column
	public String getgCode() {
		return gCode;
	}
	public void setgCode(String gCode) {
		this.gCode = gCode;
	}
	@Column
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	@Column
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	@Column
	public String getHsCode() {
		return hsCode;
	}
	public void setHsCode(String hsCode) {
		this.hsCode = hsCode;
	}
	@Column
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Column
	public String getGoodsBarCode() {
		return goodsBarCode;
	}
	public void setGoodsBarCode(String goodsBarCode) {
		this.goodsBarCode = goodsBarCode;
	}
	@Column
	public String getGoodsDesc() {
		return goodsDesc;
	}
	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}
	@Column
	public String getgRemark() {
		return gRemark;
	}
	public void setgRemark(String gRemark) {
		this.gRemark = gRemark;
	}
	@Column
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	@Column
	public String getManufactureAddr() {
		return manufactureAddr;
	}
	public void setManufactureAddr(String manufactureAddr) {
		this.manufactureAddr = manufactureAddr;
	}
	@Column
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Column
	public String getAssemCountry() {
		return assemCountry;
	}
	public void setAssemCountry(String assemCountry) {
		this.assemCountry = assemCountry;
	}
	@Column
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	@Column
	public String getAdditiveFlag() {
		return additiveFlag;
	}
	public void setAdditiveFlag(String additiveFlag) {
		this.additiveFlag = additiveFlag;
	}
	@Column
	public String getPoisonFlag() {
		return poisonFlag;
	}
	public void setPoisonFlag(String poisonFlag) {
		this.poisonFlag = poisonFlag;
	}
	@Column
	public BigDecimal getNum() {
		return num;
	}
	public void setNum(BigDecimal num) {
		this.num = num;
	}
	@Column
	public String getCiqGoodsNo() {
		return ciqGoodsNo;
	}
	public void setCiqGoodsNo(String ciqGoodsNo) {
		this.ciqGoodsNo = ciqGoodsNo;
	}
	@Column
	public String getRegStatus() {
		return regStatus;
	}
	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}
	@Column
	public String getRegNotes() {
		return regNotes;
	}
	public void setRegNotes(String regNotes) {
		this.regNotes = regNotes;
	}
	@Column
	public Integer getGmid() {
		return gmid;
	}
	public void setGmid(Integer gmid) {
		this.gmid = gmid;
	}
	@Override
	public String toString() {
		return "Good [id=" + id + ", gCode=" + gCode + ", gname=" + gname + ", spec=" + spec + ", hsCode=" + hsCode
				+ ", unit=" + unit + ", goodsBarCode=" + goodsBarCode + ", goodsDesc=" + goodsDesc + ", gRemark="
				+ gRemark + ", comName=" + comName + ", manufactureAddr=" + manufactureAddr + ", brand=" + brand
				+ ", assemCountry=" + assemCountry + ", ingredient=" + ingredient + ", additiveFlag=" + additiveFlag
				+ ", poisonFlag=" + poisonFlag + ", num=" + num + ", ciqGoodsNo=" + ciqGoodsNo + ", regStatus="
				+ regStatus + ", regNotes=" + regNotes + ", gmid=" + gmid + "]";
	}
	
	

}
