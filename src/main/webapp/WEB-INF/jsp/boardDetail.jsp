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

	<table class="list_table" style="width:70%;">
	
		<colgroup>
			<col width="22%" />
			<col width="*" />
		</colgroup>
		
		<tbody>	
			<tr>
				<td style="text-align: left" colspan="2">${boardDto.title}</td>
			</tr>
			<tr>
				<td style="text-align: left" colspan="2">
				<span style="margin-right: 10px">${boardDto.writer}</span>
				<span style="margin-right: 10px">
				<fmt:parseDate var="date1" value="${boardDto.reg_dt}" pattern="yyyy-MM-dd HH:mm" />
				<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${date1}" />
                </span>
				
				<span style="margin-right: 10px">조회수: ${boardDto.view_cnt}</span>
				</td>
			</tr>
			<tr>
				<td style="text-align: left" colspan="2"><pre>${boardDto.content}</pre></td>
			</tr>
	
			<tr>
			<td colspan="2">file 부분</td>
			</tr>
					
		</tbody>			

 	 		<tr>
		 		<th>이전글</th>
		 		
		 		<c:if test="${boardDto.title_pre eq null}">
		 		<td>
		 		이전글이 없습니다.
		 		</td>
		 		</c:if>
		 		
		 		<td>
		 		<a href="#" onclick="location.href='/boardDetail?num=${boardDto.num_pre}&stype=${boardPaging.stype}&sval=${boardPaging.sval}&page=${boardPaging.page} '">${boardDto.title_pre }</a>
		 		</td>
	 		</tr>
	  
	  		<tr>
		 		<th>다음글</th>
		 		
		 		<c:if test="${boardDto.title_next eq null}">
		 		<td>
		 		다음글이 없습니다.
		 		</td>
		 		</c:if>
		 		
		 		<td>
		 		<a href="#" onclick="location.href='/boardDetail?num=${boardDto.num_next}&stype=${boardPaging.stype}&sval=${boardPaging.sval}&page=${boardPaging.page} '">${boardDto.title_next }</a>
		 		</td>
	 		</tr>
	 
	
			<tr>
				<td style="text-align: right" colspan="2">
					<button type="button" title="목록" onclick="listBtn(${boardPaging.page})">목록</button>
				</td>
			</tr>

		</table>
		
		
		
		
		
		
<script type="text/javascript">
function listBtn(page) {
	
	let stype = "${boardPaging.stype}";
	let sval = "${boardPaging.sval}";
	
	location.href = "boardList?stype=" + stype + "&sval=" + sval + "&page=" + page;
}


</script>		

</body>
</html>