package com.example.DangAnManagement.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.DangAnManagement.entity.Archive;
import com.example.DangAnManagement.service.ArchiveService;
import com.example.DangAnManagement.service.LogInfoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ArchiveManagementController {
	@Autowired
	private ArchiveService as;
	@Autowired
	private LogInfoService lgs;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	//↓↓↓档案管理↓↓↓
	@RequestMapping("/todanganGuanli")
	public String show(Model model, HttpSession session) {
		model.addAttribute("archives",as.getAllArchive());
		return "archive_management";
	}
	
	@RequestMapping("/todanganGuanliChakan")
	public String chakan(Model model, HttpSession session, Integer ObjectId) {
		model.addAttribute("archive",as.getArchiveByObjectId(ObjectId));
		return "archive_chakan";
	}
	
	@RequestMapping("/todanganGuanliXiugai")
	public String toupdate(Model model, HttpSession session, Integer ObjectId) {
		model.addAttribute("archive",as.getArchiveByObjectId(ObjectId));
        model.addAttribute("currentDate",sdf.format(new Date(System.currentTimeMillis())));//获取当前时间
		return "archive_xiugai";
	}
	
	@RequestMapping("/danganGuanliXiugai")//改
	public String update(Model model, HttpSession session, Integer ObjectId, @ModelAttribute Archive archive, @RequestParam Date CreateTime, @RequestParam Date LastModiTime, @RequestParam Date EndTime, @RequestParam Date ImpactTime, @RequestParam Date UseTime) {
		archive.setCreateTime(CreateTime);//将中国标准时间转化为标准日期，CreateTime中获取到的是标准日期 archive中的CreateTime属性获取到的是中国标准时间
		archive.setLastModiTime(LastModiTime);
		archive.setEndTime(EndTime);
		archive.setImpactTime(ImpactTime);
		archive.setUseTime(UseTime);
		as.updateArchiveByObjectId(archive, ObjectId);
        lgs.insertLog("更新", (String) session.getAttribute("username"), new Date(System.currentTimeMillis()), "用户"+session.getAttribute("username")+"修改档案信息,该档案id为"+as.getArchiveByObjectId(ObjectId).getArchiveId());
        return "redirect:/9";
	}
	
	@RequestMapping("/todanganGuanliZengjia")
	public String toadd(Model model, HttpSession session, Integer ObjectId) {
        model.addAttribute("currentDate",sdf.format(new Date(System.currentTimeMillis())));//获取当前时间
		return "archive_zengjia";
	}
	
	@RequestMapping("/danganGuanliZengjia")//增
	public String add(Model model, HttpSession session, @ModelAttribute Archive archive, @RequestParam Date CreateTime, @RequestParam Date LastModiTime, @RequestParam Date EndTime, @RequestParam Date ImpactTime, @RequestParam Date UseTime) {
		archive.setCreateTime(CreateTime);//将中国标准时间转化为标准日期，CreateTime中获取到的是标准日期 archive中的CreateTime属性获取到的是中国标准时间
		archive.setLastModiTime(LastModiTime);
		archive.setEndTime(EndTime);
		archive.setImpactTime(ImpactTime);
		archive.setUseTime(UseTime);
		as.insertArchive(archive);
        lgs.insertLog("更新", (String) session.getAttribute("username"), new Date(System.currentTimeMillis()), "用户"+session.getAttribute("username")+"增加档案信息,增加档案id为"+archive.getArchiveId());
		return "redirect:/9";
	}
	
	@RequestMapping("/danganGuanliShanchu")//删
	public String delete(Model model, HttpSession session, Integer ObjectId) {
		lgs.insertLog("更新", (String) session.getAttribute("username"), new Date(System.currentTimeMillis()), "用户"+session.getAttribute("username")+"删除档案信息,删除档案id为"+as.getArchiveByObjectId(ObjectId).getArchiveId());
		as.deleteArchiveByObjectId(ObjectId);
		return "redirect:/9";
	}
	
	@RequestMapping("/danganGuanliSousuo")//查
	public String search(Model model, HttpSession session, @RequestParam String archivetype, @RequestParam Integer save, @RequestParam String title) {
		model.addAttribute("archives",as.searchArchive(archivetype, save, title));
		return "archive_management";
	}
	//↑↑↑档案管理↑↑↑
	
	//↓↓↓档案到期查询↓↓↓
	@RequestMapping("/todanganDaoqiChaxun")
	public String show1(Model model, HttpSession session) {
		model.addAttribute("archives",null);
		return "dangan_daoqi_chaxun";
	}
	
	@RequestMapping("/danganDaoqiChaxunSousuo")
	public String search1(Model model, HttpSession session, @RequestParam Integer i) {
		model.addAttribute("archives",as.searchArchiveByEndTime(i));
		return "dangan_daoqi_chaxun";
	}
	//↑↑↑档案到期查询↑↑↑
}
