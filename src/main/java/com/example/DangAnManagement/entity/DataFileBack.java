package com.example.DangAnManagement.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataFileBack {
	@TableId(type = IdType.AUTO)
	private Integer FileId;
	private String FileName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date BackDate;
}
