package com.rfoe.msvc.foodie.common.constant;

import java.util.Arrays;
import java.util.List;

import com.rfoe.msvc.foodie.common.util.CommonUtil;

public class ConstantBoolean {


    public static final List<String> YES_AS_LIST = Arrays.asList(ConstantBoolean.YES, ConstantBoolean.TRUE, ConstantBoolean.MARKED,ConstantBoolean.YES_BIT);
	
	public static final String YES = "Y";
	public static final String NO = "N";
	
	public static final String TRUE = "Y";
	public static final String FALSE = "N";
	
	// To cater for SAP hl7 mapping
	public static final String MARKED = "X"; // means YES
	public static final String UNMARKED = ""; // means NO
	
	// To cater for third party system OAS
	public static final String YES_BIT = "1";
	public static final String NO_BIT = "0";
	
	public static String evaluateBoolean(String value){
		return CommonUtil.isEmpty(value) ? ConstantBoolean.NO : ( (ConstantBoolean.YES_AS_LIST.contains(value))  ? ConstantBoolean.YES: ConstantBoolean.NO) ;
	}
	
	private ConstantBoolean(){}
    
}
