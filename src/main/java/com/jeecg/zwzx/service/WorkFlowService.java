package com.jeecg.zwzx.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.jeecg.zwzx.entity.WorkFlowEntity;

/**
 * 描述：流程表
 * @author: www.jeecg.org
 * @since：2018年09月09日 16时50分22秒 星期日 
 * @version:1.0
 */
public interface WorkFlowService {
	public WorkFlowEntity get(String id);

	public int update(WorkFlowEntity workFlow);

	public void insert(WorkFlowEntity workFlow);

	public MiniDaoPage<WorkFlowEntity> getAll(WorkFlowEntity workFlow,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
}
