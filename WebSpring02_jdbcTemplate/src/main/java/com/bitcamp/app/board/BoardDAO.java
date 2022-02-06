package com.bitcamp.app.board;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.bitcamp.app.Constants;

public class BoardDAO implements BoardDAOImp {

	public JdbcTemplate template;
	public BoardDAO() {
		template = Constants.template;
	}

	//����Ʈ -> ��ü ���
	@Override
	public List<BoardVO> allRecord() {											//�ݵ�� ���� ���������
		String sql = "select no,subject,userid,hit, to_char(writedate,'MM-DD HH:MI') writedate "
				+" from board order by no desc";

		//template.query(sql, new BeanPropertyRowMapper<BoardVO>(BoardVO.class));

		return template.query(sql, new BeanPropertyRowMapper<BoardVO>(BoardVO.class)); 
	}

	// �� ���� ����, ���������� �̵��� �� -> ���ڵ� 1�� ����
	@Override
    public BoardVO oneRecord(int no) {
       String sql = "select no,subject,userid,content,hit,writedate "
             + " from board where no=?";
       return template.queryForObject(sql, new BeanPropertyRowMapper<BoardVO>(BoardVO.class), no);
    }


	// �� ����
	@Override
	public int boardUpdate(BoardVO vo) {
	      String sql = "update board set  content=?, subject=?"
	            + " where no=?";
	      
	      return template.update(sql, vo.getContent(), vo.getSubject(), vo.getNo());
	   }


	//�� ���
	@Override
	public int boardInsert(final BoardVO vo) {
		String sql="insert into board(no, userid, subject, content, ip) "
				+" values(boardSq.nextval,?,?,?,?)";
		return template.update(sql,new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, vo.getUserid());
				ps.setString(2, vo.getSubject());
				ps.setString(3, vo.getContent());
				ps.setString(4, vo.getIp());

			}
		});

	}

	//�� ����
	@Override
	public int boardDelete(int no) {
		String sql = "delete from board where no=?";

		return template.update(sql,no);
	}

}
