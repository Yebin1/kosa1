package com.model;

import lombok.Data;

// 상품 테이블이 존재하고 1:1 매핑을 가정
@Data
public class OrderItem {
	
	private int itemid;
	private int number;
	private String remark;

}
