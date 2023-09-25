package com.example.DangAnManagement.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.DangAnManagement.entity.Destory;

@Mapper
public interface DestoryDao extends BaseMapper<Destory>{
	@Insert("insert into destory(ArchiveId,LoginId,DestoryTime,Reason,Remark)values('${ArchiveId}','${LoginId}','${DestoryTime}','${Reason}','${Remark}');")
	public void insertDestory(Destory destory);
}
