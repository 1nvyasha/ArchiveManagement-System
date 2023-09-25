package com.example.DangAnManagement.service.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.DangAnManagement.dao.ArchiveDao;
import com.example.DangAnManagement.entity.Archive;
import com.example.DangAnManagement.service.ArchiveService;

@Service
public class ArchiveServiceImpl extends ServiceImpl<ArchiveDao,Archive> implements ArchiveService {
	@Autowired
	private ArchiveDao ad;
	
	public List<Archive> getAllArchive() {
		return ad.getAllArchive();
	}
	
	public Archive getArchiveByObjectId(Integer ObjectId) {
		return ad.getArchiveByObjectId(ObjectId);
	}
	
	public List<Archive> getArchiveByState(String state) {
		return ad.getArchiveByState(state);
	}

	public Archive getArchiveByArchiveId(String archiveid) {
		return ad.getArchiveByArchiveId(archiveid);
	}


	public void deleteArchiveByObjectId(Integer ObjectId) {		
		ad.deleteArchiveByObjectId(ObjectId);
	}
	
	public void updateArchiveByObjectId(Archive archive, Integer ObjectId) {
		ad.updateArchiveByObjectId(archive, ObjectId);
	}
	
	public void insertArchive(Archive archive) {
		String s=archive.getArchiveTypeId()+"_"+archive.getFileCode();
		archive.setArchiveId(s);
		ad.insertArchive(archive);
	}

	public List<Archive> searchArchive(String archivetype, Integer save, String title) {
		if("%".equals(archivetype)&&save==9999) {
			return ad.searchArchive3(title);
		}
		else {
			if("%".equals(archivetype)) {
				return ad.searchArchive1(save, title);
			}
			if(save==9999){
				return ad.searchArchive2(archivetype, title);
			}
		}
		return ad.searchArchive0(archivetype, save, title);
	}
	
	public List<Archive> searchArchiveWithState(String archivetype, Integer save, String title, String state) {
		if("%".equals(archivetype)&&save==9999) {
			return ad.searchArchiveWithState3(title, state);
		}
		else {
			if("%".equals(archivetype)) {
				return ad.searchArchiveWithState1(save, title, state);
			}
			if(save==9999){
				return ad.searchArchiveWithState2(archivetype, title, state);
			}
		}
		return ad.searchArchiveWithState0(archivetype, save, title, state);
	}

	public List<Archive> searchArchiveByArchiveId(String archiveid, String state) {
		return ad.searchArchiveByArchiveId(archiveid, state);
	}

	public void updateArchiveState(String state, Integer ObjectId) {
		ad.updateArchiveState(state, ObjectId);
	}

	public Map<String, List<Archive>> searchReturn() {
		Map<String, List<Archive>> map=new HashMap<>();
		map.put("red", ad.searchReturnRed());
		map.put("yellow", ad.searchReturnYellow());
		map.put("white", ad.searchReturnWhite());
		return map;
	}

	public Map<String, List<Archive>> searchReturnByEndtime(Date date1, Date date2) {
		Map<String, List<Archive>> map=new HashMap<>();
		map.put("red", ad.searchReturnRedByEndtime(date1, date2));
		map.put("yellow", ad.searchReturnYellowByEndtime(date1, date2));
		map.put("white", ad.searchReturnWhiteByEndtime(date1, date2));
		return map;
	}

	public List<Archive> searchArchiveByEndTime(Integer i) {
		switch(i) {
		case 0:return ad.searchArchiveByEndTime0();//已经到期
		case 1:return ad.searchArchiveByEndTime(0);//今天到期
		case 2:return ad.searchArchiveByEndTime(3);//三天内到期
		case 3:return ad.searchArchiveByEndTime(7);//一周内到期
		case 4:return ad.searchArchiveByEndTime(14);//两周内到期
		case 5:return ad.searchArchiveByEndTime(30);//一个月内到期
		case 6:return ad.searchArchiveByEndTime(90);//三个月内到期
		case 7:return ad.searchArchiveByEndTime(183);//半年内到期
		case 8:return ad.searchArchiveByEndTime(365);//一年内到期
		}
		return null;
	}

	public List<Archive> searchDestoryArchive(Date date1, Date date2) {
		return ad.searchDestoryArchive(date1, date2);
	}

	public List<Archive> searchLoseArchive(Date date1, Date date2) {
		return ad.searchLoseArchive(date1, date2);
	}

}
