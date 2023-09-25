package com.example.DangAnManagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.DangAnManagement.entity.Dept;
@Mapper
public interface DeptDao  extends BaseMapper<Dept>{
	@Select("select * from dept where deptid='${deptid}'")
	public Dept getDeptById(Integer deptid);
	
	@Select("select * from dept")
	public List<Dept> getAllDept();
	
	@Update("update dept set deptname='${deptname}',telephone='${telephone}',fax='${fax}',manageid='${manageid}' where deptid=${deptid}")
	public void updateDeptById(Integer deptid, String deptname, String telephone, String fax, String manageid);
	
	@Delete("delete from dept where deptid=${deptid}")
	public void deleteDeptById(Integer deptid);
	
	@Insert("insert into dept(deptid,deptname,telephone,fax,manageid,remark)values(${DeptId},'${DeptName}','${TelePhone}','${Fax}','${ManageId}','${Remark}');")
	public void insertDept(Dept Dept);
}
