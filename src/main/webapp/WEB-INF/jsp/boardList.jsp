<%@page import="com.reflexion.board.dto.BoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/table.css">

</head>
<body>



<div class="">
	<table class="list_table" style="width: 70%">
		<colgroup>
			<col style="width: 80px">
			<col style="width: auto;">
			<col style="width: 95px">
			<col style="width: 150px">
			<col style="width: 70px">
		</colgroup>
		<thead>
			<tr>
				<th>
				번호
				</th>
				<th>
				제목
				</th>
				<th>
				작성자
				</th>
				<th>
				작성일
				</th>
				<th>
				조회수
				</th>
			</tr>
		</thead>
		
		   
		<tbody>
			<c:if test="${empty boardList}"> 
				<tr>
					<td colspan="4">작성된 글이 없습니다</td>
				</tr>
			</c:if>
			
			
			<c:forEach var="list" items="${boardList}" varStatus="i">
			
				<tr>
				
					<td>${i.count} </td>
					<td class="title"><a href="#" onclick="location.href='/boardDetail?num=${list.num}&stype=${boardPaging.stype}&sval=${boardPaging.sval}&page=${boardPaging.page} '" >${list.title}</a></td>
					<td>${list.writer} </td>
					<td>
						<fmt:parseDate var="date1" value="${list.reg_dt}" pattern="yyyy-MM-dd" />
						<fmt:formatDate pattern="yyyy-MM-dd" value="${date1}" />
					</td>
					<td>${list.view_cnt} </td>
					
				</tr>

			</c:forEach>
		</tbody>
		
	</table>
</div>



<div class="search_box" style="width: 70%">
<!-- 페이징 -->
<ul>


    <c:if test="${boardPageMaker.prev }">
    	<a href="#" onclick="goPage(${boardPageMaker.startPage-1 })"><span>[이전]</span></a>
    </c:if>

    <c:forEach begin="${boardPageMaker.startPage }" end="${boardPageMaker.endPage }" var="pageNum">
    
    	<c:if test="${boardPaging.page == pageNum }">
        ${pageNum }
    	</c:if>
    	
    	<c:if test="${boardPaging.page != pageNum }">
    	<a href="#" id="goPage" onclick="goPage(${pageNum})">${pageNum }</a>
    	</c:if>
    	
    </c:forEach>
    
    <c:if test="${boardPageMaker.next && boardPageMaker.endPage > 0 }">
		<a href="#" onclick="goPage(${boardPageMaker.endPage+1 })"><span>[다음]</span></a>
    </c:if>


</ul>



<!-- 검색 -->
<select id="stype">
	<option value="all">제목+내용</option>
	<option value="title">제목</option>
	<option value="content">내용</option>
	<option value="writer">작성자</option>
</select>

<input type="text" id="sval" size="20">

<input type="button" id="searchBtn" value="검색">

</div>



<script type="text/javascript">

$(document).ready(function() {
	//검색어 유지
	let stype = "${boardPaging.stype}";
	let sval = "${boardPaging.sval}";
	
	if(stype != "" && sval != "") {  
		$("#stype").val( stype );
		$("#sval").val( sval );
	}
	
});




//검색
$("#searchBtn").click(function() {
	
	let stype = $("#stype").val();
	let sval = $("#sval").val();
	
	//alert(stype);
	//alert(sval);
	
	if($("#sval").val().trim() == "") {
		alert("검색어를 입력해주세요.");
		$("#sval").focus();
	}else{
		location.href = "boardList?stype=" + stype + "&sval=" + sval;
	}
});




//page 이동
function goPage(pageNum) {
	
	let stype = $("#stype").val();
	let sval = $("#sval").val();
	
	location.href = "boardList?stype=" + stype + "&sval=" + sval + "&page=" + pageNum;
}

</script>
	 
</body>
</html>
