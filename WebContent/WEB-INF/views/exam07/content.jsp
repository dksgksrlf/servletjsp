<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>


<div class="card m-2">
	<div class="card-header">
		 content.jsp
	</div>
	<div class="card-body">
		<a href="/servletjsp/exam07/SaveSessionController" class="btn btn-info btn-sm">세션에 정보 저장하기</a>
		<a href="/servletjsp/exam07/UseSessionController" class="btn btn-info btn-sm">세션에 저장된 정보 얻기</a>
		
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>