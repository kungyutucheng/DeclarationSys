package com.gpl.framework.model;

public class AjaxModel {

	private boolean success = false;
	private String msg = "error";
	private Object data;
	
	public AjaxModel(){
		
	}
	
	public AjaxModel(boolean success) {
		this.success = success;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
