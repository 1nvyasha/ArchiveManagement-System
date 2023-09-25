package com.example.DangAnManagement.entity;

import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Save {
	@TableId
	private Integer SaveId;//存档点id
	private String SaveName;//存档点名称
	private String SaveAddress;//存档点地址
	private String Linker;//联系人
	private String TelePhone;//联系电话
	private String Fax;//传真
	private String Remark;//部门备注
}
