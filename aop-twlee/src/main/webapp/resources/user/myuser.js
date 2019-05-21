/**
 * User message
 * Made by lee tae woong
 */
$(document).ready(function(){
	$("#signUpBtn").unbind("click").click(function(e){
		e.preventDefault();
		fn_signUp();
	});
});

function fn_signUp() {
	    
	    if($("#userId").val().length < 1)
	    {
	        alert("아이디를 입력해 주세요"); 
	        $("#userId").focus();
	    }
	    else if($("#userPw").val().length < 1)
	    {
	        alert("비밀번호를 입력해 주세요"); 
	        $("#userPw").focus();
	        
	    }
	    else if($("#userNickName").val().length < 1)
	    {
	        alert("별명을 입력해주세요");
	        $("#userNickname").focus();
	    }
	    
	    else if($("#userAge").val().length < 1)
	    {
	        alert("나이를 입력해주세요");
	        $("#userAge").focus();
	    }
	    
	    else if($("#userPhone").val().length < 1)
	    {
	        alert("휴대전화 번호를 입력해주세요");
	        $("#userPhone").focus();
	    }
	    
	    else if($("#userAddress").val().length < 1)
	    {
	        alert("주소를 입력해주세요");
	        $("#userAddress").focus();
	    }
	    
	    else if(!$("#userId").attr("disabled"))
	    {
	        alert("중복체크를 해주세요");
	    }
	    else
	    {
	    	if(window.confirm("회원가입을 하시겠습니까?"))
	    	{
	    	/*
	    	 * Common.js 참고  
	    	 */
	    	var comSubmit = new ComSubmit("frm");
	    	comSubmit.setUrl("/myweb/UserRegister");
	    	comSubmit.addParam("userId", $("#userId").val());
	    	comSubmit.submit();
	    	}
	    }
	    
}








