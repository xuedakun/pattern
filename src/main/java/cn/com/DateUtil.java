package cn.com;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {
    public static final String DATE_STYLE = "yyyy-MM-dd";
    public static final String DATE_TIME_STYLE = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_STYLE_yyyyMMddHHmmss = "yyyyMMddHHmmss";
    public static final String DATE_TIME_STYLE_yyyyMMdd = "yyyyMMdd";
    public static final String START_SCOPE = "start";
	public static final String END_SCOPE = "end";
	
	public static String getTimeStr(Date date, String pattern) {
	  SimpleDateFormat sdf = new SimpleDateFormat(pattern);
      return sdf.format(date);
	}
    public static Date parse(String strDate, String pattern, Locale locale) {
      try {
          return StringUtils.isEmpty(strDate) ? null : new SimpleDateFormat(
                  pattern,locale).parse(strDate);
      } catch (ParseException e) {
          e.printStackTrace();
      }
      return null;
    }
    /**
     * 返回当前时间所对应的年月
     * @return
     */
    public static String getCurrentMonth(){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
    	return sdf.format(new Date());
    }
    /**
     * 返回上月时间
     * @return
     */
    public static String getLastMonth(){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
    	Calendar calendar = Calendar.getInstance();
    	int month = calendar.get(Calendar.MONTH);
    	calendar.set(Calendar.MONTH, month-1);
    	return sdf.format(calendar.getTime());
    }
    /**
     * 返回上个月的最后一天
     * @return
     */
    public static String getLastMonthLastDay(){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Calendar calendar = Calendar.getInstance();
    	int month = calendar.get(Calendar.MONTH);
    	calendar.set(Calendar.MONTH, month-1);
    	calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
    	Date strDateTo = calendar.getTime();
    	return sdf.format(strDateTo);
    }
    
	/**
	 * 目标日期不在sourceDates范围之内，而且大于sourceDate的任意日期
	 * @param sourceDates
	 * @param targetDate
	 * @return
	 */
	public static boolean isValidScopeDate(Date[] sourceDates, Date targetDate){
		boolean flag = false;
		if(targetDate == null){
			return flag;
		}
		Date startDate = sourceDates[0];
		Date endDate = sourceDates[1];
		int compareStartDate = targetDate.compareTo(startDate);
		int compareEndDate = targetDate.compareTo(endDate);
		if(compareStartDate>0 && compareEndDate>0){
			flag = true;
		}
		if(compareStartDate<0 && compareEndDate<0){
			flag = true;
		}
		
		return flag;
	}
	
	/**
	 * 判断目标日期是否大于srouceDate日期
	 * @param sourceDate
	 * @param targetDate
	 * @return
	 */
	public static boolean isValidScopeDate(Date sourceDate, Date targetDate){
		boolean flag = false;
		if(targetDate == null){
			return flag;
		}
		int compareRes = targetDate.compareTo(sourceDate);
		if(compareRes > 0){
			flag = true;
		}
		return flag;
	}
	/**
	 * 获取当前日期
	 * @author chendz 2013-6-25 下午2:23:36
	 *
	 * @return
	 */
	public static String getCurrentDate(){
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	/**
	 * 根据天数取得当前日期
	 * @author chendz 2013-6-25 下午2:23:47
	 *
	 * @param days 天数
	 * @return
	 */
	public static String getCurrentDate(int days){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
		
	}
	
	/**
	 * 判断目标日期是否在sourceDates之内
	 * @param sourceDates
	 * @param targetDate
	 * @return
	 */
	public static boolean isInValidScopeDate(Date[] sourceDates, Date targetDate){
		boolean flag = false;
		if(targetDate == null){
			return flag;
		}
		Date startDate = sourceDates[0];
		Date endDate = sourceDates[1];
		int compareStartDate = targetDate.compareTo(startDate);
		int compareEndDate = targetDate.compareTo(endDate);
		if(compareStartDate >=0 && compareEndDate<=0){
			flag = true;
		}
		return flag;
	}
	
	 /**   
	  * 将字符型转换为指定格式日期型   
	  * @author chendz 2012-12-20
	  * @param _date 需要转换成日期的字符串
	  * @param format 日期格式，如:yyyy-MM-dd。默认返回yyyy-MM-dd HH:mm:ss
	  * @return   Date
	  */    
	public static Date string2Date(String dateStr, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			throw new RuntimeException("字符串转日期时发生异常", e);
		}
		return date;
	}
	public static Date string2Date(String dateStr) {
		return string2Date(dateStr,DATE_TIME_STYLE);
	}

	public static boolean isDate(String date){
		Pattern pattern = Pattern.compile("^(\\d{1,4})(-|\\/)(\\d{1,2})\\2(\\d{1,2})$");
		Matcher matcher = pattern.matcher(date);
		return matcher.matches();
	}
	public static boolean isYear(String date){
		Pattern pattern = Pattern.compile("^(\\d{1,4})");
		Matcher matcher = pattern.matcher(date);
		return matcher.matches();
	}
	public static boolean isSeason(String date){
		Pattern pattern = Pattern.compile("^(\\d{1,4})(/|\\/)(\\d{1})");
		Matcher matcher = pattern.matcher(date);
		return matcher.matches();
	}
	public static boolean isMonth(String date){
		Pattern pattern = Pattern.compile("^(\\d{1,4})(-|\\/)(\\d{1,2})");
		Matcher matcher = pattern.matcher(date);
		return matcher.matches();
	}
	public static boolean isDateTime(String date){
		Pattern pattern = Pattern.compile("^(\\d{1,4})\\-(\\d{1,2})\\-(\\d{1,2}) (\\d{1,2}):(\\d{1,2}):(\\d{1,2})$");
		Matcher matcher = pattern.matcher(date);
		return matcher.matches();
	}
	/**
	 * 将前台的年季月日的日期格式统一转换为日的日期格式
	 * @author chendz 2013-5-2 上午9:45:22
	 *
	 * @param date
	 * @param scope
	 * @return
	 */
	public static String dateFormatChange(String date, String scope){
		//返回值
		String result = null;
		if(isYear(date)){
			if(START_SCOPE.equals(scope)){
				result = date + "-01-01";
			}else if(END_SCOPE.equals(scope)){
				result = date + "-12-31";
			}
		}else if(isSeason(date)){
			int season = Integer.parseInt(date.substring(date.length()-1));
			switch(season){
			case 1:
				if(START_SCOPE.equals(scope)){
					result = date.substring(0,date.length()-2) + "-01-01";
				}else if(END_SCOPE.equals(scope)){
					result = date.substring(0,date.length()-2) + "-03-31";
				}
				break;
			case 2:
				if(START_SCOPE.equals(scope)){
					result = date.substring(0,date.length()-2) + "-04-01";
				}else if(END_SCOPE.equals(scope)){
					result = date.substring(0,date.length()-2) + "-06-30";
				}
				break;
			case 3:
				if(START_SCOPE.equals(scope)){
					result = date.substring(0,date.length()-2) + "-07-01";
				}else if(END_SCOPE.equals(scope)){
					result = date.substring(0,date.length()-2) + "-09-30";
				}
				break;
			case 4:
				if(START_SCOPE.equals(scope)){
					result = date.substring(0,date.length()-2) + "-10-01";
				}else if(END_SCOPE.equals(scope)){
					result = date.substring(0,date.length()-2) + "-12-31";
				}
				break;
			}
			
		}else if(isMonth(date)){
			Date dateformat = null;
			try {
				dateformat = new SimpleDateFormat("yyyy-MM").parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
	        if(START_SCOPE.equals(scope)){
				result = date + "-01";
			}else if(END_SCOPE.equals(scope)){
		        Date lastDay = getLastDayOfMonth(dateformat);
		        result = new SimpleDateFormat("yyyy-MM-dd").format(lastDay);
			}
	        
		}else if(isDate(date)){
			result = date;
		}
		return result;
	}
	/**
	 * 返回月份的最后一天
	 * @author chendz 2013-5-2 上午10:21:20
	 *
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, value);
        return cal.getTime();
    }
	/**
	 * 获得两个日期之间的所有日期
	 * @author chendz 2013-8-13 下午4:22:59
	 *
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ParseException
	 */
	public static List<String> getDatesBetween2Date(String startDate, String endDate) throws ParseException {
		List<String> result = new ArrayList<String>();
		if(StringUtils.isBlank(startDate) || StringUtils.isBlank(endDate))
			return result;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Date> listDate = getDatesBetween2Date(sdf.parse(startDate),sdf.parse(endDate));
		for(Date date : listDate)
		{
			result.add(sdf.format(date));
		}
		return result;
	}
	public static List<Date> getDatesBetween2Date(Date startDate, Date endDate){
		List<Date> result = new ArrayList<Date>();
		result.add(startDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		while(true){
			//根据日历的规则，为给定的日历字段添加或减去指定的时间量  
			cal.add(Calendar.DAY_OF_MONTH, 1);
			// 测试此日期是否在指定日期之后  
			if(endDate.after(cal.getTime())){
				result.add(cal.getTime());  
			}else{  
				break;  
			}
		}
		result.add(endDate);
		return result;
	}
	
	/**  
     * 计算两个日期之间相差的天数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差天数 
     * @throws ParseException
     * add by zf
     */    
	public static int daysBetween(Date smdate, Date bdate)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}
	
	public static int getMonthSpace(String date1, String date2)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		return getMonthSpace(sdf.parse(date1),sdf.parse(date2));
	}
	
	public static int getMonthSpace(Date date1, Date date2) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(date1);
		c2.setTime(date2);
		int result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
		int month = (c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR))*12;
		result = result+month;
		return result == 0 ? 1 : Math.abs(result);
	}

	/**
	 * 自定义日期格式：
	 * 出错时返回null
	 * @param style
	 * @param date
	 * @return
	 */
	public static String getDateBySelfStyle(String style, Date date){
//		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(style);
			return simpleDateFormat.format(date);
//		}catch (NullPointerException npe){
//			npe.printStackTrace();
//		}catch (IllegalArgumentException iae){
//			iae.printStackTrace();
//		}
//		return null;
	}

	/**
	 * 超过BLACK_VALID_DAYS天
	 *
	 * @param getDate   日期
	 * @param validDays 有效天数
	 * @return false:超过validDays天
	 * true：小于等于validDays天
	 * @throws ParseException
	 */
	public static boolean lessThanDays(Date getDate, Integer validDays) throws ParseException {
		int days;
		Date date = new Date();//日期处理
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat FORMAT = new SimpleDateFormat("yyyyMMdd HH:mm");
		Date from = df.parse(FORMAT.format(getDate));
		Date to = df.parse(FORMAT.format(date));
		days = (int) Math.abs((to.getTime() - from.getTime())
				/ (24 * 60 * 60 * 1000)) + 1;
		if (days <= validDays) {
//			System.out.println("该客户查询频率小于" + validDays + "天，故直接查库########  黑名单接口结束时间：" + DateUtils.format("yyyy-MM-dd HH:mm:ss", new Date()));
			return true;
		}
		return false;
	}

	public static Integer IdCardNo2Age(String idcard){
		if(null == idcard || "".equals(idcard.trim()))
		{
			return null;
		}
		int length = idcard.length();
		String dates = "";
		if(length == 18){
			dates = idcard.substring(6,10);
			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			String year = df.format(new Date());
			int u = Integer.parseInt(year)- Integer.parseInt(dates);
			return u;
		}else{
			if(length == 15){
				dates = idcard.substring(6,8);
				return Integer.parseInt(dates);
			}else{
				return null;
			}
		}
	}
}
