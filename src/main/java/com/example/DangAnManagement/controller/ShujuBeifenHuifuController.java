package com.example.DangAnManagement.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.DangAnManagement.service.DataFileBackService;

import jakarta.servlet.http.HttpSession;

/**
 * 备份与还原数据库
 */

@Controller
public class ShujuBeifenHuifuController {
	@Autowired
	private DataFileBackService dfbs;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	int t=(int)(Math.random()*9999)+1;
	String s=String.valueOf(t);
	
	//↓↓↓数据备份↓↓↓
	@RequestMapping("/toshujuBeifen")
	public String show1(Model model, HttpSession session) {
		model.addAttribute("datafiles", dfbs.getAllDataFile());
		return "shuju_beifen";
	}

    @RequestMapping("/backupDatabase")
    public String backupDatabase() throws IOException {
		dfbs.backupDatabase(s);
		dfbs.insertDataFile(s, new Date(System.currentTimeMillis()));
		return "redirect:/21";
	}
    //↑↑↑数据备份↑↑↑
    
    //↓↓↓数据恢复↓↓↓
    @RequestMapping("/toshujuHuifu")
	public String show2(Model model, HttpSession session) {
		model.addAttribute("datafiles", dfbs.getAllDataFile());
		return "shuju_huifu";
	}
    
//    public static void recover(String path) throws IOException{
//        Runtime runtime = Runtime.getRuntime();
//        //-u后面是用户名，-p是密码-p后面最好不要有空格，-family是数据库的名字，--default-character-set=utf8，这句话一定的加
//        //我就是因为这句话没加导致程序运行成功，但是数据库里面的内容还是以前的内容，最好写上完成的sql放到cmd中一运行才知道报错了
//        //错误信息：
//        //mysql: Character set 'utf-8' is not a compiled character set and is not specified in the '
//        //C:\Program Files\MySQL\MySQL Server 5.5\share\charsets\Index.xml' file ERROR 2019 (HY000): Can't
//        // initialize character set utf-8 (path: C:\Program Files\MySQL\MySQL Server 5.5\share\charsets\)，
//        //又是讨人厌的编码问题，在恢复的时候设置一下默认的编码就可以了。
//        Process process = runtime.exec("mysql -u root -pmysql --default-character-set=utf8 goldenwing");
//        OutputStream outputStream = process.getOutputStream();
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
//        String str = null;
//        StringBuffer sb = new StringBuffer();
//        while((str = br.readLine()) != null){
//            sb.append(str+"\r\n");
//        }
//        str = sb.toString();
//        System.out.println(str);
//        OutputStreamWriter writer = new OutputStreamWriter(outputStream,"utf-8");
//        writer.write(str);
//        writer.flush();
//        outputStream.close();
//        br.close();
//        writer.close();
//    }
//    //↑↑↑数据恢复↑↑↑
    private String[] getImportCommand() {  
        String username = "root"; //用户名  
        String password = "a547896321"; //密码  
        String importDatabaseName = "dangan_management"; //导入的目标数据库的名称  
        String importPath = "D:\\2023-09-182023-09-18.sql"; //导入的目标文件所在的位置  
        // 第一步，获取登录命令语句,指向mysql安装目录 
        String loginCommand = new StringBuffer().append("cmd /c mysql -u").append(username).append(" -p").append(password).toString(); 
        // 第二步，获取切换数据库到目标数据库的命令语句  
        String switchCommand = new StringBuffer("use ").append(importDatabaseName).toString();  
        // 第三步，获取导入的命令语句  
        String importCommand = new StringBuffer("source ").append(importPath).toString();  
        // 需要返回的命令语句数组  
        String[] commands = new String[] {loginCommand, switchCommand, importCommand};  
        return commands;  
    }
    
    @RequestMapping("/importDatabase")
    public String importSql() {  
    	try {
            Runtime runtime = Runtime.getRuntime();  
            //因为在命令窗口进行mysql数据库的导入一般分三步走，所以所执行的命令将以字符串数组的形式出现  
            String cmdarray[] = getImportCommand();//根据属性文件的配置获取数据库导入所需的命令，组成一个数组
            System.out.println(cmdarray[0]+","+cmdarray[1]+","+cmdarray[2]);
            //runtime.exec(cmdarray);//这里也是简单的直接抛出异常  
            Process process = runtime.exec(cmdarray[0]);  
            //System.out.println("a");
            //执行了第一条命令以后已经登录到mysql了，所以之后就是利用mysql的命令窗口  
            //进程执行后面的代码  
            OutputStream os = process.getOutputStream();  
            OutputStreamWriter writer = new OutputStreamWriter(os);  
            //命令1和命令2要放在一起执行 
            System.out.println(cmdarray[1] + "\r\n" + cmdarray[2]);
            writer.write(cmdarray[1] + "\r\n" + cmdarray[2]);  
            writer.flush();  
            writer.close();  
            os.close();
    	} catch (IOException e) { 
    		e.printStackTrace(); 
    	}
    	return "redirect:/22"; 
    }

}
