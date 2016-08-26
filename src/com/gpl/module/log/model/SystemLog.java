package com.gpl.module.log.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "log_sys")
public class SystemLog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 操作人账户
	 */
	private String account;
	/**
	 * 用户操作的方法
	 */
	private String method;
	/**
	 * 方法描述
	 */
	private String description;
	/**
	 * 类型
	 * 0-新增
	 * 1-用户操作日志
	 * 2-异常记录日志
	 */
	private Integer type;
	/**
	 * 异常代码
	 */
	private String ecode;
	/**
	 * 异常详情
	 */
	private String detail;
	/**
	 * 参数
	 */
	private String params;
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
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	@Column
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	@Column
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@Column
	public String getEcode() {
		return ecode;
	}
	public void setEcode(String ecode) {
		this.ecode = ecode;
	}
	@Column
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Column
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	@Column
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "SystemLog [id=" + id + ", account=" + account + ", method=" + method + ", description=" + description
				+ ", type=" + type + ", ecode=" + ecode + ", detail=" + detail + ", params=" + params + ", createTime="
				+ createTime + "]";
	}
	
	
	
}
