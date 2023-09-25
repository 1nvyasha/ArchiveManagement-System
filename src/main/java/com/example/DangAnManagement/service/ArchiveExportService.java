package com.example.DangAnManagement.service;

import org.springframework.http.ResponseEntity;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.DangAnManagement.entity.Archive;

public interface ArchiveExportService extends IService<Archive>{
	public ResponseEntity<byte[]> exportLand2ndClassIndex(Integer ObjectId);//导出为txt
}
