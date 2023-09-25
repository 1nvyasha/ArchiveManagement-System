package com.example.DangAnManagement.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.DangAnManagement.dao.DestoryDao;
import com.example.DangAnManagement.entity.Destory;
import com.example.DangAnManagement.service.DestoryService;

@Service
public class DestoryServiceImpl extends ServiceImpl<DestoryDao,Destory> implements DestoryService {
	@Autowired
	private DestoryDao dd;

	public void insertDestory(Destory destory) {
		dd.insertDestory(destory);
	}

}
