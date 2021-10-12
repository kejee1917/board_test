package com.reflexion.board.util;

public class BoardPaging {
	
	private int page;		//현재 페이지번호
    private int perPageNum; //한 페이지당 보여줄 글의 개수
	private String stype;	//검색 유형
	private String sval;	//검색 키워드
	
	
    public BoardPaging(int page, int perPageNum, String stype, String sval) {
		super();
		this.page = page;
		this.perPageNum = perPageNum; 
		this.stype = stype;
		this.sval = sval;
	}
    
    // limit 구문에서 시작 부분에 필요한 값을 반환(mybatis에서 사용)
	public int getPageStart() { //특정 페이지의 게시글 시작 번호
        return (this.page-1)*perPageNum; //0~, 10~, 20~
    }
    
    //최초 세팅
    public BoardPaging() {
        this.page = 1;
        this.perPageNum = 10;
        this.stype = null;
        this.sval = null;
    }
    
    public int getPage() {
        return page;
    }
    
    public void setPage(int page) {
        if(page <= 0) {
            this.page = 1;
        } else {
            this.page = page;
            
        }
    }
    
    public int getPerPageNum() {
        return perPageNum;
    }
    
    public void setPerPageNum(int pageCount) {
        int cnt = this.perPageNum;
        if(pageCount != cnt) {
            this.perPageNum = cnt;
        } else {
            this.perPageNum = pageCount;
        }
    }

    
	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public String getSval() {
		return sval;
	}

	public void setSval(String sval) {
		this.sval = sval;
	}

	@Override
	public String toString() {
		return "BoardPaging [page=" + page + ", perPageNum=" + perPageNum + ", stype=" + stype + ", sval=" + sval + "]";
	}


}
