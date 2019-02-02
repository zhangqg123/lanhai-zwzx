package com.jeecg.zwzx.main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.VelocityContext;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeecg.zwzx.entity.WorkGuideEntity;
import com.jeecg.zwzx.entity.WorkMenuEntity;
import com.jeecg.zwzx.service.WorkApplyService;
import com.jeecg.zwzx.service.WorkGuideService;
import com.jeecg.zwzx.service.WorkMenuService;

 /**
 * 描述：首页
 * @author scott
 * @version:1.0
 */
@Controller
@RequestMapping("/zwzx/index")
public class ZwzxIndexController extends BaseController{
	  @Autowired
	  private WorkApplyService workApplyService;
	  @Autowired
	  private WorkMenuService workMenuService;
	  @Autowired
	  private WorkGuideService workGuideService;

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request,HttpServletResponse response)throws Exception{
//		String rolecodes = (String) request.getSession().getAttribute("rolecodes");
		MiniDaoPage<WorkMenuEntity> mlist = null;
		List<WorkMenuEntity> menuList = null;
		List<WorkGuideEntity> guideList = null;
		MiniDaoPage<WorkGuideEntity> glist = null;
		WorkMenuEntity workMenu=new WorkMenuEntity();
			mlist =  workMenuService.getAll(workMenu,1,200);
			WorkGuideEntity workGuide=new WorkGuideEntity();
//			glist =  workGuideService.getAll(workGuide,1,200);						
			guideList=new ArrayList<WorkGuideEntity>();
		menuList = mlist.getResults();

		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("menuList",menuList);
		velocityContext.put("guideList",guideList);
		String viewName = "zwzx/main/workApplyAdd.vm";
		ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 跳转首页
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
	public void index(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		 try {
			 VelocityContext velocityContext = new VelocityContext();
			 String viewName = "zwzx/main/index.vm";
			 ViewVelocity.view(request,response,viewName,velocityContext);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
