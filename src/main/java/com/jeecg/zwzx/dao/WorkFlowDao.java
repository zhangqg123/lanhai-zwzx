package com.jeecg.zwzx.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.zwzx.entity.WorkFlowEntity;

/**
 * 描述：流程表
 * @author：www.jeecg.org
 * @since：2018年09月09日 16时50分22秒 星期日 
 * @version:1.0
 */
@Repository
public interface WorkFlowDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM work_flow WHERE ID = :id")
	WorkFlowEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param workFlow
	 * @return
	 */
	int update(@Param("workFlow") WorkFlowEntity workFlow);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("workFlow") WorkFlowEntity workFlow);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param workFlow
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(WorkFlowEntity.class)
	public MiniDaoPage<WorkFlowEntity> getAll(@Param("workFlow") WorkFlowEntity workFlow,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from work_flow WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from work_flow WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

