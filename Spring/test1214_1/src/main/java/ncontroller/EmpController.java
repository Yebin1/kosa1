package ncontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import service.EmpService;

import vo.Emp;

@Controller
@RequestMapping("/customer/")
public class EmpController {
	
	private EmpService empservice;
	
	@Autowired
	public void setEmpservice(EmpService empservice) {
		this.empservice = empservice;
	}

	// 전체 보기
	@RequestMapping("emp.htm")  
	public String notices(Model model) {
		
		List<Emp> list = empservice.allList();		
		model.addAttribute("list", list);  
		return "customer/emp";
	}
	
	// 검색 보기
		@RequestMapping("empSearch.htm")  
		public String search(int keyword, Model model) {
			
			List<Emp> list = empservice.searchList(keyword);		
			model.addAttribute("list", list);  
			return "customer/empSearch";
		}
	
	// 상세 보기
	@RequestMapping("empDetail.htm")
	public String empDetail(int empno, Model model) {
	    
		Emp emp = empservice.empDetail(empno);
		model.addAttribute("emp", emp);
		return "customer/empDetail";
	}
	
	// 사원 삽입
	@GetMapping(value="empReg.htm")
	public String empReg() {
		return "customer/empReg";
	}
	
	// 사원 삽입 처리
	@PostMapping(value="empReg.htm")
	public String insert(Emp emp, HttpServletRequest request) {
		  String url = null;
		  try {
			    url = empservice.insert(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}
	
	// 수정
	@GetMapping(value="empEdit.htm")
	public String empEdit(int empno , Model model) {
		Emp emp = null;
		try {
		      emp =  empservice.empEdit(empno);
		} catch( Exception e) {
				e.printStackTrace();
		} 
		
		model.addAttribute("emp", emp);
		return "customer/empEdit";
	}
	
	// 수정 처리
	@PostMapping(value="empEdit.htm")
	public String empEdit(Emp emp, HttpServletRequest request) {
		 return empservice.empEdit(emp, request);
		
	}
	
	// 삭제
	@RequestMapping("empDel.htm")
	public String noticeDel(int empno) {
		return empservice.empDel(empno);
	}

}





