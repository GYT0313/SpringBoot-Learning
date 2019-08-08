package com.gyt.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("通知-开会");
        message.setText("3点开发");
        message.setTo("guyt@cig.com.cn");
        message.setFrom("guyongtao@qq.com");
        mailSender.send(message);
    }

    @Test
    public void test02() throws MessagingException {
        // 复杂邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        // 设置
        helper.setSubject("通知-开会");
        helper.setText("<b style='color:red'>今天开会</b>", true);
        helper.setTo("guyt@cig.com.cn");
        helper.setFrom("guyongtao@qq.com");

        // 上传文件
        helper.addAttachment("1.jpg", new File("C:\\Users\\guyt\\Pictures\\cig\\7239_image001(03(12-11-11-29-40).png"));
        mailSender.send(mimeMessage);
    }

}
