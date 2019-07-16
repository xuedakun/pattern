package cn.com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 日期工具类
 * @author jiangqk
 * 2016-7-19
 */
public final class DateUtils {
	private static final Map<String,SimpleDateFormat> dateFmtMap = Collections.synchronizedMap(new HashMap<String,SimpleDateFormat>());
	
	/**
	 * 当前日期，只取日期部分
	 * @return
	 */
	public static Date currentDate(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	/**
	 * 下一天
	 * @return
	 */
	public static Date nextDate(){
		return DateUtils.addDay(currentDate(),1);
	}
	
	/**
	 * 当前时间
	 * @return
	 */
	public static Date currentTime(){
		return new Date();
	}

	/**
	 * 按指定的日期格式格式化数据日期
	 * @param format
	 * @param date
	 * @return
	 */
	public static String format(String format, Date date){
		if(date == null){
			return "";
		}
		
		SimpleDateFormat sdFmt = dateFmtMap.get(format);
		if(sdFmt==null){
			dateFmtMap.put(format,sdFmt = new SimpleDateFormat(format));
		}
		synchronized (sdFmt) {
			return sdFmt.format(date);
		}
	}


	
	/**
	 * 将字符串按指定格式转换成日期
	 * @param format
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String format, String date) throws ParseException {
		SimpleDateFormat sdFmt = dateFmtMap.get(format);
		if(sdFmt==null){
			dateFmtMap.put(format,sdFmt = new SimpleDateFormat(format));
		}
		synchronized (sdFmt) {
			return sdFmt.parse(date);
		}
	}
	
	public static Date parse(String format, String date, Locale locale) throws ParseException {
		SimpleDateFormat sdFmt = dateFmtMap.get(format+locale);
		if(sdFmt==null){
			dateFmtMap.put(format+locale,sdFmt = new SimpleDateFormat(format,locale));
		}
		synchronized (sdFmt) {
			return sdFmt.parse(date);
		}
	}
	
	//匹配并找出日期、时间，
	private static Pattern DATE_PARSE_PAT = Pattern.compile("([0-9]{1,4}[-/]{0,1}[0-1]{0,1}[0-9][-/]{0,1}[0-3]{0,1}[0-9])[\\s\\S]*?([0-2][0-9]([:]{0,1}[0-5]{0,1}[0-9]){0,2})");
	
	/**
	 * 将字符串转换成日期，根据传入的日期的长度推导出其格式，不保证能转换正确
	 * 接受的格式如下：yyyyMMdd,yyyy-MM-dd,MM/dd/yyyy
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String date) throws ParseException {
		
		int len = date.length();
		//如果长度是8，则可能是yyyyMMdd
		if( len ==8 ){
			return parse("yyyyMMdd",date);
		}else if(len == 10){
			//如果是10，则可能是yyyy-MM-dd和MM/dd/yyyy
			try{
				return parse("yyyy-MM-dd",date);
			}catch(ParseException e){
				return parse("MM/dd/yyyy",date);
			}
		}else if(len == 14){
			//如果是14位，则可能是yyyyMMddHHmmss
			return parse("yyyyMMddHHmmss",date);
		}else if(len == 19){
			//yyyy-MM-dd HH:mm:ss
			return parse("yyyy-MM-dd HH:mm:ss",date);
		}else{
			//只提取日期部分
			Matcher m = DATE_PARSE_PAT.matcher(date);
			if(m.find()){
				String tmpDate = m.group(1);
				
				if(tmpDate!=null && !tmpDate.equals("")){
					return parse(tmpDate);
				}
			}
		}
		return null;
	}
	
	/**
	 * ADD 小时，当num为负值时，将date减去相应的值
	 * @param date
	 * @param num
	 * @return
	 */
	public static Date addHour(Date date, int num){
		return addField(Calendar.HOUR,date,num);
	}
	
	/**
	 * ADD DAY，当num为负值时，将date减去相应的值
	 * @param date
	 * @param num
	 * @return
	 */
	public static Date addDay(Date date, int num){
		return addField(Calendar.DATE,date,num);
	}
	
	/**
	 * ADD MONTH
	 * @param date
	 * @param num
	 * @return
	 */
	public static Date addMonth(Date date, int num){
		return addField(Calendar.MONTH,date,num);
	}

	/**
	 * ADD YEAR
	 * @param date
	 * @param num
	 * @return
	 */
	public static Date addYear(Date date, int num){
		return addField(Calendar.YEAR,date,num);
	}
	
	public static int getDay(Date date){
		return getField(date, Calendar.DATE);
	}
	public static int getMonth(Date date){
		return getField(date, Calendar.MONTH);
	}
	public static int getYear(Date date){
		return getField(date, Calendar.YEAR);
	}
	public static int getHour(Date date){
		return getField(date, Calendar.HOUR);
	}
	public static int getMinute(Date date){
		return getField(date, Calendar.MINUTE);
	}
	public static int getSecond(Date date){
		return getField(date, Calendar.SECOND);
	}
	
	/**
	 * 取本月最后一天
	 * @param date
	 * @return
	 */
	public static Date getMonthLastDate(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		//下个月的第一天减一天
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.DATE, 1);
		c.add(Calendar.DATE, -1);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		return c.getTime();
	}
	
	/**
	 * 取本月最后一天
	 * @return
	 */
	public static Date getMonthLastDate(){
		return getMonthFirstDate(new Date());
	}
	
	/**
	 * 取本月第一天
	 * @param date
	 * @return
	 */
	public static Date getMonthFirstDate(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DATE, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 取本月第一天
	 * @return
	 */
	public static Date getMonthFirstDate(){
		return getMonthFirstDate(new Date());
	}
	/**
	 * 取本年最后一天
	 * @param date
	 * @return
	 */
	public static Date getYearLastDate(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		//下一年的第一天减一天
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DATE, 31);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		return c.getTime();
	}
	
	/**
	 * 取本年最后一天
	 * @return
	 */
	public static Date getYearLastDate(){
		return getYearLastDate(new Date());
	}
	/**
	 * 取本年第一天
	 * @param date
	 * @return
	 */
	public static Date getYearFirstDate(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.MONTH, 1);
		c.set(Calendar.DATE, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
	/**
	 * 取本年第一天
	 * @return
	 */
	public static Date getYearFirstDate(){
		return  getYearFirstDate(new Date());
	}
	
	/**
	 * 简化Calendar的加减操作，功能同Calendar.add方法一致
	 * @param date
	 * @param num
	 * @return
	 */
	private static Date addField(int field, Date date, int num){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(field, num);
		return c.getTime();
	}
	
	/**
	 * 获取某个字段
	 * @param field
	 * @param date
	 * @return
	 */
	private static int getField(Date date, int field){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(field);
	}
	
	public static Date getDateFromLong(Long time)
	{
		Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        return c.getTime();
	}
	
	public static void main(String[] args)
	{
		System.out.println(format("yyyy-MM-dd HH:mm:ss",getDateFromLong(1501144040517L)));
	}
}
