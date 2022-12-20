package ncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MemberController {

	// 마이페이지
	@GetMapping("mypage.htm")
	public String myPage() {
		return "mypage/mypage";
	}
	
	
}
