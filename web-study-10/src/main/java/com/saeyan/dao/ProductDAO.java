package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.ProductVO;

import util.DBManager;

public class ProductDAO {

	
	private static ProductDAO instance = new ProductDAO();
	
	private ProductDAO() {
	}
	
	public static ProductDAO getInstance() {
		return instance;
	}
	
	public List<ProductVO> selectallProducts() {
		
		String sql = "select * from product order by code desc";
		
		List<ProductVO> list = new ArrayList<ProductVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null; //sql문 전송
		ResultSet rs = null; //실행 및 결과값 받기
							
		try {
			
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 	// 결과값으로 얻어진 여러 개의 로우를 모두 출력하기 위해서는
								//ResultSet 객체로 레코드 단위로 이동하는 next() 메소드를 사용해야함
								//while문과 함께 사용
								//결과값으로 얻어진 모든 행에 접근하기 위해 while 사용
				ProductVO vo = new ProductVO();
				
				vo.setCode(rs.getInt("code")); // 각 행에서 원하는 컬럼 값을 얻기 위해서 get타입() 메소드 사용
				vo.setName(rs.getString("name"));// get타입()로 쿼리하는 방법은 컬럼 단위이므로
				vo.setPrice(rs.getInt("price")); // get타입()에 출력을 원하는 컬럼명을 기술
				vo.setPictureurl("pictureurl");	 // get타입() 메소드는 컬럽타입에 따라 달라짐
				vo.setDescription(rs.getString("description"));
				
				list.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		return list;
	}
	
	//상품 등록
	public void insertProduct(ProductVO vo) {
			String sql = "insert into product values(product_seq.nextval, ?,?,?,?)";
			Connection con = null;
			PreparedStatement pstmt = null;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql); // 맵핑 ==> "insert into product values(product_seq.nextval, ?,?,?,?)";
			
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getPictureurl());
			pstmt.setString(4, vo.getDescription());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt);
		}
	}
	
	public int confirmID(String userid) {
		return 0;
	}
	
	public int userCheck(String userid, String pwd) {
		return 0;
	}
	
	public ProductVO selectProductByCode(int code) {
		
		String sql = "select * from product where code = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO vo = new ProductVO();
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setCode(rs.getInt("code"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setPictureurl(rs.getString("pictureurl"));
				vo.setDescription(rs.getString("description"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		return vo;
	}
	
	public void updateProduct(ProductVO vo) {
		String sql = "update product set name=?, price=?, pictureurl=?, "
				+ "description=? where code=? ";
		Connection con = null;
		PreparedStatement pstmt = null;
	try {
		con = DBManager.getConnection();
		pstmt = con.prepareStatement(sql); // 맵핑 ==> 
		
		pstmt.setString(1, vo.getName());
		pstmt.setInt(2, vo.getPrice());
		pstmt.setString(3, vo.getPictureurl());
		pstmt.setString(4, vo.getDescription());
		pstmt.setInt(5, vo.getCode());
		
		pstmt.executeUpdate();
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		DBManager.close(con, pstmt);
	}
	}

	public void deleteProduct(int code) {
		String sql = "delete product where code = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt);
		}
	}
}
