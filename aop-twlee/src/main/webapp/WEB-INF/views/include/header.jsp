<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>LTW | Food&Life Balence</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="resources/bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="resources/bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css">
  <!-- Select2 -->
  <link rel="stylesheet" href="resources/bower_components/select2/dist/css/select2.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="resources/dist/css/skins/_all-skins.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font -->
  <!-- 나눔고딕 폰트 
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nanum+Gothic">
   -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
  
</head>
<%
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    Object principal = auth.getPrincipal();
%>
<body>

	<header class="main-header">
    <nav class="navbar navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <a href="/myweb" class="navbar-brand"><b>Food&Life</b>Balence</a>
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
            <i class="fa fa-bars"></i>
          </button>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="/myweb/BoardList?boardFlag=not">Notice<span class="sr-only">(current)</span></a></li>
            <li><a href="/myweb/BoardList?boardFlag=eve">Event</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">사장님 전용 <span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li><a href="/myweb/StoreRegisterPage">사장님 등록</a></li>
                <li><a href="/myweb/ceo">나의 가게 관리</a></li>
                <!-- 
                <li class="divider"></li>
                <li><a href="#">Separated link</a></li>
                <li class="divider"></li>
                <li><a href="#">One more separated link</a></li>
                 -->
              </ul>
            </li>
          </ul>
          <!-- 
          <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
              <input type="text" class="form-control" id="navbar-search-input" placeholder="Search">
            </div>
          </form>
           -->
        </div>
        <!-- /.navbar-collapse -->
        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu">
          <ul class="nav navbar-nav">
            <!-- Messages: style can be found in dropdown.less-->
            <li class="dropdown messages-menu">
              <!-- Menu toggle button -->

            <!-- User Account Menu -->
            <li class="dropdown user user-menu">
              <!-- Menu Toggle Button -->

              <!-- 로그인 완료시 -->
	          <sec:authorize access="isAuthenticated()">
		      	<a href="#" class="dropdown-toggle" data-toggle="dropdown">
              		<!-- The user image in the navbar-->
              		<img src="resources/dist/img/default-50x50.gif" class="user-image" alt="User Image">
              		<!-- hidden-xs hides the username on small devices so only the image appears. -->
              		<span class="hidden-xs"><sec:authentication property="principal.username"/></span>
              	</a>   
	          
              <ul class="dropdown-menu">
                <!-- The user image in the menu -->
                <li class="user-header">
                  <img src="resources/dist/img/default-50x50.gif" class="img-circle" alt="User Image">

                  <p>
                    <sec:authentication property="principal.username"/>님 반갑습니다.
                    <small>Login Date : </small>
                  </p>
                </li>
                <!-- Menu Body -->
                <li class="user-body">
                  <div class="row">
                    <div class="col-xs-4 text-center">
                      <a href="#">Point</a>
                    </div>
                    <div class="col-xs-4 text-center">
                      <a href="#">OrderList</a>
                    </div>
                    <div class="col-xs-4 text-center">
                      <a href="#">Review</a>
                    </div>
                  </div>
                  <!-- /.row -->
                </li>
                <!-- Menu Footer-->
                <li class="user-footer">
                  <div class="pull-left">
                  <!--
                  	 ??? : 시큐리티 적용시 어떻게 아이디를 숨겨서 보내야하지??...... 
                  -->
                    <a href="/myweb/profilePage" class="btn btn-default btn-flat">Profile</a>
                  </div>
                  <div class="pull-right">
                    <form action="${pageContext.request.contextPath}/logout" method="POST">
				            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				            <div class="pull-right">	
				            	<input class="btn btn-default btn-flat" type="submit" value="Sign out" /> 
				            </div>
			            </form>
                  </div>
                </li>
              </ul>
              </sec:authorize>
            </li>
          </ul>
        </div>
        <!-- /.navbar-custom-menu -->
      </div>
      <!-- /.container-fluid -->
    </nav>
  </header>
  
</body>
</html>