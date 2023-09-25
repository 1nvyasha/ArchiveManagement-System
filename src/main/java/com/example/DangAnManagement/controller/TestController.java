package com.example.DangAnManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.DangAnManagement.entity.UserInfo;
import com.example.DangAnManagement.service.ArchiveService;
import com.example.DangAnManagement.service.RoleService;
import com.example.DangAnManagement.service.UserInfoService;
@Controller
public class TestController {
	@Autowired
	private ArchiveService as;
	@Autowired
	private UserInfoService us;
	//@Autowired
	//private DeptService ds;
	@Autowired
	private RoleService rs;
	
	@RequestMapping("/test")
	public String test(Model model) {
		//Archive archive=as.getAllArchive().get(0);
		UserInfo user=us.getAllUserInfo().get(0);
		model.addAttribute("aaa", as.getAllArchive());
		model.addAttribute("bbb", us.getAllUserInfo());
		
		//System.out.println(ds.getDeptById(user.getDeptId()));
		
		rs.getAllRole();
		System.out.println(rs.getRoleById(user.getRoleId()).getRoleName());
		return "TestFile";
	}
}
