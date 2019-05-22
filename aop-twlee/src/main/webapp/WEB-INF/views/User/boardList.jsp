<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
  <meta charset="UTF-8">
</head>
<!-- ADD THE CLASS layout-top-nav TO REMOVE THE SIDEBAR. -->
<body class="hold-transition skin-blue layout-top-nav">
<div class="wrapper">
<!-- Header.jsp -->
  <%@include file="../include/header.jsp"%>
	<!-- /.Header.jsp -->
	
  <!-- Full Width Column -->
  <div class="content-wrapper">
    <div class="container">
      <!-- Content Header (Page header) -->
      <!-- Main content -->
      <section class="content">
      	<div class="row">
      	<div class="col-md-12">
          <!-- general form elements -->
          <div class="box box-primary">
            <!-- /.box-header -->     
            <div class="box-body">
              <table id="example2" class="table table-bordered table-hover">
				<thead>
		            <tr>
		                <th>No</th>
		                <th>제목</th>
		                <th>작성자</th>
		            	<th>작성 일자</th>
		        	</tr>
		        </thead>
		            <tbody>
			            <!-- 게시글 리스트 출력 -->
						<c:choose>
							<c:when test="${fn:length(boardList) > 0}">
						    	<c:forEach items="${boardList}" var="boardList" varStatus="rowcnt">
						        	<tr>
						            	<td>${boardList.boardIdx}</td>
						                <td>${boardList.boardTitle}</td>
						                <td>${boardList.writer}</td>
						                <td>${boardList.writeDate}</td>
						            </tr>
						        </c:forEach>
						    </c:when>
							<c:otherwise>
								<tr>
									<td colspan="6">조회된 결과가 없습니다.</td>
					  			</tr>
							</c:otherwise>
						</c:choose>
		        	</tbody>
				</table>
            	</div>
          	</div>
          	<!-- /.box -->
        	</div>
      	</div>
      	<!-- /.row -->
	  </section>
	  <!-- /.content -->
    </div>
    <!-- /.box -->
  </div>
  <!-- /.content-wrapper -->
  
  <!-- Footer.jsp -->
<%@include file="../include/footer.jsp"%>
<!-- /.Footer.jsp -->

</div>
<!-- /.wrapper -->
</body>
</html>
