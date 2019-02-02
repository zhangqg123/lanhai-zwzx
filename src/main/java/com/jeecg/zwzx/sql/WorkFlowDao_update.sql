UPDATE work_flow
SET 
	   <#if workFlow.flowName ?exists>
		   flow_name = :workFlow.flowName,
		</#if>
	   <#if workFlow.flowContent ?exists>
		   flow_content = :workFlow.flowContent,
		</#if>
	   <#if workFlow.flowChart ?exists>
		   flow_chart = :workFlow.flowChart,
		</#if>
	   <#if workFlow.guideId ?exists>
		   guide_id = :workFlow.guideId,
		</#if>
WHERE id = :workFlow.id