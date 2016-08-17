package com.gpl.module.util;

import java.util.Date;


/**
 * messageID ����
 * @author yuzfeng
 *
 */
public class Creator {
	
	private static int randomNo = 0;
	
	private static synchronized String getRandomNo(){
		randomNo ++;
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(randomNo  >= 1000){
			randomNo = 1;
		}
		int needNo = randomNo;
		if(needNo < 10){
			return "00" + needNo;
		}else if(needNo < 100){
			return "0" + needNo;
		}else {
			return "" + needNo;
		}
	}
	
	public static synchronized String create(String messageType){
		return messageType + "_" + DateFormatUtil.yyyyMMddHHmmssFormat(new Date()) + getRandomNo();
	}
	/**
	 * ����������ҵ�ڲ��Ա��
	 * @param messageType
	 * @return
	 */
	public static synchronized String createEntImportNo(String messageType){
		return messageType + DateFormatUtil.yyyyMMddHHmmssFormat(new Date()) + getRandomNo();
	}
	
	/**
	 * ������Ʒ������
	 * @return
	 */
	public static synchronized String createCargobCode(){
		return DateFormatUtil.yyyyMMddHHmmssFormat(new Date()) + getRandomNo();
	}
	
	/**
	 * ������ҵ�ڲ��Ա��
	 * @return
	 */
	public static synchronized String createEntInboundNo(){
		return DateFormatUtil.yyyyMMddHHmmssFormat(new Date()) + getRandomNo();
	}
	
}
