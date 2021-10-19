package com.finalproject.itda.vo;

public class MatchingVO {
	private int board_seq;
	private String board_select;
	private String board_subject;
	private String b_content;
	private String m_userid;
	private String m_nickname;
	private String Board_writedate;
	private String mc_start_date;
	private String mc_end_date;
	private String mc_where;
	private String m_info;
	private String board_prev_subject;
	private String board_next_subject;
	private String board_prev_select;
	private String board_next_select;
	private int board_prev_seq;
	private int board_next_seq;
	private int mc_state;
	private int mc_max;
	private int board_hit;
	private int b_goodhit;
	private int board_call;
	
	private String tags[];
	private String prevTags[];
	private String nextTags[];
	
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public String getBoard_select() {
		return board_select;
	}
	public void setBoard_select(String board_select) {
		this.board_select = board_select;
		tags=board_select.split("/");
	}
	public String getBoard_subject() {
		return board_subject;
	}
	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getM_userid() {
		return m_userid;
	}
	public void setM_userid(String m_userid) {
		this.m_userid = m_userid;
	}
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	public String getBoard_writedate() {
		return Board_writedate;
	}
	public void setBoard_writedate(String board_writedate) {
		Board_writedate = board_writedate;
	}
	public String getMc_start_date() {
		return mc_start_date;
	}
	public void setMc_start_date(String mc_start_date) {
		this.mc_start_date = mc_start_date;
	}
	public String getMc_end_date() {
		return mc_end_date;
	}
	public void setMc_end_date(String mc_end_date) {
		this.mc_end_date = mc_end_date;
	}
	public String getMc_where() {
		return mc_where;
	}
	public void setMc_where(String mc_where) {
		this.mc_where = mc_where;
	}
	public String getM_info() {
		return m_info;
	}
	public void setM_info(String m_info) {
		this.m_info = m_info;
	}
	public String getBoard_prev_subject() {
		return board_prev_subject;
	}
	public void setBoard_prev_subject(String board_prev_subject) {
		this.board_prev_subject = board_prev_subject;
	}
	public String getBoard_next_subject() {
		return board_next_subject;
	}
	public void setBoard_next_subject(String board_next_subject) {
		this.board_next_subject = board_next_subject;
	}
	public String getBoard_prev_select() {
		return board_prev_select;
	}
	public void setBoard_prev_select(String board_prev_select) {
		this.board_prev_select = board_prev_select;
		prevTags=board_prev_select.split("/");
	}
	public String getBoard_next_select() {
		return board_next_select;
	}
	public void setBoard_next_select(String board_next_select) {
		this.board_next_select = board_next_select;
		nextTags=board_next_select.split("/");
	}
	public int getBoard_prev_seq() {
		return board_prev_seq;
	}
	public void setBoard_prev_seq(int board_prev_seq) {
		this.board_prev_seq = board_prev_seq;
	}
	public int getBoard_next_seq() {
		return board_next_seq;
	}
	public void setBoard_next_seq(int board_next_seq) {
		this.board_next_seq = board_next_seq;
	}
	public int getMc_state() {
		return mc_state;
	}
	public void setMc_state(int mc_state) {
		this.mc_state = mc_state;
	}
	public int getMc_max() {
		return mc_max;
	}
	public void setMc_max(int mc_max) {
		this.mc_max = mc_max;
	}
	public int getBoard_hit() {
		return board_hit;
	}
	public void setBoard_hit(int board_hit) {
		this.board_hit = board_hit;
	}
	public int getB_goodhit() {
		return b_goodhit;
	}
	public void setB_goodhit(int b_goodhit) {
		this.b_goodhit = b_goodhit;
	}
	public int getBoard_call() {
		return board_call;
	}
	public void setBoard_call(int board_call) {
		this.board_call = board_call;
	}
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	public String[] getPrevTags() {
		return prevTags;
	}
	public void setPrevTags(String[] prevTags) {
		this.prevTags = prevTags;
	}
	public String[] getNextTags() {
		return nextTags;
	}
	public void setNextTags(String[] nextTags) {
		this.nextTags = nextTags;
	}
}