package com.gpl.module.entry.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entry_con")
public class EntryCon implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 入境进区id
	 */
	private Integer eid;
	/**
	 * 箱号
	 */
	private String conNo;
	/**
	 * 尺寸
	 */
	private String conSize;
	/**
	 * 柜型
	 */
	private String conType;
	/**
	 * 封条号码
	 */
	private String sealNo;
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
	public String getConNo() {
		return conNo;
	}
	public void setConNo(String conNo) {
		this.conNo = conNo;
	}
	@Column
	public String getConSize() {
		return conSize;
	}
	public void setConSize(String conSize) {
		this.conSize = conSize;
	}
	@Column
	public String getConType() {
		return conType;
	}
	public void setConType(String conType) {
		this.conType = conType;
	}
	@Column
	public String getSealNo() {
		return sealNo;
	}
	public void setSealNo(String sealNo) {
		this.sealNo = sealNo;
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
		return "EntryCon [id=" + id + ", eid=" + eid + ", conNo=" + conNo + ", conSize=" + conSize + ", conType="
				+ conType + ", sealNo=" + sealNo + ", createTime=" + createTime + "]";
	}
	
	
	
}
