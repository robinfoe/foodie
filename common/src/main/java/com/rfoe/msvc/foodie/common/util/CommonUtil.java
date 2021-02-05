package com.rfoe.msvc.foodie.common.util;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.BeanUtils;

public class CommonUtil {


    public static final String ALPHA_NUMERIC_PATTERN = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]+$";
	public static final String TEXT_PATTERN = "^[a-zA-Z]+$";
	public static final String NUMERIC_PATTERN = "^[0-9]+$";
	public static final String QUEUE_FORMAT_PATTERN = "0000000000";
	public static final String[] DEFAULT_IGNORED_PROPERTIES = new String[] {  "createdById", "createdDateTime" , "modifiedById" , "modifiedDateTime" }; 
	//public static final String BASE64_HEADER = "data:image/png;base64,";
	public static final DecimalFormat QUEUE_DECIMAL_FORMAT = new DecimalFormat(CommonUtil.QUEUE_FORMAT_PATTERN);
	


    public static String idTrim(String str){
		return (str == null) ? null : str.trim().toUpperCase();
	}
	
	public static String toUpperCase(String str){
		return (str == null) ? null : str.toUpperCase();
	}
	
	public static String nullTrim(String str){
		return (CommonUtil.isEmpty(str)) ? "" : str.trim();
	}
	
	public static String getNullIfEmpty(String str){
		return (CommonUtil.isEmpty(str)) ? null : str;
	}
	
	public static String getEmptyIfNull(String str){
		return (CommonUtil.isEmpty(str)) ? "" : str;
	}
	
	public static String getReplacedIfEmpty(String source, String replace){
		return (CommonUtil.isEmpty(source)) ? replace : source;
    }
    

    public static boolean isNumeric(String str){
		if(CommonUtil.isEmpty(str)) return false;
		
		Pattern pattern = Pattern.compile(CommonUtil.NUMERIC_PATTERN);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
	public static boolean isEmpty(String... texts){
		for(String text : texts){
			if(text == null || "".equals(text.trim()) )
				continue;
			
			return false;
		}
		return true;
	}



	// Copy properties with default ignore
	public static <T extends Serializable>  T copyProperties(T source, T target) {
		return CommonUtil.copyProperties(source, target, CommonUtil.DEFAULT_IGNORED_PROPERTIES);
	}

	public static  <T extends Serializable>  T copyProperties(T source, T target,String...  ignored) {
		BeanUtils.copyProperties(source, target, ignored);
		return target;
	}
    
}
