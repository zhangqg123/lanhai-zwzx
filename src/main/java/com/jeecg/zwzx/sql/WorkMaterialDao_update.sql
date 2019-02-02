UPDATE work_material
SET 
	   <#if workMaterial.materialName ?exists>
		   material_name = :workMaterial.materialName,
		</#if>
	   <#if workMaterial.materialContent ?exists>
		   material_content = :workMaterial.materialContent,
		</#if>
	   <#if workMaterial.materialStandard ?exists>
		   material_standard = :workMaterial.materialStandard,
		</#if>
	   <#if workMaterial.materialRequred ?exists>
		   material_requred = :workMaterial.materialRequred,
		</#if>
	   <#if workMaterial.guideId ?exists>
		   guide_id = :workMaterial.guideId,
		</#if>
WHERE id = :workMaterial.id