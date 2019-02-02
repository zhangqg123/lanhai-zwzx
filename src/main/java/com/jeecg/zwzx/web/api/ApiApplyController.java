package com.jeecg.zwzx.web.api;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.util.oConvertUtils;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.jeecg.zwzx.entity.WorkApplyEntity;
import com.jeecg.zwzx.entity.WorkFlowEntity;
import com.jeecg.zwzx.entity.WorkGuideEntity;
import com.jeecg.zwzx.entity.WorkMaterialEntity;
import com.jeecg.zwzx.entity.WorkMenuEntity;
import com.jeecg.zwzx.entity.WorkUserEntity;
import com.jeecg.zwzx.service.WorkApplyService;
import com.jeecg.zwzx.service.WorkFlowService;
import com.jeecg.zwzx.service.WorkGuideService;
import com.jeecg.zwzx.service.WorkMaterialService;
import com.jeecg.zwzx.service.WorkMenuService;
import com.jeecg.zwzx.service.WorkUserService;
import com.jeecg.zwzx.utils.AES128Util;
import com.jeecg.zwzx.utils.ContextHolderUtils;
import com.jeecg.zwzx.utils.PasswordUtil;

/**
 * CMS API
 * 
 * @author zhangdaihao
 * 
 */
@Controller
@RequestMapping("/api/zwzx/apply")
public class ApiApplyController extends BaseController {

	@Autowired
	private WorkUserService workUserService;
	@Autowired
	private WorkMenuService workMenuService;
	@Autowired
	private WorkApplyService workApplyService;
	@Autowired
	private WorkFlowService workFlowService;
	@Autowired
	private WorkMaterialService workMaterialService;
	
	
	@RequestMapping(value="/menu")
	public @ResponseBody String menu(@ModelAttribute WorkMenuEntity query, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pid = query.getParentCode();
		MiniDaoPage<WorkMenuEntity> list = workMenuService.getAll(query, 1, 199);
		// 分页数据
		List<?> resut = list.getResults();
		return JSONArray.toJSONString(resut);
	}
	
	@RequestMapping(value="/applyList")
	public @ResponseBody String applyList(@ModelAttribute WorkApplyEntity query, HttpServletRequest request, HttpServletResponse response ,
			@RequestParam(required = false, value = "pageNumber", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "6") int pageSize) throws Exception {
		if(pageNo==0){
			pageNo=1;
		}
		String status = request.getParameter("status");
		if(status!=null&&status.equals("waitInterviews")){
			query.setApplyStatus(2);
		}
		String dealPersion = request.getHeader("login-code");
		query.setDealPersion(dealPersion);
		MiniDaoPage<WorkApplyEntity> list = workApplyService.getAll(query, pageNo, pageSize);
		// 分页数据
		List<?> resut = list.getResults();
		return JSONArray.toJSONString(resut);
	}
	
	@RequestMapping(value="/applyEditList")
	public @ResponseBody String applyEditList(@ModelAttribute WorkApplyEntity query, HttpServletRequest request, HttpServletResponse response ,
			@RequestParam(required = false, value = "pageNumber", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "6") int pageSize) throws Exception {
		if(pageNo==0){
			pageNo=1;
		}
		String dealPersion = request.getHeader("login-code");
		query.setDealPersion(dealPersion);
		MiniDaoPage<WorkApplyEntity> list = workApplyService.applyEditList(query, pageNo, pageSize);
		// 分页数据
		List<?> resut = list.getResults();
		return JSONArray.toJSONString(resut);
	}

	@RequestMapping(value="/applyInterviewList")
	public @ResponseBody String applyInterviewList(@ModelAttribute WorkApplyEntity query, HttpServletRequest request, HttpServletResponse response ,
			@RequestParam(required = false, value = "pageNumber", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "6") int pageSize) throws Exception {
		if(pageNo==0){
			pageNo=1;
		}
//		String status = request.getParameter("status");
//		if(status!=null&&status.equals("waitInterviews")){
//			query.setApplyStatus(2);
//		}
		String dealPersion = request.getHeader("login-code");
		query.setDealPersion(dealPersion);
		MiniDaoPage<WorkApplyEntity> list = workApplyService.getApplyInterview(query, pageNo, pageSize);
		// 分页数据
		List<?> resut = list.getResults();
		return JSONArray.toJSONString(resut);
	}

//	@RequestMapping("/queryOneGuides")
//	public @ResponseBody AjaxJson queryOneGuides(String guideId) {
//		AjaxJson j = new AjaxJson();
//		try {
//			if(oConvertUtils.isNotEmpty(guideId)) {
//				WorkGuideEntity workGuide = workGuideService.get(guideId);
//				j.setObj(workGuide);
//				j.setSuccess(true);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			j.setSuccess(false);
//		}
//		return j;
//	}
	
	@RequestMapping(value="/workFlow")
	public @ResponseBody String flows(@ModelAttribute WorkFlowEntity query, HttpServletRequest request, HttpServletResponse response ,
			@RequestParam(required = false, value = "pageNumber", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "6") int pageSize) throws Exception {
		String guideId = request.getParameter("guideId");
		query.setGuideId(guideId);
		MiniDaoPage<WorkFlowEntity> list = workFlowService.getAll(query, pageNo, pageSize);
		// 分页数据
		List<?> resut = list.getResults();
		return JSONArray.toJSONString(resut);
	}
	
	@RequestMapping(value="/workMaterial")
	public @ResponseBody String materials(@ModelAttribute WorkMaterialEntity query, HttpServletRequest request, HttpServletResponse response ,
			@RequestParam(required = false, value = "pageNumber", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "6") int pageSize) throws Exception {
		String guideId = request.getParameter("guideId");
		query.setGuideId(guideId);
		MiniDaoPage<WorkMaterialEntity> list = workMaterialService.getAll(query, pageNo, pageSize);
		// 分页数据
		List<?> resut = list.getResults();
		return JSONArray.toJSONString(resut);
	}
	


	@RequestMapping("/idCardLogin")
	public @ResponseBody AjaxJson idCardLogin(@ModelAttribute WorkUserEntity workUser, HttpServletRequest request, HttpServletResponse response) {
		//TODO 验证身份证号接口
		
		AjaxJson j = new AjaxJson();
		try {
			String realname= URLDecoder.decode(workUser.getRealname(),"utf-8");
			String idcard=workUser.getIdcard();
			
			workUser=workUserService.get(workUser.getId());
			workUser.setRealname(realname);
			workUser.setIdcard(idcard);
			// 4，身份证验证通过
			workUser.setStatus(4);
			workUserService.update(workUser);
			j.setObj(workUser.getId());
			Map<String,Object> attributes=new HashMap<String,Object>();
			attributes.put("status", 4);
			j.setAttributes(attributes);
			j.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
		}
		return j;
	}


}
