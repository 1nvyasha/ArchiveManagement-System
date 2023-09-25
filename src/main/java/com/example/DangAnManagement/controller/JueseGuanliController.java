package com.example.DangAnManagement.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.DangAnManagement.entity.Role;
import com.example.DangAnManagement.service.LogInfoService;
import com.example.DangAnManagement.service.RoleService;

import jakarta.servlet.http.HttpSession;

@Controller
public class JueseGuanliController {
	@Autowired
	private RoleService rs;
	@Autowired
	private LogInfoService lgs;
	
	@RequestMapping("/tojueseGuanli")
	public String show(Model model, HttpSession session) {
		model.addAttribute("roles",rs.getAllRole());
		return "juese_guanli";
	}
	
	@RequestMapping("/tojueseGuanliXiugai")
	public String toupdate(Model model, HttpSession session, Integer roleid) {
		session.setAttribute("roleid",roleid);
		return "juese_guanli_xiugai";
	}
	
	@RequestMapping("/jueseGuanliXiugai")
	public String update(Model model, HttpSession session, @RequestParam(defaultValue = "") String name) {
		//String temp=name.replace(" ", "");
		//if(!temp.equals("")) {//非空判断
			int roleid=(int)session.getAttribute("roleid");
			//System.out.println(name);
			rs.updateRoleById(roleid, name);
		//}
	    lgs.insertLog("更新", (String) session.getAttribute("username"), new Date(System.currentTimeMillis()), "用户"+session.getAttribute("username")+"修改角色信息,该角色id为"+roleid);
		return "redirect:/3";
	}
	
	@RequestMapping("/tojueseGuanliZengjia")
	public String toadd(Model model, HttpSession session) {
		return "juese_guanli_zengjia";
	}
	
	@RequestMapping("/jueseGuanliZengjia")
	public String add(Model model, HttpSession session, @ModelAttribute Role role) {
		rs.insertRole(role);
		lgs.insertLog("更新", (String) session.getAttribute("username"), new Date(System.currentTimeMillis()), "用户"+session.getAttribute("username")+"增加角色信息,增加角色id为"+role.getRoleId());
		return "redirect:/3";
	}
	
	
	@RequestMapping("/jueseGuanliShanchu")
	public String delete(Model model, HttpSession session, Integer roleid) {
		lgs.insertLog("更新", (String) session.getAttribute("username"), new Date(System.currentTimeMillis()), "用户"+session.getAttribute("username")+"删除角色信息,删除角色id为"+roleid);
		rs.deleteRoleById(roleid);
		return "redirect:/3";
	}
}
