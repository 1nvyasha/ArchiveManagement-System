package com.example.DangAnManagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.DangAnManagement.entity.Find;

public interface FindService extends IService<Find>{
	public void insertFind(Find find);
}
