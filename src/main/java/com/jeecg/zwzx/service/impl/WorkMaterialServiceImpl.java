package com.jeecg.zwzx.service.impl;

import javax.annotation.Resource;
import java.util.UUID;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.jeecg.zwzx.dao.WorkMaterialDao;
import com.jeecg.zwzx.entity.WorkMaterialEntity;
import com.jeecg.zwzx.service.WorkMaterialService;

/**
 * 描述：材料表
 * @author: www.jeecg.org
 * @since：2018年09月09日 16时48分47秒 星期日 
 * @version:1.0
 */

@Service("workMaterialService")
public class WorkMaterialServiceImpl implements WorkMaterialService {
	@Resource
	private WorkMaterialDao workMaterialDao;

	@Override
	public WorkMaterialEntity get(String id) {
		return workMaterialDao.get(id);
	}

	@Override
	public int update(WorkMaterialEntity workMaterial) {
		return workMaterialDao.update(workMaterial);
	}

	@Override
	public void insert(WorkMaterialEntity workMaterial) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		workMaterial.setId(randomSeed);
		workMaterialDao.insert(workMaterial);
		
	}

	@Override
	public MiniDaoPage<WorkMaterialEntity> getAll(WorkMaterialEntity workMaterial, int page, int rows) {
		return workMaterialDao.getAll(workMaterial, page, rows);
	}

	@Override
	public void delete(String id) {
		workMaterialDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			workMaterialDao.deleteById(id);
		}
	}
}
