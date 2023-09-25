package com.example.DangAnManagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.DangAnManagement.entity.SysConfig;


public interface SysConfigService extends IService<SysConfig>{
	public SysConfig getSysConfig();
	public void updateSysConfig(SysConfig sysconfig);
}
