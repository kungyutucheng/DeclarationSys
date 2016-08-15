package com.gpl.module.entry.model;

import java.io.Serializable;

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
	 * 入境表id
	 */
	private Integer eid;
	/**
	 * 箱号
	 */
	private String contNo;
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
	public String getContNo() {
		return contNo;
	}
	public void setContNo(String contNo) {
		this.contNo = contNo;
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
	@Override
	public String toString() {
		return "EntryCon [id=" + id + ", eid=" + eid + ", contNo=" + contNo + ", conSize=" + conSize + ", conType="
				+ conType + ", sealNo=" + sealNo + "]";
	}
	
	
}
