package com.bitcamp.seoul.board;

import java.util.List;

public interface BoardDAOImpl {
	// �� ���ڵ� ��
	public void totalRecordCount(PagingVO pVo);

	// �ش������� ���ڵ� ����
	public List<BoardVO> boardPageSelect(PagingVO pVO);

}
