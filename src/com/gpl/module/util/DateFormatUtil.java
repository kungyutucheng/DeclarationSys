package com.gpl.module.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatUtil {
	public static SimpleDateFormat yyMMddHHmmSS = new SimpleDateFormat("yyMMddHHmmSS");
	public static SimpleDateFormat yyyyMM = new SimpleDateFormat("yyyyMM");
	public static SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	public static SimpleDateFormat yyMMddHH = new SimpleDateFormat("yyMMddHH");
	public static SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat HHmm = new SimpleDateFormat("HH:mm");
	public static SimpleDateFormat HHmmss = new SimpleDateFormat("HH:mm:ss");
	public static SimpleDateFormat HHmmsss = new SimpleDateFormat("HHmmsss");
	public static SimpleDateFormat sss = new SimpleDateFormat("sss");
	public static SimpleDateFormat CN_LONG = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
	public static SimpleDateFormat CN_YMD = new SimpleDateFormat("yyyy年MM月dd日");
	public static SimpleDateFormat CN_MD = new SimpleDateFormat("MM月dd日");
	
	public static SimpleDateFormat ddHHmm = new SimpleDateFormat("dd HH:mm");
	
	public static SimpleDateFormat EEE = new SimpleDateFormat("EEE");
	public static SimpleDateFormat MMdd = new SimpleDateFormat("MMdd");
	
	public static SimpleDateFormat yMdHm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public static SimpleDateFormat yMdHms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static SimpleDateFormat dHm = new SimpleDateFormat("dd日 HH:mm");
	
	public static SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
	
	public static SimpleDateFormat yyyyMMddHHmmssSSS = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	
	public static String yyMMddHHFormat(Date date){
		return yyMMddHH.format(date);
	}
	
	public static String yyyyMMddHHmmssSSSFormat(Date date){
		return yyyyMMddHHmmssSSS.format(date);
	}
	
	public static Date yyMMddHHParse(String date) throws ParseException{
		return yyMMddHH.parse(date);
	}
	
	public static String yyyyMMddHHmmssFormat(Date date){
		return yyyyMMddHHmmss.format(date);
	}
	
	public static Date yyyyMMddHHmmssParse(String date) throws ParseException{
		return yyyyMMddHHmmss.parse(date);
	}
	
	public static String dHmFormat(Date date){
		return dHm.format(date);
	}
	
	public static String yMdHmFormat(Date date){
		return yMdHm.format(date);
	}
	
	public static Date yMdHmParse(String date) throws ParseException{
			return yMdHm.parse(date);
	}
	/**
	 * 生成"yyyy-MM-dd HH:mm:ss"格式的时间字符串
	 */
	public static String yMdHmsFormat(Date date){
		return yMdHms.format(date);
	}
	
	public static String yyMMddHHmmSSFormat(Date date){
		return yyMMddHHmmSS.format(date);
	}
	
	public static Date yMdHmsParse(String date) throws ParseException{
			return yMdHms.parse(date);
	}
	
	public static Date HHmmParse(String date) throws ParseException{
		return HHmm.parse(date);
	}
	
	public static Date yyyyMMddParse(String date){
			try {
				return yyyyMMdd.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return null;
	}
	
	public static Date yyyy_MM_ddParse(String date){
		try {
			return yyyy_MM_dd.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date cnYmdParse(String date){
		try {
			return CN_YMD.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String MMddFormat(Date date){
		return MMdd.format(date);
	}
	
	public static String yyyyMMddFormat(Date date){
		return yyyyMMdd.format(date);
	}
	
	public static String yyyyMMFormat(Date date){
		return yyyyMM.format(date);
	}
	
	public static String yyyy_MMd_dFormat(Date date){
		return yyyy_MM_dd.format(date);
	}
	
	public static String ddHHmmFormat(Date date){
		return ddHHmm.format(date);
	}
	
	public static String HHmmFormat(Date date){
		return HHmm.format(date);
	}
	
	public static String HHmmssFormat(Date date){
		return HHmmss.format(date);
	}
	
	public static String HHmmsssFormat(Date date){
		return HHmmsss.format(date);
	}
	
	public static String sssFormat(Date date){
		return sss.format(date);
	}
	
	public static String cn_longFormat(Date date){
		return CN_LONG.format(date);
	}
	
	public static String cn_YmdFormat(Date date){
		return CN_YMD.format(date);
	}
	
	public static String cn_MdFormat(Date date){
		return CN_MD.format(date);
	}
	
	public static String eeeFormat(Date date){
		return EEE.format(date);
	}
	
	public static Timestamp getTheFirstDayOfYear(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return new Timestamp(cal.getTime().getTime());
	}
	
	public static void main(String[] args) {
		Date date = new Date();
		date.setSeconds(0);
		System.out.println(date.getSeconds());
		System.out.println(yMdHmsFormat(date));
	}
	
}
