<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko" class="">
  <head>
    <meta charset="utf-8">
    <!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
    <title>H&T Technology</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="/static/css/templatemo_main.css">

    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/login.js"></script>
  </head>
  <body>
    <div id="main-wrapper">
      <div class="navbar navbar-inverse" role="navigation">
        <div class="navbar-header">
          <div class="logo"><h1>H&T Technology</h1></div>
        </div>
      </div>
      <div class="template-page-wrapper">
        <div class="form-horizontal templatemo-signin-form">
          <div class="form-group">
            <div class="col-md-12">
              <label for="userId" class="col-sm-2 control-label">Username</label>
              <div class="col-sm-10">
                <input type="text" class="form-control" id="userId" placeholder="Username">
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="col-md-12">
              <label for="userPass" class="col-sm-2 control-label">Password</label>
              <div class="col-sm-10">
                <input type="password" class="form-control" id="userPass" placeholder="Password">
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="col-md-12">
              <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                  <label>
                    <input type="checkbox" id="saveId" name="saveId" value="Y"> Save ID
                  </label>
                </div>
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="col-md-12">
              <div class="col-sm-offset-2 col-sm-10" align="right">
                <input type="submit" id="login" name="login" value="LOGIN" class="btn btn-default">
                <input type="button" id="joinBtn" name="joinBtn" value="회원가입" class="btn btn-default">
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>