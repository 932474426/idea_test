package com.example.demo.service;

import org.junit.Test;
import com.example.demo.service.SendMail;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoApplicationTests {
	@Autowired
	private SendMail mailService;
	private String toEmail = "932474426@qq.com";		// 填写你的qq邮箱号

	@Test
	public void sendTextMail() {
		mailService.sendTextMail(toEmail,"主题","测试内容");
	}
	@Test
	public void sendAttachmentMail() {
		mailService.sendAttachmentMail(toEmail,"这是带附件的邮件","有附件","D:\\1.txt");
	}
}
