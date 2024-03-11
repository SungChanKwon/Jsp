package com.magic.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * ID     NOT NULL VARCHAR2(10) 
PASS   NOT NULL VARCHAR2(10) 
NAME            VARCHAR2(24) 
LEV             CHAR(1)      
ENTER           DATE         
GENDER          CHAR(1)      
PHONE           VARCHAR2(30) 
 */

@Getter
@Setter
@ToString
//eDao.getMember(id); 에 보내주기 위해서 DB에 있는 값들을 EmployeesVO 클래스에 담아줌
public class EmployeesVO {
	
	String id;
	String pass;
	String name;
	String lev;
	Date enter;
	int gender;
	String phone;
	
}
