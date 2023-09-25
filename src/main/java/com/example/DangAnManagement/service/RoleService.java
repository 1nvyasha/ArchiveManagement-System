package com.example.DangAnManagement.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.DangAnManagement.entity.Role;

public interface RoleService extends IService<Role>{
	public Role getRoleById(Integer roleid);
	public List<Role> getAllRole();
	public void updateRoleById(Integer roleid, String rolename);
	public void deleteRoleById(Integer roleid);
	public void insertRole(Role role);
}
