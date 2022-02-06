package com.bitcamp.myapp.register;

import java.util.ArrayList;
import java.util.List;

import com.bitcamp.myapp.DBConnection;

public class RegisterDAO extends DBConnection implements RegisterDAOImpl {

	@Override
	public int insertRecord(RegisterVO vo) {
		int cnt = 0;
		try {
			dbConn();
			sql = "insert into register(userid, userpwd, username, tel, email, "
					+ "zipcode, addr, addrdetail, hobby) values(?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getUserpwd());
			pstmt.setString(3, vo.getUsername());
			pstmt.setString(4, vo.getTel());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getZipcode());
			pstmt.setString(7, vo.getAddr());
			pstmt.setString(8, vo.getAddrdetail());
			pstmt.setString(9, vo.getHobbyStr()); // 운동/쇼핑 (2개 선택했을 시)

			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	@Override
	public void selectRecord(RegisterVO vo) {
		try {
			dbConn();
			sql = "select userid, username, tel, email, zipcode, addr, addrdetail, hobby from register where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo.setUserid(rs.getString(1));
				vo.setUsername(rs.getString(2));
				vo.setTel(rs.getString(3));
				vo.setEmail(rs.getString(4));
				vo.setZipcode(rs.getString(5));
				vo.setAddr(rs.getString(6));
				vo.setAddrdetail(rs.getString(7));
				vo.setHobbyStr(rs.getString(8));

				System.out.println(vo.getUserid());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	@Override
	public int updateRecord(RegisterVO vo) {
		int cnt = 0;
		try {
			dbConn();
			sql = "update register set tel=?, email=?, zipcode=?, addr=?, addrdetail=?, hobby=? where userid=? and userpwd=?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, vo.getTel());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getZipcode());
			pstmt.setString(4, vo.getAddr());
			pstmt.setString(5, vo.getAddrdetail());
			pstmt.setString(6, vo.getHobbyStr());

			pstmt.setString(7, vo.getUserid());
			pstmt.setString(8, vo.getUserpwd());

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

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

	@Override
	public int idDoubleCheck(String userid) {
		int cnt = 0;
		try {
			sql = "select count(userid) from register where userid=?";
			dbConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	@Override
	public List<ZipCodeVO> zipSearchRecord(String doro) {
		List<ZipCodeVO> list = new ArrayList<ZipCodeVO>();
		try {
			dbConn();
			sql = "select zipcode, sido, sigungu, doro, num1, num2, build, dong " + "from zipcodetbl where doro like ?"; // '%이어도로%'
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + doro + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ZipCodeVO vo = new ZipCodeVO();
				vo.setZipcode(rs.getString(1));
				vo.setSido(rs.getString(2));
				vo.setSigungu(rs.getString(3));
				vo.setDoro(rs.getString(4));
				vo.setNum1(rs.getInt(5));
				vo.setNum2(rs.getInt(6));
				vo.setBuild(rs.getString(7));
				vo.setDong(rs.getString(8));
				String zipcodeFull = vo.getZipcode() + " " + vo.getSido() + " " + vo.getSigungu() + " " + vo.getDoro()
						+ " " + vo.getNum1();
				if (vo.getNum2() != 0)
					zipcodeFull += "-" + vo.getNum2();
				if (vo.getBuild() != null)
					zipcodeFull += " " + vo.getBuild();
				zipcodeFull += " (" + vo.getDong() + ")";

				vo.setZipcodeFull(zipcodeFull);
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
