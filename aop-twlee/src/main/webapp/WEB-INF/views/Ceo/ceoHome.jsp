<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- Header.jsp -->
  <%@include file="../include/ceoheader.jsp"%>
	<!-- /.Header.jsp -->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        CEO PAGE
        <small>hello world</small>
      </h1>
    </section>

    <!-- Main content -->
    <section class="content container-fluid">

      <div class="row">
      	<div class="col-md-12">
          <!-- general form elements -->
	          <!-- PRODUCT LIST -->
	          <div class="box box-primary">
	            <div class="box-header with-border">
	              <h3 class="box-title">나의 가게 목록</h3>
	            </div>
	            <!-- /.box-header -->
	            <div class="box-body">
	              <ul class="products-list product-list-in-box">
	              	<c:choose>
						<c:when test="${fn:length(ceoStoreList) > 0}">
						    <c:forEach items="${ceoStoreList}" var="ceoStoreList" varStatus="rowcnt">
						    	<li class="item">
					            	<div class="product-img">
					            		<img src="resources/dist/img/default-50x50.gif" alt="Product Image">
					            	</div>
					                  <div class="product-info">
					                  	<a href="/myweb/ceoStoreDetail?storeName=${ceoStoreList.storeName}" class="product-title">${ceoStoreList.storeName}
						                    	<!-- <span class="label label-success pull-right">리뷰 ${ceoStoreList.reviewCount}</span>  -->
						                    	<span class="product-description">${ceoStoreList.storeAddress}</span>
						                    	<!-- <span class="label label-info pull-right">좋아요 ${ceoStoreList.goodCount}</span>  -->
						                  	</a>
					                  <!-- 
					                  	<form:form id="frm" action="/myweb/ceoStoreDetail" method="post">
					                  		<input type="hidden" name="storeName" value="${ceoStoreList.storeName}">
						                    <a href="#" onclick="document.getElementById('frm').submit();" class="product-title">${ceoStoreList.storeName}
						                    	<span class="label label-success pull-right">리뷰 ${ceoStoreList.reviewCount}</span>
						                    	<span class="product-description">${ceoStoreList.storeAddress}</span>
						                    	<span class="label label-info pull-right">좋아요 ${ceoStoreList.goodCount}</span>
						                  	</a>
					                  	</form:form>
					                  	 -->
					                 </div>
					            </li>
						    </c:forEach>
						</c:when>
					<c:otherwise>
						<li>
							<div class="product-info">등록된 가게가 없습니다. 가게를 등록해주세요</div>
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
  <!-- /.content-wrapper -->

<!-- Footer.jsp -->
<%@include file="../include/ceofooter.jsp"%>
<!-- /.Footer.jsp -->

</div>
</body>
</html>