<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>LTW | Food&Life Balence</title>
<%@include file="../../include/ceoheader.jsp"%>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
    
      <h1>Store Register</h1>
      
      <ol class="breadcrumb">
        <li class="active"><a href="#"><i class="fa fa-dashboard"></i> Store Register</a></li>
      </ol>
    </section>
	<!-- Main content -->
    <section class="content">
      <div class="row">
        <!-- left column -->
        <div class="col-md-8">
          <!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Store Register</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form:form action="/myweb/StoreRegister" method="POST">
              <div class="box-body">
              
                <div class="form-group">
                  <label>StoreName</label>
                  <input type="text" class="form-control" name="storeName" placeholder="가게 이름을 입력해 주세요">
                </div>
                <div class="form-group">
                  <label>StoreAddress</label>
                  <input type="text" class="form-control" name="storeAddress" placeholder="가게 주소를 입력해 주세요">
                </div>
                <div class="form-group">
                  <label>StoreTel</label>
                  <input type="text" class="form-control" name="storeTel" placeholder="가게 전화번호를 입력해 주세요">
                </div>
                <div class="form-group">
                <label>Category</label>
	                <select name="storeCategory" class="form-control select2" style="width: 100%;">
	                  <option selected="selected">카테고리를 선택해주세요</option>
	                  <option value="han">한식 (등록 테스트)</option>
	                  <option value="sna">분식 (등록 테스트)</option>
	                  <option value="caf">카페 디저트 (등록 테스트)</option>
	                  <option value="" disabled="disabled">돈까스 회 일식</option>
	                  <option value="" disabled="disabled">치킨</option>
	                  <option value="" disabled="disabled">피자</option>
	                  <option value="" disabled="disabled">중국집</option>
	                  <option value="" disabled="disabled">족발 보쌈</option>
	                  <option value="" disabled="disabled">야식</option>
	                  <option value="" disabled="disabled">찜 탕</option>
	                  <option value="" disabled="disabled">도시락</option>
	                  <option value="" disabled="disabled">패스트푸드</option>
	                </select>
	            </div>
	            <!-- /.col -->
                <div class="form-group">
                	<label for="exampleInputFile">가게 배너 등록</label>
                  	<input type="file" name="storeImg">
                </div>
                
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
                <button type="submit" class="btn btn-warning">Register</button>
              </div>
            </form:form>
            </div>
          </div>
          <!-- /.box -->
        </div>
      </section>
	</div>
	<!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->
</body>
<footer>
	<%@include file="../../include/ceofooter.jsp"%>
</footer>
</html>