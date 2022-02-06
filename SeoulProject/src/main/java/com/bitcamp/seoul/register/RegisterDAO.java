package com.bitcamp.seoul.register;

import com.bitcamp.seoul.DBConnection;


public class RegisterDAO extends DBConnection implements RegisterDAOImpl {

	@Override
	public void loginSelect(RegisterVO vo) {
		try {
			dbConn();
			sql = "select userid, username from register where userid=? and userpwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getUserpwd());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo.setUserid(rs.getString(1));
				vo.setUsername(rs.getString(2));
				vo.setLogStatus("Y");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}


}
