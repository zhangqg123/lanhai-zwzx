package com.jeecg.zwzx.service;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;

import com.jeecg.zwzx.entity.User;
import com.jeecg.zwzx.entity.WorkMenuEntity;

/**
 * 描述：分类表
 * @author: www.jeecg.org
 * @since：2018年09月12日 08时10分47秒 星期三 
 * @version:1.0
 */
public interface WorkMenuService {
	public WorkMenuEntity get(String id);

	public int update(WorkMenuEntity workMenu);

	public void insert(WorkMenuEntity workMenu);

	public MiniDaoPage<WorkMenuEntity> getAll(WorkMenuEntity workMenu,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);

	public List<User> getUsers(String rolecode);

	public User getUserById(String userId);

	public WorkMenuEntity getMenuByOwner(String userId);
	
}
