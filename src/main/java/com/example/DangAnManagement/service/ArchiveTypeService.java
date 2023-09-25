package com.example.DangAnManagement.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.DangAnManagement.entity.ArchiveType;

public interface ArchiveTypeService extends IService<ArchiveType>{
	public ArchiveType getArchiveTypeById(String archivetypeid);
	public List<ArchiveType> getAllArchiveType();
	public void updateArchiveTypeById(ArchiveType archivetype, String archivetypeid);
	public void deleteArchiveTypeById(String archivetypeid);
	public void insertArchiveType(ArchiveType archivetype);
}
