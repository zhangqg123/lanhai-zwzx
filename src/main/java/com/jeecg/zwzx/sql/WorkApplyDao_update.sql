UPDATE work_apply
SET 
	   <#if workApply.id ?exists>
		   ID = :workApply.id,
		</#if>
	   <#if workApply.management ?exists>
		   MANAGEMENT = :workApply.management,
		</#if>
	   <#if workApply.guideId ?exists>
		   GUIDE_ID = :workApply.guideId,
		</#if>
	   <#if workApply.idNumber ?exists>
		   ID_NUMBER = :workApply.idNumber,
		</#if>
	   <#if workApply.applySubject ?exists>
		   APPLY_SUBJECT = :workApply.applySubject,
		</#if>
	   <#if workApply.legalRepresent ?exists>
		   LEGAL_REPRESENT = :workApply.legalRepresent,
		</#if>
	   <#if workApply.contact ?exists>
		   CONTACT = :workApply.contact,
		</#if>
	   <#if workApply.mobile ?exists>
		   MOBILE = :workApply.mobile,
		</#if>
	   <#if workApply.phone ?exists>
		   PHONE = :workApply.phone,
		</#if>
	   <#if workApply.address ?exists>
		   ADDRESS = :workApply.address,
		</#if>
	   <#if workApply.receiveType ?exists>
		   RECEIVE_TYPE = :workApply.receiveType,
		</#if>
	   <#if workApply.applyNum ?exists>
		   APPLY_NUM = :workApply.applyNum,
		</#if>
	   <#if workApply.applyStatus ?exists>
		   APPLY_STATUS = :workApply.applyStatus,
		</#if>
	    <#if workApply.applyData ?exists>
		   APPLY_DATA = :workApply.applyData,
		</#if>
	    <#if workApply.dealData ?exists>
		   DEAL_DATA = :workApply.dealData,
		</#if>
	   <#if workApply.dealPersion ?exists>
		   DEAL_PERSION = :workApply.dealPersion,
		</#if>
	   <#if workApply.audit ?exists>
		   AUDIT = :workApply.audit,
		</#if>
	   <#if workApply.reply ?exists>
		   REPLY = :workApply.reply,
		</#if>
	   <#if workApply.material ?exists>
		   material = :workApply.material,
		</#if>
	   <#if workApply.processInstanceId ?exists>
		   processInstanceId = :workApply.processInstanceId,
		</#if>
	   <#if workApply.resCode ?exists>
		   res_code = :workApply.resCode,
		</#if>
	   <#if workApply.openId ?exists>
		   open_id = :workApply.openId,
		</#if>
	   <#if workApply.formId ?exists>
		   form_id = :workApply.formId,
		</#if>
WHERE id = :workApply.id