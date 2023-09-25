package com.example.DangAnManagement.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.DangAnManagement.entity.Find;

@Mapper
public interface FindDao extends BaseMapper<Find>{
	@Insert("insert into find(ArchiveId,LoginId,Finder,FindTime,Remark)values('${ArchiveId}','${LoginId}','${Finder}','${FindTime}','${Remark}');")
	public void insertFind(Find find);
}
