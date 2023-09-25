package com.example.DangAnManagement.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.DangAnManagement.entity.SysConfig;
import com.example.DangAnManagement.service.LogInfoService;
import com.example.DangAnManagement.service.SysConfigService;

import jakarta.servlet.http.HttpSession;

@Controller
public class XitongPeizhiController {
	@Autowired
	private SysConfigService scs;
	@Autowired
	private LogInfoService lgs;
	
	@RequestMapping("/toxitongPeizhi")
	public String show(Model model, HttpSession session) {
		model.addAttribute("SystemInfo",scs.getSysConfig());
		return "xitong_peizhi";
	}
	
	@RequestMapping("/toxitongPeizhiXiugai")
	public String toupdate(Model model, HttpSession session) {
		model.addAttribute("SystemInfo",scs.getSysConfig());//表单绑定
		return "xitong_peizhi_xiugai";
	}
	
	@RequestMapping("/xitongPeizhiXiugai")
	public String update(Model model, HttpSession session, @ModelAttribute SysConfig sysconfig) {
		//int deptid=(int)session.getAttribute("deptid");
		scs.updateSysConfig(sysconfig);
		lgs.insertLog("更新", (String) session.getAttribute("username"), new Date(System.currentTimeMillis()), "用户"+session.getAttribute("username")+"修改系统配置");
		return "redirect:/1";
	}
}
