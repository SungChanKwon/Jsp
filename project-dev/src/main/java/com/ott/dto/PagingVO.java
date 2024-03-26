package com.ott.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PagingVO {
	
	private int page;
	private int limit;
	private int listCount;
	private int startPage;
	private int endPage;
	private boolean prev, next;
	private int realEnd;
	public PagingVO() {}
		
	public PagingVO(int page, int limit,int listCount) {
		this.page = page;
		this.limit = limit;
		this.listCount = listCount;
		realEnd = (int)Math.ceil(listCount/(double)limit);
		startPage = ((int)(((double)page/limit+0.9))-1)*limit+1;
		endPage =(int)Math.ceil(page*0.1)*10;
		
		
		if(endPage > realEnd) {
			endPage = realEnd;
		}
	
		prev = startPage > 1;
		next = endPage < realEnd ;
	}
}
