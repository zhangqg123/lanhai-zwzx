package com.jeecg.zwzx.service.impl;

import javax.annotation.Resource;
import java.util.UUID;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.jeecg.zwzx.dao.WorkBlacklistDao;
import com.jeecg.zwzx.entity.WorkBlacklistEntity;
import com.jeecg.zwzx.service.WorkBlacklistService;

/**
 * 描述：黑名单
 * @author: www.jeecg.org
 * @since：2018年11月11日 09时47分35秒 星期日 
 * @version:1.0
 */

@Service("workBlacklistService")
public class WorkBlacklistServiceImpl implements WorkBlacklistService {
	@Resource
	private WorkBlacklistDao workBlacklistDao;

	@Override
	public WorkBlacklistEntity get(String id) {
		return workBlacklistDao.get(id);
	}

	@Override
	public int update(WorkBlacklistEntity workBlacklist) {
		return workBlacklistDao.update(workBlacklist);
	}

	@Override
	public void insert(WorkBlacklistEntity workBlacklist) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		workBlacklist.setId(randomSeed);
		workBlacklistDao.insert(workBlacklist);
		
	}

	@Override
	public MiniDaoPage<WorkBlacklistEntity> getAll(WorkBlacklistEntity workBlacklist, int page, int rows) {
		return workBlacklistDao.getAll(workBlacklist, page, rows);
	}

	@Override
	public void delete(String id) {
		workBlacklistDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			workBlacklistDao.deleteById(id);
		}
	}
}
