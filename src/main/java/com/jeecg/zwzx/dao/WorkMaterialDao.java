package com.jeecg.zwzx.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.zwzx.entity.WorkMaterialEntity;

/**
 * 描述：材料表
 * @author：www.jeecg.org
 * @since：2018年09月09日 16时48分47秒 星期日 
 * @version:1.0
 */
@Repository
public interface WorkMaterialDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM work_material WHERE ID = :id")
	WorkMaterialEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param workMaterial
	 * @return
	 */
	int update(@Param("workMaterial") WorkMaterialEntity workMaterial);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("workMaterial") WorkMaterialEntity workMaterial);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param workMaterial
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(WorkMaterialEntity.class)
	public MiniDaoPage<WorkMaterialEntity> getAll(@Param("workMaterial") WorkMaterialEntity workMaterial,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from work_material WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from work_material WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

