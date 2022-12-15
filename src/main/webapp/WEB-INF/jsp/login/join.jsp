<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<?DOCTYPE html>

<html lang="ko" class="">
    <head>
        <meta charset="utf-8">
        <!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
        <title>H&T Technology</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="viewport" content="width=device-width">
        <link rel="stylesheet" href="/css/templatemo_main.css">

        <script src="/js/jquery.min.js"></script>
        <script src="/js/bootstrap.min.js"></script>
        <script src="/js/login.js"></script>
    </head>

    <body>
        <div class="navbar navbar-inverse" role="navigation">
            <div class="navbar-header">
                <div class="logo"><h1>H&T Technology</h1></div>
            </div>
        </div>

        <div class="template-page-wrapper">
            <div class="form-horizontal templatemo-signin-form">
                <div class="form-group">
                    <div class="col-md-12">
                        <label for="userNm" class="col-sm-2 control-label">이름</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userNm" placeholder="이름">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-12">
                        <label for="userId" class="col-sm-2 control-label">아이디</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userId" placeholder="사용자 아이디">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-12">
                        <label for="userPass" class="col-sm-2 control-label">비밀번호</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userPass" placeholder="비밀번호">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-12">
                        <label for="userTel" class="col-sm-2 control-label">전화번호</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userTel" placeholder="전화번호">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-12">
                        <label for="userEmail" class="col-sm-2 control-label">메일주소</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userEmail" placeholder="메일주소">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-sm-offset-2 col-sm-10" align="right">
                            <input type="submit" id="join" name="join" value="회원가입" class="btn btn-default">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>