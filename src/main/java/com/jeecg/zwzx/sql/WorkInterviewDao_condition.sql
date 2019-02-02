		<#if ( workInterview.id )?? && workInterview.id ?length gt 0>
		    /* id */
			and wi.ID = :workInterview.id
		</#if>
		<#if ( workInterview.applyId )?? && workInterview.applyId ?length gt 0>
		    /* 申报编号 */
			and wi.APPLY_ID = :workInterview.applyId
		</#if>
		<#if ( workInterview.guideId )?? && workInterview.guideId ?length gt 0>
		    /* 指南编号 */
			and wi.GUIDE_ID = :workInterview.guideId
		</#if>
		<#if ( workInterview.management )?? && workInterview.management ?length gt 0>
		    /* 实施部门 */
			and wi.MANAGEMENT = :workInterview.management
		</#if>
		<#if ( workInterview.interviewStatus )?? && workInterview.interviewStatus ?length gt 0>
		    /* 预约状态 */
			and wi.INTERVIEW_STATUS = :workInterview.interviewStatus
		</#if>
	    <#if ( workInterview.interviewDate )??>
		    /* 预约日期  */
			and wi.INTERVIEW_DATE = :workInterview.interviewDate
		</#if>
		<#if ( workInterview.choosTime )?? && workInterview.choosTime ?length gt 0>
		    /* 时间段 */
			and wi.CHOOS_TIME = :workInterview.choosTime
		</#if>
	    <#if ( workInterview.interviewNum )??>
		    /* 预约日期  */
			and wi.INTERVIEW_NUM = :workInterview.interviewNum
		</#if>
	    <#if ( workInterview.dealDate )??>
		    /* 办理日期 */
			and wi.DEAL_DATE = :workInterview.dealDate
		</#if>
		<#if ( workInterview.dealPersion )?? && workInterview.dealPersion ?length gt 0>
		    /* 办理人员 */
			and wi.DEAL_PERSION = :workInterview.dealPersion
		</#if>
		<#if ( workInterview.audit )?? && workInterview.audit ?length gt 0>
		    /* 审核人  */
			and wi.AUDIT = :workInterview.audit
		</#if>
		<#if ( workInterview.reply )?? && workInterview.reply ?length gt 0>
		    /* 回复 */
			and wi.REPLY = :workInterview.reply
		</#if>
