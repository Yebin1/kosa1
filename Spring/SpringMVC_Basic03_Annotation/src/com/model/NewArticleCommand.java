package com.model;

import lombok.Data;

// DB에 Article 테이블이 있으며 1:1 매핑을 가정
@Data
public class NewArticleCommand {

	private int parentId;
	private String title;
	private String content;

}
