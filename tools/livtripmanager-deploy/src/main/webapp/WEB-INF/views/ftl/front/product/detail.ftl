[#escape x as x?html]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>${hotelDetail.name}-${hotelDetail.keywords}酒店详情页</title>
    <link rel="stylesheet" href="${base}/resources/style/public.css"/>
    <link rel="stylesheet" href="http://g.alicdn.com/sui/sui3/0.0.2/old/css/icons.min.css"/>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="http://g.alicdn.com/sui/sui3/0.0.18/css/sui.min.css">
    <script type="text/javascript" src="http://g.alicdn.com/sj/lib/jquery/dist/jquery.min.js"></script>
    <script type="text/javascript" src="http://g.alicdn.com/sui/sui3/0.0.18/js/sui.min.js"></script>
    <script src='http://maps.google.cn/maps/api/js?key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM' type="text/javascript"></script>
    <script src="${base}/resources/js/product/detail.js"></script>
</head>

<body onload="loadMap()">
<div id="address_text" style="display: none">${hotelDetail.address}</div>
<div id="lat" style="display:none">${hotelDetail.latitude}</div>
<div id="lng" style="display:none">${hotelDetail.longitude}</div>
[#include  "nav.ftl"/]
<div class="container">
    <ol class="breadcrumb" style="margin:0px;">
        <li><a href="#">首页</a></li>
        <li><a href="#">香港酒店</a></li>
        <li class="active">${hotelDetail.name}</li>
    </ol>
    <div class="base_info">
        <ul>
            <li style="width:25%;">
                <img src="${hotelDetail.thumb}" width="280px" height="100%;" class="border-radius-3"/>
            </li>
            <li style="width:47%;">
                <h3 style="color:#82B5CD; margin:0px;">${hotelDetail.name}&nbsp;
                    [#if hotelDetail.isBest == 1]
                        <i class="fa fa-thumbs-o-up" style="color:#FB7F49"></i>
                    [/#if]
                </h3>
                <p style="color:#FB7F49;" >
                    <i class="fa  fa-star"></i>
                    <i class="fa  fa-star"></i>
                    <i class="fa  fa-star"></i>
                    <i class="fa  fa-star-half-full"></i>
                </p>
                <p style="margin:0px; font-size:15px;">
                    <i class="fa fa-map-marker"></i>&nbsp;
                    ${hotelDetail.address}
                </p>
                <div class="hotel_pics_box">
                    <ul >
                        [#list hotelDetail.hotelImageVOList as image]
                            [#if image_index > 7]
                                [#break ]
                            [/#if]
                            <li><img  src="${image.path}"/></li>
                        [/#list]
                    </ul>
                </div>
            </li>
            <li style="width:25%;">
                <p class="text-right" style="font-size:22px; color:#FF0000; font-weight:bold; height:50px;">$ ${hotelDetail.salePrice} 起</p>
                <div class="small_map" id="small_map"></div>
            </li>
        </ul>
    </div>
</div>

<div class="container">
    <div class="detail_left">
        <div class="panel panel-default">
            <div class="panel-heading">酒店预订</div>
            <div class="panel-body">
                <table class="table table-bordered">
                    <tr>
                        <th>房型</th>
                        <th style="text-align: center">每晚均价</th>
                        <th style="text-align: center">政策</th>
                        <th></th>
                    </tr>
                    [#list hotelDetail.roomTypeList as roomType]
                        [#if roomType.isAvailable == true]
                        <tr>
                            <td style="max-width:300px;">${roomType.name}</td>
                            <td  style=" text-align:center; vertical-align:middle;">${roomType.occupancies[0].avrNightPrice}</td>
                            <td  style="text-align:center; vertical-align:middle;">policy</td>
                            <td style="min-width:60px; text-align:center; vertical-align:middle;"><button type="button" class="btn btn-primary">预订</button></td>
                        </tr>
                        [/#if]
                    [/#list]

                </table>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">酒店介绍</div>
            <div class="panel-body">
                ${hotelDetail.description}
                <br/>
                [#list hotelDetail.hotelDescriptionVOList as description]
                <h4>${description.category}</h4>
                <p class="text-justify">
                    ${description.value}
                </p>
                [/#list]
            </div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading">酒店政策</div>
            <div class="panel-body">
                幼儿0-1岁：在不加床的情况下，可免费入住。请注意，如果使用婴儿床可能需要支付额外费用。
                儿童2-12岁：在不加床的情况下可免费入住。
                * 12岁以上的旅客入住此酒店将按照成人标准收费。
                * 加床政策根据您所选定的客房而有所不同。
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">地理位置</div>
            <div class="panel-body">
                <div class="large_map" id="large_map"></div>
            </div>
        </div>
    </div>
    <div class="detail_right"></div>
</div>


<div class="container-fluid" style=" margin-top:10px;background:#EEEEEE; height:300px; ">
    <div class="footer">
    </div>
</div>

</body>
</html>
[/#escape]