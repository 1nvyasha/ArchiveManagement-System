package com.example.DangAnManagement.service.Impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.DangAnManagement.dao.DataFileBackDao;
import com.example.DangAnManagement.entity.DataFileBack;
import com.example.DangAnManagement.service.DataFileBackService;

@Service
public class DataFileBackServiceImpl extends ServiceImpl<DataFileBackDao,DataFileBack> implements DataFileBackService{
	@Autowired
	private DataFileBackDao dfbd;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public List<DataFileBack> getAllDataFile() {
		return dfbd.getAllDataFile();
	}

	public void insertDataFile(String fileName, Date backDate) {
		dfbd.insertDataFile(fileName,backDate);
	}
	
	/**
     * 数据库文件备份
     */
	public void backupDatabase(String s) throws IOException {
		backup("d:\\"+s+ sdf.format(new Date()) + ".sql");
	}
	public static void backup(String path) throws IOException{
	    Runtime runtime = Runtime.getRuntime();
	    //-u后面是用户名，-p是密码-p后面最好不要有空格，-family是数据库的名字
	    Process process = runtime.exec("C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump -uroot -pa547896321 dangan_management");
	    InputStream inputStream = process.getInputStream();//得到输入流，写成.sql文件
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(reader);
        String s = null;
        StringBuffer sb = new StringBuffer();
        while((s = br.readLine()) != null){
            sb.append(s+"\r\n");
        }
        s = sb.toString();
        System.out.println(s);
        File file = new File(path);
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(s.getBytes());
        fileOutputStream.close();
        br.close();
        reader.close();
        inputStream.close();
    }
}
