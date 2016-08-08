package com.gpl.framework.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;
import org.omg.PortableServer.POA;

public class Page<T> implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 公共变量
	 */
	private static final String ASC = "asc";
	private static final String DESC = "desc";

	/**
	 * 页号
	 */
	private int pageNo = -1;
	
	
	/**
	 * 每页数量
	 */
	private int pageSize = -1;
	
	/**
	 * 记录总数
	 */
	private long totalCount = -1;
	
	/**
	 * 查询结果
	 */
	private List<T> result;
	
	/**
	 * 查询的排序字段（仅仅是字段），多个字段之间以“，”隔开
	 */
	private String orderBy = null;
	/**
	 * 与排序字段对应的排序方式，多个字段之间以“，”隔开
	 */
	private String order = null;
	private boolean autoCount = true;
	
	/**
	 * 查询参数
	 */
	private Map<String, Object> params = new HashMap<String,Object>();
	
	
	/**
	 * 字段常量，避免修改名字时引起的麻烦
	 */
	public static final String PAGE_NO = "pageNo";
	public static final String PAGE_SIZE = "pageSize";
	public static final String TOTAL_COUNT = "totalCount";
	public static final String ORDER_BY = "orderBy";
	public static final String ORDER = "order";
	public static final String AUTO_COUNT = "autoCount";
	
	public Page(){
		
	}
	
	public Page(int pageSize){
		this.pageSize = pageSize;
	}

	/**
	 * 获得当前的页号，序号从1开始，默认为1
	 * @return
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * 设置当前页的页号，序号从1开始，低于1时自动调整为1
	 * @param pageNo
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
		
		if(pageNo < 1){
			this.pageNo = 1;
		}
	}
	
	/**
	 * 设置当前页的页号，返回当前对象，用于连续设置
	 * @param pageNo
	 * @return
	 */
	public Page<T> pageNo(int pageNo) {
		setPageNo(pageNo);
		return this;
	}

	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置每页的数据量，默认值为-1
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 设置每页的数据量，默认值为-1，返回当前对象以便连续设置
	 * @param pageSize
	 * @return
	 */
	public Page<T> pageSize(int pageSize) {
		setPageSize(pageSize);
		return this;
	}
	
	public long getTotalCount() {
		return totalCount;
	}

	/**
	 * 设置数据总量，默认值为-1
	 * @param totalCount
	 */
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	/**
	 * 设置数据总量，默认值为-1，返回当前对象以便连续设置
	 * @param totalCount
	 * @return
	 */
	public Page<T> totalCount(long totalCount) {
		setTotalCount(totalCount);
		return this;
	}

	
	public List<T> getResult() {
		return result;
	}

	/**
	 * 返回查询结果集
	 * @param result
	 */
	public void setResult(List<T> result) {
		this.result = result;
	}

	public String getOrderBy() {
		return orderBy;
	}

	/**
	 * 设置排序字段，多个字段之间以“，”隔开
	 * @param orderBy
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	/**
	 * 设置排序字段，返回当前对象以便连续设置
	 * @param orderBy
	 * @return
	 */
	public Page<T> orderBy(String orderBy) {
		setOrderBy(orderBy);
		return this;
	}

	public String getOrder() {
		return order;
	}

	/**
	 * 设置排序方式，多个字段之间以“,”隔开，默认值只能是“ASC”或“DESC”之中的一个，不区分大小写
	 * @param order
	 */
	public void setOrder(String order) {
		String temp = StringUtils.lowerCase(order);
		String orders [] = StringUtils.split(temp, ",");
		for(String item : orders){
			if(!StringUtils.equals(item, ASC) && !StringUtils.equals(item, DESC)){
				throw new IllegalArgumentException("排序方向" + order + "不合法");
			}
		}
		this.order = temp;
	}
	
	/**
	 * 是否已设置排序
	 * @return
	 */
	public boolean isOrderBySetted(){
		return (StringUtils.isNotBlank(order) && StringUtils.isNotBlank(orderBy));
	}

	/**
	 * 设置排序方式，返回当前对象以便连续设置
	 * @param order
	 * @return
	 */
	public Page<T> order(String order) {
		setOrder(order);
		return this;
	}
	
	public boolean isAutoCount() {
		return autoCount;
	}

	/**
	 * 设置查询对象时是否自动先执行count查询获取总记录数.
	 */
	public void setAutoCount(boolean autoCount) {
		this.autoCount = autoCount;
	}
	
	/**
	 * 设置查询对象时是否自动先执行count查询获取总记录数，返回当前对象以便连续设置
	 * @param autoCount
	 * @return
	 */
	public Page<T> autoCount(boolean autoCount) {
		setAutoCount(autoCount);
		return this;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	/**
	 * 获取总页数
	 * @return
	 */
	public long getPageCount(){
		if(totalCount == 0)
			return 0;
		if(pageSize == 0)
			return 0;
		long pageCount = totalCount / pageSize;
		if(totalCount % pageSize != 0){
			pageCount += 1;
		}
		return pageCount;
		
	}
	
	/**
	 * 获取每一页第一条数据的序号
	 * @return
	 */
	public int getFirstInPage(){
		return (pageNo - 1) * pageSize + 1;
	}
	
	/**
	 * 判断是否还有下一页
	 * @return
	 */
	public boolean hasNext(){
		return pageNo + 1 <= getPageCount() ? true : false;
	}
	
	/**
	 * 获取下一页的页号，如果已经是尾页，返回尾页页号
	 * @return
	 */
	public int getNextPage(){
		return hasNext() ? pageNo + 1 : pageNo;
	}
	
	/**
	 * 判断是否有上一页
	 * @return
	 */
	public boolean hasPre(){
		return pageNo - 1 >= 1 ? true : false;
	}
	
	/**
	 * 获取上一页页号，如果已经是首页，返回首页号码
	 * @return
	 */
	public int getPrePage(){
		return hasPre() ? pageNo - 1 : pageNo;
	}
}
