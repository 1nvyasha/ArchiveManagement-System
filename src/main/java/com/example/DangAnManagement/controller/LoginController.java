package com.example.DangAnManagement.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.DangAnManagement.service.LogInfoService;
import com.example.DangAnManagement.service.RoleService;
import com.example.DangAnManagement.service.UserInfoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	private UserInfoService us;
	
	@Autowired
	private RoleService rs;
	
	@Autowired
	private LogInfoService lgs;
	
	@RequestMapping("/")
	public String tologin(Model model,HttpSession session) {
		return "Login";
	}
	
	@RequestMapping("/index")
	public String index(Model model,HttpSession session) {
		if(session.getAttribute("username")==null) {
			return "Login";
		}
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(Model model,HttpSession session,@RequestParam String name, String pwd) {
		if(us.loginCheck(name, pwd, session)) {
			int i=(int)session.getAttribute("role");
			session.setAttribute("rolename", rs.getRoleById(i).getRoleName());
			lgs.insertLog("普通", name, new Date(System.currentTimeMillis()), "用户"+name+"登录");
			return "redirect:/index";
		}
		model.addAttribute("error", "用户名或密码不正确");
		return "Login";
	}
	
	@RequestMapping("/logout")
	public String logout(Model model,HttpSession session) {	
		String name=(String) session.getAttribute("username");
		session.removeAttribute("username");
		session.removeAttribute("role");
		lgs.insertLog("普通", name, new Date(System.currentTimeMillis()), "用户"+name+"登出");
		return "redirect:/";
	}
}
