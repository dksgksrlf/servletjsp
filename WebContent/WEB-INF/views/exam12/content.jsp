<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>


<div class="card m-2">
	<div class="card-header">
		 content.jsp
	</div>
	<div class="card-body">
		<div class="card m-2">
			<div class="card-header">
				 조건 태그
			</div>
			<div class="card-body">
				<c:if test="${loginUser != null }">
						${loginUser.userId} / ${loginUser.userName}
				</c:if>
				<c:if test="${loginUser == null }">
						저장된 유저가 없습니다.
				</c:if>
				<hr/>
				
				<c:choose>
					<c:when test="${loginUser.userId == 'winter' }">
						winter is comming.
					</c:when>
					<c:when test="${loginUser.userId == 'spring'}">
						spring 
					</c:when>
					<c:when test="${loginUser.userId == 'summer'}">
						summer 
					</c:when>
					<c:otherwise>
						fall
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="card m-2">
			<div class="card-header">
				 반복 태그1
			</div>
			<div class="card-body">
				<c:forEach var="i" begin="1" end="5" step="1">
					<img src="${pageContext.request.contextPath}/resources/photo${i}.jpg" width="100" height="100"/>
				</c:forEach>
				
			</div>
		</div>
		<div class="card m-2">
			<div class="card-header">
				반복태그2
			</div>
			<div class="card-body">
				 <table class="table table-bordered">
				 	<thead>
				 		<tr>
				 			<th>순번</th>
					 		<th>번호</th>
					 		<th>제목</th>
					 		<th>내용</th>
					 		<th>글쓴이</th>
				 			<th>날짜</th>
				 		</tr>
				 	</thead>
				 	<tbody>
				 		<c:forEach var="board" items="${list}" varStatus="status">
				 			<tr>
				 				<td>${status.index}</td>
						 		<td>${board.bno }</td>
						 		<td>${board.btitle }</td>
						 		<td>${board.bcontent }</td>
						 		<td>${board.bwriter }</td>
					 			<td><fmt:formatDate value="${board.bdate}" pattern="yyyy.MM.dd"/></td>
					 		</tr>	
				 		</c:forEach>
				 	</tbody>
				 </table>
				
				
			</div>
		</div>
		<div class="card m-2">
			<div class="card-header">
				반복태그3
			</div>
			<div class="card-body">
				<c:forEach var="board" items="${list}" varStatus="status">
				 	<c:if test="${status.first}">
				 	<table class="table table-bordered">
				 		<thead>
					 		<tr>
					 			<th>순번</th>
						 		<th>번호</th>
						 		<th>제목</th>
						 		<th>내용</th>
						 		<th>글쓴이</th>
					 			<th>날짜</th>
					 		</tr>
					 	</thead>
					 	<tbody>
				 	</c:if>
					 		
				 			<tr>
				 				<td>${status.index},${status.count} </td>
						 		<td>${board.bno }</td>
						 		<td>${board.btitle }</td>
						 		<td>${board.bcontent }</td>
						 		<td>${board.bwriter }</td>
					 			<td><fmt:formatDate value="${board.bdate}" pattern="yyyy.MM.dd"/></td>
					 		</tr>	
						<c:if test="${status.last }">
						 	</tbody>
					 </table>
						</c:if>					 		
				</c:forEach>
				
			</div>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>