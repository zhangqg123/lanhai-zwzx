package com.jeecg.zwzx.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：cms表
 * @author: www.jeecg.org
 * @since：2018年09月09日 14时21分19秒 星期日 
 * @version:1.0
 */
public class WorkGuideEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *id	 */	private String id;	/**
	 *指南名称
	 */
	private String guideName;
	/**	 *事项类型	 */	private String itemType;	/**	 *实施主体性质	 */	private String nature;	/**	 *实施机构	 */	private String management;	/**	 *目录编码/实施编码	 */	private String workCode;	/**	 *办事地点	 */	private String address;	/**	 *咨询电话	 */	private String phone;	/**	 *监督投诉	 */	private String audit;	/**	 *办件类型	 */	private String officeType;	/**	 *办理时间	 */	private String workTime;	/**	 *法定时限	 */	private String legalTime;	/**	 *承诺时间	 */	private String promiseTime;	/**	 *结果名称	 */	private String resultName;	/**	 *办理形式	 */	private String workType;	/**	 *行驶层级	 */	private String workLevel;	/**	 *数量限制	 */	private String numLimit;	/**	 *收费方式	 */	private String feeType;	/**	 *通办范围	 */	private String domain;	/**	 *中介服务	 */	private String agency;	/**	 *受理条件	 */	private String admissibility;	/**	 *foundation	 */	private String foundation;	/**	 *收费标准	 */	private String feeScale;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getGuideName() {
		return guideName;
	}
	public void setGuideName(String guideName) {
		this.guideName = guideName;
	}
	public String getItemType() {	    return this.itemType;	}	public void setItemType(String itemType) {	    this.itemType=itemType;	}	public String getnature() {	    return this.nature;	}	public void setnature(String nature) {	    this.nature=nature;	}	public String getManagement() {	    return this.management;	}	public void setManagement(String management) {	    this.management=management;	}	public String getWorkCode() {	    return this.workCode;	}	public void setWorkCode(String workCode) {	    this.workCode=workCode;	}	public String getAddress() {	    return this.address;	}	public void setAddress(String address) {	    this.address=address;	}	public String getPhone() {	    return this.phone;	}	public void setPhone(String phone) {	    this.phone=phone;	}	public String getAudit() {	    return this.audit;	}	public void setAudit(String audit) {	    this.audit=audit;	}	public String getOfficeType() {	    return this.officeType;	}	public void setOfficeType(String officeType) {	    this.officeType=officeType;	}	public String getWorkTime() {	    return this.workTime;	}	public void setWorkTime(String workTime) {	    this.workTime=workTime;	}	public String getLegalTime() {	    return this.legalTime;	}	public void setLegalTime(String legalTime) {	    this.legalTime=legalTime;	}	public String getPromiseTime() {	    return this.promiseTime;	}	public void setPromiseTime(String promiseTime) {	    this.promiseTime=promiseTime;	}	public String getResultName() {	    return this.resultName;	}	public void setResultName(String resultName) {	    this.resultName=resultName;	}	public String getWorkType() {	    return this.workType;	}	public void setWorkType(String workType) {	    this.workType=workType;	}	public String getWorkLevel() {	    return this.workLevel;	}	public void setWorkLevel(String workLevel) {	    this.workLevel=workLevel;	}	public String getNumLimit() {	    return this.numLimit;	}	public void setNumLimit(String numLimit) {	    this.numLimit=numLimit;	}	public String getFeeType() {	    return this.feeType;	}	public void setFeeType(String feeType) {	    this.feeType=feeType;	}	public String getDomain() {	    return this.domain;	}	public void setDomain(String domain) {	    this.domain=domain;	}	public String getAgency() {	    return this.agency;	}	public void setAgency(String agency) {	    this.agency=agency;	}	public String getAdmissibility() {	    return this.admissibility;	}	public void setAdmissibility(String admissibility) {	    this.admissibility=admissibility;	}	public String getFoundation() {	    return this.foundation;	}	public void setFoundation(String foundation) {	    this.foundation=foundation;	}	public String getFeeScale() {	    return this.feeScale;	}	public void setFeeScale(String feeScale) {	    this.feeScale=feeScale;	}
}

