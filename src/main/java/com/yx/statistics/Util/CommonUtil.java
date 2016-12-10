package com.yx.statistics.Util;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

public class CommonUtil {
	
	private static final Logger LOG=Logger.getLogger(CommonUtil.class);
	
	public static boolean isEmpty(Object obj) throws Exception{
		if(obj ==null) return true;
		if( obj instanceof String ){
			if(String.valueOf(obj).trim().equals(""))
				return true;
			else
				return false;
		}
		else 
			throw new Exception("暂不支持该数据类型非空判断");
	}

	public static boolean isNum(String str) throws Exception{
		if(isEmpty(str))
			return false;
		String reg = "^-?\\d+$";
        return Pattern.compile(reg).matcher(str).find();
	}


	public static boolean isYMDHMS(String str) throws Exception{
		if(isEmpty(str))
			return false;
		String reg = "^(((20[0-3][0-9]-(0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|(20[0-3][0-9]-(0[2469]|11)-(0[1-9]|[12][0-9]|30))) (20|21|22|23|[0-1][0-9]):[0-5][0-9]:[0-5][0-9])$";
		return Pattern.compile(reg).matcher(str).find();
	}

	
	public static void main(String[] args) throws Exception {
		System.out.println(isYMDHMS("2016-10-01 10:10"));
	}
	
	

	public static String getRemoteHost(HttpServletRequest request){
	    String ip = request.getHeader("x-forwarded-for");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getRemoteAddr();
	    }
	    return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	}
	

}
