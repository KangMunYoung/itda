package com.finalproject.itda.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.finalproject.itda.vo.BoardCommentVO;
import com.finalproject.itda.vo.BoardVO;
import com.finalproject.itda.vo.MemberBaseVO;
import com.finalproject.itda.vo.MessageSendVO;
import com.finalproject.itda.vo.QuestionVO;

public interface MypageDAO {
	
	//내정보수정 정보가지고오기
	/*
	 * @Select("select m_userid, m_email, m_nickname, m_tel, m_addr, m_birth, m_username, m_info, m_tag "
	 * + " from memberbase where m_seq=1") public MemberBaseVO editMyInfo(MemberBaseVO vo);
	 */
	//내가쓴글
	@Select("select bc.board_content, b.board_subject, to_char(b.board_writedate, 'YYYY-MM-DD'), b.board_hit, count(br.br_id) br_count "
			+ " from boardbase b full outer join board_code bc on b.board_code=bc.board_code "
			+ " join board_comment br on b.m_seq=br.m_seq where br.m_seq=#{m_seq} "
			+ " group by bc.board_content, b.board_subject, b.board_writedate, b.board_hit")
	public List<BoardVO> mypagePostList(MemberBaseVO vo);
	
	//내가 쓴 댓글
	@Select("select bc.br_id, b.board_subject, bc.board_seq, m.m_nickname, bc.br_content, to_char(bc.br_writedate, 'YYYY-MM-DD') br_writedate "
			+ " from board_comment bc join boardbase b on bc.board_seq=b.board_seq "
			+ " join memberbase m on m.m_seq=bc.m_seq where m.m_seq=#{m_seq}")
	public List<BoardCommentVO>myReplyList(MemberBaseVO vo);
	
	//1:1문의는 글을 뿌리면서 시작합니다.
	@Select("select q_number, q_title, q_date, q_category, m_seq, q_result_state,q_result from question where m_seq=2 order by q_date desc")
	public List<QuestionVO> MypageQnA(int seq);
	
	
	//1:1문의는 글을 뿌리면서 시작합니다.
		@Select("select q_number, q_title, q_date, q_category, m_seq, q_result_state,q_result from question where m_seq=${param1} order by q_date desc")
		public List<QuestionVO> MypageQnaList(int seq);
		//1:1문의는 글을 뿌리면서 시작합니다.
	
		
		
	//1:1문의 글 써봅니다.
	@Insert("insert into question(q_number, q_category, q_title, m_seq) "
			+ " values(q_number_seq.nextval, #{q_category}, #{q_title}, #{m_seq})")
	public int QuestionInsert(QuestionVO quesVo);
	
	//받은쪽지함 
	@Select("select m_nickname, msg_content, to_char(msg_writedate, 'YYYY-MM-DD') msg_writedate from messagesend ms join memberbase mb on ms.m_seq2= mb.m_seq where m_seq1=${m_seq}")
	public List<MessageSendVO> mypageMsg(MessageSendVO msVo);
	
	
	//select mb.m_nickname, ms.m_seq1, ms.m_seq2, ms.msg_content, to_char(ms.msg_writedate, 'YYYY-MM-DD') msg_writedate from messagesend ms join memberbase mb on ms.m_seq1= mb.m_seq where m_seq1=(select m_seq from memberbase where m_seq=${m_seq})")
//	@Select("select ms.m_seq2, ms.msg_content, to_char(ms.msg_writedate, 'YYYY-MM-DD') msg_writedate from messagesend ms join memberbase mb on ms.m_seq1= mb.m_seq where m_seq1=(select m_seq from memberbase where m_seq=${m_seq})")
	//보낸쪽지함
	 @Select("select m_nickname, msg_content, to_char(msg_writedate, 'YYYY-MM-DD') msg_writedate "
	 		+ " from messagesend ms join memberbase mb "
	 		+ " on ms.m_seq1= mb.m_seq where m_seq2=${m_seq}")
	 public List<MessageSendVO> mypageMsgsend(MessageSendVO msVo);
	 
	 
	 
}