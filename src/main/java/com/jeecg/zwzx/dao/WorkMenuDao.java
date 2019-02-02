package com.jeecg.zwzx.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.zwzx.entity.User;
import com.jeecg.zwzx.entity.WorkMenuEntity;

/**
 * 描述：分类表
 * @author：www.jeecg.org
 * @since：2018年09月12日 08时10分47秒 星期三 
 * @version:1.0
 */
@Repository
public interface WorkMenuDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM work_menu WHERE ID = :id")
	WorkMenuEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param workMenu
	 * @return
	 */
	int update(@Param("workMenu") WorkMenuEntity workMenu);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("workMenu") WorkMenuEntity workMenu);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param workMenu
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(WorkMenuEntity.class)
	public MiniDaoPage<WorkMenuEntity> getAll(@Param("workMenu") WorkMenuEntity workMenu,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("SELECT tsbu.id,tsbu.username,tsbu.realname FROM t_s_base_user tsbu left join t_s_role_user tsru on tsbu.id=tsru.userid where tsru.roleid= (select id from t_s_role where rolecode=:rolecode)")
	public List<User> getUsers(@Param("rolecode") String rolecode);
	
	@Sql("SELECT id, username, realname FROM t_s_base_user where id=:userId")
	User getUserById(@Param("userId") String userId);

	@Sql("select * from work_menu WHERE owner = :userId")
	WorkMenuEntity getMenuByOwner(@Param("userId") String userId);

	@Sql("DELETE from work_menu WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from work_menu WHERE ID = :id")
	 public void deleteById(@Param("id") String id);


	
}

