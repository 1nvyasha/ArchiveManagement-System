package com.example.DangAnManagement.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.DangAnManagement.entity.DataFileBack;

@Mapper
public interface DataFileBackDao extends BaseMapper<DataFileBack>{
	@Select("select * from datafileback")
	public List<DataFileBack> getAllDataFile();
	
	@Insert("insert into dataFileBack(FileName,BackDate)values('${fileName}','${backDate}');")
	public void insertDataFile(String fileName, Date backDate);
}
