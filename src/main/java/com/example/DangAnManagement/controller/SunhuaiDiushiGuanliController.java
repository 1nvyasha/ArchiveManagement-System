package com.example.DangAnManagement.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.DangAnManagement.entity.Lose;
import com.example.DangAnManagement.service.ArchiveService;
import com.example.DangAnManagement.service.LogInfoService;
import com.example.DangAnManagement.service.LoseService;
import com.example.DangAnManagement.service.UserInfoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SunhuaiDiushiGuanliController {
	@Autowired
	private ArchiveService as;
	@Autowired
	private LoseService ls;
	@Autowired
	private UserInfoService us;
	@Autowired
	private LogInfoService lgs;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	//↓↓↓损坏丢失管理↓↓↓
	@RequestMapping("/tosunhuaiDiushiManagement")
	public String show(Model model, HttpSession session) {
		model.addAttribute("archives",null);
		return "sunhuai_diushi_management";
	}
		
	@RequestMapping("/tosunhuaiDiushiDengji")
	public String tolose(Model model, HttpSession session, Integer ObjectId) {
		session.setAttribute("ObjectId", ObjectId);
		model.addAttribute("currentDate",sdf.format(new Date(System.currentTimeMillis())));
		return "sunhuai_diushi_dengji";
	}
	
	@RequestMapping("/sunhuaiDiushiDengji")
	public String lose(Model model, HttpSession session, @ModelAttribute Lose lose, @RequestParam Date LoseTime) {
		int ObjectId=(int)session.getAttribute("ObjectId");
		String ArchiveId=as.getArchiveByObjectId(ObjectId).getArchiveId();
		
		String loginname=(String)session.getAttribute("username");
		
		lgs.insertLog("更新",loginname, new Date(System.currentTimeMillis()), "用户"+loginname+"登记损坏丢失档案,该档案id为"+ArchiveId);
		
		lose.setArchiveId(ArchiveId);
		lose.setLoginId(us.getUserByName(loginname).getLoginId());
		lose.setLoseTime(LoseTime);
		
		as.updateArchiveState(lose.getType(), ObjectId);
		ls.insertLose(lose);
		
		model.addAttribute("message", "损坏丢失登记成功");
		return "index";
	}
	
	@RequestMapping("/sunhuaiDiushiManagementSousuo")
	public String search(Model model, HttpSession session, @RequestParam String archiveid) {
		model.addAttribute("archives",as.getArchiveByArchiveId(archiveid));
		return "sunhuai_diushi_management";
	}
	//↑↑↑损坏丢失管理↑↑↑
	
	//↓↓↓损坏丢失查询↓↓↓
	@RequestMapping("/tosunhuaiDiushiChaxun")
	public String show1(Model model, HttpSession session) {
		model.addAttribute("currentDate",sdf.format(new Date(System.currentTimeMillis())));
		model.addAttribute("archives",null);
		return "sunhuai_diushi_chaxun";
	}
	
	@RequestMapping("/sunhuaiDiushiChaxunSousuo")
	public String search1(Model model, HttpSession session, @RequestParam Date date1, @RequestParam Date date2) {
		model.addAttribute("currentDate",sdf.format(new Date(System.currentTimeMillis())));
		model.addAttribute("archives",as.searchLoseArchive(date1, date2));
		return "sunhuai_diushi_chaxun";
	}
	//↑↑↑损坏丢失查询↑↑↑
}
