<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<title>后台管理系统登录</title>
	<style type="text/css">
		.error-msg{
			display: none;
			color: red;
		}
	</style>
</head>
<body>
    <!-- Top content -->
    <div class="top-content">
        <div class="inner-bg">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 col-sm-offset-2 text">
                        <h1><strong>后台管理系统</strong></h1>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3 form-box">
                    	<div class="form-top">
                    		<div class="form-top-left">
                    			<h3>系统登录</h3>
                        		<p>输入您的用户名和密码 :</p>
                    		</div>
                    		<div class="form-top-right">
                    			<i class="fa fa-key"></i>
                    		</div>
                        </div>
                        <div class="form-bottom">
		                    <form role="form" action="" method="post" class="login-form" id="loginForm">
		                   	   <div class="form-group">
		                   			<label class="sr-only" for="form-username">用户名</label>
		                       		<input type="text" name="usercode" placeholder="用户名..." class="form-control" id="usercode" required>
		                       </div>
		                       <div class="form-group">
		                       		<label class="sr-only" for="form-password">密码</label>
		                       		<input type="password" name="password" placeholder="密码..." class="form-control" id="password" required>
		                       </div>
		                       <div class="form-group">
		                       		<label class="sr-only" for="form-code">验证码</label>
		                       		<input type="text" name="randomCode" placeholder="验证码..." class="form-control" id="randomCode" required>
		                       		<img src="" id="randomImg" onclick="changeRandomCode()" class="" title="点击图片刷新验证码" />
		                       </div>
		                       <label id="result" class="error-msg"></label>
		                       <button type="submit" class="btn">登录</button>
		                   </form>
	                  	</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
		function changeRandomCode() {		
			//每次请求需要一个不同的参数，否则可能会返回同样的验证码    
			//这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。    
			$("#randomImg").attr("src","${ctx}/login/randomCode?" + new Date().getTime());
		}
		changeRandomCode();
		
		$().ready(function(){
            // Form validation
            $("#loginForm").validate({
            	rules: {
            		randomCode:{remote:"${ctx}/login/randomCode?"+$("#randomCode").val()}
                },
            	messages: {	
            		usercode: { required: "请填写用户名." },
                    password: { required: "请填写密码." },
                    randomCode: { 
                    	required: "请填写验证码.",
                    	remote:"请填写正确的验证码."
                    }
               },
               submitHandler: function(form) { 
            	   //var param = $("#loginForm").serialize(); 
            	   $.post("${ctx}/sys/checkUser.do", {usercode:$("#usercode").val(),password:$("#password").val()}, function(data) { 
           			   if (data == "passwordError") {
           				   $("#result").show();
           				   $("#result").html("用户名或密码不匹配，请重新填写");
           			   } else if (data == "userNotExist") {
           				   $("#result").show();
           				   $("#result").html("用户不存在，请重新填写");
           			   } else if (data == "userInvaild") {
           				   $("#result").show();
           				   $("#result").html("此用户已注销，请联系系统管理员");
           			   } else if (data == "success") {
           				   $("#logonForm").attr("action","${ctx}/index.html");
           				   <%-- 如果想提交表单, 需要使用form.submit()而不要使用$(form).submit() --%> 
           				   form.submit();
           			   }
            	    },"json");
               }
            });
		});
    </script>
</body>
</html>