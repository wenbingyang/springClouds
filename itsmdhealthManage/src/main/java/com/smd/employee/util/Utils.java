package com.smd.employee.util;

//import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @name Utils
 * @description 工具类
 * @author 朱晨晨 - zhuchenchen@sys-test.com.cn
 * @date 2017-8-1 上午10:32:48
 */
public class Utils {
	
	 private static final SimpleDateFormat datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 
	 //yyyy-MM-dd HH:mm:ss 格式  
     public static final String DEFAULT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";  
	 
     //yyyyMMddHHmmss 格式  
     public static final String DEFAULT_SYSTEM_TIME = "yyyyMMddHHmmss";  
	 //yyyy-MM-dd 格式  
     public static final String DEFAULT_DATE_FORMAT_PATTERN = "YYYY/MM/dd";

	//HH:mm:ss 格式
	 public static final String DEFAULT_TIME_FORMAT_PATTERN = "HH:mm:ss"; 

    //yyyy格式
    public static final String DEFAULT_YEAR_FORMAT_PATTERN = "yyyy";

    //MM格式
    public static final String DEFAULT_MONTH_FORMAT_PATTERN = "MM";

    //dd格式
	private static String DEFAULT_DAY_FORMAT_PATTERN = "dd";
	  //格式化日期
	 private static SimpleDateFormat df=null;
	/**
	 * @description (获得以 yyyy-MM-dd HH:mm:ss 为形式的当前时间字符串)
	 * @author 朱晨晨 - zhuchenchen@sys-test.com.cn
	 * @date 2017-8-1 上午10:33:45
	*/
    public static String getCurrentTimeBySecond() {
        return datetime.format(new Date(System.currentTimeMillis()));
    }
    
	/**
	 * @description (等价于StringUtils.isNotEmpty)
	 * @param  value
	 * @return boolean
	 * @author 朱晨晨 - zhuchenchen@sys-test.com.cn
	 * @date 2017-7-25 下午1:45:03
	 */
	public static boolean isNotEmpty(String value)  
	{  
	    return null != value && !"".equals(value) && "null" != value;  
	} 
	
	/**
	 * @description (判断集合等于空)
	 * @param  list
	 * @return true/false
	 * @author 朱晨晨 - zhuchenchen@sys-test.com.cn
	 * @date 2017-7-27 下午12:12:56
	 */
	public static boolean isEmpty(@SuppressWarnings("rawtypes") List list){
		return null==list || list.isEmpty() || list.size()<=0;
	}
	
	/**
	 * @description (判断集合不等于空)
	 * @param  list
	 * @return true/false
	 * @author 朱晨晨 - zhuchenchen@sys-test.com.cnmp
	 * @date 2017-7-27 下午12:12:56
	 */
	public static boolean isNotEmpty(@SuppressWarnings("rawtypes") List list){
		return null!=list && !list.isEmpty();
	}
	
	/**
	 * @description (获取系统当前时间 格式 :yyyy-MM-dd)
	 * @return  String
	 * @author 朱晨晨 - zhuchenchen@sys-test.com.cn
	 * @date 2017年8月28日 下午1:42:50
	 */
	public static String getDate(){  
	      df=new SimpleDateFormat(DEFAULT_DATE_FORMAT_PATTERN);
	     return df.format(new Date());
	}  
	
	/**
	 * @description (获取系统当前时间 格式 :HH:mm:ss)
	 * @return  String
	 * @author 朱晨晨 - zhuchenchen@sys-test.com.cn
	 * @date 2017年8月28日 下午1:42:50
	 */
	public static String getTime(){  
	      df=new SimpleDateFormat(DEFAULT_TIME_FORMAT_PATTERN);
	     return df.format(new Date());
	}

	public static String getYearMonthDay(){
		df=new SimpleDateFormat("yyyyMMdd");
		return df.format(new Date());
	}

