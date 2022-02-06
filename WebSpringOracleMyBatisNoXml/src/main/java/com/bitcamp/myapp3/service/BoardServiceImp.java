package com.bitcamp.myapp3.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bitcamp.myapp3.dao.BoardDAO;
import com.bitcamp.myapp3.vo.BoardVO;

@Service
public class BoardServiceImp implements BoardService {
	@Inject
	BoardDAO boardDAO;

	@Override
	public List<BoardVO> boardList() {
		return boardDAO.boardList();
	}

	@Override
	public BoardVO boardView(int no) {
		return boardDAO.boardView(no);
	}

	@Override
	public int boardInsert(BoardVO vo) {
		return boardDAO.boardInsert(vo);
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		return boardDAO.boardUpdate(vo);
	}

	@Override
	public int boardDelete(int no, String userid) {
		return boardDAO.boardDelete(no, userid);
	}

	@Override
	public int boardDelArray(int[] noDelArray) {
		return boardDAO.boardDelArray(noDelArray);
	}

	@Override
	public int boardDelList(List<Integer> noDelList) {
		return boardDAO.boardDelList(noDelList);
	}
}
