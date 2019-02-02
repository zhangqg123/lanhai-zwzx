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
	
	/**
	private String guideName;
	
	private String interviewId;
	
	
	private Integer choosTime;
	/**
	private String personName;
	/**
	 * 上传材料
	 */
	private String material;
	
	private String processInstanceId;
	
	private String deptLeaderPass;
	
	private String resCode;
	private String openId;
	private String formId;
	
	
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
