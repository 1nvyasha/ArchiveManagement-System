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
public class Destory {
	@TableId
	private Integer DestoryId;//销毁信息id
	private String ArchiveId;//档案编号
	private String LoginId;//操作用户(登录名)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DestoryTime;//销毁日期
	private String Reason;//销毁原因
	private String Remark;//销毁信息备注
}
