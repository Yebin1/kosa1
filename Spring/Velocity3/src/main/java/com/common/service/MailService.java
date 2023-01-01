package com.common.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;

	// 첨부파일 메일 보내기
	public void sendMessageWithAttachment(String to, String subject, String text, MultipartFile file)
			throws MessagingException, UnsupportedEncodingException, IOException {

		System.out.println("첨부파일 메일 서비스 도는중");

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		System.out.println("mailSender.createMimeMessage 완료");

		helper.setFrom("yb632339@gmail.com");
		helper.setTo(to);
		System.out.println("to: " + to);

		helper.setSubject(subject);
		System.out.println("subject: " + subject);
		
		helper.setText(text);
		System.out.println("text:" + text);

//		FileDataSource fds = new FileDataSource(file);
		System.out.println("file: " + file);
		
		 String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		 helper.addAttachment(MimeUtility.encodeText(fileName, "UTF-8", "B"), new
		 ByteArrayResource(IOUtils.toByteArray(file.getInputStream())));
		 

		mailSender.send(message);

	}

}
