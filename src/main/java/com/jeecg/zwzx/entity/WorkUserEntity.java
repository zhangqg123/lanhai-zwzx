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
		/**	 *ID	 */	private String id;	/**	 *手机	 */	private String phone;	/**	 *用户账号	 */	private String username;	/**	 *密码	 */	private String password;	/**	 *有效状态	 */	private Integer status;	/**	 *用户KEY	 */	private String userkey;	/**	 *身份证号	 */	private String idcard;	/**	 *真实名字	 */	private String realname;	/**	 *性别	 */	private Integer sex;	/**	 *地址	 */	private String address;
	private String usertype;
	private String openid;
	private String parent;
		public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getPhone() {	    return this.phone;	}	public void setPhone(String phone) {	    this.phone=phone;	}	public String getUsername() {	    return this.username;	}	public void setUsername(String username) {	    this.username=username;	}	public String getPassword() {	    return this.password;	}	public void setPassword(String password) {	    this.password=password;	}	public Integer getStatus() {	    return this.status;	}	public void setStatus(Integer status) {	    this.status=status;	}	public String getUserkey() {	    return this.userkey;	}	public void setUserkey(String userkey) {	    this.userkey=userkey;	}	public String getIdcard() {	    return this.idcard;	}	public void setIdcard(String idcard) {	    this.idcard=idcard;	}	public String getRealname() {	    return this.realname;	}	public void setRealname(String realname) {	    this.realname=realname;	}	public Integer getSex() {	    return this.sex;	}	public void setSex(Integer sex) {	    this.sex=sex;	}	public String getAddress() {	    return this.address;	}	public void setAddress(String address) {	    this.address=address;	}
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
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
}

