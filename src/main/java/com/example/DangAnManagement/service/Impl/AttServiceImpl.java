package com.example.DangAnManagement.service.Impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.DangAnManagement.dao.AttDao;
import com.example.DangAnManagement.entity.Att;
import com.example.DangAnManagement.service.AttService;

@Service
public class AttServiceImpl extends ServiceImpl<AttDao,Att> implements AttService {

}
