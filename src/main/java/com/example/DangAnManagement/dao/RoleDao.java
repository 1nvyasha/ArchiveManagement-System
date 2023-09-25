package com.example.DangAnManagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.DangAnManagement.entity.Role;
@Mapper
public interface RoleDao extends BaseMapper<Role>{
	@Select("select * from role where roleid='${roleid}'")
	public Role getRoleById(Integer roleid);
	
	@Select("select * from role")
	public List<Role> getAllRole();
	
	@Update("update role set rolename='${rolename}' where roleid=${roleid}")
	public void updateRoleById(Integer roleid, String rolename);
	
	@Delete("delete from role where roleid=${roleid}")
	public void deleteRoleById(Integer roleid);
	
	@Insert("insert into role(roleid,rolename,power)values(${RoleId},'${RoleName}','${Power}');")
	public void insertRole(Role role);
}
