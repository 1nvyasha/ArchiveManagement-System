package com.example.DangAnManagement.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.DangAnManagement.entity.LogInfo;

@Mapper
public interface LogInfoDao extends BaseMapper<LogInfo>{
	@Select("select * from loginfo order by logid desc")
	public List<LogInfo> getAllLog();
	
	//@Insert("insert into loginfo(LogType,OperateUser,OperateDate,LogDescp)values('${logType}','${operateUser}','${operateDate}','${logDescp}');")
	@Insert("select * from loginfo")
	public void insertLog(String logType, String operateUser, Date operateDate, String logDescp);
	
	@Delete("delete from loginfo where logid=${logId}")
	public void deleteLog(Integer logId);
	
	@Select("select * from loginfo where logtype like '${logtype}' order by logid desc")
	public List<LogInfo> searchLogByType(String logtype);
	
	@Select("select * from loginfo where operatedate>='${date1}' and operatedate<='${date2}' order by logid desc")
	public List<LogInfo> searchLogByDate(Date date1, Date date2);
}
