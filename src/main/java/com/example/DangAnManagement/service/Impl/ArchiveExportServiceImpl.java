package com.example.DangAnManagement.service.Impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.DangAnManagement.dao.ArchiveDao;
import com.example.DangAnManagement.entity.Archive;
import com.example.DangAnManagement.service.ArchiveExportService;

@Service
public class ArchiveExportServiceImpl extends ServiceImpl<ArchiveDao,Archive> implements ArchiveExportService{
	@Autowired
	private ArchiveDao ad;
	
	/**
     * txt文件导出
     * @return CallbackBody
     */
    @Override
    public ResponseEntity<byte[]> exportLand2ndClassIndex(Integer ObjectId){
        //查询表数据
        Archive list = ad.getArchiveByObjectId(ObjectId);
        //if (list == null || list.size() <= 0){
        //    return null;
        //}
        List<String> txtContentList = new ArrayList<String>();
        txtContentList.add("\"name\",\"content\"");
        //for(Archive classIndex : list){
            String name = list.getArchiveId();
            String content = list.getContent();
            txtContentList.add(name + "," + content);
        //}
        //导出的文件存储目录
        String fileSavePath = ".\\export\\"+ad.getArchiveByObjectId(ObjectId).getArchiveId()+".txt";
        //保存文本文件
        writeToTxt(txtContentList, fileSavePath);
        //获取文本文件的ResponseEntity
        try{
            ResponseEntity<byte[]> fileByte = buildResponseEntity(new File(fileSavePath));
            return fileByte;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将数据写入文本文件
     * @param list
     * @param path
     */
    private void writeToTxt(List<String> list,String path) {

        String dir = path.substring(0,path.lastIndexOf("\\"));
        File parent = new File(dir);
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }
        FileOutputStream outSTr = null;
        BufferedOutputStream Buff = null;
        String enter = "\r\n";
        StringBuffer write ;
        try {
            outSTr = new FileOutputStream(new File(path));
            Buff = new BufferedOutputStream(outSTr);
            for (int i = 0; i < list.size(); i++) {
                write = new StringBuffer();
                write.append(list.get(i));
                write.append(enter);
                Buff.write(write.toString().getBytes("UTF-8"));
            }
            Buff.flush();
            Buff.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Buff.close();
                outSTr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //读取文件
    private ResponseEntity<byte[]> buildResponseEntity(File file) throws IOException {
        byte[] body = null;
        //获取文件
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        //设置文件类型
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        //设置Http状态码
        HttpStatus statusCode = HttpStatus.OK;
        //返回数据
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;
    }

}
