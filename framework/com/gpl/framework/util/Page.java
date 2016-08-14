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
	 * ��������
	 */
	private static final String ASC = "asc";
	private static final String DESC = "desc";

	/**
	 * ҳ��
	 */
	private int page = -1;
	
	
	/**
	 * ÿҳ����
	 */
	private int pageSize = -1;
	
	/**
	 * ��¼����
	 */
	private long total = -1;
	
	/**
	 * ��ѯ���
	 */
	private List<T> rows;
	
	/**
	 * ��ѯ�������ֶΣ��������ֶΣ�������ֶ�֮���ԡ���������
	 */
	private String orderBy = null;
	/**
	 * �������ֶζ�Ӧ������ʽ������ֶ�֮���ԡ���������
	 */
	private String order = null;
	private boolean autoCount = true;
	
	/**
	 * ��ѯ����
	 */
	private Map<String, Object> params = new HashMap<String,Object>();
	
	
	/**
	 * �ֶγ����������޸�����ʱ������鷳
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
	 * ��õ�ǰ��ҳ�ţ���Ŵ�1��ʼ��Ĭ��Ϊ1
	 * @return
	 */
	public int getPage() {
		return page;
	}

	/**
	 * ���õ�ǰҳ��ҳ�ţ���Ŵ�1��ʼ������1ʱ�Զ�����Ϊ1
	 * @param pageNo
	 */
	public void setPage(int page) {
		this.page = page;
		
		if(page < 1){
			this.page = 1;
		}
	}
	
	/**
	 * ���õ�ǰҳ��ҳ�ţ����ص�ǰ����������������
	 * @param pageNo
	 * @return
	 */
	public Page<T> page(int page) {
		setPage(page);
		return this;
	}

	public int getPageSize() {
		return pageSize;
	}

	/**
	 * ����ÿҳ����������Ĭ��ֵΪ-1
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * ����ÿҳ����������Ĭ��ֵΪ-1�����ص�ǰ�����Ա���������
	 * @param pageSize
	 * @return
	 */
	public Page<T> pageSize(int pageSize) {
		setPageSize(pageSize);
		return this;
	}
	
	public long getTotal() {
		return total;
	}

	/**
	 * ��������������Ĭ��ֵΪ-1
	 * @param totalCount
	 */
	public void setTotal(long total) {
		this.total = total;
	}
	
	/**
	 * ��������������Ĭ��ֵΪ-1�����ص�ǰ�����Ա���������
	 * @param totalCount
	 * @return
	 */
	public Page<T> total(long total) {
		setTotal(total);
		return this;
	}

	
	public List<T> getRows() {
		return rows;
	}

	/**
	 * ���ز�ѯ�����
	 * @param result
	 */
	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public String getOrderBy() {
		return orderBy;
	}

	/**
	 * ���������ֶΣ�����ֶ�֮���ԡ���������
	 * @param orderBy
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	/**
	 * ���������ֶΣ����ص�ǰ�����Ա���������
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
	 * ��������ʽ������ֶ�֮���ԡ�,��������Ĭ��ֵֻ���ǡ�ASC����DESC��֮�е�һ���������ִ�Сд
	 * @param order
	 */
	public void setOrder(String order) {
		String temp = StringUtils.lowerCase(order);
		String orders [] = StringUtils.split(temp, ",");
		for(String item : orders){
			if(!StringUtils.equals(item, ASC) && !StringUtils.equals(item, DESC)){
				throw new IllegalArgumentException("������" + order + "���Ϸ�");
			}
		}
		this.order = temp;
	}
	
	/**
	 * �Ƿ�����������
	 * @return
	 */
	public boolean isOrderBySetted(){
		return (StringUtils.isNotBlank(order) && StringUtils.isNotBlank(orderBy));
	}

	/**
	 * ��������ʽ�����ص�ǰ�����Ա���������
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
	 * ���ò�ѯ����ʱ�Ƿ��Զ���ִ��count��ѯ��ȡ�ܼ�¼��.
	 */
	public void setAutoCount(boolean autoCount) {
		this.autoCount = autoCount;
	}
	
	/**
	 * ���ò�ѯ����ʱ�Ƿ��Զ���ִ��count��ѯ��ȡ�ܼ�¼�������ص�ǰ�����Ա���������
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
	 * ��ȡ��ҳ��
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
	 * ��ȡÿһҳ��һ�����ݵ����
	 * @return
	 */
	public int getFirstInPage(){
		return (page - 1) * pageSize + 1;
	}
	
	/**
	 * �ж��Ƿ�����һҳ
	 * @return
	 */
	public boolean hasNext(){
		return page + 1 <= getPageCount() ? true : false;
	}
	
	/**
	 * ��ȡ��һҳ��ҳ�ţ�����Ѿ���βҳ������βҳҳ��
	 * @return
	 */
	public int getNextPage(){
		return hasNext() ? page + 1 : page;
	}
	
	/**
	 * �ж��Ƿ�����һҳ
	 * @return
	 */
	public boolean hasPre(){
		return page - 1 >= 1 ? true : false;
	}
	
	/**
	 * ��ȡ��һҳҳ�ţ�����Ѿ�����ҳ��������ҳ����
	 * @return
	 */
	public int getPrePage(){
		return hasPre() ? page - 1 : page;
	}
}
