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
public class UserInfo {
	@TableId
	private String LoginId;//登录名
	private String LoginName;//员工姓名
	private String LoginPwd;//密码
	private Integer RoleId;//用户角色
	private Integer LevelId;//安全级别
	private String CardId;//身份证
	private Integer DutyId;//职务
	private Integer DeptId;//所在部门
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date JoinDate;//加入公司时间
	private String TelePhone;//联系电话
	private Integer EnduId;//学历
	private String Address;//联系地址
	private String Sex;//性别
	private String Remark;//备注信息

	
}
