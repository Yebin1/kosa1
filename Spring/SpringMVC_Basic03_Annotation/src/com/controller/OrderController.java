package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.OrderCommand;

/*
하나의 요청 주소로 두 개의 업무 처리가 가능
/order/order.do

GET > 화면
POST > 처리 

*/

@Controller
@RequestMapping("/order/order.do")
public class OrderController {
	
	@GetMapping
	public String form() {
		return "order/OrderForm";
	}
	
	@PostMapping
	public String submit(OrderCommand ordercommand) {
		
		/*
		자동화된 코드
		
		1. OrderCommand ordercommand = new OrderCommand();
		1.1. 자동 매핑 >> member field >> private List<OrderItem> orderItem 자동 주입
		
		2. List<OrderItem> itemlist = new ArrayList<>();
		 	>>> orderItem[0].itemid
		 	>>> orderItem[0].number
		 	>>> orderItem[0].remark
		 	itemlist.add(new OrderItem(1, 10, "주의사항"));
		 	...
		 	ordercommand.setOrderItem(itemlist);
		 	
		key값 view >> OrderCommand >> orderCommand
		mv.addObject("orderCommand", ordercommand);
		mv.setViewName("order/OrderCommitted");
		*/
		
		return "order/OrderCommitted";
	}

}
