package com.example.DangAnManagement.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.DangAnManagement.entity.ArchiveType;
import com.example.DangAnManagement.service.ArchiveTypeService;
import com.example.DangAnManagement.service.LogInfoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DanganFenleiGuanliController {
	@Autowired
	private ArchiveTypeService ats;
	@Autowired
	private LogInfoService lgs;
	
	@RequestMapping("/todanganFenleiGuanli")
	public String show(Model model, HttpSession session) {
		model.addAttribute("archivetypes",ats.getAllArchiveType());
		return "dangan_fenlei_guanli";
	}
	
	@RequestMapping("/todanganFenleiGuanliXiugai")
	public String toupdate(Model model, HttpSession session, String archivetypeid) {//改
		session.setAttribute("archivetypeid",archivetypeid);
		model.addAttribute("archivetype",ats.getArchiveTypeById(archivetypeid));//表单绑定
		return "dangan_fenlei_guanli_xiugai";
	}
	
	@RequestMapping("/danganFenleiGuanliXiugai")
	public String update(Model model, HttpSession session, @ModelAttribute ArchiveType archivetype) {
        String archivetypeid=(String)session.getAttribute("archivetypeid");
        ats.updateArchiveTypeById(archivetype, archivetypeid);
        lgs.insertLog("更新", (String) session.getAttribute("username"), new Date(System.currentTimeMillis()), "用户"+session.getAttribute("username")+"修改档案分类信息,该档案类型id为"+archivetypeid);
        return "redirect:/8";
	}
	
	@RequestMapping("/danganFenleiGuanliShanchu")
	public String delete(Model model, HttpSession session, String archivetypeid) {//删
		lgs.insertLog("更新", (String) session.getAttribute("username"), new Date(System.currentTimeMillis()), "用户"+session.getAttribute("username")+"删除档案分类信息,删除档案类型id为"+archivetypeid);
		ats.deleteArchiveTypeById(archivetypeid);
		return "redirect:/8";
	}
	
	@RequestMapping("/todanganFenleiGuanliZengjia")
	public String toadd(Model model, HttpSession session) {//增
		return "dangan_fenlei_guanli_zengjia";
	}
	
	@RequestMapping("/danganFenleiGuanliZengjia")
	public String add(Model model, HttpSession session, @ModelAttribute ArchiveType archivetype) {
		ats.insertArchiveType(archivetype);
        lgs.insertLog("更新", (String) session.getAttribute("username"), new Date(System.currentTimeMillis()), "用户"+session.getAttribute("username")+"增加档案分类信息,删除档案类型id为"+archivetype.getArchiveTypeId());
		return "redirect:/8";
	}
}
