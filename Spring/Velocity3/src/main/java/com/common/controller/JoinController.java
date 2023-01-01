package com.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.service.MemberService;

@Controller
@RequestMapping("/joinus/")
public class JoinController {

	// memberDao 의존
	MemberService memberservice;

	@Autowired
	public void setMemberservice(MemberService memberservice) {
		this.memberservice = memberservice;
	}

	@GetMapping("join.htm")
	public String join() {
		return "joinus/join";
	}

	@GetMapping("multiMail.htm")
	public String multiMail() {
		return "joinus/multiMail";
	}
	
	@GetMapping("fileMail.htm")
	public String fileMail() {
		return "joinus/fileMail";
	}
}