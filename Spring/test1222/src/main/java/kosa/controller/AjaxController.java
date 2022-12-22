package kosa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kosa.service.EmpService;
import kosa.vo.Emp;

// @Controller + 함수 (@ResponseBody)
@RestController
@RequestMapping("/emp")
public class AjaxController {

	private EmpService empservice;

	@Autowired
	public void setEmpService(EmpService empservice) {
		this.empservice = empservice;
	}

	// 전체 조회
	  @RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<List<Emp>> empList() {
		List<Emp> list = new ArrayList<Emp>();

		try {
			System.out.println("정상 실행");
			list = empservice.allList();
			return new ResponseEntity<List<Emp>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Emp>>(list, HttpStatus.BAD_REQUEST);
		}
	}

	// 검색 보기
	@GetMapping("{keyword}")
	public List<Emp> search(@PathVariable("keyword") int keyword) {
		List<Emp> list = empservice.searchList(keyword);
		return list;
	}

	// 사원 삽입
	@PostMapping("")
	public ResponseEntity<List<Emp>> insert(@RequestBody Emp emp) {
		List<Emp> list = null;
		try {
			empservice.insert(emp);
			list = empservice.allList();
			return new ResponseEntity<List<Emp>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Emp>>(list, HttpStatus.BAD_REQUEST);
		}
	}

	// 수정
	@PutMapping("")
	public ResponseEntity<List<Emp>> update(@RequestBody Emp emp) {
		List<Emp> list = null;
		try {
			empservice.empEdit(emp);
			list = empservice.allList();
			return new ResponseEntity<List<Emp>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Emp>>(list, HttpStatus.BAD_REQUEST);
		}
	}

	// 삭제
	@DeleteMapping("{keyword}")
	public ResponseEntity<String> delete(@PathVariable("keyword") int empno) {
		try {
			empservice.empDel(empno);
			return new ResponseEntity<String>("delete success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("delete fail", HttpStatus.BAD_REQUEST);
		}
	}

	

	

}