	/**
	 * @description (获取系统当前时间 格式 :yyyy-MM-dd HH:mm:ss)
	 * @return  String
	 * @author 朱晨晨 - zhuchenchen@sys-test.com.cn
	 * @date 2017年8月28日 下午1:42:50
	 */
	public static String getDateTime(){  
	      df=new SimpleDateFormat(DEFAULT_DATE_TIME);
	     return df.format(new Date());
	} 
	
	public static String getSystemTime(){  
	      df=new SimpleDateFormat(DEFAULT_SYSTEM_TIME);
	     return df.format(new Date());
	} 

    /**
     * @description (获取当前年份)
     * @return
     * @author
     * @date
     */
    public static String getCurrentYear(){
        df=new SimpleDateFormat(DEFAULT_YEAR_FORMAT_PATTERN);
        return df.format(new Date());
    }

    /**
     * @description (获取当前月份)
     * @return
     * @author
     * @date
     */
    public static String getCurrentMonth(){
        df=new SimpleDateFormat(DEFAULT_MONTH_FORMAT_PATTERN);
        return df.format(new Date());
    }

	/**
	 * @description (获取当天日期)
	 * @return
	 * @author
	 * @date
	 */
	public static String getCurrentDay(){
		df=new SimpleDateFormat(DEFAULT_DAY_FORMAT_PATTERN);
		return df.format(new Date());
	}

    /**
	 * @description (计算两个时间的间隔 单位 分钟)
	 * @param  s1
	 * @param  s2
	 * @return long
	 * @author 朱晨晨 - zhuchenchen@sys-test.com.cn
	 * @date 2017年10月13日 下午2:53:33
	 */
	public static long getMinutesBetween(String s1, String s2) {
   		SimpleDateFormat sdf = new SimpleDateFormat (DEFAULT_DATE_TIME);
   		try {
   			Date dt1=sdf.parse(s1);
   			Date dt2=sdf.parse(s2);
   			return (dt1.getTime()-dt2.getTime())/(60*1000);	
   		} catch (Exception e) {
   			return 0;
   		}
   		
   	}
	/**
	 * @description (获取tomcat的temp文件夹的绝对路径,一般上传文件都上传到temp文件夹下  )
	 * @param  request
	 * @return String
	 * @author 朱晨晨 - zhuchenchen@sys-test.com.cn
	 * @date 2017年9月22日 下午4:38:04
	 */
	public static String getTempPath(HttpServletRequest request)
	{
		String separator = File.separator;
		// 项目的绝对路径
		String realpath = request.getSession().getServletContext().getRealPath("");
		// webapp路径
		String pRoot = realpath.substring(0, realpath.lastIndexOf(separator));
		// tomcat路径
		String tomcatpath = pRoot.substring(0, pRoot.lastIndexOf(separator));
		// temp路径
		return tomcatpath + separator + "temp";
	}
	
	/**
	 * @description (截取除了文件名前面的目录)
	 * @param  str
	 * @return String
	 * @author 朱晨晨 - zhuchenchen@sys-test.com.cn
	 * @date 2017年9月28日 上午9:03:44
	 */
	public static String Intercept(String str){
		int index = str.lastIndexOf("/"); 
		str = str.substring(0,index+1);
		//判断目录第一个字符是否包含/
		if (str.indexOf("/") ==0) {
			str =str.substring(0+1,str.length());
		}
		return str;
	}
	
	/**
	 * @description (截取文件名称)
	 * @param  str
	 * @return String
	 * @author 朱晨晨 - zhuchenchen@sys-test.com.cn
	 * @date 2017年9月28日 下午3:16:20
	 */
	public static String InterFileName(String str){
		int index = str.lastIndexOf("/"); 
		str = str.substring(index+1,str.length());
		return str;
	}
	
	/**
	 * @description (截取之前字符串之前的值)
	 * @param  str
	 * @return String
	 * @author 朱晨晨 - zhuchenchen@sys-test.com.cn
	 * @date 2017年9月28日 下午3:16:20
	 */
	public static String InterSpend(String str){
		int index = str.lastIndexOf("/"); 
		str = str.substring(0,index+1);
		return str;
	}
	
