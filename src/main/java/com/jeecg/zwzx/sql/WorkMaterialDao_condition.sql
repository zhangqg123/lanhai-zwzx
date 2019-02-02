		<#if ( workMaterial.materialName )?? && workMaterial.materialName ?length gt 0>
		    /* 材料名称 */
			and wm.material_name = :workMaterial.materialName
		</#if>
		<#if ( workMaterial.materialContent )?? && workMaterial.materialContent ?length gt 0>
		    /* 材料内容 */
			and wm.material_content = :workMaterial.materialContent
		</#if>
		<#if ( workMaterial.materialStandard )?? && workMaterial.materialStandard ?length gt 0>
		    /* 受理标准 */
			and wm.material_standard = :workMaterial.materialStandard
		</#if>
		<#if ( workMaterial.materialRequred )?? && workMaterial.materialRequred ?length gt 0>
		    /* 材料要求 */
			and wm.material_requred = :workMaterial.materialRequred
		</#if>
		<#if ( workMaterial.guideId )?? && workMaterial.guideId ?length gt 0>
		    /* 指南编号 */
			and wm.guide_id = :workMaterial.guideId
		</#if>
