package ncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String rending() {
		System.out.println("rending");
		return "index";
		// return "/WEB-INF/views/index.jsp";
	}

	@RequestMapping("/index.htm")
	public String index() {
		System.out.println("뭐해");
		return "index";
		// return "/WEB-INF/views/index.jsp";
	}
}
