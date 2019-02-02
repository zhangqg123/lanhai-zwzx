		<#if ( workFlow.flowName )?? && workFlow.flowName ?length gt 0>
		    /* 流程名称 */
			and wf.flow_name = :workFlow.flowName
		</#if>
		<#if ( workFlow.flowContent )?? && workFlow.flowContent ?length gt 0>
		    /* 流程内容 */
			and wf.flow_content = :workFlow.flowContent
		</#if>
		<#if ( workFlow.flowChart )?? && workFlow.flowChart ?length gt 0>
		    /* 流程图 */
			and wf.flow_chart = :workFlow.flowChart
		</#if>
		<#if ( workFlow.guideId )?? && workFlow.guideId ?length gt 0>
		    /* 指南编号 */
			and wf.guide_id = :workFlow.guideId
		</#if>
