package com.example.DangAnManagement.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.DangAnManagement.entity.Archive;

public interface ArchiveService extends IService<Archive>{
	/** 考虑到档案是不可抢占资源,
	 * 在进行档案操作(如借阅、销毁等)时,
	 * 可以在service层中创建一个"资源池"(Set),
	 * 在service层中将正在进行登记的档案加入"资源池"中,
	 * 此时只有最先提交登记的用户能够操作成功,
	 * 其余用户无法操作成功.
	 */
	public List<Archive> getAllArchive();
	
	public Archive getArchiveByObjectId(Integer ObjectId);
	
	public List<Archive> getArchiveByState(String state);
	
	public Archive getArchiveByArchiveId(String archiveid);
	
	public void deleteArchiveByObjectId(Integer ObjectId);
	public void updateArchiveByObjectId(Archive archive,Integer ObjectId);
	public void insertArchive(Archive archive);
	
	public List<Archive> searchArchive(String archivetype, Integer save, String title);
	public List<Archive> searchArchiveWithState(String archivetype, Integer save, String title, String state);
	
	public List<Archive> searchArchiveByArchiveId(String archiveid, String state);
	
	public void updateArchiveState(String state, Integer ObjectId);
	
	public Map<String, List<Archive>> searchReturn();
	public Map<String, List<Archive>> searchReturnByEndtime(Date date1, Date date2);
	
	public List<Archive> searchArchiveByEndTime(Integer i);
	
	public List<Archive> searchDestoryArchive(Date date1, Date date2);
	
	public List<Archive> searchLoseArchive(Date date1, Date date2);
}
