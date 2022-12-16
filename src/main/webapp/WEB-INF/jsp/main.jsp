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
  <link rel="stylesheet" href="/css/templatemo_main.css">
</head>
<body>
<div class="navbar navbar-inverse" role="navigation">
  <div class="navbar-header">
    <div class="logo"><h1>H&T Technology</h1></div>
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
  </div>
</div>
<div class="template-page-wrapper">
  <div class="navbar-collapse collapse templatemo-sidebar">
    <ul class="templatemo-sidebar-menu">
      <!--li>
        <form class="navbar-form">
          <input type="text" class="form-control" id="templatemo_search_box" placeholder="Search...">
          <span class="btn btn-default">Go</span>
        </form>
      </li-->
      <li class="active"><a href="#"><i class="fa fa-home"></i>Dashboard</a></li>
      <li class="sub open">
        <a href="javascript:;">
          <i class="fa fa-database"></i> 관리 메뉴보기 <div class="pull-right"><span class="caret"></span></div>
        </a>
        <ul class="templatemo-submenu">
          <li><a href="tables.html">사용자 관리</a></li>
          <li><a href="#">센서 관리</a></li>
          <li><a href="#">IO 관리</a></li>
          <li><a href="#">챠트 관리</a></li>
        </ul>
      </li>
      <li><a href="data-visualization.html"><i class="fa fa-cubes"></i>센서 정보</a></li>
      <!--li><a href="maps.html"><i class="fa fa-map-marker"></i>Maps</a></li>
      <li><a href="tables.html"><i class="fa fa-users"></i>Manage Users</a></li-->
      <li><a href="preferences.html"><i class="fa fa-cog"></i>기본 설정</a></li>
      <li><a href="javascript:;" data-toggle="modal" data-target="#confirmModal"><i class="fa fa-sign-out"></i>로그아웃</a></li>
    </ul>
  </div><!--/.navbar-collapse -->

  <div class="templatemo-content-wrapper">
    <div class="templatemo-content">
      <ol class="breadcrumb">
        <li><a href="index.html">Main</a></li>
      </ol>
      <h1>Main</h1>
      <p>초기화면입니다.</p>
      <div class="templatemo-panels">
        <div class="row">
          <div class="col-md-6 col-sm-6 margin-bottom-30">
            <div class="panel panel-success">
              <div class="panel-heading">센서 챠트</div>
              <canvas id="sensorChart" height="400" width="500"></canvas>
            </div>
            <span class="btn btn-success"><a href="data-visualization.html">More Charts</a></span>
          </div>
          <div class="col-md-6 col-sm-6 margin-bottom-30">
            <div class="panel panel-primary">
              <div class="panel-heading">사용자 정보</div>
              <div class="panel-body">
                <table class="table table-striped">
                  <thead>
                  <tr>
                    <th>번호</th>
                    <th>이름</th>
                    <th>아이디</th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:choose>
                    <c:when test="${empty userList}"></c:when>
                    <c:otherwise>
                      <c:forEach var="item" items="${userList}">
                        <tr>
                          <td>${item.no}</td>
                          <td>${item.userNm}</td>
                          <td>${item.userId}</td>
                        </tr>
                      </c:forEach>
                    </c:otherwise>
                  </c:choose>
                  </tbody>
                </table>
              </div>
            </div>
            <span class="btn btn-primary"><a href="tables.html">사용자 관리</a></span>
          </div>
        </div>

        <!--<div class="row">
          <div class="col-md-6 col-sm-6">

            <ul class="nav nav-tabs" role="tablist" id="templatemo-tabs">
              <li class="active"><a href="#home" role="tab" data-toggle="tab">tab1</a></li>
              <li><a href="#profile" role="tab" data-toggle="tab">tab2</a></li>
              <li><a href="#messages" role="tab" data-toggle="tab">tab3</a></li>
              <li><a href="#settings" role="tab" data-toggle="tab">tab4</a></li>
            </ul>


            <div class="tab-content">
              <div class="tab-pane fade in active" id="home">
                <ul class="list-group">
                  <li class="list-group-item"><input type="checkbox" name="" value=""> 111</li>
                  <li class="list-group-item"><input type="checkbox" name="" value=""> 222</li>
                  <li class="list-group-item"><input type="checkbox" name="" value=""> 333</li>
                  <li class="list-group-item"><input type="checkbox" name="" value=""> 444</li>
                  <li class="list-group-item"><input type="checkbox" name="" value=""> 555</li>
                </ul>
              </div>
              <div class="tab-pane fade" id="profile">
                <ul class="list-group">
                  <li class="list-group-item">
                    <span class="badge">33</span>
                    111
                  </li>
                  <li class="list-group-item">
                    <span class="badge">9</span>
                    222
                  </li>
                  <li class="list-group-item">
                    <span class="badge">0</span>
                    333
                  </li>
                  <li class="list-group-item">
                    <span class="badge">14</span>
                    555
                  </li>
                  <li class="list-group-item">
                    <span class="badge">2</span>
                    666
                  </li>
                </ul>
              </div>
              <div class="tab-pane fade" id="messages">
                <div class="list-group">
                  <a href="#" class="list-group-item active">
                    777
                  </a>
                  <a href="#" class="list-group-item">888</a>
                  <a href="#" class="list-group-item">999</a>
                  <a href="#" class="list-group-item">000</a>
                  <a href="#" class="list-group-item">111</a>
                </div>
              </div>
              <div class="tab-pane fade" id="settings">
                <div class="list-group">
                  <a href="#" class="list-group-item disabled">
                    ㅁㅁㅁ
                  </a>
                  <a href="#" class="list-group-item">ㅂㅈㄷㄱ</a>
                  <a href="#" class="list-group-item">테스트</a>
                  <a href="#" class="list-group-item">111</a>
                  <a href="#" class="list-group-item">ㅇㅇㅇ</a>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-sm-6">
            <div class="panel-group" id="accordion">
              <div class="panel panel-default">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                      제목 1
                    </a>
                  </h4>
                </div>
                <div id="collapseOne" class="panel-collapse collapse in">
                  <div class="panel-body">
                    내용입니다.
                  </div>
                </div>
              </div>
              <div class="panel panel-default">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                      제목 2
                    </a>
                  </h4>
                </div>
                <div id="collapseTwo" class="panel-collapse collapse">
                  <div class="panel-body">
                    내용입니다.
                  </div>
                </div>
              </div>
              <div class="panel panel-default">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
                      제목 3
                    </a>
                  </h4>
                </div>
                <div id="collapseThree" class="panel-collapse collapse">
                  <div class="panel-body">
                    내용입니다.
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>-->
      </div>
    </div>
  </div>
  <!-- Modal -->
  <div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
          <h4 class="modal-title" id="myModalLabel">로그아웃 하시겠습니까?</h4>
        </div>
        <div class="modal-footer">
          <a href="sign-in.html" class="btn btn-primary">Yes</a>
          <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
        </div>
      </div>
    </div>
  </div>
  <footer class="templatemo-footer">
    <div class="templatemo-copyright">
      <p>Copyright &copy; 2022 H&T Technology</p>
    </div>
  </footer>
