package com.example.DangAnManagement.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.DangAnManagement.entity.Save;
import com.example.DangAnManagement.service.LogInfoService;
import com.example.DangAnManagement.service.SaveService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CundangdianGuanliController {
	@Autowired
	private SaveService ss;
	@Autowired
	private LogInfoService lgs;
	
	@RequestMapping("/tocundangdianGuanli")
	public String show(Model model, HttpSession session) {
		model.addAttribute("saves",ss.getAllSave());
		return "cundangdian_guanli";
	}
	
	@RequestMapping("/tocundangdianGuanliXiugai")
	public String toupdate(Model model, HttpSession session, Integer saveid) {//改
		session.setAttribute("saveid",saveid);
		model.addAttribute("save",ss.getSaveById(saveid));//表单绑定
		return "cundangdian_guanli_xiugai";
	}
	
	@RequestMapping("/cundangdianGuanliXiugai")
	public String update(Model model, HttpSession session, @ModelAttribute Save save) {
        Integer saveid=(Integer)session.getAttribute("saveid");
        ss.updateSaveById(save, saveid);
        lgs.insertLog("更新", (String) session.getAttribute("username"), new Date(System.currentTimeMillis()), "用户"+session.getAttribute("username")+"修改存档点信息,该存档点id为"+saveid);
        return "redirect:/7";
	}
	
	@RequestMapping("/cundangdianGuanliShanchu")
	public String delete(Model model, HttpSession session, Integer saveid) {//删
		lgs.insertLog("更新", (String) session.getAttribute("username"), new Date(System.currentTimeMillis()), "用户"+session.getAttribute("username")+"删除存档点信息,删除存档点id为"+saveid);
		ss.deleteSaveById(saveid);
		return "redirect:/7";
	}
	
	@RequestMapping("/tocundangdianGuanliZengjia")
	public String toadd(Model model, HttpSession session) {//增
		return "cundangdian_guanli_zengjia";
	}
	
	@RequestMapping("/cundangdianGuanliZengjia")
	public String add(Model model, HttpSession session,@ModelAttribute Save save) {
		ss.insertSave(save);
        lgs.insertLog("更新", (String) session.getAttribute("username"), new Date(System.currentTimeMillis()), "用户"+session.getAttribute("username")+"增加存档点信息,增加存档点id为"+save.getSaveId());
		return "redirect:/7";
	}
	
	@RequestMapping("/cundangdianGuanliSousuo")
	public String search(Model model, HttpSession session, @RequestParam String name) {//查
		model.addAttribute("saves",ss.searchSaveByName(name));
		System.out.println(ss.searchSaveByName(name));
		return "cundangdian_guanli";
	}
}
