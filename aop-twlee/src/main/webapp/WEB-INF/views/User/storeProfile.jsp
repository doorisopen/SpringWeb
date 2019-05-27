<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="_csrf" content="${_csrf.token}"/>
  <meta name="_csrf_header" content="${_csrf.headerName}"/>
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
        <div class="col-md-3">

          <!-- Profile Image -->
          <div class="box box-primary">
            <div class="box-body box-profile">
              <img class="profile-user-img img-responsive img-circle" src="resources/dist/img/default-50x50.gif" alt="User profile picture">

              <h3 class="profile-username text-center">${storeDetail.storeName }</h3>

              <p class="text-muted text-center">방문 해주셔서 감사합니다.</p>

              <ul class="list-group list-group-unbordered">
                <li class="list-group-item">
                  <b>좋아요</b> <a class="pull-right">${storeDetail.goodCount }</a>
                </li>
                <li class="list-group-item">
                  <b>리뷰</b> <a class="pull-right"><span id="cCnt"></span></a>
                </li>
                <li class="list-group-item">
                  <b>전화 번호</b> <a class="pull-right">${storeDetail.storeTel }</a>
                </li>
                <li class="list-group-item">
                  <b>주소</b> <a class="pull-right">${storeDetail.storeAddress }</a>
                </li>
              </ul>
              <a href="#" class="btn btn-danger btn-block"><b>찜 하기</b></a>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
        <div class="col-md-9">
          <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
              <li class="active"><a href="#activity" data-toggle="tab">Menu</a></li>
              <li><a href="#timeline" data-toggle="tab">Review</a></li>
              <li><a href="#settings" data-toggle="tab">Store Info</a></li>
            </ul>
            <div class="tab-content">
              <div class="active tab-pane" id="activity">
                <ul class="products-list product-list-in-box" id="menuList">
                
                	<!-- Menu List -->
                
	              </ul>
	              <!-- Menu Form -->
				<form:form id="menuRegisterForm" name="menuRegisterForm">
					<div class="input-group">
				    	<input type="hidden" class="form-control" id="menuName" name="menuName" placeholder="메뉴이름을 입력하세요.">
				    	<input type="hidden" class="form-control" id="menuPrice" name="menuPrice" placeholder="메뉴가격을 입력하세요.">
					</div>
				    <input type="hidden" id="storeName" name="storeName" value="${storeDetail.storeName}" />
				</form:form>
              </div>
              
              <!-- /.tab-pane -->
              <div class="tab-pane" id="timeline">
              	<!-- The timeline -->
                <ul class="timeline timeline-inverse" id="reviewList">
                
                	<!-- Review List -->
                	
                </ul>
                	
				<!-- Review Form -->
				<form:form id="reviewRegisterForm" name="reviewRegisterForm" method="GET">
					<div class="input-group">
				    	<input type="text" class="form-control" id="reviewContent" name="reviewContent" placeholder="내용을 입력하세요.">
				        	<span class="input-group-btn">
				            	<button onClick="fn_review()" class="btn btn-default" name="reviewRegisterBtn">등록</button>
				        	</span>
					</div>
				    <input type="hidden" id="storeName" name="storeName" value="${storeDetail.storeName}" />
				</form:form>
              </div>
              <!-- /.tab-pane -->

              <div class="tab-pane" id="settings">
                <form:form class="form-horizontal">
                  <div class="form-group">
                    <label for="storeName" class="col-sm-2 control-label">가게 이름</label>

                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="storeName" name="storeName" value="${storeDetail.storeName}" placeholder="storeName" disabled>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="storeAddress" class="col-sm-2 control-label">가게 주소</label>

                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="storeAddress" name="storeAddress" value="${storeDetail.storeAddress}" placeholder="storeAddress" disabled>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="storeTel" class="col-sm-2 control-label">전화번호</label>

                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="storeTel" name="storeTel" value="${storeDetail.storeTel}" placeholder="storeTel" disabled>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="writeDate" class="col-sm-2 control-label">등록일자</label>

                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="writeDate" name="writeDate" value="${storeDetail.writeDate}" placeholder="writeDate" disabled>
                    </div>
                  </div>
                </form:form>
              </div>
              <!-- /.tab-pane -->
            </div>
            <!-- /.tab-content -->
          </div>
          <!-- /.nav-tabs-custom -->
        </div>
        <!-- /.col -->
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

<script>
/*
 * 댓글 등록하기(Ajax)
 */
