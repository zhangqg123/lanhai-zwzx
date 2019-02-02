package com.jeecg.zwzx.service.impl;

import javax.annotation.Resource;

import java.util.List;
import java.util.UUID;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.jeecg.zwzx.dao.WorkMenuDao;
import com.jeecg.zwzx.entity.User;
import com.jeecg.zwzx.entity.WorkMenuEntity;
import com.jeecg.zwzx.service.WorkMenuService;

/**
 * 描述：分类表
 * @author: www.jeecg.org
 * @since：2018年09月12日 08时10分47秒 星期三 
 * @version:1.0
 */

@Service("workMenuService")
public class WorkMenuServiceImpl implements WorkMenuService {
	@Resource
	private WorkMenuDao workMenuDao;

	@Override
	public WorkMenuEntity get(String id) {
		return workMenuDao.get(id);
	}

	@Override
	public int update(WorkMenuEntity workMenu) {
		return workMenuDao.update(workMenu);
	}

	@Override
	public void insert(WorkMenuEntity workMenu) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		workMenu.setId(randomSeed);
		workMenuDao.insert(workMenu);
		
	}

	@Override
	public MiniDaoPage<WorkMenuEntity> getAll(WorkMenuEntity workMenu, int page, int rows) {
		return workMenuDao.getAll(workMenu, page, rows);
	}

	@Override
	public void delete(String id) {
		workMenuDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			workMenuDao.deleteById(id);
		}
	}

	@Override
	public List<User> getUsers(String rolecode) {
		// TODO Auto-generated method stub
		return workMenuDao.getUsers(rolecode);
	}

	@Override
	public User getUserById(String userId) {
		return workMenuDao.getUserById(userId);
	}

	@Override
	public WorkMenuEntity getMenuByOwner(String userId) {
		// TODO Auto-generated method stub
		return workMenuDao.getMenuByOwner(userId);
	}
}
