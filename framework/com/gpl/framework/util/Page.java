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
	 * 排序常量
	 */
	private static final String ASC = "asc";
	private static final String DESC = "desc";

	/**
	 * 页号
	 */
	private int page = -1;
	
	
	/**
	 * 每页记录数
	 */
	private int pageSize = -1;
	
	/**
	 * 总记录数
	 */
	private long total = -1;
	
	/**
	 * 结果集
	 */
	private List<T> rows;
	
	/**
	 * 排序字段
	 */
	private String orderBy = null;
	/**
	 * 排序字段对应的排序规则
	 */
	private String order = null;
	private boolean autoCount = true;
	
	/**
	 * 查询参数
	 */
	private Map<String, Object> params = new HashMap<String,Object>();
	
	
	/**
	 * 常量
	 */
	public static final String PAGE_NO = "page";
	public static final String PAGE_SIZE = "rows";
	public static final String TOTAL_COUNT = "total";
	public static final String ORDER_BY = "orderBy";
	public static final String ORDER = "order";
	public static final String AUTO_COUNT = "autoCount";
	
	public Page(){
		
	}
	
	public Page(int pageSize){
		this.pageSize = pageSize;
	}

	/**
	 * 获取页数
	 * @return
	 */
	public int getPage() {
		return page;
	}

	/**
	 * 设置页数
	 * @param pageNo
	 */
	public void setPage(int page) {
		this.page = page;
		
		if(page < 1){
			this.page = 1;
		}
	}
	
	/**
	 * 链式设置页数
	 * @param pageNo
	 * @return
	 */
	public Page<T> page(int page) {
		setPage(page);
		return this;
	}

	/**
	 * 获取每页记录数
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置每页记录数
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 链式设置每页记录数
	 * @param pageSize
	 * @return
	 */
	public Page<T> pageSize(int pageSize) {
		setPageSize(pageSize);
		return this;
	}
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * 设置总记录数
	 * @param totalCount
	 */
	public void setTotal(long total) {
		this.total = total;
	}
	
	/**
	 * 链式设置总记录数
	 * @param totalCount
	 * @return
	 */
	public Page<T> total(long total) {
		setTotal(total);
		return this;
	}

	/**
	 * 获取结果集
	 * @return
	 */
	public List<T> getRows() {
		return rows;
	}

	/**
	 * 设置结果集
	 * @param result
	 */
	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	/**
	 * 获取排序字段
	 * @return
	 */
	public String getOrderBy() {
		return orderBy;
	}

	/**
	 * 设置排序字段
	 * @param orderBy
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	/**
	 * 链式设置排序字段
	 * @param orderBy
	 * @return
	 */
	public Page<T> orderBy(String orderBy) {
		setOrderBy(orderBy);
		return this;
	}

	/**
	 * 获取排序规则
	 * @return
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * 组织排序规则
	 * @param order
	 */
	public void setOrder(String order) {
		String temp = StringUtils.lowerCase(order);
		String orders [] = StringUtils.split(temp, ",");
		for(String item : orders){
			if(!StringUtils.equals(item, ASC) && !StringUtils.equals(item, DESC)){
				throw new IllegalArgumentException("排序规则" + order + "不符合要求");
			}
		}
		this.order = temp;
	}
	
	/**
	 * 是否设置排序
	 * @return
	 */
	public boolean isOrderBySetted(){
		return (StringUtils.isNotBlank(order) && StringUtils.isNotBlank(orderBy));
	}

	/**
	 * 链式设置排序规则
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
	 * 设置是否计算总数
	 */
	public void setAutoCount(boolean autoCount) {
		this.autoCount = autoCount;
	}
	
	/**
	 * 链式设置是否记录总数
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
	 * 获取页数
	 * @return
	 */
	public long getPageCount(){
		if(total == 0)
			return 0;
		if(pageSize == 0)
			return 0;
		long pageCount = total / pageSize;
		if(total % pageSize != 0){
			pageCount += 1;
		}
		return pageCount;
		
	}
	
	/**
	 * 获取每页的第一条记录
	 * @return
	 */
	public int getFirstInPage(){
		return (page - 1) * pageSize + 1;
	}
	
	/**
	 * 是否有下一页
	 * @return
	 */
	public boolean hasNext(){
		return page + 1 <= getPageCount() ? true : false;
	}
	
	/**
	 * 获取下一页页号
	 * @return
	 */
	public int getNextPage(){
		return hasNext() ? page + 1 : page;
	}
	
	/**
	 * 是否有前一页
	 * @return
	 */
	public boolean hasPre(){
		return page - 1 >= 1 ? true : false;
	}
	
	/**
	 * 获取前一页页号
	 * @return
	 */
	public int getPrePage(){
		return hasPre() ? page - 1 : page;
	}

	@Override
	public String toString() {
		return "Page [page=" + page + ", pageSize=" + pageSize + ", total="
				+ total + ", rows=" + rows + ", orderBy=" + orderBy
				+ ", order=" + order + ", autoCount=" + autoCount + ", params="
				+ params + "]";
	}
	
	
}
