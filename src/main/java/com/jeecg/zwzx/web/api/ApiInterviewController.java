package com.jeecg.zwzx.web.api;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.alibaba.fastjson.JSONArray;
import com.jeecg.zwzx.entity.WorkApplyEntity;
import com.jeecg.zwzx.entity.WorkInterviewEntity;
import com.jeecg.zwzx.service.WorkInterviewService;
import com.jeecg.zwzx.utils.DateUtil;

/**
 * 描述：预约表
 * 
 * @author: www.jeecg.org
 * @since：2018年11月07日 08时04分31秒 星期三
 * @version:1.0
 */
@Controller
@RequestMapping("/api/zwzx/interview")
public class ApiInterviewController extends BaseController {
	@Autowired
	private WorkInterviewService workInterviewService;

	@RequestMapping(value = "/interviewList")
	public @ResponseBody String interviewList(
			@ModelAttribute WorkInterviewEntity query,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = false, value = "pageNumber", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "6") int pageSize)
			throws Exception {
		if (pageNo == 0) {
			pageNo = 1;
		}
		query.setInterviewStatus(3);
		String dealPersion = request.getHeader("login-code");
		query.setDealPersion(dealPersion);
		MiniDaoPage<WorkInterviewEntity> list = workInterviewService.getAll(
				query, pageNo, pageSize);
		// 分页数据
		List<?> resut = list.getResults();
		return JSONArray.toJSONString(resut);
	}

	@RequestMapping(value = "/interviewTime")
	public @ResponseBody String interviewTime(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String guideId = request.getParameter("guideid");
		int everyInterviews = 3;
		List<WorkInterviewEntity> list = workInterviewService
				.getInterviewNum(guideId);
		ArrayList futureDaysList = new ArrayList();
		for (int i = 1; i <= 7; i++) {
			Map map = new HashMap();
			String tmpDate = DateUtil.getFutureDate(i);
			if (tmpDate.equals("weekend")) {
				continue;
			}
			map.put("date", tmpDate);
			map.put("chooseTime1", everyInterviews);
			map.put("interviewNum1", everyInterviews);
			map.put("chooseTime2", everyInterviews);
			map.put("interviewNum2", everyInterviews);
			map.put("enablenum1", true);
			map.put("enablenum2", true);
			for (int j = 0; j < list.size(); j++) {
				WorkInterviewEntity interview = list.get(j);
				Date interviewDate = interview.getInterviewDate();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String result = format.format(interviewDate);
				if (result.equals(tmpDate)) {
					if (interview.getChoosTime() == 1) {
						map.put("chooseTime1",
								everyInterviews - interview.getChoosTime());
						map.put("interviewNum1",
								everyInterviews - interview.getInterviewNum());
						map.put("enablenum1",
								everyInterviews - interview.getInterviewNum() > 0);
					}
					if (interview.getChoosTime() == 2) {
						map.put("chooseTime2",
								everyInterviews - interview.getChoosTime());
						map.put("interviewNum2",
								everyInterviews - interview.getInterviewNum());
						map.put("enablenum2",
								everyInterviews - interview.getInterviewNum() > 0);
					}
				}
			}
			futureDaysList.add(map);
		}

		return JSONArray.toJSONString(futureDaysList);
	}

	// public static void main(String args[]) {
	// ArrayList futureDaysList = new ArrayList();
	// for (int i = 1; i <= 5; i++) {
	// Map map=new HashMap();
	// map.put("date", DateUtil.getFutureDate(i));
	// futureDaysList.add(map);
	// }
	// System.out.println("Hello World!");
	//
	// }

	/**
	 * 详情
	 * 
	 * @return
	 */
	@RequestMapping(params = "toDetail", method = RequestMethod.GET)
	public void workInterviewDetail(
			@RequestParam(required = true, value = "id") String id,
			HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "jeecg/zwzx/workInterview-detail.vm";
		WorkInterviewEntity workInterview = workInterviewService.get(id);
		velocityContext.put("workInterview", workInterview);
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	/**
	 * 跳转到添加页面
	 * 
	 * @return
	 */
	@RequestMapping(params = "toAdd", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void toAddDialog(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "jeecg/zwzx/workInterview-add.vm";
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	/**
	 * 保存信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/startInterview", method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public AjaxJson startInterview(
			@ModelAttribute WorkInterviewEntity workInterview,
			HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		String dealPersion = request.getHeader("login-code");
		workInterview.setDealPersion(dealPersion);
		String chooseTime = request.getParameter("chooseTime");
		String time = request.getParameter("date");
		if (Integer.parseInt(chooseTime) == 1) {
			time = time + " 10:00:00";
		} else {
			time = time + " 14:00:00";
		}
		// String—>Date
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date = sdf.parse(time);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		workInterview.setChoosTime(Integer.parseInt(chooseTime));
		workInterview.setInterviewDate(date);
		workInterview.setInterviewStatus(3); // 预约成功
		try {
			workInterviewService.startInterview(workInterview);
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
	 * 
	 * @return
	 */
	@RequestMapping(params = "toEdit", method = RequestMethod.GET)
	public void toEdit(@RequestParam(required = true, value = "id") String id,
			HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		WorkInterviewEntity workInterview = workInterviewService.get(id);
		velocityContext.put("workInterview", workInterview);
		String viewName = "jeecg/zwzx/workInterview-edit.vm";
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	/**
	 * 编辑
	 * 
	 * @return
	 */
	@RequestMapping(params = "doEdit", method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute WorkInterviewEntity workInterview) {
		AjaxJson j = new AjaxJson();
		try {
			workInterviewService.update(workInterview);
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
	 * 
	 * @return
	 */
	@RequestMapping(value = "/cancelInterview", method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson cancelInterview(
			@RequestParam(required = true, value = "interviewId") String interviewId,
			@RequestParam(required = true, value = "applyId") String applyId) {
		AjaxJson j = new AjaxJson();
		try {
			workInterviewService.cancelInterview(interviewId,applyId);
			j.setMsg("取消预约成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("取消预约失败");
			e.printStackTrace();
		}
		return j;
	}

	/**
	 * 批量删除数据
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "batchDelete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson batchDelete(
			@RequestParam(required = true, value = "ids") String[] ids) {
		AjaxJson j = new AjaxJson();
		try {
			workInterviewService.batchDelete(ids);
			j.setMsg("批量删除成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("批量删除失败");
			e.printStackTrace();
		}
		return j;
	}

}
