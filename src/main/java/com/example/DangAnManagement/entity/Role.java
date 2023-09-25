package com.example.DangAnManagement.entity;

import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
	@TableId
	private Integer RoleId;//角色id
	private String RoleName;//角色名称
	private String Power;//权限
}
