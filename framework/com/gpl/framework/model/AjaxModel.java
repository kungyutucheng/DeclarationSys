package com.gpl.framework.model;

public class AjaxModel {

	public static final String SAVE_SUCCESS = "添加成功";
	public static final String SAVE_FAILURE = "系统出错，添加失败";
	public static final String UPDATE_SUCCESS = "更新成功";
	public static final String UPDATE_FAILURE = "系统出错，删除失败";
	public static final String DELETE_SUCCESS = "删除成功";
	public static final String DELETE_FAILURE = "系统出错，删除失败";
	public static final String RECORD_SUCCESS = "提交备案成功";
	public static final String RECORD_FAILURE = "系统出错，提交备案失败";
	
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
