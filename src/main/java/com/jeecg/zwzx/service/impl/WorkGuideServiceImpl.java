package com.jeecg.zwzx.service.impl;

import javax.annotation.Resource;

import java.util.List;
import java.util.UUID;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.jeecg.zwzx.dao.WorkGuideDao;
import com.jeecg.zwzx.entity.Guide;
import com.jeecg.zwzx.entity.WorkGuideEntity;
import com.jeecg.zwzx.entity.WorkMenuEntity;
import com.jeecg.zwzx.service.WorkGuideService;

/**
 * 描述：cms表
 * @author: www.jeecg.org
 * @since：2018年09月09日 14时21分19秒 星期日 
 * @version:1.0
 */

@Service("workGuideService")
public class WorkGuideServiceImpl implements WorkGuideService {
	@Resource
	private WorkGuideDao workGuideDao;

	@Override
	public WorkGuideEntity get(String id) {
		return workGuideDao.get(id);
	}

	@Override
	public int update(WorkGuideEntity workGuide) {
		return workGuideDao.update(workGuide);
	}

	@Override
	public void insert(WorkGuideEntity workGuide) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		workGuide.setId(randomSeed);
		workGuideDao.insert(workGuide);
		
	}

	@Override
	public MiniDaoPage<WorkGuideEntity> getAll(WorkGuideEntity workGuide, int page, int rows) {
		return workGuideDao.getAll(workGuide, page, rows);
	}

	@Override
	public void delete(String id) {
		workGuideDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			workGuideDao.deleteById(id);
		}
	}

	@Override
	public List<Guide> guideIdName() {
		// TODO Auto-generated method stub
		return workGuideDao.guideIdName();
	}

}
