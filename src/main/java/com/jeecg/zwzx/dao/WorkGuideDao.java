package com.jeecg.zwzx.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.zwzx.entity.Guide;
import com.jeecg.zwzx.entity.WorkGuideEntity;

/**
 * 描述：cms表
 * @author：www.jeecg.org
 * @since：2018年09月09日 14时21分19秒 星期日 
 * @version:1.0
 */
@Repository
public interface WorkGuideDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM work_guide WHERE ID = :id")
	WorkGuideEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param workGuide
	 * @return
	 */
	int update(@Param("workGuide") WorkGuideEntity workGuide);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("workGuide") WorkGuideEntity workGuide);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param workGuide
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(WorkGuideEntity.class)
	public MiniDaoPage<WorkGuideEntity> getAll(@Param("workGuide") WorkGuideEntity workGuide,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from work_guide WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from work_guide WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
		
	@Sql("SELECT id, guide_name FROM work_guide")
	public List<Guide> guideIdName();
	
}

