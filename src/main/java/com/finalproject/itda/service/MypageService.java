package com.finalproject.itda.service;

import java.util.List;

import com.finalproject.itda.vo.BoardCommentVO;
import com.finalproject.itda.vo.BoardVO;
import com.finalproject.itda.vo.MemberVO;
import com.finalproject.itda.vo.QuestionVO;

public interface MypageService {
	/*
	 * //���������� ����� ���� ��������� public MemberVO editMyInfo(MemberVO vo);
	 */ 
	
	//���������� �������� ����Ʈ
	public List<BoardVO> mypagePostList();
	
	//��������� �Ѹ��� ����
	public List<BoardCommentVO>myReplyList();
	
	//1:1���� 
	public int QuestionInsert(QuestionVO quesVo);
	
	//1:1���� �ۻѸ��鼭 ����
	public List<QuestionVO> MypageQnA();
	
	
	
}
