package com.example.DangAnManagement.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.DangAnManagement.entity.UserInfo;
import com.example.DangAnManagement.service.LogInfoService;
import com.example.DangAnManagement.service.UserInfoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class YuangongGuanliController {
	@Autowired
	private UserInfoService us;
	@Autowired
	private LogInfoService lgs;
	
	@RequestMapping("/toyuangongGuanli")
	public String show(Model model, HttpSession session) {
		model.addAttribute("users",us.getAllUserInfo());
		return "yuangong_guanli";
	}
	
	@RequestMapping("/toyuangongGuanliXiugai")
	public String toupdate(Model model, HttpSession session, String loginname) {//改
		session.setAttribute("loginname",loginname);
		model.addAttribute("userinfo",us.getUserByName(loginname));//表单绑定
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        model.addAttribute("currentDate",simpleDateFormat.format(new Date(System.currentTimeMillis())));//获取当前时间
		return "yuangong_guanli_xiugai";
	}
	
	@RequestMapping("/yuangongGuanliXiugai")
	public String update(Model model, HttpSession session, @ModelAttribute UserInfo userinfo, @RequestParam Date JoinDate) {//util.date出现400错误
        String loginname=(String)session.getAttribute("loginname");
        userinfo.setJoinDate(JoinDate);//将中国标准时间转化为标准日期，JoinDate中获取到的是标准日期 userinfo中的JoinDate属性获取到的是中国标准时间
        us.updateUserByName(userinfo, loginname);
        lgs.insertLog("更新", (String) session.getAttribute("username"), new Date(System.currentTimeMillis()), "用户"+session.getAttribute("username")+"修改员工信息,该员工用户名名为"+userinfo.getLoginName());
        return "redirect:/5";
	}
	
	@RequestMapping("/yuangongGuanliShanchu")
	public String delete(Model model, HttpSession session, String loginname) {//删
		lgs.insertLog("更新", (String) session.getAttribute("username"), new Date(System.currentTimeMillis()), "用户"+session.getAttribute("username")+"删除员工信息,删除员工用户名为"+loginname);
		us.deleteUserByName(loginname);
		return "redirect:/5";
	}
	
	@RequestMapping("/toyuangongGuanliZengjia")
	public String toadd(Model model, HttpSession session) {//增
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        model.addAttribute("currentDate",simpleDateFormat.format(new Date(System.currentTimeMillis())));//获取当前时间
		return "yuangong_guanli_zengjia";
	}
	
	@RequestMapping("/yuangongGuanliZengjia")
	public String add(Model model, HttpSession session, @ModelAttribute UserInfo userinfo, @RequestParam Date JoinDate) {//util.date出现400错误
		userinfo.setJoinDate(JoinDate);//将中国标准时间转化为标准日期，JoinDate中获取到的是标准日期 userinfo中的JoinDate属性获取到的是中国标准时间
		//
		//
		//if(us.getUserByName(LoginName)!=null) {
		//	model.addAttribute("errorname","用户名已存在");
		//	return "yuangong_guanli_zengjia";
		//}
		//if(!LoginPwd2.equals(LoginPwd)) {
		//	model.addAttribute("errorpwd","密码不一致");
		//	return "yuangong_guanli_zengjia";
		//}
		//
		//
        us.insertUserInfo(userinfo);
        lgs.insertLog("更新", (String) session.getAttribute("username"), new Date(System.currentTimeMillis()), "用户"+session.getAttribute("username")+"增加员工信息,增加员工用户名为"+userinfo.getLoginName());
		return "redirect:/5";
	}
	
	@RequestMapping("/yuangongGuanliSousuo")
	public String search(Model model, HttpSession session, @RequestParam String name) {//查
		model.addAttribute("users",us.searchUserByName(name));
		return "yuangong_guanli";
	}
}
