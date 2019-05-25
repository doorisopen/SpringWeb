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
	          <!-- PRODUCT LIST -->
	          <div class="box box-primary">
	            <div class="box-header with-border">
	              <h3 class="box-title">Store List</h3>
	            </div>
	            <!-- /.box-header -->
	            <div class="box-body">
	              <ul class="products-list product-list-in-box">
	              	<c:choose>
						<c:when test="${fn:length(storeList) > 0}">
						    <c:forEach items="${storeList}" var="storeList" varStatus="rowcnt">
						    	<li class="item">
					            	<div class="product-img">
					            		<img src="resources/dist/img/default-50x50.gif" alt="Product Image">
					            	</div>
					                  <div class="product-info">
					                  <!--  -->
						                    <a href="/myweb/StoreDetail?storeName=${storeList.storeName}" class="product-title">${storeList.storeName}
						                    	<span class="label label-success pull-right">리뷰 ${storeList.reviewCount}</span>
						                    	<span class="product-description">${storeList.storeAddress}</span>
						                    	<span class="label label-info pull-right">좋아요 ${storeList.goodCount}</span>
						                  	</a>
						                  	
					                  	
					                  <!-- 
					                  	<form:form id="frm" action="/myweb/StoreDetail" method="post">
						                    <a href="#" onclick="document.getElementById('frm').submit();" class="product-title">${storeList.storeName}
						                    	<span class="label label-success pull-right">리뷰 ${storeList.reviewCount}</span>
						                    	<span class="product-description">${storeList.storeAddress}</span>
						                    	<span class="label label-info pull-right">좋아요 ${storeList.goodCount}</span>
						                  	</a>
						                  	<input type="hidden" name="storeName" value="${storeList.storeName}"/>
					                  	</form:form>
					                  	 -->
					                  </div>
					            </li>
						    </c:forEach>
						</c:when>
					<c:otherwise>
						<li>
							<div class="product-info">조회된 결과가 없습니다.</div>
					  	</li>
					</c:otherwise>
				</c:choose>
				</ul>
			</div>
	        <!-- /.box-body -->
	            <div class="box-footer text-center">
	              <a href="javascript:void(0)" class="uppercase">View All Products</a>
	            </div>
	            <!-- /.box-footer -->
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
