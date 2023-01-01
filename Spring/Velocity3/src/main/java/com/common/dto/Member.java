package com.common.dto;

import java.util.Date;

import lombok.Data;
import lombok.Getter;


@Getter
@Data
public class Member {
	private String userid;
	private String pwd;
	private String name;
	private String gender;
	private String birth;
	private String isLunar;
	private String cphone;
	private String email;
	private String habit;
	private Date regDate;

}
