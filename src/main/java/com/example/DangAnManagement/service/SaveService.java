package com.example.DangAnManagement.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.DangAnManagement.entity.Save;

public interface SaveService extends IService<Save>{
	public List<Save> getAllSave();
	public Save getSaveById(Integer saveid);
	public void updateSaveById(Save save, Integer saveid);
	public void deleteSaveById(Integer saveid);
	public void insertSave(Save save);
	public List<Save> searchSaveByName(String savename);
}
