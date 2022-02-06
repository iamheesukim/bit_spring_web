package com.bitcamp.myapp.service;

import java.util.List;

import com.bitcamp.myapp.vo.BoardVO;

public interface BoardService {
	
	public List<BoardVO> boardAllSelect();
	public int boardWrite(BoardVO vo);
	public BoardVO boardView(int no);
	public int boardEdit(BoardVO vo);
	public int boardDel(int no, String userid);
}
