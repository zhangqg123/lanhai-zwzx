package com.jeecg.zwzx.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.jeecg.zwzx.entity.WorkMaterialEntity;

/**
 * 描述：材料表
 * @author: www.jeecg.org
 * @since：2018年09月09日 16时48分47秒 星期日 
 * @version:1.0
 */
public interface WorkMaterialService {
	public WorkMaterialEntity get(String id);

	public int update(WorkMaterialEntity workMaterial);

	public void insert(WorkMaterialEntity workMaterial);

	public MiniDaoPage<WorkMaterialEntity> getAll(WorkMaterialEntity workMaterial,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
}
