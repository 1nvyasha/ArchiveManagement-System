package com.example.DangAnManagement.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.DangAnManagement.entity.Borrow;
import com.example.DangAnManagement.service.ArchiveService;
import com.example.DangAnManagement.service.BorrowService;
import com.example.DangAnManagement.service.LogInfoService;
import com.example.DangAnManagement.service.UserInfoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DanganJieyueGuihuanController {
	@Autowired
	private BorrowService bs;
	@Autowired
	private ArchiveService as;
	@Autowired
	private UserInfoService us;
	@Autowired
	private LogInfoService lgs;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	//↓↓↓档案借阅↓↓↓
	@RequestMapping("/todanganJieyueGuanli")
	public String show(Model model, HttpSession session) {
		model.addAttribute("archives",as.getArchiveByState("正常"));
		return "dangan_jieyue_guanli";
	}
	
	@RequestMapping("/todanganJieyueDengji")
	public String toadd(Model model, HttpSession session, Integer ObjectId) {
        model.addAttribute("currentDate",sdf.format(new Date(System.currentTimeMillis())));//获取当前时间
        session.setAttribute("ObjectId", ObjectId);
		return "dangan_jieyue_dengji";
	}
	
	@RequestMapping("/danganJieyueDengji")
	public String add(Model model, HttpSession session,  @ModelAttribute Borrow borrow, @RequestParam Date BorrowTime, @RequestParam Date EndTime) {
		int id=(int)session.getAttribute("ObjectId");
		String loginname=(String)session.getAttribute("username");
		borrow.setArchiveId(as.getArchiveByObjectId(id).getArchiveId());
		borrow.setLoginId(us.getUserByName(loginname).getLoginId());
		borrow.setBorrowTime(BorrowTime);
		borrow.setEndTime(EndTime);
		bs.insertBorrow(borrow);
		
		model.addAttribute("message", "档案借阅成功");
		as.updateArchiveState("正在借阅", id);//归还后改回"正常"
		
		lgs.insertLog("更新", (String) session.getAttribute("username"), new Date(System.currentTimeMillis()), "用户"+session.getAttribute("username")+"借阅档案,该档案id为"+as.getArchiveByObjectId(id).getArchiveId());
		return "index";
	}
	
	@RequestMapping("/danganJieyueSousuo1")
	public String searchByAST(Model model, HttpSession session, @RequestParam String archivetypeid, @RequestParam Integer saveid, @RequestParam String title) {
		model.addAttribute("archives",as.searchArchiveWithState(archivetypeid, saveid, title, "正常"));
		return "dangan_jieyue_guanli";
	}
	
	@RequestMapping("/danganJieyueSousuo2")
	public String searchByArchiveId(Model model, HttpSession session, @RequestParam String archiveid) {
		model.addAttribute("archives",as.searchArchiveByArchiveId(archiveid, "正常"));
		return "dangan_jieyue_guanli";
	}
	
	//↑↑↑档案借阅↑↑↑
	
	//↓↓↓档案归还↓↓↓
	@RequestMapping("/todanganGuihuanGuanli")
	public String show1(Model model, HttpSession session) {
		model.addAttribute("archives",as.getArchiveByState("正在借阅"));
		return "dangan_guihuan_guanli";
	}
	
	@RequestMapping("/danganGuihuan")
	public String add1(Model model, HttpSession session, String ArchiveId) {	
		model.addAttribute("message", "档案归还成功");
		as.updateArchiveState("正常", as.getArchiveByArchiveId(ArchiveId).getObjectId());//归还后改回"正常"
		bs.updateBorrow(sdf.format(new Date(System.currentTimeMillis())), us.getUserByName((String)session.getAttribute("username")).getLoginId(), ArchiveId);
		
		lgs.insertLog("更新", (String) session.getAttribute("username"), new Date(System.currentTimeMillis()), "用户"+session.getAttribute("username")+"归还档案,该档案id为"+ArchiveId);
		return "index";
	}
	
	@RequestMapping("/danganGuihuanSousuo")
	public String search(Model model, HttpSession session, @RequestParam String archiveid) {
		model.addAttribute("archives",as.searchArchiveByArchiveId(archiveid, "正在借阅"));
		return "dangan_guihuan_guanli";
	}
	//↑↑↑档案归还↑↑↑
	
	//↓↓↓档案归还查询↓↓↓
	@RequestMapping("/todanganGuihuanChaxun")
	public String show2(Model model, HttpSession session) {
		model.addAttribute("currentDate",sdf.format(new Date(System.currentTimeMillis())));//获取当前时间
		model.addAttribute("archives", as.searchReturn());
		return "dangan_guihuan_chaxun";
	}
	
	@RequestMapping("/danganGuihuanChaxunSousuo")
	public String searchByDate(Model model, HttpSession session, @RequestParam Date date1, @RequestParam Date date2) {
		model.addAttribute("currentDate",sdf.format(new Date(System.currentTimeMillis())));//获取当前时间
		model.addAttribute("archives", as.searchReturnByEndtime(date1, date2));
		return "dangan_guihuan_chaxun";
	}
	//↑↑↑档案归还查询↑↑↑
}
