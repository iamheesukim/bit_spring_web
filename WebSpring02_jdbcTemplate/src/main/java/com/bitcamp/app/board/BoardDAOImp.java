package com.bitcamp.app.board;

import java.util.List;

public interface BoardDAOImp {
   // 리스트 -> 레코드 전체 선택
   public List<BoardVO> allRecord();
   
   // 글 내용 보기, 수정폼으로 이동할 때 -> 레코드 1개 선택
   public BoardVO oneRecord(int no);
   
   // 글 수정하기
   public int boardUpdate(BoardVO vo);
   
   // 글 등록하기
   public int boardInsert(BoardVO vo);
   
   // 글 삭제하기
   public int boardDelete(int no);
   
}