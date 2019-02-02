package com.jeecg.zwzx.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.zwzx.entity.WorkApplyEntity;

/**
 * 描述：申报表
 * @author：www.jeecg.org
 * @since：2018年10月05日 13时32分21秒 星期五 
 * @version:1.0
 */
@Repository
public interface WorkApplyDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM work_apply WHERE ID = :id")
	WorkApplyEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param workApply
	 * @return
	 */
	int update(@Param("workApply") WorkApplyEntity workApply);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("workApply") WorkApplyEntity workApply);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param workApply
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(WorkApplyEntity.class)
	public MiniDaoPage<WorkApplyEntity> getAll(@Param("workApply") WorkApplyEntity workApply,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from work_apply WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	@Sql("DELETE from work_apply WHERE ID = :id")
	public void deleteById(@Param("id") String id);
	 
	@Sql("select username from t_s_base_user where id = (select owner from work_menu where id=:id)")
	public String getUserName(@Param("id") String id);
	
	@ResultType(WorkApplyEntity.class)
	public MiniDaoPage<WorkApplyEntity> getApplyInterview(@Param("workApply") WorkApplyEntity workApply,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from work_apply WHERE deal_persion = :id")
	public void deleterByUserId(@Param("id") String id);
	
	@ResultType(WorkApplyEntity.class)
	public MiniDaoPage<WorkApplyEntity> applyEditList(@Param("workApply") WorkApplyEntity workApply,
			@Param("page")  int page,@Param("rows") int rows);
	
}

