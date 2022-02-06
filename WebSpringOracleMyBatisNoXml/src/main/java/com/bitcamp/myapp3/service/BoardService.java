package com.bitcamp.myapp3.service;

import java.util.List;

import com.bitcamp.myapp3.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> boardList();
	public BoardVO boardView(int no);
	public int boardInsert(BoardVO vo);
	public int boardUpdate(BoardVO vo);
	public int boardDelete(int no, String userid);
	public int boardDelArray(int[] noDelArray);
	public int boardDelList(List<Integer> noDelList);
}
