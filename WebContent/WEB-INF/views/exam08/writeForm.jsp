<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>


<div class="card m-2">
	<div class="card-header">
		 writeForm.jsp
	</div>
	<div class="card-body">
		<form method="Post" action="BoardWriteController">
		  <div class="form-group">
		    <label for="btitle">Title</label>
		    <input type="text" class="form-control"  id="btitle" name="btitle">
		  </div>
		  <div class="form-group">
		    <label for="bcontent">Content:</label>
		    <textarea row="5" cols="50" id="bcontent" name="bcontent"></textarea>
		  </div>
		  
		  <button type="submit" class="btn btn-primary">게시물 쓰기</button>
		</form>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>