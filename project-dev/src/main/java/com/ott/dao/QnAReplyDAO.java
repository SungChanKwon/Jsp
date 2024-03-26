package com.ott.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ott.dto.QnAReplyVO;

import util.DBManager;

public class QnAReplyDAO {

	private static QnAReplyDAO instance = new QnAReplyDAO();
	
	private QnAReplyDAO() {
		
	}
	
	public static QnAReplyDAO getInstance() {
		return instance;
	}
	
	public QnAReplyVO getOneQnAReply(int qnaNum) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from qnaReply where qnaNum = ?";
		
		QnAReplyVO vo = new QnAReplyVO();
		try {
			
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,qnaNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				vo.setReplyContent(rs.getString("replyContent"));
				vo.setReplyRegiDate(rs.getTimestamp("replyRegiDate"));
				vo.setReplyNum(rs.getInt("qnaReplyNum"));
				
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		return vo;
	}
	
	public void insertQnAReply() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into qnaReply values(?,?,sysdate,?)";
		
		try {
			
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			
			
			QnAReplyVO vo = new QnAReplyVO();
			
			pstmt.setInt(1, vo.getReplyNum());
			pstmt.setString(2, vo.getReplyContent());
			pstmt.setInt(3, vo.getQnaNum());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt);
		}
		
	}

	
	
	
	
}
