UPDATE work_blacklist
SET 
	   <#if workBlacklist.id ?exists>
		   ID = :workBlacklist.id,
		</#if>
	   <#if workBlacklist.phone ?exists>
		   PHONE = :workBlacklist.phone,
		</#if>
	   <#if workBlacklist.status ?exists>
		   STATUS = :workBlacklist.status,
		</#if>
	   <#if workBlacklist.idcard ?exists>
		   IDCARD = :workBlacklist.idcard,
		</#if>
	   <#if workBlacklist.createBy ?exists>
		   CREATE_BY = :workBlacklist.createBy,
		</#if>
	    <#if workBlacklist.createDate ?exists>
		   CREATE_DATE = :workBlacklist.createDate,
		</#if>
WHERE id = :workBlacklist.id