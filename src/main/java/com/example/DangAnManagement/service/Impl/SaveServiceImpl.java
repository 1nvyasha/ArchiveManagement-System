package com.example.DangAnManagement.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.DangAnManagement.dao.SaveDao;
import com.example.DangAnManagement.entity.Save;
import com.example.DangAnManagement.service.SaveService;

@Service
public class SaveServiceImpl extends ServiceImpl<SaveDao,Save> implements SaveService {
	@Autowired
	private SaveDao sd;
	
	public List<Save> getAllSave() {
		return sd.getAllSave();
	}
	
	public Save getSaveById(Integer saveid) {
		return sd.getSaveById(saveid);
	}
	
	public void updateSaveById(Save save, Integer saveid) {		
		sd.updateSaveById(save, saveid);
	}
	
	public void deleteSaveById(Integer saveid) {		
		sd.deleteSaveById(saveid);
	}
	
	public void insertSave(Save save) {		
		sd.insertSave(save);
	}
	
	public List<Save> searchSaveByName(String savename) {		
		return sd.searchSaveByName(savename);
	}

}
