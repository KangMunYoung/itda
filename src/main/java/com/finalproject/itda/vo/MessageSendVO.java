package com.finalproject.itda.vo;

public class MessageSendVO {
	private int msg_seq; // 보낸 메세지 코드
	private String msg_writedate; //쪽지보낸시간
	private String msg_content; //쪽지내용
	private int m_seq1; //보낸사람(회원번호)
	private int m_seq2; //받는사람
	
	private int m_seq;
	private String m_nickname;
	
	
	public int getMsg_seq() {
		return msg_seq;
	}
	public void setMsg_seq(int msg_seq) {
		this.msg_seq = msg_seq;
	}
	public String getMsg_writedate() {
		return msg_writedate;
	}
	public void setMsg_writedate(String msg_writedate) {
		this.msg_writedate = msg_writedate;
	}
	public String getMsg_content() {
		return msg_content;
	}
	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}
	public int getM_seq1() {
		return m_seq1;
	}
	public void setM_seq1(int m_seq1) {
		this.m_seq1 = m_seq1;
	}
	public int getM_seq2() {
		return m_seq2;
	}
	public void setM_seq2(int m_seq2) {
		this.m_seq2 = m_seq2;
	}
	public int getM_seq() {
		return m_seq;
	}
	public void setM_seq(int m_seq) {
		this.m_seq = m_seq;
	}
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	} 
	
	
	
	
	
	
	
}
