package com.reflexion.board.util;

public class BoardPageMaker {

	private BoardPaging pag;
	private int totalCount;	//총 글의 개수
	private int startPage;	//현재 페이지 기준으로 시작페이지
	private int endPage;	//현재 페이지 기준으로 끝페이지
	private boolean prev;	//전(버튼 생성 여부)
    private boolean next;	//후(버튼 생성 여부)
	private int pageNumber; //하단에 출력할 페이지넘버

	private int displayPageNum = 10;	// 게시판 화면에서 한번에 보여질 페이지 번호의 개수

	
	public BoardPageMaker() {
	}

	public BoardPageMaker(int totalCount, int startPage, int endPage, int pageNumber, int displayPageNum) {
		super();
		this.totalCount = totalCount;
		this.startPage = startPage;
		this.endPage = endPage;
		this.pageNumber = pageNumber;
		this.displayPageNum = displayPageNum;
	}
	
	public BoardPaging getPag() {
		return pag;
	}
	
	public void setPag(BoardPaging pag) {
		this.pag = pag;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData(); //필드들 값 세팅
	}
	
	//게시글 페이징 처리 계산하는 부분	
    private void calcData() {
        
    	//끝 페이지 번호(현재 페이지 번호 / 화면에 보여질 페이지 번호의 갯수) * 화면에 보여질 페이지 번호의 갯수
        endPage = (int) (Math.ceil(pag.getPage() / (double) displayPageNum) * displayPageNum); //정수 연산의 결과는 정수!
 
        //시작 페이지 번호 = (끝 페이지 번호 - 화면에 보여질 페이지 번호의 갯수) + 1
        startPage = (endPage - displayPageNum) + 1;
        if(startPage <= 0) {
        	startPage = 1;
        }
        
        //마지막 페이지 번호 = 총 게시글 수 / 한 페이지당 보여줄 게시글의 갯수
        int tempEndPage = (int) (Math.ceil(totalCount / (double) pag.getPerPageNum())); //
        if (endPage > tempEndPage) {
            endPage = tempEndPage;
        }
        
        prev = startPage == 1 ? false : true;
        next = endPage * pag.getPerPageNum() < totalCount ? true : false;

    }

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
    public boolean isPrev() {
        return prev;
    }
    
    public void setPrev(boolean prev) {
        this.prev = prev;
    }
    
    public boolean isNext() {
        return next;
    }
    
    public void setNext(boolean next) {
        this.next = next;
    }

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	@Override
	public String toString() {
		return "BoardPageMaker [pag=" + pag + ", totalCount=" + totalCount + ", startPage=" + startPage + ", endPage="
				+ endPage + ", prev=" + prev + ", next=" + next + ", pageNumber=" + pageNumber + ", displayPageNum="
				+ displayPageNum + "]";
	}
	
	


	
	
	
}