	/**
	 * @description (判断列名是否存在)
	 * @param rs
	 * @param columnName
	 * @return  方法返回说明
	 * @author 朱晨晨 - zhuchenchen@sys-test.com.cn
	 * @date 2017年10月12日 上午11:06:48
	 */
	public static boolean isExistColumn(ResultSet rs, String columnName) {  
	    try {  
	        if (rs.findColumn(columnName) > 0 ) {  
	            return true;  
	        }   
	    }  
	    catch (SQLException e) {  
	        return false;  
	    }  
	      
	    return false;  
	}
	
	/**
	 * @description (字符串截取)
	 * @param  str
	 * @return String
	 * @author 朱晨晨 - zhuchenchen@sys-test.com.cn
	 * @date 2017年10月24日 下午4:37:11
	 */
	public static String InterFlowUrl(String str){
		
		if (str.indexOf("/") == 0) {
			str = str.substring(1,str.length());
		}
		return str;
	}
	
	/**
	 * @description (截取指定字符之后的值)
	 * @param  str
	 * @return String
	 * @author 朱晨晨 - zhuchenchen@sys-test.com.cn
	 * @date 2017年10月10日 下午4:53:02
	 */
	public static String InterFileUrl(String str){
//		str = StringUtils.substringAfter(str, "temp");
		return str;
	}
	
	/**
	 * @description (不通过request方式获取tomcat根路径)
	 * @param
	 * @return  方法返回说明
	 * @author 朱晨晨 - zhuchenchen@sys-test.com.cn
	 * @date 2017年10月26日 上午10:58:02
	 */
	public static String tempTomcat(){
		String home = System.getProperty("catalina.home");
		home = home.replaceAll("\\\\","/");
		return home+"/temp/";
	}
	
	/**
	 * @description (获取系统行号)
	 * @return String
	 * @author 朱晨晨 - zhuchenchen@sys-test.com.cn
	 * @date 2017年11月3日 下午1:15:15
	 */
	public static String printLine(){
	     StackTraceElement[] trace = new Throwable().getStackTrace();
	        // 下标为0的元素是上一行语句的信息, 下标为1的才是调用printLine的地方的信息
	     StackTraceElement tmp = trace[1];
	     return tmp.getClassName() + "." + tmp.getMethodName() 
	            + "(" + tmp.getFileName() + ":" + tmp.getLineNumber() + ")";
	 }
	
	/**
	 * @description (效验字符串最后一位是否包含单斜杠,如有则截取)
	 * @param  str
	 * @return String
	 * @author 朱晨晨 - zhuchenchen@sys-test.com.cn
	 * @date 2017年11月14日 下午1:58:03
	 */
	public static String InterFirst(String str){
		//单斜杠的下标
		int index=str.lastIndexOf("/");
		//字符串的长度
		int length = str.length();
		if(index ==(length-1)){
			str = str.substring(0,length-1);
		}
		return str;
	}

