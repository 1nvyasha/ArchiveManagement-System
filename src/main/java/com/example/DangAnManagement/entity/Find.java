package com.example.DangAnManagement.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Find {
	@TableId
	private Integer FindId;//找回id
	private String ArchiveId;//档案编号
	private String LoginId;//操作用户(登录名)
	private String Finder;//找回用户
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date FindTime;//找回日期
	private String Remark;//找回信息备注
}
