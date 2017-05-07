[#escape x as x?html]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>list</title>
    <link rel="stylesheet" href="${base}/resources/style/public.css"/>
    <link rel="stylesheet" href="http://g.alicdn.com/sui/sui3/0.0.2/old/css/icons.min.css"/>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="http://g.alicdn.com/sui/sui3/0.0.18/css/sui.min.css">
    <script type="text/javascript" src="http://g.alicdn.com/sj/lib/jquery/dist/jquery.min.js"></script>
    <script type="text/javascript" src="http://g.alicdn.com/sui/sui3/0.0.18/js/sui.min.js"></script>
    <script src='http://maps.google.cn/maps/api/js?key=AIzaSyAjNbgkCbR5VzzBw2VsJagYKBASIJoa2iw' type="text/javascript"></script>
    <script src="${base}/resources/js/page.js"></script>
    <script src="${base}/resources/js/product/list.js"></script>
</head>

<body onload="initizePittingMap();">
[#include  "nav.ftl"/]
[#include  "search.ftl"/]

<div class="container">
    <div class="breadcrumb_list">
        ${destinationName} 地区 共 <font color="#FF0000">${page.total}</font> 家酒店  当前 ${page.pageNum}/${page.pages} 页
    </div>
</div>
<div class="container">
    <div class="product_list">
        <div id="pids" style="display:none;">${pids}</div>
        <div style="display:none;">
            [#list page.list as product]
                <div id="${product.id}_latitude" style="display: none">${product.latitude}</div>
                <div id="${product.id}_longitude" style="display: none">${product.longitude}</div>
                <div id="${product.id}_map_view" style="width:185px;height:80px;text-align:left; display:none">
                ${product.address}<br>${product.city}<br>${product.state} ${product.country}
                </div>
            [/#list]
        </div>
        <ul>
            [#list page.list as product]
            <li>
                <div class="product_item_left">
                    <img src="${product.thumb}" />
                </div>
                <div class="product_item_right">
                    <h3 style="font-size: 14px">
                        <img src="https://raw.githubusercontent.com/Concept211/Google-Maps-Markers/master/images/marker_red${product_index + 1}.png"/>
                        &nbsp;${product.name}
                    </h3>
                    <p style="color:#FB7F49;" >
                        <i class="fa  fa-star"></i>
                        <i class="fa  fa-star"></i>
                        <i class="fa  fa-star"></i>
                        <i class="fa  fa-star-half-full"></i>
                    </p>
                    <p style="margin:0px; font-size:15px;">
                        <i class="fa fa-map-marker"></i>&nbsp;
                        ${product.address}
                    </p>
                    <div class="hotel_price_area">
                        <p class="lowest_price">
                            每晚低至 <span><i class="fa fa-dollar"></i>
                             ${product.minAvgNightPrice}</span>
                        </p>
                        <p class="booking_policy">免费取消,即刻确认</p>
                        <p class="user_room_area">
                            <button type="button"
                                    onclick="window.location.href='detail.do?productId=${product.id}&destination=${destination}&checkIn=${checkIn}&checkOut=${checkOut}&peopleNum=${peopleNum}'" class="btn btn-primary">选择客房>></button>
                        </p>
                    </div>
                </div>
            </li>
             [/#list]
        </ul>

        <form id="listForm" action="list.jhtml" method="post" class="sui-form form-horizontal">
            <input type="hidden" name="destinationName" value="${destinationName}"/>
            <input type="hidden" name="destination" value="${destination}"/>
            <input type="hidden" name="checkIn" value="${checkIn}"/>
            <input type="hidden" name="checkOut" value="${checkOut}"/>
            <input type="hidden" name="peopleNum" value="${peopleNum}"/>
            [@pagination pageNumber = page.pageNum totalPages = page.total]
                [#include "pagination.ftl"/]
            [/@pagination]
        </form>
    </div>

    <div class="product_map" id="list_map"></div>
</div>

<div class="container-fluid" style=" margin-top:10px;background:#EEEEEE; height:300px; ">
    <div class="footer">

    </div>
</div>
</body>
</html>


[/#escape]