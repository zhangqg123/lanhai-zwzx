package com.jeecg.zwzx.web;

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

import com.jeecg.zwzx.entity.WorkFlowEntity;
import com.jeecg.zwzx.entity.WorkGuideEntity;
import com.jeecg.zwzx.service.WorkFlowService;
import com.jeecg.zwzx.service.WorkGuideService;

 /**
 * 描述：流程表
 * @author: www.jeecg.org
 * @since：2018年09月09日 16时50分22秒 星期日 
 * @version:1.0
 */
@Controller
@RequestMapping("/jeecg/workFlow")
public class WorkFlowController extends BaseController{
  @Autowired
  private WorkFlowService workFlowService;
  @Autowired
  private WorkGuideService workGuideService;
  
	/**
	  * 列表页面
	  * @return
	  */
	@RequestMapping(params = "list",method = {RequestMethod.GET,RequestMethod.POST})
	public void list(@ModelAttribute WorkFlowEntity query,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
			try {
			 	LOG.info(request, " back list");
			 	//分页数据
				MiniDaoPage<WorkFlowEntity> list =  workFlowService.getAll(query,pageNo,pageSize);
				WorkGuideEntity workGuide = workGuideService.get(query.getGuideId());
				query.setGuideName(workGuide.getGuideName());
				VelocityContext velocityContext = new VelocityContext();
				velocityContext.put("workFlow",query);
				velocityContext.put("pageInfos",SystemTools.convertPaginatedList(list));
				String viewName = "jeecg/zwzx/workFlow-list.vm";
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
	public void workFlowDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
			VelocityContext velocityContext = new VelocityContext();
			String viewName = "jeecg/zwzx/workFlow-detail.vm";
			WorkFlowEntity workFlow = workFlowService.get(id);
			velocityContext.put("workFlow",workFlow);
			ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request,HttpServletResponse response)throws Exception{
		String guideId=(String) request.getParameter("guideId");		
 
		VelocityContext velocityContext = new VelocityContext();
		String sessionid = request.getSession().getId();
		velocityContext.put("sessionid", sessionid);
		velocityContext.put("guideId",guideId);
		 String viewName = "jeecg/zwzx/workFlow-add.vm";
		 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 保存信息
	 * @return
	 */
	@RequestMapping(params = "doAdd",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute WorkFlowEntity workFlow){
		AjaxJson j = new AjaxJson();
		try {
			workFlowService.insert(workFlow);
			j.setMsg("保存成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("保存失败");
		    e.printStackTrace();
		}
		return j;
	}
	/**
	 * 生成流程
	 */
//	@RequestMapping(params = "generate",method ={RequestMethod.GET, RequestMethod.POST})
//	public void generate(HttpServletRequest request,HttpServletResponse response)throws Exception{
//		MiniDaoPage<WorkGuideEntity> list = null;
//		List<WorkGuideEntity> guideList = null;
//		WorkGuideEntity workGuide=new WorkGuideEntity();
//			list =  workGuideService.getAll(workGuide,1,200);
//		guideList = list.getResults();
//		for(WorkGuideEntity guide:guideList){
//			for(int i=0 ;i<2;i++){
//				WorkFlowEntity workFlow=new WorkFlowEntity();
//				workFlow.setFlowName(guide.getGuideName()+"--办事流程--"+String.valueOf(i));
//				workFlow.setGuideId(guide.getId());
//				workFlowService.insert(workFlow);
//			}
//		}
//	}

	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@RequestMapping(params="toEdit",method = RequestMethod.GET)
	public void toEdit(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request) throws Exception{
			VelocityContext velocityContext = new VelocityContext();
			String sessionid = request.getSession().getId();
			velocityContext.put("sessionid", sessionid);
			WorkFlowEntity workFlow = workFlowService.get(id);
			velocityContext.put("workFlow",workFlow);
			String viewName = "jeecg/zwzx/workFlow-edit.vm";
			ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute WorkFlowEntity workFlow){
		AjaxJson j = new AjaxJson();
		try {
			workFlowService.update(workFlow);
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
				workFlowService.delete(id);
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
			workFlowService.batchDelete(ids);
			j.setMsg("批量删除成功");
		} catch(Exception e) {
			j.setSuccess(false);
			j.setMsg("批量删除失败");
			e.printStackTrace();
		}
		return j;
	}

}

