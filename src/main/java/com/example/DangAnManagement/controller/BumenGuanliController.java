package com.example.DangAnManagement.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.DangAnManagement.entity.Dept;
import com.example.DangAnManagement.service.DeptService;
import com.example.DangAnManagement.service.LogInfoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BumenGuanliController {
	@Autowired
	private DeptService ds;
	@Autowired
	private LogInfoService lgs;
	
	@RequestMapping("/tobumenGuanli")
	public String show(Model model, HttpSession session) {
		model.addAttribute("depts",ds.getAllDept());
		return "bumen_guanli";
	}
	
	@RequestMapping("/tobumenGuanliXiugai")
	public String toupdate(Model model, HttpSession session, Integer deptid) {
		session.setAttribute("deptid",deptid);
		model.addAttribute("dept",ds.getDeptById(deptid));//表单绑定
		return "bumen_guanli_xiugai";
	}
	
	@RequestMapping("/bumenGuanliXiugai")
	public String update(Model model, HttpSession session, @RequestParam String DeptName, 
							@RequestParam String TelePhone, @RequestParam String Fax, 
							@RequestParam String ManageId) {
		int deptid=(int)session.getAttribute("deptid");
		ds.updateDeptById(deptid, DeptName, TelePhone, Fax, ManageId);
		lgs.insertLog("更新", (String) session.getAttribute("username"), new Date(System.currentTimeMillis()), "用户"+session.getAttribute("username")+"修改部门信息,该部门id为"+deptid);
		return "redirect:/4";
	}
	
	@RequestMapping("/bumenGuanliShanchu")
	public String delete(Model model, HttpSession session, Integer deptid) {
		lgs.insertLog("更新", (String) session.getAttribute("username"), new Date(System.currentTimeMillis()), "用户"+session.getAttribute("username")+"删除部门信息,删除部门id为"+deptid);
		ds.deleteDeptById(deptid);
		return "redirect:/4";
	}
	
	@RequestMapping("/tobumenGuanliZengjia")
	public String toadd(Model model, HttpSession session) {
		return "bumen_guanli_zengjia";
	}
	
	@RequestMapping("/bumenGuanliZengjia")
	public String add(Model model, HttpSession session, @ModelAttribute Dept dept) {
		ds.insertDept(dept);
		lgs.insertLog("更新", (String) session.getAttribute("username"), new Date(System.currentTimeMillis()), "用户"+session.getAttribute("username")+"增加部门信息,新增部门id为"+dept.getDeptId());
		return "redirect:/4";
	}
}
