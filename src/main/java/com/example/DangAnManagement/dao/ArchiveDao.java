package com.example.DangAnManagement.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.DangAnManagement.entity.Archive;
@Mapper
public interface ArchiveDao extends BaseMapper<Archive>{
	//
	//创建修改ArchiveId、SaveId外键的触发器 
	//
	
	@Select("select * from archive")
	public List<Archive> getAllArchive();
	
	@Select("select * from archive where objectid=${ObjectId}")
	public Archive getArchiveByObjectId(Integer ObjectId);
	
	@Select("select * from archive where state='${state}'")
	public List<Archive> getArchiveByState(String state);
	
	@Select("select * from archive where archiveid='${archiveid}'")
	public Archive getArchiveByArchiveId(String archiveid);
	
	@Delete("delete from archive where objectid=${ObjectId}")
	public void deleteArchiveByObjectId(Integer ObjectId);
	
	@Update("update archive set SaveId=${archive.SaveId},Title='${archive.Title}',Content='${archive.Content}',Remark='${archive.Remark}',Creater='${archive.Creater}',"
			+ "CreateTime='${archive.CreateTime}',LastModiUser='${archive.LastModiUser}',LastModiTime='${archive.LastModiTime}',LevelId=${archive.LevelId},"
			+ "EndTime='${archive.EndTime}',State='${archive.State}',EndIsAlert='${archive.EndIsAlert}',EndBeforeDay=${archive.EndBeforeDay},IsOften='${archive.IsOften}',"
			+ "FromDept='${archive.FromDept}',FromUnit='${archive.FromUnit}',FromUser='${archive.FromUser}',ImpactTime='${archive.ImpactTime}',UseTime='${archive.UseTime}',"
			+ "ProductCode='${archive.ProductCode}',StuffCode='${archive.StuffCode}',Number=${archive.Number},PageCount=${archive.PageCount},PatentCode='${archive.PatentCode}',"
			+ "CheckUser='${archive.CheckUser}' where ObjectId=${ObjectId}")
	public void updateArchiveByObjectId(Archive archive,Integer ObjectId);
	
	@Insert("insert into archive(ArchiveId,ArchiveTypeId,SaveId,Title,Content,Remark,Creater,CreateTime,LastModiUser,LastModiTime,LevelId,EndTime,"
			+ "EndIsAlert,EndBeforeDay,IsOften,FileCode,FromDept,FromUnit,FromUser,ImpactTime,UseTime,ProductCode,StuffCode,Number,PageCount,"
			+ "PatentCode,CheckUser)values('${ArchiveId}','${ArchiveTypeId}',${SaveId},'${Title}','${Content}','${Remark}','${Creater}',"
			+ "'${CreateTime}','${LastModiUser}','${LastModiTime}',${LevelId},'${EndTime}','${EndIsAlert}',${EndBeforeDay},'${IsOften}',"
			+ "'${FileCode}','${FromDept}','${FromUnit}','${FromUser}','${ImpactTime}','${UseTime}','${ProductCode}','${StuffCode}',${Number},${PageCount},'${PatentCode}','${CheckUser}');")
	public void insertArchive(Archive archive);
	
	@Select("select * from archive where archivetypeid='${archivetype}' and saveid=${save} and title like '%${title}%'")//'%${}%'可能会引发sql注入
	public List<Archive> searchArchive0(String archivetype, Integer save, String title);//档案联合查询
	@Select("select * from archive where saveid=${save} and title like '%${title}%'")
	public List<Archive> searchArchive1(Integer save, String title);
	@Select("select * from archive where archivetypeid='${archivetype}' and title like '%${title}%'")
	public List<Archive> searchArchive2(String archivetype, String title);
	@Select("select * from archive where title like '%${title}%'")
	public List<Archive> searchArchive3(String title);
	
	@Select("select * from archive where archivetypeid='${archivetype}' and saveid=${save} and title like '%${title}%' and state='${state}'")//'%${}%'可能会引发sql注入
	public List<Archive> searchArchiveWithState0(String archivetype, Integer save, String title, String state);//档案借阅
	@Select("select * from archive where saveid=${save} and title like '%${title}%' and state='${state}'")
	public List<Archive> searchArchiveWithState1(Integer save, String title, String state);
	@Select("select * from archive where archivetypeid='${archivetype}' and title like '%${title}%' and state='${state}'")
	public List<Archive> searchArchiveWithState2(String archivetype, String title, String state);
	@Select("select * from archive where title like '%${title}%' and state='${state}'")
	public List<Archive> searchArchiveWithState3(String title, String state);
	
	@Select("select * from archive where archiveid like '%${archiveid}%' and state='${state}';")
	public List<Archive> searchArchiveByArchiveId(String archiveid, String state);
	
	@Update("update archive set state='${state}' where ObjectId=${ObjectId}")
	public void updateArchiveState(String state, Integer ObjectId);
	
	@Select("select * from archive where state='正在借阅' and archiveid in(select archiveid from borrow where EndTime<=curdate() and ReturnTime is null)")
	public List<Archive> searchReturnRed();//超过归还时间
	@Select("select * from archive where state='正在借阅' and archiveid in(select archiveid from borrow where EndTime>curdate() and EndTime<=date_add(curdate(),interval 3 day) and ReturnTime is null)")
	public List<Archive> searchReturnYellow();//距离归还时间还剩3天
	@Select("select * from archive where state='正在借阅' and archiveid in(select archiveid from borrow where EndTime>date_add(curdate(),interval 3 day) and ReturnTime is null)")
	public List<Archive> searchReturnWhite();
	
	
	@Select("select * from archive where state='正在借阅' and archiveid in(select archiveid from borrow where EndTime<=curdate() and EndTime>='${date1}' and EndTime<='${date2}' and ReturnTime is null)")
	public List<Archive> searchReturnRedByEndtime(Date date1, Date date2);//超过归还时间
	@Select("select * from archive where state='正在借阅' and archiveid in(select archiveid from borrow where EndTime>curdate() and EndTime<=date_add(curdate(),interval 3 day) and EndTime>='${date1}' and EndTime<='${date2}' and ReturnTime is null)")
	public List<Archive> searchReturnYellowByEndtime(Date date1, Date date2);//距离归还时间还剩3天
	@Select("select * from archive where state='正在借阅' and archiveid in(select archiveid from borrow where EndTime>date_add(curdate(),interval 3 day) and EndTime>='${date1}' and EndTime<='${date2}' and ReturnTime is null)")
	public List<Archive> searchReturnWhiteByEndtime(Date date1, Date date2);
	
	@Select("select * from archive where EndTime<curdate()")
	public List<Archive> searchArchiveByEndTime0();//档案已经超过过期时间
	@Select("select * from archive where EndTime<=date_add(curdate(),interval #{i} day) and EndTime>=curdate()")
	public List<Archive> searchArchiveByEndTime(Integer i);//#{i}可以注入,${i}注入失败//档案在i天之内过期
	
	@Select("select * from archive where state='销毁' and archiveid in(select archiveid from destory where DestoryTime>='${date1}' and DestoryTime<='${date2}')")
	public List<Archive> searchDestoryArchive(Date date1, Date date2);//查询时间段内销毁的档案
	
	@Select("select * from archive where state='损坏' and archiveid in(select archiveid from lose where LoseTime>='${date1}' and LoseTime<='${date2}') or state='丢失' and archiveid in(select archiveid from lose where LoseTime>='${date1}' and LoseTime<='${date2}')")
	public List<Archive> searchLoseArchive(Date date1, Date date2);//查询时间段内损坏丢失的档案
}
