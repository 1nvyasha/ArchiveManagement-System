package com.example.DangAnManagement.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Att {
	@TableId
	private Integer AttId;//部门id
	private String ArchiveId;//档案编号
	private String Title;//附件标题
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date UpTime;//上传附件时间
	private Integer AttType;//附件类型
	private String Remark;//备注信息
	private String FileUrl;//附件文件
	private BigDecimal FileSize;//文件大小
	private String Creater;//上传用户

}
