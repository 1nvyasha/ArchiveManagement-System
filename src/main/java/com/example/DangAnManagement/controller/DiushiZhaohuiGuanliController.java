package com.example.DangAnManagement.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.DangAnManagement.entity.Find;
import com.example.DangAnManagement.service.ArchiveService;
import com.example.DangAnManagement.service.FindService;
import com.example.DangAnManagement.service.LogInfoService;
import com.example.DangAnManagement.service.UserInfoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DiushiZhaohuiGuanliController {
	@Autowired
	private ArchiveService as;
	@Autowired
	private FindService fs;
	@Autowired
	private UserInfoService us;
	@Autowired
	private LogInfoService lgs;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@RequestMapping("/todiushiZhaohuiManagement")
	public String show(Model model, HttpSession session) {
		model.addAttribute("archives",as.getAllArchive());
		return "diushi_zhaohui_management";
	}
	
	@RequestMapping("/todiushiZhaohuiDengji")
	public String tolose(Model model, HttpSession session, Integer ObjectId) {
		session.setAttribute("ObjectId", ObjectId);
		model.addAttribute("currentDate",sdf.format(new Date(System.currentTimeMillis())));
		return "diushi_zhaohui_dengji";
	}
	
	@RequestMapping("/diushiZhaohuiDengji")
	public String lose(Model model, HttpSession session, @ModelAttribute Find find, @RequestParam Date FindTime) {
		int ObjectId=(int)session.getAttribute("ObjectId");
		String ArchiveId=as.getArchiveByObjectId(ObjectId).getArchiveId();
		
		String loginname=(String)session.getAttribute("username");
		
		lgs.insertLog("更新",loginname, new Date(System.currentTimeMillis()), "用户"+loginname+"找回丢失档案,该档案id为"+ArchiveId);
		
		find.setArchiveId(ArchiveId);
		find.setLoginId(us.getUserByName(loginname).getLoginId());
		find.setFindTime(FindTime);
		
		as.updateArchiveState("正常", ObjectId);
		fs.insertFind(find);
		
		model.addAttribute("message", "档案找回成功");
		return "index";
	}
	
	@RequestMapping("/diushiZhaohuiManagementSousuo")
	public String search(Model model, HttpSession session, @RequestParam String archiveid) {
		model.addAttribute("archives",as.getArchiveByArchiveId(archiveid));
		return "diushi_zhaohui_management";
	}
}
