package com.jeecg.zwzx.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：材料表
 * @author: www.jeecg.org
 * @since：2018年09月09日 16时48分47秒 星期日 
 * @version:1.0
 */
public class WorkMaterialEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *id	 */	private String id;	/**	 *材料名称	 */	private String materialName;	/**	 *材料内容	 */	private String materialContent;	/**	 *受理标准	 */	private String materialStandard;	/**	 *材料要求	 */	private String materialRequred;	/**	 *指南编号	 */	private String guideId;	/**
	 *指南名称
	 */
	private String guideName;
	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getMaterialName() {	    return this.materialName;	}	public void setMaterialName(String materialName) {	    this.materialName=materialName;	}	public String getMaterialContent() {	    return this.materialContent;	}	public void setMaterialContent(String materialContent) {	    this.materialContent=materialContent;	}	public String getMaterialStandard() {	    return this.materialStandard;	}	public void setMaterialStandard(String materialStandard) {	    this.materialStandard=materialStandard;	}	public String getMaterialRequred() {	    return this.materialRequred;	}	public void setMaterialRequred(String materialRequred) {	    this.materialRequred=materialRequred;	}	public String getGuideId() {	    return this.guideId;	}	public void setGuideId(String guideId) {	    this.guideId=guideId;	}
	public String getGuideName() {
		return guideName;
	}
	public void setGuideName(String guideName) {
		this.guideName = guideName;
	}
}

