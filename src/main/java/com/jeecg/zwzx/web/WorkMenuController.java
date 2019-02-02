package com.jeecg.zwzx.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.VelocityContext;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.page.SystemTools;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeecg.zwzx.entity.User;
import com.jeecg.zwzx.entity.WorkGuideEntity;
import com.jeecg.zwzx.entity.WorkMenuEntity;
import com.jeecg.zwzx.service.WorkGuideService;
import com.jeecg.zwzx.service.WorkMenuService;

 /**
 * 描述：分类表
 * @author: www.jeecg.org
 * @since：2018年09月12日 08时10分47秒 星期三 
 * @version:1.0
 */
@Controller
@RequestMapping("/jeecg/workMenu")
public class WorkMenuController extends BaseController{
  @Autowired
  private WorkMenuService workMenuService;
  @Autowired
  private WorkGuideService workGuideService;
  
	/**
	  * 列表页面
	  * @return
	  */
	@RequestMapping(params = "list",method = {RequestMethod.GET,RequestMethod.POST})
	public void list(@ModelAttribute WorkMenuEntity query,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
			try {
			 	LOG.info(request, " back list");
			 	//分页数据
				MiniDaoPage<WorkMenuEntity> list =  workMenuService.getAll(query,pageNo,pageSize);
				List<User> users = getUsers(request);
				VelocityContext velocityContext = new VelocityContext();
				velocityContext.put("workMenu",query);
				velocityContext.put("users",users);
				velocityContext.put("pageInfos",SystemTools.convertPaginatedList(list));
				String viewName = "jeecg/zwzx/workMenu-list.vm";
				ViewVelocity.view(request,response,viewName,velocityContext);
			} catch (Exception e) {
				e.printStackTrace();
			}
}

	 /**
	  * 详情
	  * @return
	  */
	@RequestMapping(params="toDetail",method = RequestMethod.GET)
	public void workMenuDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
			VelocityContext velocityContext = new VelocityContext();
			String viewName = "jeecg/zwzx/workMenu-detail.vm";
			WorkMenuEntity workMenu = workMenuService.get(id);
			velocityContext.put("workMenu",workMenu);
			ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request,HttpServletResponse response)throws Exception{
		List<User> users = getUsers(request);
		VelocityContext velocityContext = new VelocityContext();
		String sessionid = request.getSession().getId();
		velocityContext.put("sessionid", sessionid);
		velocityContext.put("users", users);
		String viewName = "jeecg/zwzx/workMenu-add.vm";
		ViewVelocity.view(request,response,viewName,velocityContext);
	}

	private List<User> getUsers(HttpServletRequest request) {
		String rolecodes = (String) request.getSession().getAttribute("rolecodes");
		List<User> users = null;
		if(rolecodes.contains("admin")){
			users = workMenuService.getUsers("zwzx"); 
		}else{
			if(rolecodes.contains("zwzx")){
				String userId=(String) request.getSession().getAttribute("loginUserId");
				User user=workMenuService.getUserById(userId);
				users=new ArrayList<User>();
				users.add(user);
			}
		}
		return users;
	}

	/**
	 * 保存信息
	 * @return
	 */
	@RequestMapping(params = "doAdd",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute WorkMenuEntity workMenu){
		AjaxJson j = new AjaxJson();
		try {
			workMenuService.insert(workMenu);
			j.setMsg("保存成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("保存失败");
		    e.printStackTrace();
		}
		return j;
	}

	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@RequestMapping(params="toEdit",method = RequestMethod.GET)
	public void toEdit(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request) throws Exception{
		List<User> users = getUsers(request);
		VelocityContext velocityContext = new VelocityContext();
		String sessionid = request.getSession().getId();
		velocityContext.put("sessionid", sessionid);
		velocityContext.put("users", users);
		WorkMenuEntity workMenu = workMenuService.get(id);
		velocityContext.put("workMenu",workMenu);
		String viewName = "jeecg/zwzx/workMenu-edit.vm";
		ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute WorkMenuEntity workMenu){
		AjaxJson j = new AjaxJson();
		try {
			workMenuService.update(workMenu);
			j.setMsg("编辑成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("编辑失败");
		    e.printStackTrace();
		}
		return j;
	}


	/**
	 * 删除
	 * @return
	 */
	@RequestMapping(params="doDelete",method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson doDelete(@RequestParam(required = true, value = "id" ) String id){
			AjaxJson j = new AjaxJson();
			WorkGuideEntity workGuide=new WorkGuideEntity();
			workGuide.setManagement(id);
			MiniDaoPage<WorkGuideEntity> list = workGuideService.getAll(workGuide, 1, 10);
			List<WorkGuideEntity> guideList = list.getResults();
			if(guideList.size()>0){
				j.setMsg("有下级办事指南数据，无法删除此行");
				return j;
			}
			try {
				workMenuService.delete(id);
				j.setMsg("删除成功");
			} catch (Exception e) {
				j.setSuccess(false);
				j.setMsg("删除失败");
			    e.printStackTrace();
			}
			return j;
	}
	
	/**
	 * 批量删除数据
	 * @param ids
	 * @return
	 */
	@RequestMapping(params="batchDelete",method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson batchDelete(@RequestParam(required = true, value = "ids") String[] ids) {
		AjaxJson j = new AjaxJson();
		WorkGuideEntity workGuide=new WorkGuideEntity();
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			workGuide.setManagement(id);
			MiniDaoPage<WorkGuideEntity> list = workGuideService.getAll(workGuide, 1, 10);
			List<WorkGuideEntity> guideList = list.getResults();
			if(guideList.size()>0){
				j.setMsg(guideList.get(0).getGuideName()+":非空，无法批量删除");
				return j;
			}
		}
		try {
			workMenuService.batchDelete(ids);
			j.setMsg("批量删除成功");
		} catch(Exception e) {
			j.setSuccess(false);
			j.setMsg("批量删除失败");
			e.printStackTrace();
		}
		return j;
	}

}

