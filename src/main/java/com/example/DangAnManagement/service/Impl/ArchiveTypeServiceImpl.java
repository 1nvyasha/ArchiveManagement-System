package com.example.DangAnManagement.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.DangAnManagement.dao.ArchiveTypeDao;
import com.example.DangAnManagement.entity.ArchiveType;
import com.example.DangAnManagement.service.ArchiveTypeService;
@Service
public class ArchiveTypeServiceImpl extends ServiceImpl<ArchiveTypeDao,ArchiveType> implements ArchiveTypeService {
	@Autowired
	private ArchiveTypeDao atd;
	
	public ArchiveType getArchiveTypeById(String archivetypeid) {
		return atd.getArchiveTypeById(archivetypeid);
	}

	public List<ArchiveType> getAllArchiveType() {
		return atd.getAllArchiveType();
	}
	
	public void updateArchiveTypeById(ArchiveType archivetype, String archivetypeid) {
		atd.updateArchiveTypeById(archivetype, archivetypeid);		
	}
	
	public void deleteArchiveTypeById(String archivetypeid) {
		atd.deleteArchiveTypeById(archivetypeid);
	}

	public void insertArchiveType(ArchiveType archivetype) {
		atd.insertArchiveType(archivetype);
	}
}