		<#if ( workMenu.id )?? && workMenu.id ?length gt 0>
		    /* ID */
			and wm.ID = :workMenu.id
		</#if>
		<#if ( workMenu.imageHref )?? && workMenu.imageHref ?length gt 0>
		    /* 图片地址 */
			and wm.IMAGE_HREF = :workMenu.imageHref
		</#if>
		<#if ( workMenu.imageName )?? && workMenu.imageName ?length gt 0>
		    /* 图片名称 */
			and wm.IMAGE_NAME = :workMenu.imageName
		</#if>
		<#if ( workMenu.name )?? && workMenu.name ?length gt 0>
		    /* 栏目名称 */
			and wm.NAME = :workMenu.name
		</#if>
		<#if ( workMenu.type )?? && workMenu.type ?length gt 0>
		    /* 类型 */
			and wm.TYPE = :workMenu.type
		</#if>
		<#if ( workMenu.parentCode )?? && workMenu.parentCode ?length gt 0>
		    /* 父节点 */
			and wm.PARENT_CODE = :workMenu.parentCode
		</#if>
		<#if ( workMenu.href )?? && workMenu.href ?length gt 0>
		    /* 地址 */
			and wm.HREF = :workMenu.href
		</#if>
		<#if ( workMenu.owner )?? && workMenu.owner ?length gt 0>
		    /* 所属部门 */
			and wm.OWNER = :workMenu.owner
		</#if>
