package com.example.DangAnManagement.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.DangAnManagement.entity.Borrow;

@Mapper
public interface BorrowDao extends BaseMapper<Borrow>{
	@Insert("insert into borrow(Borrower,ArchiveId,LoginId,BorrowTime,EndTime,remark)values('${Borrower}','${ArchiveId}','${LoginId}','${BorrowTime}','${EndTime}','${remark}');")
	public void insertBorrow(Borrow borrow);
	
	@Update("update borrow set ReturnTime='${ReturnTime}',RetuenLoginId='${RetuenLoginId}' where ArchiveId='${ArchiveId}'")
	public void updateBorrow(String ReturnTime, String RetuenLoginId, String ArchiveId);
	
}