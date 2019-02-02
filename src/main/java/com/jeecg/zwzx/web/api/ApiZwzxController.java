package com.jeecg.zwzx.web.api;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.VelocityContext;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.page.SystemTools;
import org.jeecgframework.p3.core.util.oConvertUtils;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
import com.jeecg.zwzx.utils.ImageUtil;
import com.jeecg.zwzx.utils.PasswordUtil;
import com.jeecg.zwzx.utils.ResourceUtil;

/**
 * CMS API
 * 
 * @author zhangdaihao
 * 
 */
@Controller
@RequestMapping("/api/zwzx")
public class ApiZwzxController extends BaseController {
	private String sign_key="26F72780372E84B6CFAED6F7B19139CC47B1912B6CAED753";
	private String aesKey="W3ZNF7UMBAn9WFnx";
	private String ivKey="chMQRwqC2xIIXqLV";

	@Autowired
	private WorkApplyService workApplyService;
	@Autowired
	private WorkGuideService workGuideService;
	@Autowired
	private WorkMenuService workMenuService;
	@Autowired
	private WorkFlowService workFlowService;
	@Autowired
	private WorkMaterialService workMaterialService;
	@Autowired
	private WorkUserService workUserService;
	
	/**
	 * 返回栏目数据
	 * URL: http://localhost/jeecg-p3-web/api/cms/menu.do
	 * 
	 * @return
	 */
	
	
	
	
	@RequestMapping(value="/getApplies")
	public @ResponseBody String getApplies(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String dealPersion = request.getHeader("login-code");
    	String guideId=request.getParameter("guideId");
    	WorkApplyEntity workApply=new WorkApplyEntity();
    	workApply.setGuideId(guideId);
    	workApply.setDealPersion(dealPersion);
    	workApply.setApplyStatus(0);
 		MiniDaoPage<WorkApplyEntity> list = workApplyService.getAll(workApply, 1, 999999);
		// 分页数据
		List<?> resut = list.getResults();
		return JSONArray.toJSONString(resut);
	}
	
