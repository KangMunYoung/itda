package com.finalproject.itda.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.finalproject.itda.dao.BoardDAO;
import com.finalproject.itda.vo.BoardVO;
import com.finalproject.itda.vo.Board_CommentVO;
import com.finalproject.itda.vo.PagingVO;

@Service
public class BoardServiceImp implements BoardService {
	
	@Inject
	BoardDAO boardDAO;
	
	//리스트 목록 
	@Override
	public List<BoardVO> boardList(PagingVO pVo) {
		return boardDAO.boardList(pVo);
	}
	
	//검색
	@Override
	public PagingVO totalRecordCount(PagingVO pVo) {
		return boardDAO.totalRecordCount(pVo);
	}
	
	//글쓰기
	@Override
	public int freeboardWrite(BoardVO vo) {
		return boardDAO.freeboardWrite(vo);
	}
	
	//글내용보기 
	@Override
	public BoardVO freeView(int board_seq) {
		return boardDAO.freeView(board_seq);
	}
	
	//수정
	@Override
	public int freeUpdate(BoardVO vo) {
		return boardDAO.freeUpdate(vo);
	}
	//삭제
	@Override
	public int freeDelete(int board_seq, String m_userid) {
		return boardDAO.freeDelete(board_seq, m_userid);
	}

	//댓글리스트 

	@Override
	public List<Board_CommentVO> commentList(int board_seq) {
		return boardDAO.commentList(board_seq);
	}

	

	 

}