package com.example.DangAnManagement.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.DangAnManagement.dao.BorrowDao;
import com.example.DangAnManagement.entity.Borrow;
import com.example.DangAnManagement.service.BorrowService;

@Service
public class BorrowServiceImpl extends ServiceImpl<BorrowDao,Borrow> implements BorrowService {
	@Autowired
	private BorrowDao bd;

	public void insertBorrow(Borrow borrow) {
		borrow.setReturnTime(null);
		borrow.setRetuenLoginId(null);
		bd.insertBorrow(borrow);
	}

	public void updateBorrow(String ReturnTime, String RetuenLoginId, String ArchiveId) {
		bd.updateBorrow(ReturnTime, RetuenLoginId, ArchiveId);
	}
	
}