	@RequestMapping(value= "/createApply", method = RequestMethod.POST)
	public @ResponseBody AjaxJson createApply(HttpServletRequest request, @RequestBody WorkApplyEntity workApply) {
		AjaxJson j = new AjaxJson();
		try {
			workApply.setApplyData(new Date());
			workApplyService.insert(workApply);
			j.setMsg("保存成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("保存失败");
		    e.printStackTrace();
		}
		return j;
	}
	
	@RequestMapping(value= "/updateApply", method = RequestMethod.POST)
	public @ResponseBody AjaxJson updateApply(HttpServletRequest request, @RequestBody WorkApplyEntity workApply) {
		AjaxJson j = new AjaxJson();
		try {
			workApplyService.update(workApply);
			j.setMsg("保存成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("保存失败");
		    e.printStackTrace();
		}
		return j;
	}
	
	/**
	 * 删除
	 * @return
	 */
	@RequestMapping(value="/deleteApply",method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson doDelete(@RequestParam(required = true, value = "id" ) String id,
			@RequestParam(required = true, value = "dealPersion" ) String dealPersion){
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
	
	
	
	@RequestMapping(value ="/userRegister", method = RequestMethod.POST)
	public @ResponseBody AjaxJson userRegister(HttpServletRequest request, @RequestBody WorkUserEntity workUser) {
		AjaxJson j = new AjaxJson();
		String password = workUser.getPassword();
		try {
			workUser=workUserService.get(workUser.getId());
			Map<String,Object> attributes=new HashMap<String,Object>();
			workUser.setPassword(PasswordUtil.encrypt(workUser.getUsername(), password, PasswordUtil.getStaticSalt()));
			workUser.setStatus(3);
			workUserService.update(workUser);
			j.setObj(workUser.getId());
			attributes.put("status", 3);
			j.setAttributes(attributes);
			j.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
		}
		return j;
	}
	
	@RequestMapping("/smsCodeLogin")
	public @ResponseBody AjaxJson smsCodeLogin(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
    	String phone=request.getParameter("phone");
    	String userkey=request.getParameter("userkey");
    	WorkUserEntity workUser=new WorkUserEntity();
		try {
	    	if(phone!=null&&userkey!=null){
	        	workUser.setPhone(phone);
	        	workUser.setUserkey(userkey);
				MiniDaoPage<WorkUserEntity> list = workUserService.getAll(workUser, 1, 10);
				List<WorkUserEntity> workUserList = list.getResults();
				if(workUserList.size()>0){
					workUser=workUserList.get(0);
					// 2，短信验证码登录
					workUser.setStatus(2);
					workUserService.update(workUser);
					j.setObj(workUser.getId());
					Map<String,Object> attributes=new HashMap<String,Object>();
					attributes.put("status", 2);
					j.setAttributes(attributes);
					j.setSuccess(true);
				}else{
					j.setSuccess(false);
				}
	    	}else{
				j.setSuccess(false);	    		
	    	}
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
		}
		return j;
	}
	
	@RequestMapping("/registerCode")
	public @ResponseBody AjaxJson registerCode(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		String id = request.getHeader("login-code");
		WorkUserEntity workUser=new WorkUserEntity();
		workUser.setId(id);
		try {
			MiniDaoPage<WorkUserEntity> list = workUserService.getAll(workUser, 1, 10);
			List<WorkUserEntity> workUserList = list.getResults();
			if(workUserList.size()==1){
				workUser=workUserList.get(0);
				Map<String,Object> attributes=new HashMap<String,Object>();
				attributes.put("status", workUser.getStatus());
				j.setAttributes(attributes);
				j.setSuccess(true);
			}else{
				j.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
		}
		return j;
	}
	
	@RequestMapping(value= "/login", method = RequestMethod.POST)
	public @ResponseBody AjaxJson login(HttpServletRequest request, @RequestBody WorkUserEntity workUser) {
		AjaxJson j = new AjaxJson();
		if(workUser.getUsername()!=null&&workUser.getPassword()!=null){
			String encryptPass="";
			try {
				encryptPass = AES128Util.decrypt(workUser.getPassword(), aesKey ,ivKey);
			} catch (Exception e) {
				//e.printStackTrace();
			}
			System.out.println("phone:"+workUser.getUsername()+"-----"+"aespass:"+workUser.getPassword());
			workUser.setPassword(PasswordUtil.encrypt(workUser.getUsername(), encryptPass, PasswordUtil.getStaticSalt()));
			try {
				MiniDaoPage<WorkUserEntity> list = workUserService.getAll(workUser, 1, 10);
				List<WorkUserEntity> workUserList = list.getResults();
				if(workUserList.size()==1){
					System.out.println("workUserList.size:"+workUserList.size()+"个");
					workUser=workUserList.get(0);
					
	//		        HttpSession session = ContextHolderUtils.getSession();
	//				session.setAttribute("wuId", workUser.getId());
					Map<String,Object> attributes=new HashMap<String,Object>();
					attributes.put("login_code", workUser.getId());
					attributes.put("status", workUser.getStatus());
					j.setAttributes(attributes);
					j.setSuccess(true);
				}else{
					j.setSuccess(false);
				}
			} catch (Exception e) {
				e.printStackTrace();
				j.setSuccess(false);
			}
		}else{
			j.setSuccess(false);
		}
		return j;
	}
	
	@RequestMapping("/userInfo")
	public @ResponseBody AjaxJson userInfo(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		String id = request.getHeader("login-code");
		if(id!=null&&id!=""){
			try {
	    		System.out.println("id:"+id);
	    		WorkUserEntity workUser=new WorkUserEntity();
	    		workUser.setId(id);
				MiniDaoPage<WorkUserEntity> list = workUserService.getAll(workUser, 1, 10);
				List<WorkUserEntity> workUserList = list.getResults();
				if(workUserList.size()>0){
		    		System.out.println("workUserList.size():-----"+workUserList.size());
					workUser=workUserList.get(0);
	//				Map<String,Object> attributes=new HashMap<String,Object>();
	//				attributes.put("status", workUser.getStatus());
	//				j.setAttributes(attributes);
					j.setObj(workUser);
					j.setSuccess(true);
				}else{
					j.setSuccess(false);
				}
			} catch (Exception e) {
				e.printStackTrace();
				j.setSuccess(false);
			}
		}else{
			j.setSuccess(false);
		}
		return j;
	}
	

	@RequestMapping("/idCardLogin")
	public @ResponseBody AjaxJson idCardLogin(HttpServletRequest request, HttpServletResponse response) {
		//TODO 验证身份证号接口
		
		AjaxJson j = new AjaxJson();
		try {
    		WorkUserEntity workUser=new WorkUserEntity();
			String idcard=request.getParameter("idcard");
			workUser.setIdcard(idcard);
			MiniDaoPage<WorkUserEntity> list = workUserService.getAll(workUser, 1, 10);
			List<WorkUserEntity> workUserList = list.getResults();
			if(workUserList.size()>0){
				j.setSuccess(false);
				j.setMsg("身份证号已注册");
				return j;
			}
    		String id = request.getHeader("login-code");
    		workUser.setId(id);
			String realname= URLDecoder.decode(request.getParameter("realname"),"utf-8");
			
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
	
    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    @ResponseBody
    public  AjaxJson doUpload(MultipartHttpServletRequest request, HttpServletResponse response) {
    	AjaxJson j = new AjaxJson();
		Map<String, Object> attributes = new HashMap<String, Object>();
		try {
			String existFile = request.getParameter("existFile");
//			String basePath = request.getSession().getServletContext().getRealPath("/");
			//获取所有文件名称  
	        String basePath=ResourceUtil.getConfigByName("webUploadpath");//demo中设置为D://upFiles,实际项目应因事制宜
			Iterator<String> it = request.getFileNames();  
			while(it.hasNext()){  
			    //根据文件名称取文件  
			    MultipartFile multifile = request.getFile(it.next());  
//			    String fileName = multifile.getOriginalFilename(); 
		        String realFilename=multifile.getOriginalFilename();
		        String fileExtension = realFilename.substring(realFilename.lastIndexOf("."));
				String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz";// 初始化种子
		        String fileName=RandomStringUtils.random(8, str)+System.currentTimeMillis()+fileExtension;
				if(existFile!=null&existFile!=""){
					fileName=existFile+fileExtension;
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		        String datedir = sdf.format(new Date());  
			    String filePath = "/upload/img/zwzx/"+datedir+"/"; 
			    File file = new File(basePath+filePath);
				if (!file.exists()) {
					file.mkdirs();// 创建文件根目录
				}
				filePath = filePath+fileName;
			    String savePath = basePath+filePath;

			    System.out.println(savePath);
			    File newFile = new File(savePath);  
			    //上传的文件写入到指定的文件中  
			    multifile.transferTo(newFile);  
//	    		FileCopyUtils.copy(realFilename.getBytes(), newFile);
				ImageUtil.zoomImageScale(newFile, savePath,300);
			    attributes.put("url", filePath);
			    attributes.put("fileKey", fileName);
			}
			j.setMsg("文件上传成功");
			j.setAttributes(attributes);
		}  catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
			j.setMsg("文件上传失败");
		}  

		return j;
    }
}
