[#escape x as x?html]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>城市详情页</title>
    <link rel="stylesheet" href="${base}/resources/style/admin.css"/>
    <link rel="stylesheet" href="http://g.alicdn.com/sui/sui3/0.0.2/old/css/icons.min.css"/>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="http://g.alicdn.com/sui/sui3/0.0.18/css/sui.min.css">
    <script type="text/javascript" src="http://g.alicdn.com/sj/lib/jquery/dist/jquery.min.js"></script>
    <script type="text/javascript" src="http://g.alicdn.com/sui/sui3/0.0.18/js/sui.min.js"></script>
    <script src='http://maps.google.cn/maps/api/js?key=AIzaSyAjNbgkCbR5VzzBw2VsJagYKBASIJoa2iw' type="text/javascript"></script>
    <script src="${base}/resources/js/product/SingleMarkerMap.js"></script>
</head>
<body onload="loadMap();">
<div id="address_text" style="display: none">${city.name}</div>
<div id="lat" style="display:none">${city.latitude}</div>
<div id="lng" style="display:none">${city.longitude}</div>
<div class="container">
    <ol class="breadcrumb">
        <li><a href="#">后台管理</a></li>
        <li><a href="list.html">城市列表</a></li>
        <li class="active">城市详情页</li>
    </ol>
    <form class="form-horizontal" style="margin:20px 0px;">
        <div class="form-group form-group-sm">
            <label class="col-sm-2 control-label" for="state">城市名</label>
            <div class="col-sm-10">
                <input class="form-contro form-group-lg" type="text" value="${city.name}" id="state" />
            </div>
        </div>
        <div class="form-group form-group-sm">
            <label class="col-sm-2 control-label" for="country">DestinationCode</label>
            <div class="col-sm-10">
                <input class="form-contro form-group-lg" name="country" value="${city.destinationCode}" type="text" id="country" />
            </div>
        </div>

        <div class="form-group form-group-sm">
            <label class="col-sm-2 control-label" for="city">DestinatioId</label>
            <div class="col-sm-10">
                <input class="form-contro form-group-lg" value="${city.destinationId}" type="text" id="city" />
            </div>
        </div>
        <div class="form-group form-group-sm">
            <label class="col-sm-2 control-label" for="latitude">经度</label>
            <div class="col-sm-10">
                <input class="form-contro form-group-lg" value="${city.latitude}" type="text" id="latitude" />
            </div>
        </div>
        <div class="form-group form-group-sm">
            <label class="col-sm-2 control-label" for="longitude">纬度</label>
            <div class="col-sm-10">
                <input class="form-contro form-group-lg" value="${city.longitude}" type="text" id="longitude" />
            </div>
        </div>
        <div class="form-group form-group-sm">
            <div class="hotel_map" id="map"></div>
        </div>
        <button type="submit" class="btn btn-primary" style=" margin-left:150px;">提 交</button>
    </form>
</div>
</body>
</html>
[/#escape]