</div>

<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<!--script src="/js/Chart.min.js"></script-->
<script src="/js/templatemo_script.js"></script>
<script src="https://cdn.jsdelivr.net/npm/moment@2.29.1/min/moment.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4"></script>
<script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-streaming@1.9.0"></script>

<script type="text/javascript">
  var chartColors = {
    red: 'rgb(255, 99, 132)',
    orange: 'rgb(255, 159, 64)',
    yellow: 'rgb(255, 205, 86)',
    green: 'rgb(75, 192, 192)',
    blue: 'rgb(54, 162, 235)',
    purple: 'rgb(153, 102, 255)',
    grey: 'rgb(201, 203, 207)'
  };

  var xval = 0;
  var yval = 0;
  var titleStr = "";

  function getData() {
    $.ajax({
      url: '/main/getData',
      async: true,
      type: 'POST',
      dataType: 'json',
      contentType: 'application/json',
      success: function(result) {
        if(result.resultCode == "200") {
          yval = result.dataVal;
          xval = result.num;
          titleStr = result.titleStr;
        }
      },
      error: function(result) {

      }
    });

    return yval;
    //return (Math.random() > 0.5 ? 1.0 : -1.0) * Math.round(Math.random() * 100);
  }

  function onRefresh(chart) {
    var now = Date.now();

    chart.data.datasets.forEach(function(dataset) {
      dataset.data.push({
        x: now,
        //x: xval,
        y: getData()
        //y: yval
      });
    });
  }

  var color = Chart.helpers.color;
  var config = {
    type: 'line',
    data: {
      datasets: [{
        label: titleStr,
        backgroundColor: color(chartColors.red).alpha(0.5).rgbString(),
        borderColor: chartColors.red,
        fill: false,
        lineTension: 0,
        //borderDash: [8, 4],
        data: []
      }
      /**, {
        label: titleStr,
        backgroundColor: color(chartColors.blue).alpha(0.5).rgbString(),
        borderColor: chartColors.blue,
        fill: false,
        cubicInterpolationMode: 'monotone',
        data: []
      }**/
       ]
    },
    options: {
      title: {
        display: true,
        text: 'Line chart'
      },
      scales: {
        xAxes: [{
          type: 'realtime',
          realtime: {
            duration: 20000,
            refresh: 3000,
            delay: 2000,
            onRefresh: onRefresh
          }
        }],
        yAxes: [{
          scaleLabel: {
            display: true,
            labelString: 'value'
          }
        }]
      },
      tooltips: {
        mode: 'nearest',
        intersect: false
      },
      hover: {
        mode: 'nearest',
        intersect: false
      }
    }
  };

  window.onload = function() {
    var ctx = document.getElementById('sensorChart').getContext('2d');
    window.myChart = new Chart(ctx, config);
    config.type = 'line';
  };

  $('#myTab a').click(function (e) {
    e.preventDefault();
    $(this).tab('show');
  });

  $('#loading-example-btn').click(function () {
    var btn = $(this);
    btn.button('loading');
    // $.ajax(...).always(function () {
    //   btn.button('reset');
    // });
  });
</script>
</body>
</html>