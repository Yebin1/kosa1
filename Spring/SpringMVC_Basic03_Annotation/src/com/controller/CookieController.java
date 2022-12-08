package com.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	
	@RequestMapping("/cookie/make.do")
	public String make(HttpServletResponse response) {
		// Cookie >> Client에게 쓰는 방식 >> response
		// HttpServletResponse를 Interface 방식으로 받음
		// servlet 동일
		response.addCookie(new Cookie("auth", "1004")); // key=auth, value=1004
		return "cookie/CookieMake";
	}

	// @CookieValue annotation 사용하지 않을 때 >> public String view(HttpServletRequest request)
	@RequestMapping("/cookie/view.do")
	public String view(@CookieValue(value="auth", defaultValue="1007") String auth) {
		// auth라는 쿠키를 읽었을 때 값이 있으면 auth로, 없으면 defaultValue로 대체
		System.out.println("Client에서 read한 Cookie값: " + auth);
		return "cookie/CookieView";
	}
	
}
