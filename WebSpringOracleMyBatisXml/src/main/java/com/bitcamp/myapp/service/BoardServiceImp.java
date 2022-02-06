package com.bitcamp.myapp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bitcamp.myapp.dao.BoardDAO;
import com.bitcamp.myapp.vo.BoardVO;
@Service
public class BoardServiceImp implements BoardService{
	
	@Inject
	BoardDAO boardDAO;

	@Override
	public List<BoardVO> boardAllSelect() {
		return boardDAO.boardAllSelect();
	}

	@Override
	public int boardWrite(BoardVO vo) {
		return boardDAO.boardWrite(vo);
	}

	@Override
	public BoardVO boardView(int no) {
		return boardDAO.boardView(no);
	}

	@Override
	public int boardEdit(BoardVO vo) {
		return boardDAO.boardEdit(vo);
	}

	@Override
	public int boardDel(int no, String userid) {
		return boardDAO.boardDel(no, userid);
	}

}
