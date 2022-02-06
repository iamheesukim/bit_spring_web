package com.bitcamp.myapp.dao;

import java.util.List;

import com.bitcamp.myapp.vo.BoardVO;

public interface BoardDAO {
	//서비스에도 그대로 복붙

	public List<BoardVO> boardAllSelect();
	public int boardWrite(BoardVO vo);
	public BoardVO boardView(int no);
	public int boardEdit(BoardVO vo);
	public int boardDel(int no, String userid);
}
