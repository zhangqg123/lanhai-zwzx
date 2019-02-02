package com.jeecg.zwzx.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：预约表
 * @author: www.jeecg.org
 * @since：2018年11月07日 08时04分31秒 星期三 
 * @version:1.0
 */
public class WorkInterviewEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *id	 */	private String id;	/**	 *申报编号	 */	private String applyId;	/**	 *指南编号	 */	private String guideId;	/**	 *实施部门	 */	private String management;	/**	 *预约状态	 */	private Integer interviewStatus;	/**	 *预约日期 	 */	private Date interviewDate;	/**	 *时间段	 */	private Integer choosTime;
	
	private Integer interviewNum;
		/**	 *办理日期	 */	private Date dealDate;	/**	 *办理人员	 */	private String dealPersion;	/**	 *审核人 	 */	private String audit;	/**	 *回复	 */	private String reply;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getApplyId() {	    return this.applyId;	}	public void setApplyId(String applyId) {	    this.applyId=applyId;	}	public String getGuideId() {	    return this.guideId;	}	public void setGuideId(String guideId) {	    this.guideId=guideId;	}	public String getManagement() {	    return this.management;	}	public void setManagement(String management) {	    this.management=management;	}	public Integer getInterviewStatus() {	    return this.interviewStatus;	}	public void setInterviewStatus(Integer interviewStatus) {	    this.interviewStatus=interviewStatus;	}	public Date getInterviewDate() {	    return this.interviewDate;	}	public void setInterviewDate(Date interviewDate) {	    this.interviewDate=interviewDate;	}	public Integer getChoosTime() {	    return this.choosTime;	}	public void setChoosTime(Integer choosTime) {	    this.choosTime=choosTime;	}	public Date getDealDate() {	    return this.dealDate;	}	public void setDealDate(Date dealDate) {	    this.dealDate=dealDate;	}	public String getDealPersion() {	    return this.dealPersion;	}	public void setDealPersion(String dealPersion) {	    this.dealPersion=dealPersion;	}	public String getAudit() {	    return this.audit;	}	public void setAudit(String audit) {	    this.audit=audit;	}	public String getReply() {	    return this.reply;	}	public void setReply(String reply) {	    this.reply=reply;	}
	public Integer getInterviewNum() {
		return interviewNum;
	}
	public void setInterviewNum(Integer interviewNum) {
		this.interviewNum = interviewNum;
	}
}

