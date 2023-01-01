package com.common.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.common.service.MailService;

@Controller
@RequestMapping("")
public class MailController {
	
	@Autowired
	private MailService mailservice;

	// 첨부파일 메일 보내기
	@RequestMapping(value = "/joinus/fileMail", method = RequestMethod.POST)
	public void sendMessageWithAttachment(HttpServletRequest request, MultipartFile file)
			throws MessagingException, UnsupportedEncodingException, IOException {
		System.out.println("첨부파일 메일 컨트롤러 들어옴");
		
		String to = request.getParameter("to");
		String subject = request.getParameter("subject");
		String text = request.getParameter("text");
		System.out.println("file: " + file);
		
		System.out.println(to + " / " + subject + " / " + text + " / " + file);
		
		mailservice.sendMessageWithAttachment(to, subject, text, file); // 오류나는부분
		System.out.println("첨부파일 메일 서비스 완료 - 컨트롤러 마지막");
	}
	
}
