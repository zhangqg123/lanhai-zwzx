package com.jeecg.zwzx.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;

import com.jeecg.zwzx.entity.WorkApplyEntity;

/**
 * 描述：申报表
 * @author: www.jeecg.org
 * @since：2018年10月05日 13时32分21秒 星期五 
 * @version:1.0
 */
public interface WorkApplyService {
	public WorkApplyEntity get(String id);

	public int update(WorkApplyEntity workApply);

	public void insert(WorkApplyEntity workApply);

	public MiniDaoPage<WorkApplyEntity> getAll(WorkApplyEntity workApply,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);

	public String getUserName(String management);

	public MiniDaoPage<WorkApplyEntity> getApplyInterview(
			WorkApplyEntity query, int pageNo, int pageSize);

	public MiniDaoPage<WorkApplyEntity> applyEditList(WorkApplyEntity query,
			int pageNo, int pageSize);
	
}
