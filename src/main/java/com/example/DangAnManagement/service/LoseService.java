package com.example.DangAnManagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.DangAnManagement.entity.Lose;

public interface LoseService extends IService<Lose>{
	public void insertLose(Lose lose);
}
