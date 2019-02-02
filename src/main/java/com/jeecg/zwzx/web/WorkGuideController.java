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
import com.jeecg.zwzx.entity.WorkFlowEntity;
import com.jeecg.zwzx.entity.WorkGuideEntity;
import com.jeecg.zwzx.entity.WorkMaterialEntity;
import com.jeecg.zwzx.entity.WorkMenuEntity;
import com.jeecg.zwzx.service.WorkFlowService;
import com.jeecg.zwzx.service.WorkGuideService;
import com.jeecg.zwzx.service.WorkMaterialService;
import com.jeecg.zwzx.service.WorkMenuService;

 /**
 * 描述：cms表
 * @author: www.jeecg.org
 * @since：2018年09月09日 14时21分19秒 星期日 
 * @version:1.0
 */
@Controller
@RequestMapping("/jeecg/workGuide")
public class WorkGuideController extends BaseController{
  @Autowired
  private WorkGuideService workGuideService;
  @Autowired
  private WorkMenuService workMenuService;
  @Autowired
  private WorkFlowService workFlowService;
  @Autowired
  private WorkMaterialService workMaterialService;
  
	/**
	  * 列表页面
	  * @return
	  */
	@RequestMapping(params = "list",method = {RequestMethod.GET,RequestMethod.POST})
	public void list(@ModelAttribute WorkGuideEntity query,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
			try {
			 	LOG.info(request, " back list");
				String rolecodes = (String) request.getSession().getAttribute("rolecodes");
				MiniDaoPage<WorkGuideEntity> list = null;
				MiniDaoPage<WorkMenuEntity> mlist = null;
				
				if(rolecodes.contains("admin")){
					list =  workGuideService.getAll(query,pageNo,pageSize);
					mlist =  workMenuService.getAll(new WorkMenuEntity(),1,200);
				}else{
					if(rolecodes.contains("zwzx")){
						String userId=(String) request.getSession().getAttribute("loginUserId");
						WorkMenuEntity workMenu=workMenuService.getMenuByOwner(userId);
						query.setManagement(workMenu.getId());
						list =  workGuideService.getAll(query,pageNo,pageSize);
						mlist =  workMenuService.getAll(workMenu,1,200);
					}
				}

			 	//分页数据
				List<WorkMenuEntity> menuList = mlist.getResults();
				VelocityContext velocityContext = new VelocityContext();
				velocityContext.put("workGuide",query);
				velocityContext.put("menuList",menuList);
				velocityContext.put("pageInfos",SystemTools.convertPaginatedList(list));
				String viewName = "jeecg/zwzx/workGuide-list.vm";
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
	public void workGuideDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
			VelocityContext velocityContext = new VelocityContext();
			String viewName = "jeecg/zwzx/workGuide-detail.vm";
			WorkGuideEntity workGuide = workGuideService.get(id);
			velocityContext.put("workGuide",workGuide);
			ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
//	@RequestMapping(params = "generate",method ={RequestMethod.GET, RequestMethod.POST})
//	public void generate(HttpServletRequest request,HttpServletResponse response)throws Exception{
//		MiniDaoPage<WorkMenuEntity> list = null;
//		List<WorkMenuEntity> menuList = null;
//		WorkMenuEntity workMenu=new WorkMenuEntity();
//			list =  workMenuService.getAll(workMenu,1,200);
//		menuList = list.getResults();
//		for(WorkMenuEntity menu:menuList){
//			for(int i=0 ;i<4;i++){
//				WorkGuideEntity workGuide=new WorkGuideEntity();
//				workGuide.setGuideName(menu.getName()+"--办事指南--"+String.valueOf(i));
//				workGuide.setManagement(menu.getId());
//				workGuideService.insert(workGuide);
//			}
//		}
//	}
	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request,HttpServletResponse response)throws Exception{
		String rolecodes = (String) request.getSession().getAttribute("rolecodes");
		MiniDaoPage<WorkMenuEntity> list = null;
		List<WorkMenuEntity> menuList = null;
		WorkMenuEntity workMenu=new WorkMenuEntity();
		if(rolecodes.contains("admin")){
			list =  workMenuService.getAll(workMenu,1,200);
		}else{
			if(rolecodes.contains("zwzx")){
				String userId=(String) request.getSession().getAttribute("loginUserId");
				workMenu.setOwner(userId);
				list =  workMenuService.getAll(workMenu,1,200);
			}
		}
		menuList = list.getResults();
		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("menuList",menuList);
		String viewName = "jeecg/zwzx/workGuide-add.vm";
		ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 保存信息
	 * @return
	 */
	@RequestMapping(params = "doAdd",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute WorkGuideEntity workGuide){
		AjaxJson j = new AjaxJson();
		try {
			workGuideService.insert(workGuide);
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
		WorkGuideEntity workGuide = workGuideService.get(id);
		String rolecodes = (String) request.getSession().getAttribute("rolecodes");
		MiniDaoPage<WorkMenuEntity> list = null;
		List<WorkMenuEntity> menuList = null;
		WorkMenuEntity workMenu=new WorkMenuEntity();
		if(rolecodes.contains("admin")){
			list =  workMenuService.getAll(workMenu,1,200);
		}else{
			if(rolecodes.contains("zwzx")){
				String userId=(String) request.getSession().getAttribute("loginUserId");
				workMenu.setOwner(userId);
				list =  workMenuService.getAll(workMenu,1,200);
			}
		}
		menuList = list.getResults();
		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("menuList",menuList);
		velocityContext.put("workGuide",workGuide);
		String viewName = "jeecg/zwzx/workGuide-edit.vm";
		ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute WorkGuideEntity workGuide){
		AjaxJson j = new AjaxJson();
		try {
			workGuideService.update(workGuide);
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
			WorkFlowEntity workFlow=new WorkFlowEntity();
			workFlow.setGuideId(id);
			MiniDaoPage<WorkFlowEntity> list = workFlowService.getAll(workFlow, 1, 10);
			List<WorkFlowEntity> flowList = list.getResults();
			if(flowList.size()>0){
				j.setMsg("有下级流程数据，无法删除此行");
				return j;
			}
			WorkMaterialEntity workMaterial=new WorkMaterialEntity();
			workMaterial.setGuideId(id);
			MiniDaoPage<WorkMaterialEntity> list2 = workMaterialService.getAll(workMaterial, 1, 10);
			List<WorkMaterialEntity> materialList = list2.getResults();
			if(materialList.size()>0){
				j.setMsg("有下级流程数据，无法删除此行");
				return j;
			}
			try {
				workGuideService.delete(id);
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
		WorkFlowEntity workFlow=new WorkFlowEntity();
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			workFlow.setGuideId(id);
			MiniDaoPage<WorkFlowEntity> list = workFlowService.getAll(workFlow, 1, 10);
			List<WorkFlowEntity> FlowList = list.getResults();
			if(FlowList.size()>0){
				j.setMsg(FlowList.get(0).getFlowName()+":非空，无法批量删除");
				return j;
			}
		}
		WorkMaterialEntity workMaterial=new WorkMaterialEntity();
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			workMaterial.setGuideId(id);
			MiniDaoPage<WorkMaterialEntity> list = workMaterialService.getAll(workMaterial, 1, 10);
			List<WorkMaterialEntity> MaterialList = list.getResults();
			if(MaterialList.size()>0){
				j.setMsg(MaterialList.get(0).getMaterialName()+":非空，无法批量删除");
				return j;
			}
		}
		try {
			workGuideService.batchDelete(ids);
			j.setMsg("批量删除成功");
		} catch(Exception e) {
			j.setSuccess(false);
			j.setMsg("批量删除失败");
			e.printStackTrace();
		}
		return j;
	}

}

