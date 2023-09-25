package com.example.DangAnManagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.DangAnManagement.entity.Save;

@Mapper
public interface SaveDao extends BaseMapper<Save>{
	@Select("select * from save")
	public List<Save> getAllSave();
	
	@Select("select * from save where saveid=${saveid}")
	public Save getSaveById(Integer saveid);
	
	@Update("update save set SaveId=${save.SaveId},SaveName='${save.SaveName}',SaveAddress='${save.SaveAddress}',Linker='${save.Linker}',TelePhone='${save.TelePhone}',Fax='${save.Fax}',Remark='${save.Remark}' where saveid=${saveid}")
	public void updateSaveById(Save save, Integer saveid);
	
	@Delete("delete from save where saveid=${saveid}")
	public void deleteSaveById(Integer saveid);
	
	@Insert("insert into save (saveid,savename,saveaddress,linker,telephone,fax,remark)values(${SaveId},'${SaveName}','${SaveAddress}','${Linker}','${TelePhone}','${Fax}','${Remark}');")
	public void insertSave(Save save);
	
	@Select("select * from save where savename like '%${savename}%';")
	public List<Save> searchSaveByName(String savename);
}
