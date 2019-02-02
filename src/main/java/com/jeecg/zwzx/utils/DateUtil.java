package com.jeecg.zwzx.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * 获取过去或者未来 任意天内的日期数组
	 * 
	 * @param intervals
	 *            intervals天内
	 * @return 日期数组
	 */
	public static ArrayList<String> getDaysList(int intervals) {
//		ArrayList<String> pastDaysList = new ArrayList<String>();
		ArrayList<String> futureDaysList = new ArrayList<String>();
		for (int i = 1; i <= intervals; i++) {
//			pastDaysList.add(getPastDate(i));
			futureDaysList.add(getFutureDate(i));
		}
		return futureDaysList;
	}

	/**
	 * 获取过去第几天的日期
	 * 
	 * @param past
	 * @return
	 */
	public static String getPastDate(int past) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR)
				- past);
		Date today = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String result = format.format(today);
		return result;
	}

	/**
	 * 获取未来 第 past 天的日期
	 * 
	 * @param past
	 * @return
	 */
	public static String getFutureDate(int past) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR)
				+ past);
		if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY||calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
			return "weekend";
		}
		Date today = calendar.getTime();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String result = format.format(today);
		return result;
	}
    public static void main(String args[]) { 
    	ArrayList<String> daysList = DateUtil.getDaysList(5);
        System.out.println("Hello World!"); 
    } 

}
