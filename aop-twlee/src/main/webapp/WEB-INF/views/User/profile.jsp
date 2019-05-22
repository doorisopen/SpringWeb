<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <div class="col-md-3">

          <!-- Profile Image -->
          <div class="box box-primary">
            <div class="box-body box-profile">
              <img class="profile-user-img img-responsive img-circle" src="resources/dist/img/user4-128x128.jpg" alt="User profile picture">

              <h3 class="profile-username text-center"><sec:authentication property="principal.username"/></h3>

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
                <!-- Post -->
                <div class="post">
                  <div class="user-block">
                    <img class="img-circle img-bordered-sm" src="resources/dist/img/user1-128x128.jpg" alt="user image">
                        <span class="username">
                          <a href="#">Jonathan Burke Jr.</a>
                          <a href="#" class="pull-right btn-box-tool"><i class="fa fa-times"></i></a>
                        </span>
                    <span class="description">Shared publicly - 7:30 PM today</span>
                  </div>
                  <!-- /.user-block -->
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
                </div>
                <!-- /.post -->
              </div>
              
              <!-- /.tab-pane -->
              <div class="tab-pane" id="timeline">
                <!-- The timeline -->
                <ul class="timeline timeline-inverse">
                  <!-- timeline time label -->
                  <li class="time-label">
                        <span class="bg-red">
                          10 Feb. 2014
                        </span>
                  </li>
                  <!-- /.timeline-label -->
                  
          
                  <!-- timeline item -->
                  <li>
                    <i class="fa fa-comments bg-yellow"></i>

                    <div class="timeline-item">
                      <span class="time"><i class="fa fa-clock-o"></i> 27 mins ago</span>

                      <h3 class="timeline-header"><a href="#">Jay White</a> commented on your post</h3>

                      <div class="timeline-body">
                        Take me to your leader!
                        Switzerland is small and neutral!
                        We are more like Germany, ambitious and misunderstood!
                      </div>
                      <div class="timeline-footer">
                        <a class="btn btn-warning btn-flat btn-xs">View comment</a>
                        <a class="btn btn-primary btn-xs">Read more</a>
                        <a class="btn btn-danger btn-xs">Delete</a>
                      </div>
                    </div>
                  </li>
                  <!-- END timeline item -->
                  <!-- timeline time label -->
                  <li class="time-label">
                        <span class="bg-green">
                          3 Jan. 2014
                        </span>
                  </li>
                  <!-- /.timeline-label -->
                  <!-- timeline item -->
                  <li>
                    <i class="fa fa-camera bg-purple"></i>

                    <div class="timeline-item">
                      <span class="time"><i class="fa fa-clock-o"></i> 2 days ago</span>

                      <h3 class="timeline-header"><a href="#">Mina Lee</a> uploaded new photos</h3>

                      <div class="timeline-body">
                        <img src="http://placehold.it/150x100" alt="..." class="margin">
                        	ㅇㅇㅁㄴㅇㄴㅁㅇㅁㄴㄴㅁㅇㅁㄴㅇㅁㅇㄴㅁㅇㄴㅁㅇㄴㅁㅇㄴㅁㅇㄴㅁㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇㄴㅁ
                      </div>
                    </div>
                  </li>
                  <!-- END timeline item -->
                  <li>
                    <i class="fa fa-clock-o bg-gray"></i>
                  </li>
                </ul>
              </div>
              <!-- /.tab-pane -->

              <div class="tab-pane" id="settings">
                <form:form class="form-horizontal" action="/myweb/UserUpdate" method="POST">
                  <div class="form-group">
                    <label for="userId" class="col-sm-2 control-label">ID</label>

                    <div class="col-sm-10">
                      <input type="email" class="form-control" id="userId" name="userId" value="${userDetail.userId}" placeholder="ID">
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
</body>
</html>
