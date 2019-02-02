package com.jeecg.zwzx.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;

import com.jeecg.zwzx.entity.WorkUserEntity;

/**
 * 描述：用户表
 * @author: www.jeecg.org
 * @since：2018年09月28日 06时06分13秒 星期五 
 * @version:1.0
 */
public interface WorkUserService {
	public WorkUserEntity get(String id);

	public int update(WorkUserEntity workUser);

	public void insert(WorkUserEntity workUser);

	public MiniDaoPage<WorkUserEntity> getAll(WorkUserEntity workUser,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);

	public void doBlack(String id);
	
}
