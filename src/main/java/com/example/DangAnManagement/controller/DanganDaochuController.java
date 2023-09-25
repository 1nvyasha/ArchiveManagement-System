package com.example.DangAnManagement.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.DangAnManagement.service.ArchiveExportService;
import com.example.DangAnManagement.service.ArchiveService;
import com.example.DangAnManagement.service.LogInfoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DanganDaochuController {
	@Autowired
	private ArchiveService as;
	@Autowired
	private ArchiveExportService aes;
	@Autowired
	private LogInfoService lgs;
	
	@RequestMapping("/todanganDaochu")
	public String show(Model model, HttpSession session) {
		model.addAttribute("archives",null);
		return "dangan_daochu";
	}
	
	@RequestMapping("/danganDaochuSousuo")
	public String searchByAST(Model model, HttpSession session, @RequestParam String archivetypeid, @RequestParam Integer saveid, @RequestParam String title) {
		model.addAttribute("archives",as.searchArchiveWithState(archivetypeid, saveid, title, "正常"));
		return "dangan_daochu";
	}
	
	@ResponseBody
    @RequestMapping("/export2txt")
    public ResponseEntity<byte[]> exportLand2ndClassIndex(Model model, HttpSession session,Integer ObjectId){
    	lgs.insertLog("普通", (String) session.getAttribute("username"), new Date(System.currentTimeMillis()), "用户"+session.getAttribute("username")+"导出txt档案,导出档案id为"+as.getArchiveByObjectId(ObjectId).getArchiveId());
    	return aes.exportLand2ndClassIndex(ObjectId);
    }
}
