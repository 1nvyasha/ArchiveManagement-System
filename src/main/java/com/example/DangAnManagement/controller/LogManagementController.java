package com.example.DangAnManagement.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.DangAnManagement.service.LogInfoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LogManagementController {
	@Autowired
	private LogInfoService lgs;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@RequestMapping("/tologManagement")
	public String show(Model model, HttpSession session) {
		model.addAttribute("currentDate",sdf.format(new Date(System.currentTimeMillis())));//获取当前时间
		model.addAttribute("logs",lgs.getAllLog());
		return "log_management";
	}
	
	@RequestMapping("/logManagementShanchu")
	public String delete(Model model, HttpSession session, Integer logid) {
		lgs.deleteLog(logid);
		return "redirect:/6";
	}
	
	@RequestMapping("/logManagementSousuoByLogType")
	public String searchByType(Model model, HttpSession session, @RequestParam String logtype) {
        model.addAttribute("currentDate",sdf.format(new Date(System.currentTimeMillis())));//获取当前时间
		model.addAttribute("logs", lgs.searchLogByType(logtype));
		return "log_management";
	}
	
	@RequestMapping("/logManagementSousuoByOperateDate")
	public String searchByType(Model model, HttpSession session, @RequestParam Date date1, @RequestParam Date date2) {
        model.addAttribute("currentDate",sdf.format(new Date(System.currentTimeMillis())));//获取当前时间
		model.addAttribute("logs", lgs.searchLogByDate(date1, date2));
		return "log_management";
	}
}
