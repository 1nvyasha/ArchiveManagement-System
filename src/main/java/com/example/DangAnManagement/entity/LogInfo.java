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
public class LogInfo {
	@TableId(type = IdType.AUTO)
	private Integer LogId;//日志id
	private String LogType;//日志类型
	private String OperateUser;//操作用户
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date OperateDate;//操作日期
	private String LogDescp;//日志描述
}
