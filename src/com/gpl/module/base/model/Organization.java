package com.gpl.module.base.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wyc
 *
 */
@Entity
@Table(name = "base_ciq_org_info")
public class Organization implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ����
	 */
	private Integer id;
	/**
	 * ����
	 */
	private String name;
	/**
	 * ������
	 */
	private String code;
	/**
	 * ��ע
	 */
	private String note;
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Column
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", code=" + code
				+ ", note=" + note + "]";
	}
	
	
}
