package com.jeecg.zwzx.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：黑名单
 * @author: www.jeecg.org
 * @since：2018年11月11日 09时47分35秒 星期日 
 * @version:1.0
 */
public class WorkBlacklistEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *id	 */	private String id;	/**	 *手机	 */	private String phone;	/**	 *状态	 */	private Integer status;	/**	 *身份证号	 */	private String idcard;	/**	 *创建人	 */	private String createBy;	/**	 *创建日期	 */	private Date createDate;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getPhone() {	    return this.phone;	}	public void setPhone(String phone) {	    this.phone=phone;	}	public Integer getStatus() {	    return this.status;	}	public void setStatus(Integer status) {	    this.status=status;	}	public String getIdcard() {	    return this.idcard;	}	public void setIdcard(String idcard) {	    this.idcard=idcard;	}	public String getCreateBy() {	    return this.createBy;	}	public void setCreateBy(String createBy) {	    this.createBy=createBy;	}	public Date getCreateDate() {	    return this.createDate;	}	public void setCreateDate(Date createDate) {	    this.createDate=createDate;	}
}

