package com.gpl.module.good.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "good_main")
public class GoodMain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 商品申请编号
	 */
	private String cargobCode;
	/**
	 * 国检机构代码
	 */
	private String ciqbCode;
	/**
	 * 跨境电商企业id
	 */
	private Integer cbeComId;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 制单企业id
	 */
	private Integer editId;
	/**
	 * 操作类型
	 * A-新增（默认）
	 * M-修改
	 * I-自动引用
	 */
	private String operType;
	
	public GoodMain(){
		
	}
	
	public GoodMain(Integer id, String cargobCode, String ciqbCode, Integer cbeComId, String remark, Integer editId) {
		super();
		this.id = id;
		this.cargobCode = cargobCode;
		this.ciqbCode = ciqbCode;
		this.cbeComId = cbeComId;
		this.remark = remark;
		this.editId = editId;
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
	public String getCargobCode() {
		return cargobCode;
	}
	public void setCargobCode(String cargobCode) {
		this.cargobCode = cargobCode;
	}
	@Column
	public String getCiqbCode() {
		return ciqbCode;
	}
	public void setCiqbCode(String ciqbCode) {
		this.ciqbCode = ciqbCode;
	}
	@Column
	public Integer getCbeComId() {
		return cbeComId;
	}
	public void setCbeComId(Integer cbeComId) {
		this.cbeComId = cbeComId;
	}
	@Column
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column
	public Integer getEditId() {
		return editId;
	}
	public void setEditId(Integer editId) {
		this.editId = editId;
	}
	@Column(insertable = false , updatable = false)
	public String getOperType() {
		return operType;
	}
	public void setOperType(String operType) {
		this.operType = operType;
	}
	@Override
	public String toString() {
		return "GoodMain [id=" + id + ", cargobCode=" + cargobCode + ", ciqbCode=" + ciqbCode + ", cbeComId=" + cbeComId
				+ ", remark=" + remark + ", editId=" + editId + ", operType=" + operType + "]";
	}
	
	
	
}
