		<#if ( workGuide.id )?? && workGuide.id ?length gt 0>
		    /* id */
			and wg.id = :workGuide.id
		</#if>
		<#if ( workGuide.guideName )?? && workGuide.guideName ?length gt 0>
		    /* 事项类型 */
			and wg.guide_name = :workGuide.guideName
		</#if>
		<#if ( workGuide.itemType )?? && workGuide.itemType ?length gt 0>
		    /* 事项类型 */
			and wg.item_type = :workGuide.itemType
		</#if>
		<#if ( workGuide.nature )?? && workGuide.nature ?length gt 0>
		    /* 实施主体性质 */
			and wg.nature = :workGuide.nature
		</#if>
		<#if ( workGuide.management )?? && workGuide.management ?length gt 0>
		    /* 实施机构 */
			and wg.management = :workGuide.management
		</#if>
		<#if ( workGuide.workCode )?? && workGuide.workCode ?length gt 0>
		    /* 目录编码/实施编码 */
			and wg.work_code = :workGuide.workCode
		</#if>
		<#if ( workGuide.address )?? && workGuide.address ?length gt 0>
		    /* 办事地点 */
			and wg.address = :workGuide.address
		</#if>
		<#if ( workGuide.phone )?? && workGuide.phone ?length gt 0>
		    /* 咨询电话 */
			and wg.phone = :workGuide.phone
		</#if>
		<#if ( workGuide.audit )?? && workGuide.audit ?length gt 0>
		    /* 监督投诉 */
			and wg.audit = :workGuide.audit
		</#if>
		<#if ( workGuide.officeType )?? && workGuide.officeType ?length gt 0>
		    /* 办件类型 */
			and wg.office_type = :workGuide.officeType
		</#if>
		<#if ( workGuide.workTime )?? && workGuide.workTime ?length gt 0>
		    /* 办理时间 */
			and wg.work_time = :workGuide.workTime
		</#if>
		<#if ( workGuide.legalTime )?? && workGuide.legalTime ?length gt 0>
		    /* 是否发布 */
			and wg.legal_time = :workGuide.legalTime
		</#if>
		<#if ( workGuide.promiseTime )?? && workGuide.promiseTime ?length gt 0>
		    /* 承诺时间 */
			and wg.promise_time = :workGuide.promiseTime
		</#if>
		<#if ( workGuide.resultName )?? && workGuide.resultName ?length gt 0>
		    /* 结果名称 */
			and wg.result_name = :workGuide.resultName
		</#if>
		<#if ( workGuide.workType )?? && workGuide.workType ?length gt 0>
		    /* 办理形式 */
			and wg.work_type = :workGuide.workType
		</#if>
		<#if ( workGuide.workLevel )?? && workGuide.workLevel ?length gt 0>
		    /* 行驶层级 */
			and wg.work_level = :workGuide.workLevel
		</#if>
		<#if ( workGuide.numLimit )?? && workGuide.numLimit ?length gt 0>
		    /* 数量限制 */
			and wg.num_limit = :workGuide.numLimit
		</#if>
		<#if ( workGuide.feeType )?? && workGuide.feeType ?length gt 0>
		    /* 收费方式 */
			and wg.fee_type = :workGuide.feeType
		</#if>
		<#if ( workGuide.domain )?? && workGuide.domain ?length gt 0>
		    /* 通办范围 */
			and wg.domain = :workGuide.domain
		</#if>
		<#if ( workGuide.agency )?? && workGuide.agency ?length gt 0>
		    /* 中介服务 */
			and wg.agency = :workGuide.agency
		</#if>
		<#if ( workGuide.admissibility )?? && workGuide.admissibility ?length gt 0>
		    /* 受理条件 */
			and wg.admissibility = :workGuide.admissibility
		</#if>
		<#if ( workGuide.foundation )?? && workGuide.foundation ?length gt 0>
		    /* foundation */
			and wg.foundation = :workGuide.foundation
		</#if>
		<#if ( workGuide.feeScale )?? && workGuide.feeScale ?length gt 0>
		    /* 收费标准 */
			and wg.fee_scale = :workGuide.feeScale
		</#if>
