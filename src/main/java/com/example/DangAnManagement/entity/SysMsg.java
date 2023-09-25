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
public class SysMsg {
	@TableId
	private Integer msgIdInteger;//系统提示id
	private String Title;//标题
	private String Type;//类型
	private String Content;//提示内容
	private String ArchiveId;//档案编号
	private String LoginId;//提示用户(登录名)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date EndTime;//到期日期
	private String IsRead;//是否已读
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date MsgTime;//提示日期

}
