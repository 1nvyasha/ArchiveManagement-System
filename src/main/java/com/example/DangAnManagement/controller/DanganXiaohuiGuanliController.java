package com.example.DangAnManagement.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.DangAnManagement.entity.Destory;
import com.example.DangAnManagement.service.ArchiveService;
import com.example.DangAnManagement.service.DestoryService;
import com.example.DangAnManagement.service.LogInfoService;
import com.example.DangAnManagement.service.UserInfoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DanganXiaohuiGuanliController {
	@Autowired
	private ArchiveService as;
	@Autowired
	private DestoryService ds;
	@Autowired
	private UserInfoService us;
	@Autowired
	private LogInfoService lgs;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	//↓↓↓档案销毁管理↓↓↓
	@RequestMapping("/todanganXiaohuiManagement")
	public String show(Model model, HttpSession session) {
		model.addAttribute("archives",as.getAllArchive());
		return "dangan_xiaohui_management";
	}
	
	@RequestMapping("/todanganXiaohui")
	public String todestory(Model model, HttpSession session, Integer ObjectId) {
		session.setAttribute("ObjectId", ObjectId);
		model.addAttribute("currentDate",sdf.format(new Date(System.currentTimeMillis())));//获取当前时间
		return "dangan_xiaohui_dengji";
	}
	
	@RequestMapping("/danganXiaohui")
	public String destory(Model model, HttpSession session, @RequestParam Date DestoryTime, @RequestParam(defaultValue = "null") String Reason,@RequestParam(defaultValue = "null") String Remark) {
		int ObjectId=(int)session.getAttribute("ObjectId");
		String ArchiveId=as.getArchiveByObjectId(ObjectId).getArchiveId();
		
		String loginname=(String)session.getAttribute("username");
		
		lgs.insertLog("更新",loginname, new Date(System.currentTimeMillis()), "用户"+loginname+"销毁档案,该档案id为"+ArchiveId);
		
		Destory destory=new Destory();
		destory.setArchiveId(ArchiveId);
		destory.setLoginId(us.getUserByName(loginname).getLoginId());
		destory.setDestoryTime(DestoryTime);
		destory.setReason(Reason);
		destory.setRemark(Remark);
		
		as.updateArchiveState("销毁", ObjectId);
		ds.insertDestory(destory);
		
		model.addAttribute("message", "档案销毁成功");
		return "index";
	}
	
	@RequestMapping("/danganXiaohuiManagementSousuo")
	public String search(Model model, HttpSession session, @RequestParam String archiveid) {
		model.addAttribute("archives",as.getArchiveByArchiveId(archiveid));
		return "dangan_xiaohui_management";
	}
	//↑↑↑档案销毁管理↑↑↑
	
	//↓↓↓档案销毁查询↓↓↓
	@RequestMapping("/todanganXiaohuiChaxun")
	public String show1(Model model, HttpSession session) {
		model.addAttribute("currentDate",sdf.format(new Date(System.currentTimeMillis())));
		model.addAttribute("archives",null);
		return "dangan_xiaohui_chaxun";
	}
	
	@RequestMapping("/danganXiaohuiChaxunSousuo")
	public String search(Model model, HttpSession session, @RequestParam Date date1, @RequestParam Date date2) {
		model.addAttribute("currentDate",sdf.format(new Date(System.currentTimeMillis())));
		model.addAttribute("archives",as.searchDestoryArchive(date1, date2));
		return "dangan_xiaohui_chaxun";
	}
	//↑↑↑档案销毁查询↑↑↑
}
