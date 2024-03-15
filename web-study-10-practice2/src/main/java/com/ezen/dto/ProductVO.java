package com.ezen.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * create table product(
    code number(5) primary key,
    name varchar2(100) not null,
    price number(8) not null,
    pictureurl varchar2(50),
    description varchar2(1000)
);
 */


@Setter
@Getter
@ToString
public class ProductVO {
	private int code;
	private String name;
	private int price;
	private String pictureUrl;
	private String description; 
}
