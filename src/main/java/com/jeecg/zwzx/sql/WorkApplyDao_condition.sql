		<#if ( workApply.id )?? && workApply.id ?length gt 0>
		    /* id */
			and wa.ID = :workApply.id
		</#if>
		<#if ( workApply.management )?? && workApply.management ?length gt 0>
		    /* 实施部门 */
			and wa.MANAGEMENT = :workApply.management
		</#if>
		<#if ( workApply.guideId )?? && workApply.guideId ?length gt 0>
		    /* 指南编号 */
			and wa.GUIDE_ID = :workApply.guideId
		</#if>
		<#if ( workApply.idNumber )?? && workApply.idNumber ?length gt 0>
		    /* 证件号码 */
			and wa.ID_NUMBER = :workApply.idNumber
		</#if>
		<#if ( workApply.applySubject )?? && workApply.applySubject ?length gt 0>
		    /* 申报主体 */
			and wa.APPLY_SUBJECT = :workApply.applySubject
		</#if>
		<#if ( workApply.legalRepresent )?? && workApply.legalRepresent ?length gt 0>
		    /* 法人代表 */
			and wa.LEGAL_REPRESENT = :workApply.legalRepresent
		</#if>
		<#if ( workApply.contact )?? && workApply.contact ?length gt 0>
		    /* 联系人 */
			and wa.CONTACT = :workApply.contact
		</#if>
		<#if ( workApply.mobile )?? && workApply.mobile ?length gt 0>
		    /* 联系手机 */
			and wa.MOBILE = :workApply.mobile
		</#if>
		<#if ( workApply.phone )?? && workApply.phone ?length gt 0>
		    /* 联系电话 */
			and wa.PHONE = :workApply.phone
		</#if>
		<#if ( workApply.address )?? && workApply.address ?length gt 0>
		    /* 办件类型 */
			and wa.ADDRESS = :workApply.address
		</#if>
		<#if ( workApply.receiveType )?? && workApply.receiveType ?length gt 0>
		    /* 取件类型 */
			and wa.RECEIVE_TYPE = :workApply.receiveType
		</#if>
		<#if ( workApply.applyNum )?? && workApply.applyNum ?length gt 0>
		    /* 办件数量 */
			and wa.APPLY_NUM = :workApply.applyNum
		</#if>
		<#if ( workApply.applyStatus )?? && workApply.applyStatus ?length gt 0>
		    /* 申报状态 */
			and wa.APPLY_STATUS = :workApply.applyStatus
		</#if>
	    <#if ( workApply.applyData )??>
		    /* 申报日期 */
			and wa.APPLY_DATA = :workApply.applyData
		</#if>
	    <#if ( workApply.dealData )??>
		    /* 处理日期 */
			and wa.DEAL_DATA = :workApply.dealData
		</#if>
		<#if ( workApply.dealPersion )?? && workApply.dealPersion ?length gt 0>
		    /* 办理人员 */
			and wa.DEAL_PERSION = :workApply.dealPersion
		</#if>
		<#if ( workApply.audit )?? && workApply.audit ?length gt 0>
		    /* 审核人 */
			and wa.AUDIT = :workApply.audit
		</#if>
		<#if ( workApply.reply )?? && workApply.reply ?length gt 0>
		    /* 答复内容 */
			and wa.REPLY = :workApply.reply
		</#if>
		<#if ( workApply.material )?? && workApply.material ?length gt 0>
		    /* 答复内容 */
			and wa.material = :workApply.material
		</#if>
		<#if ( workApply.processInstanceId )?? && workApply.processInstanceId ?length gt 0>
		    /* 答复内容 */
			and wa.processInstanceId = :workApply.processInstanceId
		</#if>
		<#if ( workApply.resCode )?? && workApply.resCode ?length gt 0>
		    /* 答复内容 */
			and wa.res_code = :workApply.resCode
		</#if>
		<#if ( workApply.openId )?? && workApply.openId ?length gt 0>
		    /* 答复内容 */
			and wa.open_id = :workApply.openId
		</#if>
		<#if ( workApply.formId )?? && workApply.formId ?length gt 0>
		    /* 答复内容 */
			and wa.form_id = :workApply.formId
		</#if>
