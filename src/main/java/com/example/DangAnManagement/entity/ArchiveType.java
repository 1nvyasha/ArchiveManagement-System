package com.example.DangAnManagement.entity;

import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArchiveType {
	@TableId
	private String ArchiveTypeId;//档案类型id
	private String ArchiveTypeName;//档案类型名称
}
