package com.jeecg.zwzx.utils;

import java.util.ResourceBundle;

/**
 * 项目参数工具类
 * 
 */
public class ResourceUtil {


	private static final ResourceBundle bundle = java.util.ResourceBundle.getBundle("sysConfig");
	public static final String getConfigByName(String name) {
		return bundle.getString(name);
	}

}
