package com.jeecg.zwzx.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.zwzx.entity.WorkUserEntity;

/**
 * 描述：用户表
 * @author：www.jeecg.org
 * @since：2018年09月28日 06时06分13秒 星期五 
 * @version:1.0
 */
@Repository
public interface WorkUserDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM work_user WHERE ID = :id")
	WorkUserEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param workUser
	 * @return
	 */
	int update(@Param("workUser") WorkUserEntity workUser);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("workUser") WorkUserEntity workUser);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param workUser
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(WorkUserEntity.class)
	public MiniDaoPage<WorkUserEntity> getAll(@Param("workUser") WorkUserEntity workUser,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from work_user WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from work_user WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

