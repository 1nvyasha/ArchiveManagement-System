package com.example.DangAnManagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.DangAnManagement.entity.Borrow;

public interface BorrowService extends IService<Borrow>{
	public void insertBorrow(Borrow borrow);
	
	public void updateBorrow(String ReturnTime, String RetuenLoginId, String ArchiveId);
}
