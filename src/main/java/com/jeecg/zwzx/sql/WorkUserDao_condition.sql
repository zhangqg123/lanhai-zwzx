		<#if ( workUser.id )?? && workUser.id ?length gt 0>
		    /* ID */
			and wu.ID = :workUser.id
		</#if>
		<#if ( workUser.phone )?? && workUser.phone ?length gt 0>
		    /* 手机 */
			and wu.phone = :workUser.phone
		</#if>
		<#if ( workUser.username )?? && workUser.username ?length gt 0>
		    /* 用户账号 */
			and wu.username = :workUser.username
		</#if>
		<#if ( workUser.password )?? && workUser.password ?length gt 0>
		    /* 密码 */
			and wu.password = :workUser.password
		</#if>
		<#if ( workUser.status )?? && workUser.status ?length gt 0>
		    /* 有效状态 */
			and wu.status = :workUser.status
		</#if>
		<#if ( workUser.userkey )?? && workUser.userkey ?length gt 0>
		    /* 用户KEY */
			and wu.userkey = :workUser.userkey
		</#if>
		<#if ( workUser.idcard )?? && workUser.idcard ?length gt 0>
		    /* 身份证号 */
			and wu.idcard = :workUser.idcard
		</#if>
		<#if ( workUser.realname )?? && workUser.realname ?length gt 0>
		    /* 真实名字 */
			and wu.realname = :workUser.realname
		</#if>
		<#if ( workUser.sex )?? && workUser.sex ?length gt 0>
		    /* 性别 */
			and wu.sex = :workUser.sex
		</#if>
		<#if ( workUser.address )?? && workUser.address ?length gt 0>
		    /* 地址 */
			and wu.address = :workUser.address
		</#if>
		<#if ( workUser.usertype )?? && workUser.usertype ?length gt 0>
		    /* 地址 */
			and wu.usertype = :workUser.usertype
		</#if>
		<#if ( workUser.openid )?? && workUser.openid ?length gt 0>
		    /* 地址 */
			and wu.openid = :workUser.openid
		</#if>
		<#if ( workUser.xcxId )?? && workUser.xcxId ?length gt 0>
		    /* 地址 */
			and wu.xcxid = :workUser.xcxId
		</#if>
		<#if ( workUser.parent )?? && workUser.parent ?length gt 0>
		    /* 地址 */
			and wu.parent = :workUser.parent
		</#if>
