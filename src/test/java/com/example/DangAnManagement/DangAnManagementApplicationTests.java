package com.example.DangAnManagement;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.DangAnManagement.controller.ShujuBeifenHuifuController;

@SpringBootTest
class DangAnManagementApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testBackupDatabase() throws IOException{
		new ShujuBeifenHuifuController().importSql();
	}
}
