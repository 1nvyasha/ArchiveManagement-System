package com.example.DangAnManagement.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.DangAnManagement.entity.UserInfo;

import jakarta.servlet.http.HttpSession;

public interface UserInfoService extends IService<UserInfo>{
	public List<UserInfo> getAllUserInfo();
	public UserInfo getUserByName(String loginname);
	public void updateUserByName(UserInfo userinfo, String loginname);
	public void deleteUserByName(String loginname);
	public void insertUserInfo(UserInfo userinfo);
	public List<UserInfo> searchUserByName(String loginname);
	
	public boolean loginCheck(String name,String pwd,HttpSession session);
}
