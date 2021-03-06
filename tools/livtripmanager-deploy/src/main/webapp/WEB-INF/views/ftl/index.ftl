<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Livtrip  Focus on America Hotel</title>
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
<div class="container-fluid" style="background: #58B7FF;height: 400px;">
    <div class="index_logo">
        Livtrip  Focus on America Hotel
    </div>
    <div class="search_span">
        <form class="form-inline" action="front/product/list" method="get" style="margin:15px auto; padding:0px;">
            <div class="form-group">
                <input type="text" id="destination"  name="destination" placeholder="please input city name"
                       data-toggle="autocomplete" data-service-url="front/product/getCity.json" class="form-control input-lg" style="width:250px;border-radius:12px;"/>
            </div>
            <div class="form-group input-daterange" data-toggle="datepicker" >
                <input type="text" name="checkIn" id="checkIn" class="form-control input-date input-lg" placeholder="CheckIn"  /> -
                <input type="text" name="checkOut" id="checkOut" class="form-control input-date input-lg" placeholder="CheckOut" />
            </div>
            <div class="form-group">
                <select class="form-control input-lg" style="width:100px; " name="peopleNum">
                    <option value="1">peopleNum</option>
                    <option value="1">1 customer</option>
                    <option value="2">2 customer</option>
                    <option value="3">3 customer</option>
                </select>
            </div>

            <button type="submit" class="btn btn-danger btn-lg" style="width:120px;">Search</button>
        </form>

    </div>
</div>
<div class="container" >
    <div class="row">
        <div class="col-md-8"><div class="index_city_image">
            <a href="front/product/list?destination=New York, NY"><img src="resources/images/newyork.png" /></a>
        </div></div>
        <div class="col-md-4"><div class="index_city_image">
            <a href="front/product/list?destination=Washington, DC"><img src="resources/images/dc.jpg" /></a></div></div>
    </div>
    <div class="row">
        <div class="col-md-4"><div class="index_city_image">
            <a href="front/product/list?destination=Los Angeles, CA"><img src="resources/images/miami.jpg" /></a></div></div>
        <div class="col-md-4"><div class="index_city_image">
            <a href="front/product/list?destination=New York, NY"><img src="resources/images/LosAngeles.jpg" /></a></div></div>
        <div class="col-md-4"><div class="index_city_image">
            <a href="front/product/list?destination=New York, NY"><img src="resources/images/LosAngeles.jpg" /></a></div></div>
    </div>
</div>



<div class="container-fluid" style="background: #F9FAFC;height: 300px;">

</div>

</body>
</html>
