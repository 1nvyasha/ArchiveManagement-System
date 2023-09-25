package com.example.DangAnManagement.service;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.DangAnManagement.entity.LogInfo;

public interface LogInfoService  extends IService<LogInfo>{
	public List<LogInfo> getAllLog();
	public void insertLog(String logType, String operateUser, Date operateDate, String logDescp);
	public void deleteLog(Integer logId);
	public List<LogInfo> searchLogByType(String logtype);
	public List<LogInfo> searchLogByDate(Date date1, Date date2);
}
