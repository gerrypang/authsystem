<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<title>后台管理系统登录</title>
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
		                    <form role="form" action="${ctx}/user/login.do" method="post" class="login-form">
		                   	   <div class="form-group">
		                   			<label class="sr-only" for="form-username">用户名</label>
		                       		<input type="text" name="form-username" placeholder="用户名..." class="form-username form-control" id="form-username">
		                       </div>
		                       <div class="form-group">
		                       		<label class="sr-only" for="form-password">密码</label>
		                       		<input type="password" name="form-password" placeholder="密码..." class="form-password form-control" id="form-password">
		                       </div>
		                       <div class="form-group">
		                       		<label class="sr-only" for="form-code">验证码</label>
		                       		<input type="password" name="form-password" placeholder="验证码..." class="form-password form-control" id="form-password">
		                       </div>
		                       <button type="submit" class="btn">登录</button>
		                   </form>
	                  	</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>