function fn_review(){
	var token = $("meta[name='_csrf']").attr("content");
  	var header = $("meta[name='_csrf_header']").attr("content");
    $.ajax({
        type:'get',
        url : '/myweb/ReviewRegister',
        data:$("#reviewRegisterForm").serialize(),
        beforeSend : function(xhr)
        {   /*데이터를 전송하기 전에 헤더에 csrf값을 설정한다*/
            xhr.setRequestHeader(header, token);
        },
        success : function(data){
            if(data=="success")
            {
                getReviewList();
                $("#reviewContent").val("");
            }
        },
        error:function(request,status,error){
            //alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
       }
        
    });
}
 
/**
 * 초기 페이지 로딩시 댓글 불러오기
 */
$(function(){
	getMenuList();
	getReviewList();
    
});

/**
 * 메뉴 리스트 불러오기(Ajax)
 */
function getMenuList(){
	var token = $("meta[name='_csrf']").attr("content");
  	var header = $("meta[name='_csrf_header']").attr("content");
  	
    $.ajax({
        type:'GET',
        url : '/myweb/StoreMenuList',
        dataType : "json",
        data:$("#menuRegisterForm").serialize(),
        contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
        beforeSend : function(xhr)
        {   /*데이터를 전송하기 전에 헤더에 csrf값을 설정한다*/
            xhr.setRequestHeader(header, token);
        },
        success : function(data){
            
            var html = "";
            var mCnt = data.length;
            
            if(data.length > 0){
                
                for(i=0; i<data.length; i++){
                    html += "<li class='item'><div class='product-img'>";
                    html += "<img src='resources/dist/img/default-50x50.gif' alt='Product Image'></div>";
                    html += "<div class='product-info'>";
                    html += "<a href='#'  class='product-title'>"+data[i].menuName;
                    html += "<span class='label label-warning pull-right'>$"+data[i].menuPrice+"</span></a>";
                    html += "<span class='product-description'>Menu description</span></div></li>";
                    
                }

            } else {
                
            	html += "<li class='item'><div class='product-img'>";
                html += "<img src='resources/dist/img/default-50x50.gif' alt='Product Image'></div>";
                html += "<div class='product-info'>";
                html += "<a href='#'  class='product-title'>아직 등록된 메뉴가 없습니다.";
                html += "<span class='label label-warning pull-right'>$0</span></a>";
                html += "<span class='product-description'>등록된 메뉴설명이 없습니다.</span></div></li>";
       
            }
            
            $("#mCnt").html(mCnt);
            $("#menuList").html(html);
            
        },
        error:function(request,status,error){
        	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
        
    });
}

/**
 * 댓글 불러오기(Ajax)
 */
function getReviewList(){
	var token = $("meta[name='_csrf']").attr("content");
  	var header = $("meta[name='_csrf_header']").attr("content");
  	var storeName = '${storeDetail.storeName}';
  	
    $.ajax({
        type:'get',
        url : '/myweb/StoreProfileReviewList',
        dataType : "json",
        data:$("#reviewRegisterForm").serialize(),
        contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
        beforeSend : function(xhr)
        {   /*데이터를 전송하기 전에 헤더에 csrf값을 설정한다*/
            xhr.setRequestHeader(header, token, storeName);
        },
        success : function(data){
            
            var html = "";
            var cCnt = data.length;
            
            if(data.length > 0){
                
                for(i=0; i<data.length; i++){
                    html += "<li class='time-label'><span class='bg-red'>"+data[i].writeDate+"</span></li>";
                    html += "<li><i class='fa fa-comments bg-yellow'></i>";
                    html += "<div class='timeline-item'><span class='time'><i class='fa fa-clock-o'></i>"+data[i].writeDate+"</span>";
                    html += "<h3 class='timeline-header'><a href='#'>"+data[i].writer+"</a></h3>";
                    html += "<div class='timeline-body'>"+data[i].reviewContent+"</div><li>";
                    
                }
                
            } else {
                
            	html += "<li class='time-label'><span class='bg-red'>Date Line</span></li>";
                html += "<li><i class='fa fa-comments bg-yellow'></i>";
                html += "<div class='timeline-item'>";
                html += "<div class='timeline-body'>등록된 리뷰가 없습니다.</div></div><li>";
       
            }
            
            $("#cCnt").html(cCnt);
            $("#reviewList").html(html);
            
        },
        error:function(request,status,error){
            
       }
        
    });
}
 
</script>
</body>
</html>
