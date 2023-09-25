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
public class Archive {
	@TableId
	private String ArchiveId;//档案编号
	private Integer ObjectId;//记录编号
	private String ArchiveTypeId;//档案所属类型
	private Integer SaveId;//档案存档点
	private String Title;//档案标题
	private String Content;//档案内容
	private String Remark;//内容简介
	private String Creater;//建档用户
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date CreateTime;//建档日期
	private String LastModiUser;//修改用户
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date LastModiTime;//修改日期//若用String接收Date,则会直接显示Date信息
	private Integer LevelId;//安全级别
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date EndTime;//过期时间
	private String State;//借阅状态
	private Integer EndIsAlert;//过期是否提醒      //数据库bit不会用
	private Integer EndBeforeDay;//通知提前天数
	private String IsOften;//是否常用
	private String FileCode;//文件编号
	private String FromDept;//来文部门
	private String FromUnit;//发文单位
	private String FromUser;//发文人
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ImpactTime;//批准时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date UseTime;//鉴定时间
	private String ProductCode;//产品批号
	private String StuffCode;//原料批号
	private Integer Number;//数量
	private Integer PageCount;//页数
	private String PatentCode;//专利号
	private String CheckUser;//年检负责人

}
