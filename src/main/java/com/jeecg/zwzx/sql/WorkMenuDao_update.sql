UPDATE work_menu
SET 
	   <#if workMenu.id ?exists>
		   ID = :workMenu.id,
		</#if>
	   <#if workMenu.imageHref ?exists>
		   IMAGE_HREF = :workMenu.imageHref,
		</#if>
	   <#if workMenu.imageName ?exists>
		   IMAGE_NAME = :workMenu.imageName,
		</#if>
	   <#if workMenu.name ?exists>
		   NAME = :workMenu.name,
		</#if>
	   <#if workMenu.type ?exists>
		   TYPE = :workMenu.type,
		</#if>
	   <#if workMenu.parentCode ?exists>
		   PARENT_CODE = :workMenu.parentCode,
		</#if>
	   <#if workMenu.href ?exists>
		   HREF = :workMenu.href,
		</#if>
	   <#if workMenu.owner ?exists>
		   OWNER = :workMenu.owner,
		</#if>
WHERE id = :workMenu.id