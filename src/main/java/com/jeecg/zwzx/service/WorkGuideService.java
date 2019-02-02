package com.jeecg.zwzx.service;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;

import com.jeecg.zwzx.entity.Guide;
import com.jeecg.zwzx.entity.WorkGuideEntity;
import com.jeecg.zwzx.entity.WorkMenuEntity;

/**
 * 描述：cms表
 * @author: www.jeecg.org
 * @since：2018年09月09日 14时21分19秒 星期日 
 * @version:1.0
 */
public interface WorkGuideService {
	public WorkGuideEntity get(String id);

	public int update(WorkGuideEntity workGuide);

	public void insert(WorkGuideEntity workGuide);

	public MiniDaoPage<WorkGuideEntity> getAll(WorkGuideEntity workGuide,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);

	public List<Guide> guideIdName();

}
