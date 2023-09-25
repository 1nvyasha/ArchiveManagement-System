package com.example.DangAnManagement.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.DangAnManagement.dao.LogInfoDao;
import com.example.DangAnManagement.entity.LogInfo;
import com.example.DangAnManagement.service.LogInfoService;

@Service
public class LogInfoServiceImpl extends ServiceImpl<LogInfoDao,LogInfo> implements LogInfoService{
	@Autowired
	private LogInfoDao lgd;
	
	public List<LogInfo> getAllLog() {
		return lgd.getAllLog();
	}

	public void insertLog(String logType, String operateUser, Date operateDate, String logDescp) {
		lgd.insertLog(logType, operateUser, operateDate, logDescp);
	}

	public void deleteLog(Integer logId) {
		lgd.deleteLog(logId);
	}

	public List<LogInfo> searchLogByType(String logtype) {
		return lgd.searchLogByType(logtype);
	}

	@Override
	public List<LogInfo> searchLogByDate(Date date1, Date date2) {
		return lgd.searchLogByDate(date1, date2);
	}

}
