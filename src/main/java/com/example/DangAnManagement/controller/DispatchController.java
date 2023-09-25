package com.example.DangAnManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class DispatchController {
	
	@RequestMapping("/{i}")
	public String dispatch(Model model, @PathVariable int i, HttpSession session) {
		if(session.getAttribute("username")==null) {
			return "Login";
		}
		int role=(int)session.getAttribute("role");
		if(role==0) {//系统管理员
			switch(i) {
			case 0:return "index";//?
			case 1:return "forward:/toxitongPeizhi";
			case 2:return "shuju_zidian";//?
			case 3:return "forward:/tojueseGuanli";
			case 4:return "forward:/tobumenGuanli";
			case 5:return "forward:/toyuangongGuanli";
			case 6:return "forward:/tologManagement";
			
			case 7:return "forward:/tocundangdianGuanli";
			case 8:return "forward:/todanganFenleiGuanli";
			case 9:return "forward:/todanganGuanli";
			case 10:return "forward:/todanganJieyueGuanli";
			case 11:return "forward:/todanganGuihuanGuanli";
			case 12:return "forward:/todanganGuihuanChaxun"; 
			case 13:return "forward:/todanganDaochu";//txt√ pdf doc excel 
			case 14:return "saomiaojian_shangchuan";//?
			case 15:return "forward:/todanganDaoqiChaxun";
			
			case 16:return "forward:/todanganXiaohuiManagement";		
			case 17:return "forward:/todanganXiaohuiChaxun";
			case 18:return "forward:/tosunhuaiDiushiManagement";
			case 19:return "forward:/tosunhuaiDiushiChaxun";
			case 20:return "forward:/todiushiZhaohuiManagement";
			
			case 21:return "forward:/toshujuBeifen";
			case 22:return "forward:/toshujuHuifu";//? role=2
			
			default:return "index";
			}
		}
		else if(role==1) {//档案管理员
			switch(i) {
			case 7:return "forward:/tocundangdianGuanli";
			case 8:return "forward:/todanganFenleiGuanli";
			case 9:return "forward:/todanganGuanli";
			case 10:return "forward:/todanganJieyueGuanli";
			case 11:return "forward:/todanganGuihuanGuanli";
			case 12:return "forward:/todanganGuihuanChaxun"; 
			case 13:return "forward:/todanganDaochu"; 
			case 14:return "saomiaojian_shangchuan";
			case 15:return "forward:/todanganDaoqiChaxun";
			
			case 16:return "forward:/todanganXiaohuiManagement";		
			case 17:return "forward:/todanganXiaohuiChaxun";
			case 18:return "forward:/tosunhuaiDiushiManagement";
			case 19:return "forward:/tosunhuaiDiushiChaxun";
			case 20:return "forward:/todiushiZhaohuiManagement";
			}
		}
		else if(role==2) {//数据维护员
			switch(i) {
			case 15:return "forward:/todanganDaoqiChaxun";
			case 17:return "forward:/todanganXiaohuiChaxun";
			case 19:return "forward:/tosunhuaiDiushiChaxun";
			case 21:return "forward:/toshujuBeifen";
			}
		}
		else if(role==3) {//员工
			switch(i) {
			case 10:return "forward:/todanganJieyueGuanli";
			case 12:return "forward:/todanganGuihuanChaxun";
			case 18:return "forward:/tosunhuaiDiushiManagement";
			case 19:return "forward:/tosunhuaiDiushiChaxun";
			}
		}
		model.addAttribute("needrole","您的权限不够");
		return "index";
	}
}
