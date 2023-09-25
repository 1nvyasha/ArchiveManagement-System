package com.example.DangAnManagement.entity;

import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
	@TableId
	private Integer DeptId;//部门id
	private String DeptName;//部门名称
	private String TelePhone;//联系电话
	private String Fax;//传真
	private String ManageId;//负责人
	private String Remark;//部门备注
}
