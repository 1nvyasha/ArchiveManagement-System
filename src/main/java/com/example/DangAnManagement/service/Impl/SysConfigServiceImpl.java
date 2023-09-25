package com.example.DangAnManagement.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.DangAnManagement.dao.SysConfigDao;
import com.example.DangAnManagement.entity.SysConfig;
import com.example.DangAnManagement.service.SysConfigService;

@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigDao,SysConfig> implements SysConfigService{
	@Autowired
	private SysConfigDao scd;
	
	public SysConfig getSysConfig() {
		return scd.getSysConfig();
	}

	public void updateSysConfig(SysConfig sysconfig) {
		scd.updateSysConfig(sysconfig);
	}

}
