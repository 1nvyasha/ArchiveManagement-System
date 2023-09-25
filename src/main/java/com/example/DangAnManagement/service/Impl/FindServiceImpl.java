package com.example.DangAnManagement.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.DangAnManagement.dao.FindDao;
import com.example.DangAnManagement.entity.Find;
import com.example.DangAnManagement.service.FindService;

@Service
public class FindServiceImpl extends ServiceImpl<FindDao,Find> implements FindService {
	@Autowired
	private FindDao fd;
	
	public void insertFind(Find find) {
		fd.insertFind(find);
	}

}
