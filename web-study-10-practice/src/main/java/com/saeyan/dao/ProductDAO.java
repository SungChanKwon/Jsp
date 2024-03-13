package com.saeyan.dao;

import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.ProductVO;

public class ProductDAO {
	
	private static ProductDAO instance = new ProductDAO();

	private ProductDAO() {}
	
	public static ProductDAO getInstance() {
		return instance;
	}
	
	public List<ProductVO> selectallProducts() {
		
		String sql = "select * from product order by code desc";
		
		List<ProductVO> list = new ArrayList<ProductVO>();
	}
	
	public void insertProduct() {
		
	}
	
	public int confirmID(String userid) {
		return 0;
	}
	
	public int userCheck(String userid, String pwd) {
		return 0;
	}
	
	public ProductVO selectProductByCode() {
		
	}
	
	public void updateProduct() {
		
	}
	
	public void deleteProduct() {
		
	}
}
