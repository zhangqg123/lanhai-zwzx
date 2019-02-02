package com.jeecg.zwzx.service.impl;

import javax.annotation.Resource;
import java.util.UUID;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.jeecg.zwzx.dao.WorkFlowDao;
import com.jeecg.zwzx.entity.WorkFlowEntity;
import com.jeecg.zwzx.service.WorkFlowService;

/**
 * 描述：流程表
 * @author: www.jeecg.org
 * @since：2018年09月09日 16时50分22秒 星期日 
 * @version:1.0
 */

@Service("workFlowService")
public class WorkFlowServiceImpl implements WorkFlowService {
	@Resource
	private WorkFlowDao workFlowDao;

	@Override
	public WorkFlowEntity get(String id) {
		return workFlowDao.get(id);
	}

	@Override
	public int update(WorkFlowEntity workFlow) {
		return workFlowDao.update(workFlow);
	}

	@Override
	public void insert(WorkFlowEntity workFlow) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		workFlow.setId(randomSeed);
		workFlowDao.insert(workFlow);
		
	}

	@Override
	public MiniDaoPage<WorkFlowEntity> getAll(WorkFlowEntity workFlow, int page, int rows) {
		return workFlowDao.getAll(workFlow, page, rows);
	}

	@Override
	public void delete(String id) {
		workFlowDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			workFlowDao.deleteById(id);
		}
	}
}
