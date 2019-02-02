package com.jeecg.zwzx.service.impl;

import javax.annotation.Resource;

import java.util.UUID;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.jeecg.zwzx.dao.WorkApplyDao;
import com.jeecg.zwzx.entity.WorkApplyEntity;
import com.jeecg.zwzx.service.WorkApplyService;

/**
 * 描述：申报表
 * @author: www.jeecg.org
 * @since：2018年10月05日 13时32分21秒 星期五 
 * @version:1.0
 */

@Service("workApplyService")
public class WorkApplyServiceImpl implements WorkApplyService {
	@Resource
	private WorkApplyDao workApplyDao;

	@Override
	public WorkApplyEntity get(String id) {
		return workApplyDao.get(id);
	}

	@Override
	public int update(WorkApplyEntity workApply) {
		return workApplyDao.update(workApply);
	}

	@Override
	public void insert(WorkApplyEntity workApply) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		workApply.setId(randomSeed);
		workApplyDao.insert(workApply);
		
	}

	@Override
	public MiniDaoPage<WorkApplyEntity> getAll(WorkApplyEntity workApply, int page, int rows) {
		return workApplyDao.getAll(workApply, page, rows);
	}

	@Override
	public void delete(String id) {
		workApplyDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			workApplyDao.deleteById(id);
		}
	}

	@Override
	public String getUserName(String management) {
		// TODO Auto-generated method stub
		return workApplyDao.getUserName(management);
	}

	@Override
	public MiniDaoPage<WorkApplyEntity> getApplyInterview(
			WorkApplyEntity workApply, int page, int rows) {
		return workApplyDao.getApplyInterview(workApply, page, rows);	}

	@Override
	public MiniDaoPage<WorkApplyEntity> applyEditList(WorkApplyEntity workApply,
			int page, int rows) {
		return workApplyDao.applyEditList(workApply, page, rows);
	}

}
