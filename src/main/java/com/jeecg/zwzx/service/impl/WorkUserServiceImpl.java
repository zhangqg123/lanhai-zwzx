package com.jeecg.zwzx.service.impl;

import javax.annotation.Resource;

import java.util.UUID;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.zwzx.dao.WorkApplyDao;
import com.jeecg.zwzx.dao.WorkBlacklistDao;
import com.jeecg.zwzx.dao.WorkInterviewDao;
import com.jeecg.zwzx.dao.WorkUserDao;
import com.jeecg.zwzx.entity.WorkBlacklistEntity;
import com.jeecg.zwzx.entity.WorkUserEntity;
import com.jeecg.zwzx.service.WorkUserService;

/**
 * 描述：用户表
 * @author: www.jeecg.org
 * @since：2018年09月28日 06时06分13秒 星期五 
 * @version:1.0
 */

@Service("workUserService")
public class WorkUserServiceImpl implements WorkUserService {
	@Resource
	private WorkUserDao workUserDao;
	@Resource
	private WorkApplyDao workApplyDao;
	@Resource
	private WorkInterviewDao workInterviewDao;
	@Resource
	private WorkBlacklistDao workBlacklistDao;

	@Override
	public WorkUserEntity get(String id) {
		return workUserDao.get(id);
	}

	@Override
	public int update(WorkUserEntity workUser) {
		return workUserDao.update(workUser);
	}

	@Override
	public void insert(WorkUserEntity workUser) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		workUser.setId(randomSeed);
		workUserDao.insert(workUser);
		
	}

	@Override
	public MiniDaoPage<WorkUserEntity> getAll(WorkUserEntity workUser, int page, int rows) {
		return workUserDao.getAll(workUser, page, rows);
	}

	@Override
	@Transactional
	public void delete(String id) {
		workUserDao.delete(id);
		workApplyDao.deleterByUserId(id);
		workInterviewDao.deleteByUserId(id);
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			workUserDao.deleteById(id);
		}
	}

	@Override
	@Transactional
	public void doBlack(String id) {
		WorkUserEntity workUser = workUserDao.get(id);		
		WorkBlacklistEntity workBlacklist=new WorkBlacklistEntity();
		workBlacklist.setPhone(workUser.getPhone());
		workBlacklist.setIdcard(workUser.getIdcard());
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		workBlacklist.setId(randomSeed);
		workBlacklistDao.insert(workBlacklist);
		workUserDao.delete(id);
		workApplyDao.deleterByUserId(id);
		workInterviewDao.deleteByUserId(id);
	}
}
