package com.example.DangAnManagement.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.DangAnManagement.dao.LoseDao;
import com.example.DangAnManagement.entity.Lose;
import com.example.DangAnManagement.service.LoseService;

@Service
public class LoseServiceImpl extends ServiceImpl<LoseDao,Lose> implements LoseService {
	@Autowired
	private LoseDao ld;
	
	public void insertLose(Lose lose) {
		ld.insertLose(lose);
	}

}
