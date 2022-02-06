package com.bitcamp.seoul.board;

import java.util.ArrayList;
import java.util.List;

import com.bitcamp.seoul.DBConnection;

public class BoardDAO extends DBConnection implements BoardDAOImpl {

	@Override
	public void totalRecordCount(PagingVO pVo) {
		try {
			dbConn();
			sql = "select count(no) from board ";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				pVo.setTotalRecord(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	@Override
	public List<BoardVO> boardPageSelect(PagingVO pVo) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			dbConn();
			sql = "select * from " + " (select * from "
					+ " (select no, subject, board.userid, register.username, hit, to_char(writedate, 'YYYY.MM.DD') writedate from board join register on board.userid=register.userid"
					+ " order by no desc) "
					+ " where rownum<=? order by no asc) "
					+ " where rownum<=? order by no desc";

			pstmt = con.prepareStatement(sql);
			// ���������� ���ڵ� ��*���� ������
			pstmt.setInt(1, pVo.getOnePageRecord() * pVo.getNowPage());
			// ���������� ���ڵ� ��
			// ���� ���ڵ� ��
			int lastPageRecord = pVo.getTotalRecord() % pVo.getOnePageRecord(); // 2
			if (pVo.getTotalPage() == pVo.getNowPage() && lastPageRecord != 0) { // ������������ ������������ ������? ������������!
				pstmt.setInt(2, lastPageRecord); // 1,2,3,4

			} else {
				pstmt.setInt(2, pVo.getOnePageRecord()); // 5
			}

			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setUserid(rs.getString(3));
				vo.setUsername(rs.getString(4));
				vo.setHit(rs.getInt(5));
				vo.setWritedate(rs.getString(6));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}

}

