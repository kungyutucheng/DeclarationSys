package com.gpl.authorization.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "_user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String account;
	private String password;
	private Date createTime;
	private String creator;
	private int enabled;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	@Column(name = "pwd")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(insertable = false , updatable = false)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", password=" + password + ", createTime=" + createTime
				+ ", creator=" + creator + ", enabled=" + enabled + "]";
	}
	
	
}
