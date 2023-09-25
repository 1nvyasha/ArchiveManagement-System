package com.example.DangAnManagement.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.DangAnManagement.dao.RoleDao;
import com.example.DangAnManagement.entity.Role;
import com.example.DangAnManagement.service.RoleService;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao,Role> implements RoleService {
	@Autowired
	private RoleDao rd;
	
	public Role getRoleById(Integer roleid) {
		return rd.getRoleById(roleid);
	}

	public List<Role> getAllRole() {
		//List<Role> roles=rd.getAllRole();
		return rd.getAllRole();
	}

	public void updateRoleById(Integer roleid,String rolename) {
		rd.updateRoleById(roleid, rolename);
	}

	public void deleteRoleById(Integer roleid) {
		rd.deleteRoleById(roleid);
	}

	public void insertRole(Role role) {
		rd.insertRole(role);
	}

}
