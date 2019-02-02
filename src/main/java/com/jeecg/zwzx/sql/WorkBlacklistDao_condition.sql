		<#if ( workBlacklist.id )?? && workBlacklist.id ?length gt 0>
		    /* id */
			and wb.ID = :workBlacklist.id
		</#if>
		<#if ( workBlacklist.phone )?? && workBlacklist.phone ?length gt 0>
		    /* 手机 */
			and wb.PHONE = :workBlacklist.phone
		</#if>
		<#if ( workBlacklist.status )?? && workBlacklist.status ?length gt 0>
		    /* 状态 */
			and wb.STATUS = :workBlacklist.status
		</#if>
		<#if ( workBlacklist.idcard )?? && workBlacklist.idcard ?length gt 0>
		    /* 身份证号 */
			and wb.IDCARD = :workBlacklist.idcard
		</#if>
		<#if ( workBlacklist.createBy )?? && workBlacklist.createBy ?length gt 0>
		    /* 创建人 */
			and wb.CREATE_BY = :workBlacklist.createBy
		</#if>
	    <#if ( workBlacklist.createDate )??>
		    /* 创建日期 */
			and wb.CREATE_DATE = :workBlacklist.createDate
		</#if>
