package com.ott.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ott.dto.BulletinVO;
import com.ott.dto.ContentVO;

import util.DBManager;

public class BulletinDAO {

	private static BulletinDAO instance = new BulletinDAO();

	public BulletinDAO() {
	}

	public static BulletinDAO getInstance() {
		return instance;
	}

	public void insertBulletin(BulletinVO bVo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "insert into bulletin(bulletinNum, name, userId, bulletinTitle, bulletinContent) values(bulletin_seq.nextval, ?, ?, ?, ?)";

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);

//			pstmt.setInt(1, bVo.getBulletinNum());
			pstmt.setString(1, bVo.getName());
			pstmt.setString(2, bVo.getUserId());
			pstmt.setString(3, bVo.getBulletinTitle());
			pstmt.setString(4, bVo.getBulletinContent());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
	}

	public void updateBulletin(BulletinVO bVo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "update bulletin set name=?, bulletinTitle=?, bulletinContent=? where bulletinNum = ?";

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql); // sql문 전송, 맵핑

			pstmt.setString(1, bVo.getName());
			pstmt.setString(2, bVo.getBulletinTitle());
			pstmt.setString(3, bVo.getBulletinContent());
			pstmt.setInt(4, bVo.getBulletinNum());

			pstmt.executeUpdate();// sql문 실행

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
	}

	public void deleteBulletin(int BulletinNum) {

		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "delete from bulletin where bulletinNum=?";

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, BulletinNum);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
	}

	public List<BulletinVO> getAllBulletin(int page, int limit) {

		List<BulletinVO> list = new ArrayList<BulletinVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from (select rownum rn, a.* "
				+ "from (select * from bulletin order by bulletinNum desc) a ) " + "where rn >= ? and rn <= ?";

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql); // sql문 전송

			int startrow = (page - 1) * limit + 1; // 게시글 첫 행 번호
			int endrow = startrow + limit - 1; // 게시글 마지막 행 번호

			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);

			rs = pstmt.executeQuery(); // sql문 실행 후 결과값 얻어오기

			while (rs.next()) {
				BulletinVO bVo = new BulletinVO();

				bVo.setBulletinNum(rs.getInt("bulletinNum"));
				bVo.setUserId(rs.getString("userId"));
				bVo.setName(rs.getString("name"));
				bVo.setBulletinTitle(rs.getString("bulletinTitle"));
				bVo.setBulletinDate(rs.getTimestamp("bulletinDate"));
				bVo.setBulletinContent(rs.getString("bulletinContent"));
				bVo.setReadCount(rs.getInt("readCount"));

				list.add(bVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return list;
	}

	public int getListCount() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select count(*) from bulletin";

		int count = 0;

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return count;
	}

	public BulletinVO selectOneBulletinByNum(int bulletinNum) {

		BulletinVO bVo = new BulletinVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from bulletin where bulletinNum=?";

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql); // sql문 전송
			pstmt.setInt(1, bulletinNum); // 맵핑
			rs = pstmt.executeQuery(); // sql문 실행 후 결과값 얻어오기

			while (rs.next()) {

				bVo.setBulletinNum(rs.getInt("bulletinNum"));
				bVo.setName(rs.getString("name"));
				bVo.setBulletinDate(rs.getTimestamp("bulletinDate"));
				bVo.setReadCount(rs.getInt("readCount"));
				bVo.setBulletinTitle(rs.getString("bulletinTitle"));
				bVo.setBulletinContent(rs.getString("bulletinContent"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return bVo;
	}

	public void updateReadCount(int BulletinNum) {

		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "update bulletin set readcount = readcount+1 where bulletinNum=?";

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, BulletinNum);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}

	}

	public List<BulletinVO> getAllBulletinList(int page, int limit) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from (select rownum rnum, bulletinNum " + ", userId, name, bulletinTitle, bulletinDate, "
				+ " bulletinContent, readCount from " + "(select * from bulletin order by bulletinNum desc)) "
				+ "where rnum >= ? and rnum <=?";

		List<BulletinVO> list = new ArrayList<BulletinVO>();

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);

			int startrow = (page - 1) * limit + 1;
			int endrow = startrow + limit - 1;

			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BulletinVO vo = new BulletinVO();

				vo.setBulletinNum(rs.getInt("bulletinNum"));
				vo.setUserId(rs.getString("userId"));
				vo.setName(rs.getString("name"));
				vo.setBulletinTitle(rs.getString("bulletinTitle"));
				vo.setBulletinDate(rs.getTimestamp("bulletinDate"));
				vo.setBulletinContent(rs.getString("bulletinContent"));
				vo.setReadCount(rs.getInt("readCount"));

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return list;
	}

	public List<BulletinVO> getAllBulletin() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<BulletinVO> list = new ArrayList<BulletinVO>();

		String sql = "select * from bulletin order by bulletinNum desc";

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BulletinVO vo = new BulletinVO();

				vo.setBulletinNum(rs.getInt("bulletinNum"));
				vo.setUserId(rs.getString("userId"));
				vo.setName(rs.getString("name"));
				vo.setBulletinTitle(rs.getString("bulletinTitle"));
				vo.setBulletinDate(rs.getTimestamp("bulletinDate"));
				vo.setBulletinContent(rs.getString("bulletinContent"));
				vo.setReadCount(rs.getInt("readCount"));

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return list;

	}

	public BulletinVO getOneBulletin(int bulletinNum) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from bulletin where bulletinNum = ?";
		BulletinVO vo = new BulletinVO();

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bulletinNum);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				vo.setBulletinNum(rs.getInt("bulletinNum"));
				vo.setUserId(rs.getString("userId"));
				vo.setName(rs.getString("name"));
				vo.setBulletinTitle(rs.getString("bulletinTitle"));
				vo.setBulletinDate(rs.getTimestamp("bulletinDate"));
				vo.setBulletinContent(rs.getString("bulletinContent"));
				vo.setReadCount(rs.getInt("readCount"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return vo;

	}
}
