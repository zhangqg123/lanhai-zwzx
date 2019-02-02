package com.jeecg.zwzx.service.impl;

import javax.annotation.Resource;

import java.util.List;
import java.util.UUID;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.zwzx.dao.WorkApplyDao;
import com.jeecg.zwzx.dao.WorkInterviewDao;
import com.jeecg.zwzx.entity.WorkApplyEntity;
import com.jeecg.zwzx.entity.WorkInterviewEntity;
import com.jeecg.zwzx.service.WorkInterviewService;

/**
 * 描述：预约表
 * @author: www.jeecg.org
 * @since：2018年11月07日 08时04分31秒 星期三 
 * @version:1.0
 */

@Service("workInterviewService")
public class WorkInterviewServiceImpl implements WorkInterviewService {
	@Resource
	private WorkInterviewDao workInterviewDao;
	@Resource
	private WorkApplyDao workApplyDao;

	@Override
	public WorkInterviewEntity get(String id) {
		return workInterviewDao.get(id);
	}

	@Override
	public int update(WorkInterviewEntity workInterview) {
		return workInterviewDao.update(workInterview);
	}

	@Override
	public void insert(WorkInterviewEntity workInterview) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		workInterview.setId(randomSeed);
		workInterviewDao.insert(workInterview);
		
	}

	@Override
	public MiniDaoPage<WorkInterviewEntity> getAll(WorkInterviewEntity workInterview, int page, int rows) {
		return workInterviewDao.getAll(workInterview, page, rows);
	}

	@Override
	public void delete(String id) {
		workInterviewDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			workInterviewDao.deleteById(id);
		}
	}

	@Override
	@Transactional
	public void startInterview(WorkInterviewEntity workInterview) {
		WorkApplyEntity workApply = workApplyDao.get(workInterview.getApplyId());
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		workInterview.setId(randomSeed);
		workInterviewDao.insert(workInterview);		
		workApply.setApplyStatus(3);
		workApplyDao.update(workApply);
	}

	@Override
	public List getInterviewNum(String guideId) {
		
		List interviewList=workInterviewDao.getInterviewNum(guideId);
		return interviewList;
	}

	@Override
	@Transactional
	public void cancelInterview(String interviewId, String applyId) {
		WorkApplyEntity workApply = workApplyDao.get(applyId);
		workApply.setApplyStatus(2);
		workApplyDao.update(workApply);
		workInterviewDao.delete(interviewId);
		
	}
}
