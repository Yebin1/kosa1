package ncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	// 프로젝트 자체 run as 했을 때 매핑
    @RequestMapping("/")
    public String rending() {
       System.out.println("rending");
       return "index";
       //return "/WEB-INF/views/index.jsp";
    }
	
    // index.htm 실행시킬 때 매핑
	@RequestMapping("/index.htm")
	public String index() {
		// return "/WEB-INF/views/index.jsp";
		return "index";
		// <bean id="internalResourceViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	}
}
