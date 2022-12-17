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
<input type="hidden" id="userId" name="userId" value="${userId}" />
<input type="hidden" id="userNm" name="userNm" value="${userNm}" />
<input type="hidden" id="userGrade" name="userGrade" value="${userGrade}" />

<div id="main-wrapper">
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
                <li class="active"><a href="/main/main"><i class="fa fa-home"></i>Dashboard</a></li>
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
                <li><a href="/chart/chart"><i class="fa fa-cubes"></i>센서 정보</a></li>
                <li><a href="/admin/admin"><i class="fa fa-cog"></i>기본 설정</a></li>
                <li><a href="" data-toggle="modal" data-target="#confirmModal"><i class="fa fa-sign-out"></i>로그아웃</a></li>
            </ul>
        </div><!--/.navbar-collapse -->

        <div class="templatemo-content-wrapper">
            <div class="templatemo-content">
                <ol class="breadcrumb">
                    <li class="active">센서 정보</li>
                </ol>
                <h1>센서 정보</h1>
                <p></p>
                <div class="templatemo-charts">
                    <!--<div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="panel panel-info">
                                <div class="panel-heading">Pie Chart &amp; Doughnut Chart</div>
                            </div>
                            <div class="row templatemo-chart-row">

                                <div class="templatemo-chart-box col-lg-3 col-md-3 col-sm-4 col-xs-12">
                                    <canvas id="templatemo-pie-chart"></canvas>
                                    <h4>Pie Chart</h4>
                                    <span class="text-muted">Maecenas non</span>
                                </div>

                                <div class="templatemo-chart-box col-lg-3 col-md-3 col-sm-4 col-xs-12">
                                    <canvas id="templatemo-doughnut-chart"></canvas>
                                    <h4>Doughnut Chart</h4>
                                    <span class="text-muted">Sodales orci aliquet</span>
                                </div>

                                <div class="templatemo-chart-box col-lg-3 col-md-3 col-sm-4 col-xs-12">
                                    <canvas id="templatemo-radar-chart"></canvas>
                                    <h4>Radar Chart</h4>
                                    <span class="text-muted">Lorem sed</span>
                                </div>

                                <div class="templatemo-chart-box col-lg-3 col-md-3 col-sm-4 col-xs-12">
                                    <canvas id="templatemo-polar-chart"></canvas>
                                    <h4>Polar Area Chart</h4>
                                    <span class="text-muted">Curabitur</span>
                                </div>

                            </div>
                        </div>
                    </div>-->
                    <div class="row">
                        <div class="col-md-6 col-sm-6">
                            <div class="panel panel-success">
                                <div class="panel-heading">Line Chart</div>
                                <canvas id="sensorChartLine" height="400" width="500"></canvas>
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <div class="panel panel-primary">
                                <div class="panel-heading">Bar Chart</div>
                                <canvas id="sensorChartBar" height="400" width="500"></canvas>
                            </div>
                        </div>
                    </div>
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
                        <a href="/login/logout?userId=${userId}" class="btn btn-primary">Yes</a>
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
    var loginUserId = $('#userId').val();

    var sendData = {
        userId: loginUserId
    }

    function getData() {
        $.ajax({
            url: '/main/getData',
            async: true,
            type: 'POST',
            data: JSON.stringify(sendData),
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
            }]
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

    var config2 = {
        type: 'bar',
        data: {
            datasets: [{
                label: titleStr,
                backgroundColor: color(chartColors.blue).alpha(0.5).rgbString(),
                borderColor: chartColors.blue,
                fill: false,
                lineTension: 0,
                //borderDash: [8, 4],
                data: []
            }]
        },
        options: {
            title: {
                display: true,
                text: 'Bar chart'
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
        var ctx = document.getElementById('sensorChartLine').getContext('2d');
        window.myChart = new Chart(ctx, config);

        var ctx2 = document.getElementById('sensorChartBar').getContext('2d');
        window.myBar = new Chart(ctx2, config2);
    };
</script>
</body>
</html>