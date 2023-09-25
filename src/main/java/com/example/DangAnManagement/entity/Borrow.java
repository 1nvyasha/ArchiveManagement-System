package com.example.DangAnManagement.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {
	@TableId(type = IdType.AUTO)
	private Integer BorrowId;//档案借阅id
	private String Borrower;//借阅用户
	private String ArchiveId;//档案编号
	private String LoginId;//操作用户(登录名)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date BorrowTime;//借阅时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date EndTime;//要求归还时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ReturnTime;//归还时间
	private String remark;//备注信息
	private String RetuenLoginId;//归还用户(登录名)

}
