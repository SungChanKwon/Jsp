package com.saeyan.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * name VARCHAR2(30),
userid VARCHAR2(20) PRIMARY key,
pwd VARCHAR2(20),
email VARCHAR2(30),
phone CHAR(13),
admin number(1)
 */

@Setter
@Getter
@ToString
public class MemberVO {
	
	
	
	String name;
	String userid;
	String pwd;
	String email;
	String phone;
	int admin;
	
}
