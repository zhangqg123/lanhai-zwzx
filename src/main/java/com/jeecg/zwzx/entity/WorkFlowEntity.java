package com.jeecg.zwzx.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：流程表
 * @author: www.jeecg.org
 * @since：2018年09月09日 16时50分22秒 星期日 
 * @version:1.0
 */
public class WorkFlowEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *id	 */	private String id;	/**	 *流程名称	 */	private String flowName;	/**	 *流程内容	 */	private String flowContent;	/**	 *流程图	 */	private String flowChart;	/**	 *指南编号	 */	private String guideId;
	/**
	 *指南名称   非字段
	 */
	private String guideName;
		public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getFlowName() {	    return this.flowName;	}	public void setFlowName(String flowName) {	    this.flowName=flowName;	}	public String getFlowContent() {	    return this.flowContent;	}	public void setFlowContent(String flowContent) {	    this.flowContent=flowContent;	}	public String getFlowChart() {	    return this.flowChart;	}	public void setFlowChart(String flowChart) {	    this.flowChart=flowChart;	}	public String getGuideId() {	    return this.guideId;	}	public void setGuideId(String guideId) {	    this.guideId=guideId;	}
	public String getGuideName() {
		return guideName;
	}
	public void setGuideName(String guideName) {
		this.guideName = guideName;
	}
}

