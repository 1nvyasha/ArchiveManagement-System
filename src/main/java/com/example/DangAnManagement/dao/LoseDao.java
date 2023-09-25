package com.example.DangAnManagement.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.DangAnManagement.entity.Lose;

@Mapper
public interface LoseDao extends BaseMapper<Lose>{
	@Insert("insert into lose(ArchiveId,LoginId,Type,Loser,LoseTime,Remark)values('${ArchiveId}','${LoginId}','${Type}','${Loser}','${LoseTime}','${Remark}');")
	public void insertLose(Lose lose);
}
