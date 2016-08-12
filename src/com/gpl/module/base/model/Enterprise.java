package com.gpl.module.base.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enterprise")
public class Enterprise implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*public static final String ID = "id";
	public static final String ENMAE = "ename";
	public static final String ECODE = "ecode";
	public static final String ORGANIZATION = "organization";
	public static final String CONTACT = "contact";
	public static final String TELEPHONE = "telephone";
	public static final String ADDRESS = "address";
	public static final String NOTE = "note";*/
	/**
	 * ����
	 */
	private Integer id;
	/**
	 * ����
	 */
	private String ename;
	/**
	 * ������
	 */
	private String ecode;
	/**
	 * ��֯
	 */
	private String organization;
	/**
	 * ��ϵ�ˣ������ǣ�
	 */
	private String contact;
	/**
	 * �绰
	 */
	private String telephone;
	/**
	 * ��ַ
	 */
	private String address;
	/**
	 * ��ע
	 */
	private String note;
	/**
	 * ¼����
	 */
	private String recorder;
	/**
	 * ����ʱ��
	 */
	private Date createTime;
	/**
	 * ftp�˻�
	 */
	private String ftpUser;
	/**
	 * ftp����
	 */
	private String ftpPwd;
	/**
	 * ftp�˿�
	 */
	private String ftpPort;
	/**
	 * ftp��ַ
	 */
	private String ftpUrl;
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	@Column
	public String getEcode() {
		return ecode;
	}
	public void setEcode(String ecode) {
		this.ecode = ecode;
	}
	@Column
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	@Column
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Column
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Column
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Column
	public String getRecorder() {
		return recorder;
	}
	public void setRecorder(String recorder) {
		this.recorder = recorder;
	}
	@Column(insertable = false,updatable = false)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column
	public String getFtpUser() {
		return ftpUser;
	}
	public void setFtpUser(String ftpUser) {
		this.ftpUser = ftpUser;
	}
	@Column
	public String getFtpPwd() {
		return ftpPwd;
	}
	public void setFtpPwd(String ftpPwd) {
		this.ftpPwd = ftpPwd;
	}
	@Column
	public String getFtpPort() {
		return ftpPort;
	}
	public void setFtpPort(String ftpPort) {
		this.ftpPort = ftpPort;
	}
	@Column
	public String getFtpUrl() {
		return ftpUrl;
	}
	public void setFtpUrl(String ftpUrl) {
		this.ftpUrl = ftpUrl;
	}
	@Override
	public String toString() {
		return "Enterprise [id=" + id + ", ename=" + ename + ", ecode=" + ecode + ", organization=" + organization
				+ ", contact=" + contact + ", telephone=" + telephone + ", address=" + address + ", note=" + note
				+ ", recorder=" + recorder + ", createTime=" + createTime + ", ftpUser=" + ftpUser + ", ftpPwd="
				+ ftpPwd + ", ftpPort=" + ftpPort + ", ftpUrl=" + ftpUrl + "]";
	}
	
	
	
}
