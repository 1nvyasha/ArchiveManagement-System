package com.example.DangAnManagement.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.DangAnManagement.entity.DataFileBack;

public interface DataFileBackService extends IService<DataFileBack>{
	public List<DataFileBack> getAllDataFile();

	public void insertDataFile(String fileName, Date backDate);	
	
	public void backupDatabase(String s) throws IOException;//数据库文件备份
	
}