	/**
	 * 计算加几个月之后的时间
	 * @param date
	 * @param dateType
	 * @param month
	 * @return
	 */
	public static String addMonth(String date,String dateType,int month){
		String nowDate = null;
		SimpleDateFormat format = new SimpleDateFormat(dateType);
		try {
			Date parse = format.parse(date);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(parse);
			calendar.add(Calendar.MONTH, month);
			nowDate = format.format(calendar.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return nowDate;
	}

	/**
	 * 获取指定时间前多少天的数据
	 * @param date	指定的时间字符串
	 * @param dateType 格式化类型：yyyy-MM-dd HH:mm:ss
	 * @param amount 往前推移N天
	 * @return
	 */
	public static String lastWeekDay(String date,String dateType,int amount) {
		String lastWeekDay = null;
		SimpleDateFormat format = new SimpleDateFormat(dateType);
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(format.parse(date));
			//过去指定的N天
			c.add(Calendar.DATE, amount);
			Date d = c.getTime();
			lastWeekDay = format.format(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return lastWeekDay;
	}

	/**
	 * null转空字符串
	 * @param s
	 * @return
	 */
	public static String nullToEmpty(Object s)
	{
		if (s == null)
		{
			s = "";
		}

		return s.toString();
	}

	/**
	 * 根据具体时间获取具体月份的所有工作日
	 *
	 * @param year
	 * @param month
	 * @return
	 */
	public static List<String> getDates(int year, int month) {
		List<String> dates = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, 1);

		while (cal.get(Calendar.YEAR) == year && cal.get(Calendar.MONTH) < month) {
			int day = cal.get(Calendar.DAY_OF_WEEK);

			if (!(day == Calendar.SUNDAY || day == Calendar.SATURDAY)) {
				dates.add(sdf.format(cal.getTime()));
			}
			cal.add(Calendar.DATE, 1);
		}
		return dates;
	}


	// 获取当前时间的上个月的开始时间
	public static String getLastMouthStart() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();// 上月开始日期
		cal.add(Calendar.MONTH, -1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return format.format(cal.getTime());
	}

	// 获取当前时间的上个月的结束时间
	public static String getLastMouthEnd() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal2 = Calendar.getInstance();// 上月结束日期
		cal2.set(Calendar.DAY_OF_MONTH, 1);
		cal2.add(Calendar.DATE, -1);
		return format.format(cal2.getTime());
	}

	/**
	 *  java.util.UUID 有可能重复
	 *  java.util.UUID + 日期时间 生成唯一ID ，length长度:46
	 * @return
	 */
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String str = sdf.format(new Date());
		uuid = uuid+str;
		return uuid;
	}

	/**
	 * 把map key转换为大写
	 * @param list
	 * @return
	 */
	public static List<Map<String, Object>> converMap2Map(List<Map<String, Object>> list) {
		List<Map<String, Object>> result = new ArrayList<>(list.size());
		for(int i=0;i<list.size();i++){
			Map<String,Object> obdmap = new HashMap<String, Object>();
			Set<String> se = list.get(i).keySet();
			for(String set :se){
				obdmap.put(set.toUpperCase(), list.get(i).get(set));
			}
			result.add(obdmap);
		}
		return result;
	}
	/**
	 * 把map key转换为大写
	 * @param map
	 * @return
	 */
	public static Map<String, Object> converMap2Map(Map<String, Object> map) {
		Map<String,Object> obdmap = new HashMap<String, Object>();
		Set<String> keys = map.keySet();
		for(String key :keys){
			obdmap.put(key.toUpperCase(), map.get(key));
		}

		return obdmap;
	}

	/**
	 * 取两集合差异的数据
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static List<String> getDiffrentList(List<String> list1, List<String> list2) {
		long st = System.nanoTime();
		List<String> diff = new ArrayList<String>();
		List<String> maxList = list1;
		List<String> minList = list2;
		if(list2.size()>list1.size())
		{
			maxList = list2;
			minList = list1;
		}
		Map<String,Integer> map = new HashMap<String,Integer>(maxList.size());
		for (String string : maxList) {
			map.put(string, 1);
		}
		for (String string : minList) {
			if(map.get(string)!=null)
			{
				map.put(string, 2);
				continue;
			}
			diff.add(string);
		}
		for(Map.Entry<String, Integer> entry:map.entrySet())
		{
			if(entry.getValue()==1)
			{
				diff.add(entry.getKey());
			}
		}
		return diff;

	}

	/**
	 * 取两集合相同的数据
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static List<String> getSameList(List<String> list1, List<String> list2) {
		List<String> result=new ArrayList<>();
		for (String string:list2) {
			if (list1.contains(string)) {
				result.add(string);
			}
		}
		return result;
	}
}
