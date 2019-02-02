package com.jeecg.zwzx.service;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;

import com.jeecg.zwzx.entity.WorkInterviewEntity;

/**
 * 描述：预约表
 * @author: www.jeecg.org
 * @since：2018年11月07日 08时04分31秒 星期三 
 * @version:1.0
 */
public interface WorkInterviewService {
	public WorkInterviewEntity get(String id);

	public int update(WorkInterviewEntity workInterview);

	public void insert(WorkInterviewEntity workInterview);

	public MiniDaoPage<WorkInterviewEntity> getAll(WorkInterviewEntity workInterview,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);

	public void startInterview(WorkInterviewEntity workInterview);

	public List getInterviewNum(String guideId);

	public void cancelInterview(String id, String applyId);
	
}
