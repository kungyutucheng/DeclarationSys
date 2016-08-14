package com.gpl.module.good.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONException;
import org.json.JSONObject;

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
	 * 当前状态，0-默认；1-待发送；2-待审核；3-接收失败；4-通过；5-不通过
	 */
	private Integer status;
	/**
	 * iciq回执信息
	 */
	private String regNotes;
	/**
	 * 商品备案申请主表id
	 */
	private Integer gmid;
	/**
	 * 商品录入日期
	 */
	private Date createTime;
	
	public Good() {
	}

	public Good(JSONObject jsonObject) throws JSONException{
		if(jsonObject.has("id")){
			this.id = jsonObject.getInt("id");
		}
		if(jsonObject.has("gCode")){
			this.gCode = jsonObject.getString("gCode");
		}
		if(jsonObject.has("gname")){
			this.gname = jsonObject.getString("gname");
		}
		if(jsonObject.has("spec")){
			this.spec = jsonObject.getString("spec");
		}
		if(jsonObject.has("hsCode")){
			this.hsCode = jsonObject.getString("hsCode");
		}
		if(jsonObject.has("unit")){
			this.unit = jsonObject.getString("unit");
		}
		if(jsonObject.has("goodsBarCode")){
			this.goodsBarCode = jsonObject.getString("goodsBarCode");
		}
		if(jsonObject.has("goodsDesc")){
			this.goodsDesc = jsonObject.getString("goodsDesc");
		}
		if(jsonObject.has("gRemark")){
			this.gRemark = jsonObject.getString("gRemark");
		}
		if(jsonObject.has("comName")){
			this.comName = jsonObject.getString("comName");
		}
		if(jsonObject.has("manufactureAddr")){
			this.manufactureAddr = jsonObject.getString("manufactureAddr");
		}
		if(jsonObject.has("brand")){
			this.brand = jsonObject.getString("brand");
		}
		if(jsonObject.has("assemCountry")){
			this.assemCountry = jsonObject.getString("assemCountry");
		}
		if(jsonObject.has("ingredient")){
			this.ingredient = jsonObject.getString("ingredient");
		}
		if(jsonObject.has("additiveFlag")){
			this.additiveFlag = jsonObject.getString("additiveFlag");
		}
		if(jsonObject.has("poisonFlag")){
			this.poisonFlag = jsonObject.getString("poisonFlag");
		}
		if(jsonObject.has("num")){
			this.num = (BigDecimal) jsonObject.get("num");
		}
		if(jsonObject.has("ciqGoodsNo")){
			this.ciqGoodsNo = jsonObject.getString("ciqGoodsNo");
		}
		if(jsonObject.has("status")){
			this.status = jsonObject.getInt("status");
		}
		if(jsonObject.has("regNotes")){
			this.regNotes = jsonObject.getString("regNotes");
		}
		if(jsonObject.has("gmid")){
			this.gmid = jsonObject.getInt("gmid");
		}
		
	}
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
	@Column(insertable = false)
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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

	@Column(insertable = false,updatable = false)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Good [id=" + id + ", gCode=" + gCode + ", gname=" + gname
				+ ", spec=" + spec + ", hsCode=" + hsCode + ", unit=" + unit
				+ ", goodsBarCode=" + goodsBarCode + ", goodsDesc=" + goodsDesc
				+ ", gRemark=" + gRemark + ", comName=" + comName
				+ ", manufactureAddr=" + manufactureAddr + ", brand=" + brand
				+ ", assemCountry=" + assemCountry + ", ingredient="
				+ ingredient + ", additiveFlag=" + additiveFlag
				+ ", poisonFlag=" + poisonFlag + ", num=" + num
				+ ", ciqGoodsNo=" + ciqGoodsNo + ", status=" + status
				+ ", regNotes=" + regNotes + ", gmid=" + gmid + ", createTime="
				+ createTime + "]";
	}
	
	
	
	

}
