package com.example.DangAnManagement.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.DangAnManagement.dao.UserInfoDao;
import com.example.DangAnManagement.entity.UserInfo;
import com.example.DangAnManagement.service.UserInfoService;

import jakarta.servlet.http.HttpSession;
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao,UserInfo> implements UserInfoService {
	@Autowired
	private UserInfoDao ud;
	
	public List<UserInfo> getAllUserInfo() {
		return ud.getAllUserInfo();
	}

	public UserInfo getUserByName(String loginname) {
		return ud.getUserByName(loginname);
	}

	public void updateUserByName(UserInfo userinfo, String loginname) {
		ud.updateUserByName(userinfo, loginname);
	}

	public void deleteUserByName(String loginname) {
		ud.deleteUserByName(loginname);
	}

	public void insertUserInfo(UserInfo userinfo) {
		ud.insertUserInfo(userinfo);
	}
	
	public List<UserInfo> searchUserByName(String loginname) {
		//QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
		//wrapper.like("LoginName", loginname);
		//return ud.selectList(wrapper);// 实际执行 SQL : SELECT * FROM userinfo WHERE LoginName LIKE '%${loginname}%';
		return ud.searchUserByName(loginname);
	}
	
	public boolean loginCheck(String name, String pwd, HttpSession session) {
		if(ud.getUserByName(name)!=null&&pwd.equals(ud.getUserPwdByName(name))) {
			UserInfo user=ud.getUserByName(name);
			session.setAttribute("username", user.getLoginName());
			session.setAttribute("role",user.getRoleId());
			return true;
		}
		return false;
	}

}
