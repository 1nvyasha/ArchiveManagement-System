package com.example.DangAnManagement.entity;

import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysConfig {
	private String SysName;//系统名称
	@TableId
	private String ComName;//公司名称
	private String ComTel;//公司电话
	private String ComFax;//公司传真
	private String ComAddress;//公司地址
	private String ComURL;//公司网址
	private String BrowserType;//浏览器类型
	private String BrowserVersion;//浏览器版本
	private String ClientIP;//客户端ip地址
	private String ClientOS;//客户端操作系统
}
