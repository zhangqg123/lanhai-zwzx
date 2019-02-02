package com.jeecg.zwzx.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.jeecg.zwzx.entity.WorkBlacklistEntity;

/**
 * 描述：黑名单
 * @author: www.jeecg.org
 * @since：2018年11月11日 09时47分35秒 星期日 
 * @version:1.0
 */
public interface WorkBlacklistService {
	public WorkBlacklistEntity get(String id);

	public int update(WorkBlacklistEntity workBlacklist);

	public void insert(WorkBlacklistEntity workBlacklist);

	public MiniDaoPage<WorkBlacklistEntity> getAll(WorkBlacklistEntity workBlacklist,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
}
