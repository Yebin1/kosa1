package ncontroller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
/*
@Controller
@RequestMapping("/customer/")
public class LocaleChangeController {
	
	private LocaleResolver localeResolver;
	
	@RequestMapping("/noticeLang.htm")
	public String change(@RequestParam("lang") String language, HttpServletRequest request,
	HttpServletResponse response) {
		System.out.println("hhhhhhhhhhhhhhhhhhhhhhhh");
		Locale locale = new Locale(language);
		localeResolver.setLocale(request, response, locale);
		return "redirect:/index.jsp";
	}
	
	public void setLocaleResolver(LocaleResolver localeResolver) {
		this.localeResolver = localeResolver;
	}

}
*/