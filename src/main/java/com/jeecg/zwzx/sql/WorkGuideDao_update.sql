UPDATE work_guide
SET 
	   <#if workGuide.id ?exists>
		   id = :workGuide.id,
		</#if>
	   <#if workGuide.guideName ?exists>
		   guide_name = :workGuide.guideName,
		</#if>
	   <#if workGuide.itemType ?exists>
		   item_type = :workGuide.itemType,
		</#if>
	   <#if workGuide.nature ?exists>
		   nature = :workGuide.nature,
		</#if>
	   <#if workGuide.management ?exists>
		   management = :workGuide.management,
		</#if>
	   <#if workGuide.workCode ?exists>
		   work_code = :workGuide.workCode,
		</#if>
	   <#if workGuide.address ?exists>
		   address = :workGuide.address,
		</#if>
	   <#if workGuide.phone ?exists>
		   phone = :workGuide.phone,
		</#if>
	   <#if workGuide.audit ?exists>
		   audit = :workGuide.audit,
		</#if>
	   <#if workGuide.officeType ?exists>
		   office_type = :workGuide.officeType,
		</#if>
	   <#if workGuide.workTime ?exists>
		   work_time = :workGuide.workTime,
		</#if>
	   <#if workGuide.legalTime ?exists>
		   legal_time = :workGuide.legalTime,
		</#if>
	   <#if workGuide.promiseTime ?exists>
		   promise_time = :workGuide.promiseTime,
		</#if>
	   <#if workGuide.resultName ?exists>
		   result_name = :workGuide.resultName,
		</#if>
	   <#if workGuide.workType ?exists>
		   work_type = :workGuide.workType,
		</#if>
	   <#if workGuide.workLevel ?exists>
		   work_level = :workGuide.workLevel,
		</#if>
	   <#if workGuide.numLimit ?exists>
		   num_limit = :workGuide.numLimit,
		</#if>
	   <#if workGuide.feeType ?exists>
		   fee_type = :workGuide.feeType,
		</#if>
	   <#if workGuide.domain ?exists>
		   domain = :workGuide.domain,
		</#if>
	   <#if workGuide.agency ?exists>
		   agency = :workGuide.agency,
		</#if>
	   <#if workGuide.admissibility ?exists>
		   admissibility = :workGuide.admissibility,
		</#if>
	   <#if workGuide.foundation ?exists>
		   foundation = :workGuide.foundation,
		</#if>
	   <#if workGuide.feeScale ?exists>
		   fee_scale = :workGuide.feeScale,
		</#if>
WHERE id = :workGuide.id