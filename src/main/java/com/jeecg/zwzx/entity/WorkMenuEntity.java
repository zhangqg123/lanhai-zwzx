package com.jeecg.zwzx.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：分类表
 * @author: www.jeecg.org
 * @since：2018年09月12日 08时10分47秒 星期三 
 * @version:1.0
 */
public class WorkMenuEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *ID	 */	private String id;	/**	 *图片地址	 */	private String imageHref;	/**	 *图片名称	 */	private String imageName;	/**	 *栏目名称	 */	private String name;	/**	 *类型	 */	private String type;	/**	 *父节点	 */	private String parentCode;	/**	 *地址	 */	private String href;	/**	 *所属部门	 */	private String owner;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getImageHref() {	    return this.imageHref;	}	public void setImageHref(String imageHref) {	    this.imageHref=imageHref;	}	public String getImageName() {	    return this.imageName;	}	public void setImageName(String imageName) {	    this.imageName=imageName;	}	public String getName() {	    return this.name;	}	public void setName(String name) {	    this.name=name;	}	public String getType() {	    return this.type;	}	public void setType(String type) {	    this.type=type;	}	public String getParentCode() {	    return this.parentCode;	}	public void setParentCode(String parentCode) {	    this.parentCode=parentCode;	}	public String getHref() {	    return this.href;	}	public void setHref(String href) {	    this.href=href;	}	public String getOwner() {	    return this.owner;	}	public void setOwner(String owner) {	    this.owner=owner;	}
}

