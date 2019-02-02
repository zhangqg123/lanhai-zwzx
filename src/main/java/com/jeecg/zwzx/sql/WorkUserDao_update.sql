UPDATE work_user
SET 
	   <#if workUser.phone ?exists>
		   phone = :workUser.phone,
		</#if>
	   <#if workUser.username ?exists>
		   username = :workUser.username,
		</#if>
	   <#if workUser.password ?exists>
		   password = :workUser.password,
		</#if>
	   <#if workUser.status ?exists>
		   status = :workUser.status,
		</#if>
	   <#if workUser.userkey ?exists>
		   userkey = :workUser.userkey,
		</#if>
	   <#if workUser.idcard ?exists>
		   idcard = :workUser.idcard,
		</#if>
	   <#if workUser.realname ?exists>
		   realname = :workUser.realname,
		</#if>
	   <#if workUser.sex ?exists>
		   sex = :workUser.sex,
		</#if>
	   <#if workUser.address ?exists>
		   address = :workUser.address,
		</#if>
	   <#if workUser.usertype ?exists>
		   usertype = :workUser.usertype,
		</#if>
	   <#if workUser.openid ?exists>
		   openid = :workUser.openid,
		</#if>
WHERE id = :workUser.id