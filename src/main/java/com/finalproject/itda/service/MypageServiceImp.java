package com.finalproject.itda.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.finalproject.itda.dao.MypageDAO;
import com.finalproject.itda.vo.BoardCommentVO;
import com.finalproject.itda.vo.BoardVO;
import com.finalproject.itda.vo.MemberVO;
import com.finalproject.itda.vo.QuestionVO;

@Service
public class MypageServiceImp implements MypageService {
	@Inject
	MypageDAO mypageDao;
	//���������� ���� �ѷ��ִ°� ���ǿ��� �����;��� ������
	/*
	 * @Override public MemberVO editMyInfo(MemberVO vo) { return
	 * mypageDao.editMyInfo(vo); }
	 */
	//���������� �������� ����Ʈ
	@Override
	public List<BoardVO> mypagePostList() {
		return  mypageDao.mypagePostList();
	}
	//��������� �Ѹ��� ����
	@Override
	public List<BoardCommentVO> myReplyList() {
		
		return null;
	}
	//1:1���� �ۻѸ��鼭 ����
	@Override
	public int QuestionInsert(QuestionVO quesVo) {
		return  mypageDao.QuestionInsert(quesVo);
	}
	//1:1���� 
	@Override
	public List<QuestionVO> MypageQnA() {
		return  mypageDao.MypageQnA();
	}


}
