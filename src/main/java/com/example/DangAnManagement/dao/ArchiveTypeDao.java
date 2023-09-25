package com.example.DangAnManagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.DangAnManagement.entity.ArchiveType;
@Mapper
public interface ArchiveTypeDao extends BaseMapper<ArchiveType>{
	@Select("select * from archivetype where archivetypeid='${archivetypeid}'")
	public ArchiveType getArchiveTypeById(String archivetypeid);

	@Select("select * from archivetype")
	public List<ArchiveType> getAllArchiveType();
	
	@Update("update archivetype set ArchiveTypeId='${archivetype.ArchiveTypeId}',ArchiveTypeName='${archivetype.ArchiveTypeName}' where archivetypeid='${archivetypeid}'")
	public void updateArchiveTypeById(ArchiveType archivetype, String archivetypeid);
	
	@Delete("delete from archivetype where archivetypeid='${archivetypeid}'")
	public void deleteArchiveTypeById(String archivetypeid);
	
	@Insert("insert into archivetype (ArchiveTypeId,ArchiveTypeName)values('${ArchiveTypeId}','${ArchiveTypeName}');")
	public void insertArchiveType(ArchiveType archivetype);
}
