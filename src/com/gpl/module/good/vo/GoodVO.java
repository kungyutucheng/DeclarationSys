package com.gpl.module.good.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * value object便于向前台传输数据
 * @author wyc
 *
 */
@Entity
public class GoodVO {

	private Integer id;
	private String gCode;
	private String gname;
	private String spec;
	private String hsCode;
	private String unit;
	private String goodsDesc;
	private String gRemark;
	private String comName;
	private String manufactureAddr;
	private String brand;
	private String assemCountry;
	private String ingredient;
	private String addtiveFlag;
	private String poisonFlag;
	private BigDecimal num;
	private String ciqGoodsNo;
	private String regNotes;
	private Integer gmid;
	private String cargobCode;
	private String ciqbName;
	private String cbeComName;
	private String remark;
	private String editName;
	private String operType;
	private Integer status;
	private Date createTime;
	
	public GoodVO() {
	}

	public GoodVO(Integer id, String gCode, String gname, String spec,
			String hsCode, String unit, String goodsDesc, String gRemark,
			String comName, String manufactureAddr, String brand,
			String assemCountry, String ingredient, String addtiveFlag,
			String poisonFlag, BigDecimal num, String ciqGoodsNo,Integer status,
			String regNotes, Integer gmid, String cargobCode,
			String ciqbName, String cbeComName, String remark, String editName,
			String operType,  Date createTime) {
		super();
		this.id = id;
		this.gCode = gCode;
		this.gname = gname;
		this.spec = spec;
		this.hsCode = hsCode;
		this.unit = unit;
		this.goodsDesc = goodsDesc;
		this.gRemark = gRemark;
		this.comName = comName;
		this.manufactureAddr = manufactureAddr;
		this.brand = brand;
		this.assemCountry = assemCountry;
		this.ingredient = ingredient;
		this.addtiveFlag = addtiveFlag;
		this.poisonFlag = poisonFlag;
		this.num = num;
		this.ciqGoodsNo = ciqGoodsNo;
		this.regNotes = regNotes;
		this.gmid = gmid;
		this.cargobCode = cargobCode;
		this.ciqbName = ciqbName;
		this.cbeComName = cbeComName;
		this.remark = remark;
		this.editName = editName;
		this.operType = operType;
		this.status = status;
		this.createTime = createTime;
	}

	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getgCode() {
		return gCode;
	}

	public void setgCode(String gCode) {
		this.gCode = gCode;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getHsCode() {
		return hsCode;
	}

	public void setHsCode(String hsCode) {
		this.hsCode = hsCode;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public String getgRemark() {
		return gRemark;
	}

	public void setgRemark(String gRemark) {
		this.gRemark = gRemark;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getManufactureAddr() {
		return manufactureAddr;
	}

	public void setManufactureAddr(String manufactureAddr) {
		this.manufactureAddr = manufactureAddr;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getAssemCountry() {
		return assemCountry;
	}

	public void setAssemCountry(String assemCountry) {
		this.assemCountry = assemCountry;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public String getAddtiveFlag() {
		return addtiveFlag;
	}

	public void setAddtiveFlag(String addtiveFlag) {
		this.addtiveFlag = addtiveFlag;
	}

	public String getPoisonFlag() {
		return poisonFlag;
	}

	public void setPoisonFlag(String poisonFlag) {
		this.poisonFlag = poisonFlag;
	}

	public BigDecimal getNum() {
		return num;
	}

	public void setNum(BigDecimal num) {
		this.num = num;
	}

	public String getCiqGoodsNo() {
		return ciqGoodsNo;
	}

	public void setCiqGoodsNo(String ciqGoodsNo) {
		this.ciqGoodsNo = ciqGoodsNo;
	}

	public String getRegNotes() {
		return regNotes;
	}

	public void setRegNotes(String regNotes) {
		this.regNotes = regNotes;
	}

	public Integer getGmid() {
		return gmid;
	}

	public void setGmid(Integer gmid) {
		this.gmid = gmid;
	}

	public String getCargobCode() {
		return cargobCode;
	}

	public void setCargobCode(String cargobCode) {
		this.cargobCode = cargobCode;
	}

	public String getCiqbName() {
		return ciqbName;
	}

	public void setCiqbName(String ciqbName) {
		this.ciqbName = ciqbName;
	}

	public String getCbeComName() {
		return cbeComName;
	}

	public void setCbeComName(String cbeComName) {
		this.cbeComName = cbeComName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getEditName() {
		return editName;
	}

	public void setEditName(String editName) {
		this.editName = editName;
	}

	public String getOperType() {
		return operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	
	
}
