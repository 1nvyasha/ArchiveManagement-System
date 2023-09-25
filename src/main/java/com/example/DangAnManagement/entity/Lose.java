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
public class Lose {
	@TableId
	private Integer LoseId;//损坏丢失id
	private String ArchiveId;//档案编号
	private String LoginId;//操作用户(登录名)
	private String Type;//损坏丢失类型
	private String Loser;//当事用户
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date LoseTime;//事故日期
	private String Remark;//事故信息备注

}
