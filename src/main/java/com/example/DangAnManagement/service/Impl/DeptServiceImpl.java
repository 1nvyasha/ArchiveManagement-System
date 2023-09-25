package com.example.DangAnManagement.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.DangAnManagement.dao.DeptDao;
import com.example.DangAnManagement.entity.Dept;
import com.example.DangAnManagement.service.DeptService;
@Service
public class DeptServiceImpl extends ServiceImpl<DeptDao,Dept> implements DeptService {
	@Autowired
	private DeptDao dd;
	
	public Dept getDeptById(Integer deptid) {
		return dd.getDeptById(deptid);
	}

	public List<Dept> getAllDept() {
		return dd.getAllDept();
	}

	public void updateDeptById(Integer deptid, String deptname, String telephone, String fax, String manageid){
		dd.updateDeptById(deptid, deptname, telephone, fax, manageid);
	}

	public void deleteDeptById(Integer deptid) {
		dd.deleteDeptById(deptid);
	}

	public void insertDept(Dept Dept) {
		dd.insertDept(Dept);
	}
	
}
