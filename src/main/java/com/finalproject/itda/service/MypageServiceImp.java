package com.finalproject.itda.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.finalproject.itda.dao.MypageDAO;
import com.finalproject.itda.vo.BoardCommentVO;
import com.finalproject.itda.vo.BoardVO;
import com.finalproject.itda.vo.MemberBaseVO;
import com.finalproject.itda.vo.QuestionVO;

@Service
public class MypageServiceImp implements MypageService {
	@Inject
	MypageDAO mypageDao;
	//마이페이지 내글 뿌려주는건 세션에서 가져와야함 ㅇㅅㅇ
	/*
	 * @Override public MemberBaseVO editMyInfo(MemberBaseVO vo) { return
	 * mypageDao.editMyInfo(vo); }
	 */
	//마이페이지 내가쓴글 리스트
	@Override
	public List<BoardVO> mypagePostList(MemberBaseVO vo) {
		return  mypageDao.mypagePostList(vo);
	}
	//내가쓴댓글 뿌리고 시작
	@Override
	public List<BoardCommentVO> mypageReplyList(MemberBaseVO vo) {
		return mypageDao.myReplyList(vo);
	}
	
	//1:1문의 글뿌리면서 시작
	@Override
	public int QuestionInsert(QuestionVO quesVo) {
		return  mypageDao.QuestionInsert(quesVo);
	}
	//1:1문의 
	@Override
	public List<QuestionVO> MypageQnA(int seq) {
		return  mypageDao.MypageQnA(seq);
	}
	
	public List<QuestionVO> MypageQnaList(int seq) {
		return  mypageDao.MypageQnaList(seq);
	}
}
