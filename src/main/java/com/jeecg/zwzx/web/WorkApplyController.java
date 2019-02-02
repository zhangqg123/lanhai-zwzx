package com.jeecg.zwzx.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

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

import com.jeecg.zwzx.entity.Material;
import com.jeecg.zwzx.entity.WorkApplyEntity;
import com.jeecg.zwzx.entity.WorkGuideEntity;
import com.jeecg.zwzx.entity.WorkMenuEntity;
import com.jeecg.zwzx.service.WorkApplyService;
import com.jeecg.zwzx.service.WorkGuideService;
import com.jeecg.zwzx.service.WorkMenuService;

 /**
 * 描述：申报表
 * @author: www.jeecg.org
 * @since：2018年10月05日 13时32分21秒 星期五 
 * @version:1.0
 */
@Controller
@RequestMapping("/jeecg/workApply")
public class WorkApplyController extends BaseController{
  @Autowired
  private WorkApplyService workApplyService;
  @Autowired
  private WorkMenuService workMenuService;
  @Autowired
  private WorkGuideService workGuideService;

	/**
	  * 列表页面
	  * @return
	  */
	@RequestMapping(params = "list",method = {RequestMethod.GET,RequestMethod.POST})
	public void list(@ModelAttribute WorkApplyEntity query,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
			try {
			 	LOG.info(request, " back list");
				String rolecodes = (String) request.getSession().getAttribute("rolecodes");
				MiniDaoPage<WorkApplyEntity> list = null;
				MiniDaoPage<WorkMenuEntity> mlist = null;
				MiniDaoPage<WorkGuideEntity> glist = null;
				
				if(rolecodes.contains("admin")){
					list =  workApplyService.getAll(query,pageNo,pageSize);
					mlist =  workMenuService.getAll(new WorkMenuEntity(),1,200);
					WorkGuideEntity workGuide=new WorkGuideEntity();
					workGuide.setManagement(query.getManagement());
					glist =  workGuideService.getAll(workGuide,1,200);
				}else{
					if(rolecodes.contains("zwzx")){
						String userId=(String) request.getSession().getAttribute("loginUserId");
						WorkMenuEntity workMenu=workMenuService.getMenuByOwner(userId);
						query.setManagement(workMenu.getId());
						list =  workApplyService.getAll(query,pageNo,pageSize);
						mlist =  workMenuService.getAll(workMenu,1,200);
						
						workMenu=mlist.getResults().get(0);
						WorkGuideEntity workGuide=new WorkGuideEntity();
						workGuide.setManagement(workMenu.getId());						
						glist =  workGuideService.getAll(workGuide,1,200);						
					}
				}

			 	//分页数据
				List<WorkMenuEntity> menuList = mlist.getResults();
				List<WorkGuideEntity> guideList =glist.getResults();
				VelocityContext velocityContext = new VelocityContext();
				velocityContext.put("menuList",menuList);
				velocityContext.put("guideList",guideList);
				velocityContext.put("rolecodes",rolecodes);
			 	//分页数据
				velocityContext.put("workApply",query);
				velocityContext.put("pageInfos",SystemTools.convertPaginatedList(list));
				String viewName = "jeecg/zwzx/workApply-list.vm";
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
	public void workApplyDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
			VelocityContext velocityContext = new VelocityContext();
			String viewName = "jeecg/zwzx/workApply-detail.vm";
			WorkApplyEntity workApply = workApplyService.get(id);
			velocityContext.put("workApply",workApply);
			ViewVelocity.view(request,response,viewName,velocityContext);
	}
	/**
	 * 生成
	 */
//	@RequestMapping(params = "generate",method ={RequestMethod.GET, RequestMethod.POST})
//	public void generate(HttpServletRequest request,HttpServletResponse response)throws Exception{
//		MiniDaoPage<WorkGuideEntity> list = null;
//		List<WorkGuideEntity> guideList = null;
//		WorkGuideEntity workGuide=new WorkGuideEntity();
//			list =  workGuideService.getAll(workGuide,1,200);
//		guideList = list.getResults();
//		for(WorkGuideEntity guide:guideList){
//			for(int i=0 ;i<4;i++){
//				WorkApplyEntity workApply=new WorkApplyEntity();
//				workApply.setGuideId(guide.getId());
//				workApply.setManagement(guide.getManagement());
//				workApply.setApplySubject(guide.getGuideName()+"--申报--"+String.valueOf(i));
//				workApplyService.insert(workApply);
//			}
//		}
//	}
	
	/**
	 * 根据menu获取guide
	 */
	@RequestMapping(params = "getGuideByManagement",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson getGuideByManagement(HttpServletRequest request,HttpServletResponse response)throws Exception{
		AjaxJson j = new AjaxJson();
		String management=request.getParameter("management");
		MiniDaoPage<WorkGuideEntity> list = null;
		List<WorkGuideEntity> guideList = null;
		WorkGuideEntity workGuide=new WorkGuideEntity();
		workGuide.setManagement(management);
		list =  workGuideService.getAll(workGuide,1,200);
		guideList = list.getResults();
		j.setObj(list);
		return j;
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request,HttpServletResponse response)throws Exception{
		String rolecodes = (String) request.getSession().getAttribute("rolecodes");
		MiniDaoPage<WorkMenuEntity> mlist = null;
		List<WorkMenuEntity> menuList = null;
		List<WorkGuideEntity> guideList = null;
		MiniDaoPage<WorkGuideEntity> glist = null;
		WorkMenuEntity workMenu=new WorkMenuEntity();
		if(rolecodes.contains("admin")){
			mlist =  workMenuService.getAll(workMenu,1,200);
			WorkGuideEntity workGuide=new WorkGuideEntity();
//			glist =  workGuideService.getAll(workGuide,1,200);						
			guideList=new ArrayList<WorkGuideEntity>();
		}else{
			if(rolecodes.contains("zwzx")){
				String userId=(String) request.getSession().getAttribute("loginUserId");
				workMenu.setOwner(userId);
				mlist =  workMenuService.getAll(workMenu,1,200);
				workMenu=mlist.getResults().get(0);
				WorkGuideEntity workGuide=new WorkGuideEntity();
				workGuide.setManagement(workMenu.getId());
				
				glist =  workGuideService.getAll(workGuide,1,200);						
				guideList=glist.getResults();			}
		}
		menuList = mlist.getResults();

		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("menuList",menuList);
		velocityContext.put("guideList",guideList);
		String viewName = "jeecg/zwzx/workApply-add.vm";
		ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 保存信息
	 * @return
	 */
	@RequestMapping(params = "doAdd",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute WorkApplyEntity workApply){
		AjaxJson j = new AjaxJson();
		try {
			workApplyService.insert(workApply);
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
		String rolecodes = (String) request.getSession().getAttribute("rolecodes");
		MiniDaoPage<WorkMenuEntity> mlist = null;
		List<WorkMenuEntity> menuList = null;
		List<WorkGuideEntity> guideList = null;
		MiniDaoPage<WorkGuideEntity> glist = null;
		WorkMenuEntity workMenu=new WorkMenuEntity();
		WorkApplyEntity workApply = workApplyService.get(id);
		if(rolecodes.contains("admin")){
			mlist =  workMenuService.getAll(workMenu,1,200);
			WorkGuideEntity workGuide=new WorkGuideEntity();	
			workGuide.setManagement(workApply.getManagement());
			glist =  workGuideService.getAll(workGuide,1,200);						
		}else{
			if(rolecodes.contains("zwzx")){
				String userId=(String) request.getSession().getAttribute("loginUserId");
				workMenu.setOwner(userId);
				mlist =  workMenuService.getAll(workMenu,1,200);
				workMenu=mlist.getResults().get(0);
				WorkGuideEntity workGuide=new WorkGuideEntity();
				workGuide.setManagement(workMenu.getId());
				
				glist =  workGuideService.getAll(workGuide,1,200);						
			}
		}
		menuList = mlist.getResults();
		guideList=glist.getResults();
		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("menuList",menuList);
		velocityContext.put("guideList",guideList);
		velocityContext.put("workApply",workApply);
		if(workApply.getMaterial()!=null&&workApply.getMaterial()!=""){
			JSONArray materialArray = JSONArray.fromObject(workApply.getMaterial());
			List<?> materialList = JSONArray.toList(materialArray, new Material(), new JsonConfig());
			velocityContext.put("materialList",materialList);
		}
		String viewName = "jeecg/zwzx/workApply-edit.vm";
		ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute WorkApplyEntity workApply){
		AjaxJson j = new AjaxJson();
		try {
			workApplyService.update(workApply);
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
			try {
				workApplyService.delete(id);
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
		try {
			workApplyService.batchDelete(ids);
			j.setMsg("批量删除成功");
		} catch(Exception e) {
			j.setSuccess(false);
			j.setMsg("批量删除失败");
			e.printStackTrace();
		}
		return j;
	}

}

