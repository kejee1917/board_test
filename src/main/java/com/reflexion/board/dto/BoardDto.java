package com.reflexion.board.dto;

public class BoardDto {

	private int num;		//번호(PK)
	private String title;	//제목
	private String content;	//내용
	private String writer;	//작성자
	private int view_cnt;	//조회수
	private String reg_dt;	//작성일
	
	private int num_pre;
	private int num_next;
	private String title_pre;
	private String title_next;
	
	public BoardDto() {
	}

	public BoardDto(int num, String title, String content, String writer, int view_cnt, String reg_dt) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.view_cnt = view_cnt;
		this.reg_dt = reg_dt;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getView_cnt() {
		return view_cnt;
	}

	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}

	public String getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}

	public int getNum_pre() {
		return num_pre;
	}

	public void setNum_pre(int num_pre) {
		this.num_pre = num_pre;
	}

	public int getNum_next() {
		return num_next;
	}

	public void setNum_next(int num_next) {
		this.num_next = num_next;
	}

	
	public String getTitle_pre() {
		return title_pre;
	}

	public void setTitle_pre(String title_pre) {
		this.title_pre = title_pre;
	}

	public String getTitle_next() {
		return title_next;
	}

	public void setTitle_next(String title_next) {
		this.title_next = title_next;
	}

	@Override
	public String toString() {
		return "BoardDto [num=" + num + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", view_cnt=" + view_cnt + ", reg_dt=" + reg_dt + ", num_pre=" + num_pre + ", num_next=" + num_next
				+ ", title_pre=" + title_pre + ", title_next=" + title_next + "]";
	}

	
	
	
}
