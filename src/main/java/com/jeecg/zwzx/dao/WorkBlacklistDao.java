package com.jeecg.zwzx.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.zwzx.entity.WorkBlacklistEntity;

/**
 * 描述：黑名单
 * @author：www.jeecg.org
 * @since：2018年11月11日 09时47分35秒 星期日 
 * @version:1.0
 */
@Repository
public interface WorkBlacklistDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM work_blacklist WHERE ID = :id")
	WorkBlacklistEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param workBlacklist
	 * @return
	 */
	int update(@Param("workBlacklist") WorkBlacklistEntity workBlacklist);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("workBlacklist") WorkBlacklistEntity workBlacklist);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param workBlacklist
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(WorkBlacklistEntity.class)
	public MiniDaoPage<WorkBlacklistEntity> getAll(@Param("workBlacklist") WorkBlacklistEntity workBlacklist,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from work_blacklist WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from work_blacklist WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

