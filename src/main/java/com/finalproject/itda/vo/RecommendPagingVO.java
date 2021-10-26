package com.finalproject.itda.vo;

public class RecommendPagingVO {
	private int totalRecord;
	private int nowPage = 1;
	private int totalPage;
	private int onePageRecord = 5;
	
	// �˻���
	private String searchKey;
	private String searchWord;
	private String tagStr;
	private String tag[];
	private String selectedDate;
	
	// ������
	private int onePageNumCount = 5;
	private int startPage = 1;
	
	// ���Ĺ��
	private String frequency;
	private String listup;
	private int lastPage;
	
	
	
	
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
		lastPage = totalRecord % onePageRecord;
		System.out.println("lastPage=======>"+lastPage);
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		//총페이지수
		totalPage = (int)Math.ceil(totalRecord/(double)onePageRecord);
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
		
		if(nowPage != 0) {
			startPage = (nowPage - 1) / onePageNumCount * onePageNumCount + 1;
		}
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getOnePageRecord() {
		return onePageRecord;
	}
	public void setOnePageRecord(int onePageRecord) {
		this.onePageRecord = onePageRecord;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public String getTagStr() {
		return tagStr;
	}
	public void setTagStr(String tagStr) {
		this.tagStr = tagStr;
	}
	public String[] getTag() {
		return tag;
	}
	public void setTag(String[] tag) {
		this.tag = tag;
	}
	public String getSelectedDate() {
		return selectedDate;
	}
	public void setSelectedDate(String selectedDate) {
		this.selectedDate = selectedDate;
	}
	public int getOnePageNumCount() {
		return onePageNumCount;
	}
	public void setOnePageNumCount(int onePageNumCount) {
		this.onePageNumCount = onePageNumCount;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getListup() {
		return listup;
	}
	public void setListup(String listup) {
		this.listup = listup;
	}
	
	
	
}
