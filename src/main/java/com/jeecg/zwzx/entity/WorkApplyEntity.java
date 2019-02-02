package com.jeecg.zwzx.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：申报表
 * @author: www.jeecg.org
 * @since：2018年10月05日 13时32分21秒 星期五 
 * @version:1.0
 */
public class WorkApplyEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *id	 */	private String id;	/**	 *实施部门	 */	private String management;	private String managementName;
	/**	 *指南编号	 */	private String guideId;
	private String guideName;
	
	private String interviewId;	/**	 *证件号码	 */	private String idNumber;	/**	 *申报主体	 */	private String applySubject;	/**	 *法人代表	 */	private String legalRepresent;	/**	 *联系人	 */	private String contact;	/**	 *联系手机	 */	private String mobile;	/**	 *联系电话	 */	private String phone;	/**	 *地址	 */	private String address;	/**	 *取件类型	 */	private Integer receiveType;	/**	 *办件数量	 */	private Integer applyNum;	/**	 *申报状态	 */	private Integer applyStatus;	/**	 *申报日期	 */	private Date applyData;	/**	 *处理日期	 */	private Date dealData;
		private Date interviewDate;
	
	private Integer choosTime;
	/**	 *办理人员	 */	private String dealPersion;
	private String personName;	/**	 *审核人	 */	private String audit;	/**	 *答复内容	 */	private String reply;
	/**
	 * 上传材料
	 */
	private String material;
	
	private String processInstanceId;
	
	private String deptLeaderPass;
	
	private String resCode;
	private String openId;
	private String formId;
	
		public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getManagement() {	    return this.management;	}	public void setManagement(String management) {	    this.management=management;	}	public String getGuideId() {	    return this.guideId;	}	public void setGuideId(String guideId) {	    this.guideId=guideId;	}	public String getIdNumber() {	    return this.idNumber;	}	public void setIdNumber(String idNumber) {	    this.idNumber=idNumber;	}	public String getApplySubject() {	    return this.applySubject;	}	public void setApplySubject(String applySubject) {	    this.applySubject=applySubject;	}	public String getLegalRepresent() {	    return this.legalRepresent;	}	public void setLegalRepresent(String legalRepresent) {	    this.legalRepresent=legalRepresent;	}	public String getContact() {	    return this.contact;	}	public void setContact(String contact) {	    this.contact=contact;	}	public String getMobile() {	    return this.mobile;	}	public void setMobile(String mobile) {	    this.mobile=mobile;	}	public String getPhone() {	    return this.phone;	}	public void setPhone(String phone) {	    this.phone=phone;	}	public String getAddress() {	    return this.address;	}	public void setAddress(String address) {	    this.address=address;	}	public Integer getReceiveType() {	    return this.receiveType;	}	public void setReceiveType(Integer receiveType) {	    this.receiveType=receiveType;	}	public Integer getApplyNum() {	    return this.applyNum;	}	public void setApplyNum(Integer applyNum) {	    this.applyNum=applyNum;	}	public Integer getApplyStatus() {	    return this.applyStatus;	}	public void setApplyStatus(Integer applyStatus) {	    this.applyStatus=applyStatus;	}	public Date getApplyData() {	    return this.applyData;	}	public void setApplyData(Date applyData) {	    this.applyData=applyData;	}	public Date getDealData() {	    return this.dealData;	}	public void setDealData(Date dealData) {	    this.dealData=dealData;	}	public String getDealPersion() {	    return this.dealPersion;	}	public void setDealPersion(String dealPersion) {	    this.dealPersion=dealPersion;	}	public String getAudit() {	    return this.audit;	}	public void setAudit(String audit) {	    this.audit=audit;	}	public String getReply() {	    return this.reply;	}	public void setReply(String reply) {	    this.reply=reply;	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getGuideName() {
		return guideName;
	}
	public void setGuideName(String guideName) {
		this.guideName = guideName;
	}
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public String getDeptLeaderPass() {
		return deptLeaderPass;
	}
	public void setDeptLeaderPass(String deptLeaderPass) {
		this.deptLeaderPass = deptLeaderPass;
	}
	public Date getInterviewDate() {
		return interviewDate;
	}
	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}
	public Integer getChoosTime() {
		return choosTime;
	}
	public void setChoosTime(Integer choosTime) {
		this.choosTime = choosTime;
	}
	public String getInterviewId() {
		return interviewId;
	}
	public void setInterviewId(String interviewId) {
		this.interviewId = interviewId;
	}
	public String getManagementName() {
		return managementName;
	}
	public void setManagementName(String managementName) {
		this.managementName = managementName;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getResCode() {
		return resCode;
	}
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
}

