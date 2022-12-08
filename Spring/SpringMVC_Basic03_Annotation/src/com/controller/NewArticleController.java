package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.NewArticleCommand;
import com.service.ArticleService;

/*
- 클라이언트 요청
1. 화면 요청 (글쓰기, 로그인 화면): write.do
2. 처리 요청 (글쓰기 입력 처리, 로그인 완료 처리): writeok.do

요청 주소 >> write.do		>> 화면
요청 주소 >> writeok.do	>> 처리

- 클라이언트 요청
- 1개의 주소를 가지고 판단
- 요청 주소 하나로 화면 혹은 처리인지 판단해야 함 >> 근거: 전송 방식 (GET, POST)
>> http://localhost:9000/SpringMVC_Basic03_Annotation/article/newArticle.do
*/

@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {

	private ArticleService articleservice;

	@Autowired
	public void setArticleservice(ArticleService articleservice) {
		this.articleservice = articleservice;
	}

	// 요청 주소 "/article/newArticle.do", 전송 방식이 GET이라면 form() 실행
	// 화면 출력 요청
	// @RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public String form() {
		// 함수 return type이 String >> view의 주소를 의미
		System.out.println("GET");
		return "article/newArticleForm";
		// /WEB-INF/views/ + article/newArticleForm + .jsp
	}

	/*
	// 1. 데이터를 받는 가장 전통적인 방식 (request 객체 사용)
	// @RequestMapping(method = RequestMethod.POST)
	@PostMapping // 5.x.x 버전부터
	public ModelAndView submit(HttpServletRequest request) {
		System.out.println("POST");

		NewArticleCommand article = new NewArticleCommand();
		article.setParentId(Integer.parseInt(request.getParameter("parentId")));
		article.setTitle(request.getParameter("title"));
		article.setContent(request.getParameter("content"));

		// NewArticleController 가 service 필요
		this.articleservice.writeArticle(article);
		// 처리 완료

		ModelAndView mv = new ModelAndView();
		mv.addObject("newArticleCommand", article);
		mv.setViewName("article/newArticleSubmitted");

		return mv;
	}
	
	// 2. Spring에서 parameter를 DTO 객체로 받기
	// 2.1. 자동화 >> 전제조건 >> input name="" 값이 DTO 객체의 member field명과 동일해야 할 것
	@PostMapping // 5.x.x 버전부터
	public ModelAndView submit(NewArticleCommand command) {
		// 1. 자동으로 DTO 객체 생성 NewArticleCommand command = new NewArticleCommand();
		// 2. 넘어 온 parameter값을 DTO setter 함수를 사용하여 자동 주입
		// 3. NewArticleCommand command 객체 IOC 컨테이너 안에 자동 생성
		this.articleservice.writeArticle(command);
		
		// 처리 완료
		ModelAndView mv = new ModelAndView();
		mv.addObject("newArticleCommand", command);
		mv.setViewName("article/newArticleSubmitted");
		
		return mv;
	}
		*/
	
	@PostMapping // 5.x.x 버전부터
	public String submit(@ModelAttribute("Articledata") NewArticleCommand command) {
		/*
		ModelAndView mv = new ModelAndView();
		mv.addObject("newArticleCommand", command);
		>> @ModelAttribute("Articledata") 대체
		
		mv.setViewName("article/newArticleSubmitted");
		>> String submit >> return "article/newArticleSubmitted"
		
		view까지 자동 forward
		*/
		
		this.articleservice.writeArticle(command);
		
		return "article/newArticleSubmitted";
	}
}
