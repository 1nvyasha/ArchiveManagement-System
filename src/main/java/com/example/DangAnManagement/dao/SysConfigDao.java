package com.example.DangAnManagement.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.DangAnManagement.entity.SysConfig;

@Mapper
public interface SysConfigDao extends BaseMapper<SysConfig>{
	@Select("select * from sysconfig limit 0,1")
	public SysConfig getSysConfig();
	
	@Update("update sysconfig set SysName='${SysName}',ComName='${ComName}',ComTel='${ComTel}',ComFax='${ComFax}',ComAddress='${ComAddress}',ComURL='${ComURL}',BrowserType='${BrowserType}',BrowserVersion='${BrowserVersion}',ClientIP='${ClientIP}',ClientOS='${ClientOS}'")
	public void updateSysConfig(SysConfig sysconfig);
}
