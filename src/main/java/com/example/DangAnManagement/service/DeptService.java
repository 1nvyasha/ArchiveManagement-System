package com.example.DangAnManagement.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.DangAnManagement.entity.Dept;

public interface DeptService extends IService<Dept>{
	public Dept getDeptById(Integer deptid);
	public List<Dept> getAllDept();
	public void updateDeptById(Integer deptid, String deptname, String telephone, String fax, String manageid);
	public void deleteDeptById(Integer deptid);
	public void insertDept(Dept Dept);
}
