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

              <h3 class="profile-username text-center">${userDetail.userNickName}</h3>

              <p class="text-muted text-center">님 반갑습니다.</p>

              <ul class="list-group list-group-unbordered">
                <li class="list-group-item">
                  <b>누적 주문</b> <a class="pull-right">0</a>
                </li>
                <li class="list-group-item">
                  <b>찜한 가게</b> <a class="pull-right">0</a>
                </li>
                <li class="list-group-item">
                  <b>포인트</b> <a class="pull-right">0</a>
                </li>
              </ul>
              <a href="/myweb/UserDelete" class="btn btn-danger btn-block"><b>회원탈퇴</b></a>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
        <div class="col-md-9">
          <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
              <li class="active"><a href="#activity" data-toggle="tab">Ordered List</a></li>
              <li><a href="#timeline" data-toggle="tab">Review</a></li>
              <li><a href="#settings" data-toggle="tab">Settings</a></li>
            </ul>
            <div class="tab-content">
              <div class="active tab-pane" id="activity">
                <div class="post">
                	 미구현 상태입니다.
                <!-- Post
                  <div class="user-block">
                    <img class="img-circle img-bordered-sm" src="resources/dist/img/user1-128x128.jpg" alt="user image">
                        <span class="username">
                          <a href="#">Jonathan Burke Jr.</a>
                          <a href="#" class="pull-right btn-box-tool"><i class="fa fa-times"></i></a>
                        </span>
                    <span class="description">Shared publicly - 7:30 PM today</span>
                  </div>
                  /.user-block 
                  <p>
                    Lorem ipsum represents a long-held tradition for designers,
                    typographers and the like. Some people hate it and argue for
                    its demise, but others ignore the hate as they create awesome
                    tools to help create filler text for everyone from bacon lovers
                    to Charlie Sheen fans.
                  </p>
                  <ul class="list-inline">
                    <li><a href="#" class="link-black text-sm"><i class="fa fa-share margin-r-5"></i> Share</a></li>
                    <li><a href="#" class="link-black text-sm"><i class="fa fa-thumbs-o-up margin-r-5"></i> Like</a>
                    </li>
                    <li class="pull-right">
                      <a href="#" class="link-black text-sm"><i class="fa fa-comments-o margin-r-5"></i> Comments
                        (5)</a></li>
                  </ul>

                  <input class="form-control input-sm" type="text" placeholder="Type a comment">
                -->
                </div>
                
              </div>
              
              <!-- /.tab-pane -->
              <div class="tab-pane" id="timeline">
              	<!-- The timeline -->
                <ul class="timeline timeline-inverse" id="reviewList">
                
                	<!-- Review List -->
                	
                </ul>
                	
				<!-- Review Form -->
				<form:form id="reviewRegisterForm" name="reviewRegisterForm">
				    <input type="hidden" id="storeName" name="storeName" value="${storeDetail.storeName}" />
				    <input type="hidden" id="userId" name="userId" value="${userDetail.userId}" />
				</form:form>
              </div>
              <!-- /.tab-pane -->

              <div class="tab-pane" id="settings">
                <form:form class="form-horizontal" action="/myweb/UserUpdate" method="POST">
                  <div class="form-group">
                    <label for="userId" class="col-sm-2 control-label">ID</label>

                    <div class="col-sm-10">
                      <input type="email" class="form-control"value="${userDetail.userId}" placeholder="ID" disabled>
                      <input type="hidden" class="form-control" id="userId" name="userId" value="${userDetail.userId}">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="userPw" class="col-sm-2 control-label">PW</label>

                    <div class="col-sm-10">
                      <input type="password" class="form-control" id="userPw" name="userPw" value="${userDetail.userPw}" placeholder="Password">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="userNickName" class="col-sm-2 control-label">NickName</label>

                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="userNickName" name="userNickName" value="${userDetail.userNickName}" placeholder="NickName">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="userAge" class="col-sm-2 control-label">Age</label>

                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="userAge" name="userAge" value="${userDetail.userAge}" placeholder="Age">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="userPhone" class="col-sm-2 control-label">Phone</label>

                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="userPhone" name="userPhone" value="${userDetail.userPhone}" placeholder="Phone">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="userAddress" class="col-sm-2 control-label">Address</label>

                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="userAddress" name="userAddress" value="${userDetail.userAddress}" placeholder="Address">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                    	<ul class="list-inline">
                   			<li class="pull-right"><button type="submit" class="btn btn-warning pull-right">Submit</button></li>
                  		</ul>
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

/**
 * 초기 페이지 로딩시 댓글 불러오기
 */
$(function(){
    
	getReviewList();
    
});
 
/**
 * 댓글 불러오기(Ajax)
 */
function getReviewList(){
	var token = $("meta[name='_csrf']").attr("content");
  	var header = $("meta[name='_csrf_header']").attr("content");
  	var userId = '${userDetail.userId}';
  	
    $.ajax({
        type:'POST',
        url : '/myweb/UserProfileReviewList',
        dataType : "json",
        data:$("#reviewRegisterForm").serialize(),
        contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
        beforeSend : function(xhr)
        {   /*데이터를 전송하기 전에 헤더에 csrf값을 설정한다*/
            xhr.setRequestHeader(header, token, userId);
        },
        success : function(data){
            
            var html = "";
            var cCnt = data.length;
            
            if(data.length > 0){
                
                for(i=0; i<data.length; i++){
                    html += "<li class='time-label'><span class='bg-red'>"+data[i].writeDate+"</span></li>";
                    html += "<li><i class='fa fa-comments bg-yellow'></i>";
                    html += "<div class='timeline-item'><span class='time'><i class='fa fa-clock-o'></i>"+data[i].writeDate+"</span>";
                    html += "<h3 class='timeline-header'><a href='#'>"+data[i].storeName+"</a></h3>";
                    html += "<div class='timeline-body'>"+data[i].reviewContent+"</div>";
                    html += "<div class='timeline-footer'>";
                    html += "<a class='btn btn-danger btn-flat btn-xs'>삭제</a>";
                    html += "<a class='btn btn-warning btn-flat btn-xs'>수정</a>";
                    html += "<a class='btn btn-success btn-flat btn-xs'>Read More</a></div><li>"
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
