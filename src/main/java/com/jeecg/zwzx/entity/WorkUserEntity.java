package com.jeecg.zwzx.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：用户表
 * @author: www.jeecg.org
 * @since：2018年09月28日 06时06分13秒 星期五 
 * @version:1.0
 */
public class WorkUserEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String usertype;
	private String openid;
	
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
}
