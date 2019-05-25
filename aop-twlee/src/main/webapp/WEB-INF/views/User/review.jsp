<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <script>
var storeIdx = '${storeDetail.storeIdx}'; //게시글 번호
 
$("#reviewRegisterBtn").on("click",function(){ //댓글 등록 버튼 클릭시 
    var insertData = $('[name=reviewRegisterForm]').serialize(); //reviewRegisterForm의 내용을 가져옴
    reviewRegister(insertData); //Insert 함수호출(아래)
});
 
 
 
//댓글 목록 
function reviewList(){
	var token = $("meta[name='_csrf']").attr("content");
  	var header = $("meta[name='_csrf_header']").attr("content");
  	
    $.ajax({
        url : '/myweb/ReviewList',
        type : 'POST',
        data : {'storeIdx':storeIdx},
        beforeSend : function(xhr)
       	{   //데이터를 전송하기 전에 헤더에 csrf값을 설정한다
            xhr.setRequestHeader(header, token);
        },
        success : function(data){
            var a =''; 
            $.each(data, function(key, value){ 
                a += '<li class="time-label">';
                a += '<span class="bg-red">'+value.writeDate+'</span>';
                a += '</li>';
                a += '<li><i class="fa fa-comments bg-yellow"></i>';
                a += '<div class="timeline-item"><span class="time"><i class="fa fa-clock-o"></i>'+value.writeDate+'</span>';
                a += '<h3 class="timeline-header"><a href="#">'+value.writer+'</a></h3>';
                a += '<div class="reviewInfo'+value.reviewIdx+'">';
                a += '<div class="timeline-body">'+value.reviewContent+'</div>';
                a += '<div class="timeline-footer">';
                a += '<a class="btn btn-warning btn-flat btn-xs" onclick="reviewUpdate('+value.reviewIdx+',\''+value.reviewContent+'\');"> 수정 </a>';
                a += '<a class="btn btn-danger btn-xs" onclick="reviewDelete('+value.reviewIdx+');"> 삭제 </a>';
                a += '</div></div></li>';
               
            });
            
            $(".reviewList").html(a);
        }
    });
}
 
//댓글 등록
function reviewRegister(insertData){
  	var token = $("meta[name='_csrf']").attr("content");
  	var header = $("meta[name='_csrf_header']").attr("content");
    $.ajax({
        url : '/myweb/ReviewRegister',
        type : 'post',
        data : insertData,
        beforeSend : function(xhr)
       	{   //데이터를 전송하기 전에 헤더에 csrf값을 설정한다
            xhr.setRequestHeader(header, token);
        },
        error: function(type, error) {
			alert("에러 발생 관리자에게 문의 하세요");
			console.log('log : ' + type)
		},
        success : function(data){
            if(data == 1) {
                reviewList(); //댓글 작성 후 댓글 목록 reload
                $('[name=reviewContent]').val('');
            }
        }
    });
}
 
//댓글 수정 - 댓글 내용 출력을 input 폼으로 변경 
function reviewUpdate(reviewIdx, reviewContent){
    var a ='';
    
    a += '<div class="input-group">';
    a += '<input type="text" class="form-control" name="reviewContent_'+reviewIdx+'" value="'+reviewContent+'"/>';
    a += '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="reviewUpdateProc('+reviewIdx+');">수정</button> </span>';
    a += '</div>';
    
    $('.reviewContent'+cno).html(a);
    
}
//댓글 수정
function reviewUpdateProc(reviewIdx){
    var updateContent = $('[name=reviewContent_'+reviewIdx+']').val();
    
    $.ajax({
        url : '/myweb/ReviewUpdate',
        type : 'post',
        data : {'reviewContent' : updateContent, 'reviewIdx' : reviewIdx},
        success : function(data){
            if(data == 1) reviewList(storeIdx); //댓글 수정후 목록 출력 
        }
    });
}
 
//댓글 삭제 
function reviewDelete(reviewIdx){
    $.ajax({
        url : '/myweb/ReviewDelete/'+reviewIdx,
        type : 'post',
        success : function(data){
            if(data == 1) reviewList(storeIdx); //댓글 삭제후 목록 출력 
        }
    });
}

$(document).ready(function(){
    reviewList(); //페이지 로딩시 댓글 목록 출력 
});
 
</script>