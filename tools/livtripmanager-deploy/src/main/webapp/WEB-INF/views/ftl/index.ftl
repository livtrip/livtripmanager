<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>index</title>
    <link rel="stylesheet" href="resources/style/public.css"/>
    <link rel="stylesheet" href="http://g.alicdn.com/sui/sui3/0.0.2/old/css/icons.min.css"/>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="http://g.alicdn.com/sui/sui3/0.0.18/css/sui.min.css">
    <script type="text/javascript" src="http://g.alicdn.com/sj/lib/jquery/dist/jquery.min.js"></script>
    <script type="text/javascript" src="http://g.alicdn.com/sui/sui3/0.0.18/js/sui.min.js"></script>
    <script src='http://maps.google.cn/maps/api/js?key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM' type="text/javascript"></script>
    <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
    <script>
        (adsbygoogle = window.adsbygoogle || []).push({
            google_ad_client: "ca-pub-3237101361515251",
            enable_page_level_ads: true
        });
    </script>
    <script>
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
                    (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
                m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
        })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

        ga('create', 'UA-100338539-1', 'auto');
        ga('send', 'pageview');

    </script>
</head>


<body>
<nav class="navbar navbar-default">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">LivTrip</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">美东</a></li>
                <li><a href="#">美西</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">景区 <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">黄石公园</a></li>
                        <li><a href="#">自由女神像</a></li>
                        <li><a href="#">夏威夷</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>

                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">注册</a></li>
                <li><a href="#">登录</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>


<div class="container">
    <div style="margin-top:15px; padding:0px; border:1px solid #d1d1d1; height:120px; border-radius:5px; text-align:center">
        <form class="form-inline" action="front/product/list" method="get" style="margin:45px auto; padding:0px;">
            <div class="form-group">
                <input type="text" id="destination"  name="destination" placeholder="您感兴趣的城市"
                       data-toggle="autocomplete" data-service-url="front/product/getCity.json" class="form-control" style="width:250px;border-radius:12px;"/>
            </div>
            <div class="form-group input-daterange" data-toggle="datepicker" >
                <input type="text" name="checkIn" id="checkIn" class="form-control input-date" placeholder="入住日期"  /> -
                <input type="text" name="checkOut" id="checkOut" class="form-control input-date" placeholder="退房日期" />
            </div>
            <div class="form-group">
                <select class="form-control" style="width:100px" name="peopleNum">
                    <option value="1">人数</option>
                    <option value="1">1人</option>
                    <option value="2">2人</option>
                    <option value="3">3人</option>
                    <option value="4">4人</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary" style="width:120px">搜索</button>
        </form>
    </div>
</div>
<div class="container"  style="margin-top:15px;">
    <div class="row">
        <div class="col-xs-6 col-md-6">
            <a href="#" class="thumbnail">
                <img  src="resources/images/a9.jpg" alt="..."/>
            </a>
        </div>
        <div class="col-xs-6 col-md-6">
            <a href="#" class="thumbnail">
                <img  src="resources/images/a11.jpg" alt="..."/>
            </a>
        </div>
    </div>
</div>
<div class="container" style="margin-top:15px;">
    <div class="row">
        <div class="col-xs-6 col-md-3">
            <a href="#" class="thumbnail">
                <img  src="resources/images/am0.jpg" alt="...">
            </a>
        </div>
        <div class="col-xs-6 col-md-3">
            <a href="#" class="thumbnail">
                <img  src="resources/images/am2.jpg" alt="...">
            </a>
        </div>
        <div class="col-xs-6 col-md-3">
            <a href="#" class="thumbnail">
                <img  src="resources/images/am3.jpg" alt="...">
            </a>
        </div>
        <div class="col-xs-6 col-md-3">
            <a href="#" class="thumbnail">
                <img  src="resources/images/am4.jpg" alt="...">
            </a>
        </div>
    </div>
</div>
<div class="container"  style="margin-top:15px;">
    <div class="row">
        <div class="col-xs-6 col-md-3">
            <a href="#" class="thumbnail">
                <img  src="resources/images/am7.jpg" alt="...">
            </a>
        </div>
        <div class="col-xs-6 col-md-3">
            <a href="#" class="thumbnail">
                <img  src="resources/images/am8.jpg" alt="...">
            </a>
        </div>
        <div class="col-xs-6 col-md-3">
            <a href="#" class="thumbnail">
                <img  src="resources/images/am9.jpg" alt="...">
            </a>
        </div>
        <div class="col-xs-6 col-md-3">
            <a href="#" class="thumbnail">
                <img  src="resources/images/wy.jpg" alt="...">
            </a>
        </div>
    </div>
</div>

<div class="container-fluid" style=" margin-top:10px;background:#EEEEEE; height:300px; ">
    <div class="footer">

    </div>
</div>
</body>
</html>
