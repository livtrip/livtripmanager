[#escape x as x?html]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>产品详情页</title>
    <link rel="stylesheet" href="${base}/resources/style/admin.css"/>
    <link rel="stylesheet" href="http://g.alicdn.com/sui/sui3/0.0.2/old/css/icons.min.css"/>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="http://g.alicdn.com/sui/sui3/0.0.18/css/sui.min.css">
    <script type="text/javascript" src="http://g.alicdn.com/sj/lib/jquery/dist/jquery.min.js"></script>
    <script type="text/javascript" src="http://g.alicdn.com/sui/sui3/0.0.18/js/sui.min.js"></script>
    <script src='http://maps.google.cn/maps/api/js?key=AIzaSyAjNbgkCbR5VzzBw2VsJagYKBASIJoa2iw' type="text/javascript"></script>
    <script src="${base}/resources/js/product/SingleMarkerMap.js"></script>
</head>
<body>
<div id="address_text" style="display: none">${product.address}</div>
<div id="lat" style="display:none">${product.latitude}</div>
<div id="lng" style="display:none">${product.longitude}</div>
<div class="container">
    <ol class="breadcrumb">
        <li><a href="#">后台管理</a></li>
        <li><a href="javascription.hsitory(-1);">产品列表</a></li>
        <li class="active">产品详情页</li>
    </ol>

    <div role="tabpanel">

        <!-- Nav tabs -->
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">基础信息</a></li>
            <li role="presentation"><a href="#description" aria-controls="description" role="tab" data-toggle="tab">详情描述</a></li>
            <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">图片资源</a></li>
            <li role="presentation"><a href="#messages" onclick="loadMap();" aria-controls="messages" role="tab" data-toggle="tab">地理位置</a></li>
            <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">房型数据</a></li>
        </ul>

        <!-- Tab panes -->
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="home">
                <form class="form-horizontal" style="margin:20px 0px;">
                    <div class="form-group">
                        <label for="product_name" class="col-sm-2 control-label">产品名称</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="product_name" value="${product.name}">
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label class="col-sm-2 control-label" for="hotel_id">酒店ID</label>
                        <div class="col-sm-10">
                            <input class="form-contro form-group-sm" disabled="disabled" name="hotelId" value="${product.hotelId}" type="text" id="hotel_id" />
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label class="col-sm-2 control-label" for="star">星级</label>
                        <div class="col-sm-10">
                            <input class="form-contro form-group-sm" name="startLevel" value="${product.startLevel}" type="text" id="star" />
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label class="col-sm-2 control-label" for="hotel_brand">酒店品牌</label>
                        <div class="col-sm-10">
                            <input class="form-contro form-group-sm" type="text" name="brandName" value="${product.brandName}" id="hotel_brand" />
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label class="col-sm-2 control-label" for="currency">计价货币</label>
                        <div class="col-sm-10">
                            <input class="form-contro form-group-sm" type="text" name="currency" value="${product.currency}" id="currency" />
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label class="col-sm-2 control-label" for="rooms">房间数</label>
                        <div class="col-sm-10">
                            <input class="form-contro form-group-sm" type="text" name="rooms" value="${product.rooms}" id="rooms"  />
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label class="col-sm-2 control-label" for="checkInTime">入住时间</label>
                        <div class="col-sm-10">
                            <input class="form-contro form-group-sm" type="text" name="checkInTime" value="${product.checkInTime}" id="checkInTime"  />
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label class="col-sm-2 control-label" for="checkOutTime">退房时间</label>
                        <div class="col-sm-10">
                            <input class="form-contro form-group-sm" type="text" name="checkOutTime" value="${product.checkOutTime}" id="checkOutTime" />
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label class="col-sm-2 control-label" for="phone">酒店电话</label>
                        <div class="col-sm-10">
                            <input class="form-contro form-group-sm" type="text" id="hotelPhone" value="${product.hotelPhone}" />
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label class="col-sm-2 control-label" for="fax">传真</label>
                        <div class="col-sm-10">
                            <input class="form-contro form-group-sm" type="text" id="hotelFax" name="hotelFax" value="${product.hotelFax}" />
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary" style=" margin-left:150px;">提 交</button>
                </form>
            </div>

            <div role="tabpanel" class="tab-pane" id="description">
                <form style="margin:20px 0px;">
                   [#list product.hotelDescriptionVOList as description]
                    <div class="form-group">
                        <label for="category">${description.category}</label>
                        <textarea  type="email" class="form-control" id="category" rows="5">${description.value}</textarea>
                    </div>
                    [/#list]
                    <button type="submit" class="btn btn-primary" style=" margin-left:150px;">提 交</button>
                </form>
            </div>
            <div role="tabpanel" class="tab-pane" id="profile">
                <ul class="product_images_ul">
                    [#list product.hotelImageVOList as image]
                    <li>
                        <img src="${image.path}" alt="..."/>
                    </li>
                    [/#list]
                </ul>
            </div>
            <div role="tabpanel" class="tab-pane" id="messages">
                <form class="form-horizontal" style="margin:20px 0px;">
                    <div class="form-group form-group-sm">
                        <label class="col-sm-2 control-label" for="country">国家</label>
                        <div class="col-sm-10">
                            <input class="form-contro form-group-lg" name="country" value="${product.country}" type="text" id="country" />
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label class="col-sm-2 control-label" for="state">州</label>
                        <div class="col-sm-10">
                            <input class="form-contro form-group-lg" type="text" value="${product.state}" id="state" />
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label class="col-sm-2 control-label" for="city">城市</label>
                        <div class="col-sm-10">
                            <input class="form-contro form-group-lg" value="${product.city}" type="text" id="city" />
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label class="col-sm-2 control-label" for="address">具体地址</label>
                        <div class="col-sm-10">
                            <input class="form-contro form-group-lg" value="${product.address}" type="text" id="address" />
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label class="col-sm-2 control-label" for="latitude">经度</label>
                        <div class="col-sm-10">
                            <input class="form-contro form-group-lg" value="${product.latitude}" type="text" id="latitude" />
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label class="col-sm-2 control-label" for="longitude">纬度</label>
                        <div class="col-sm-10">
                            <input class="form-contro form-group-lg" value="${product.longitude}" type="text" id="longitude" />
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <div class="hotel_map" id="map"></div>
                    </div>

                    <button type="submit" class="btn btn-primary" style=" margin-left:150px;">提 交</button>
                </form>
            </div>
            <div role="tabpanel" class="tab-pane" id="settings">44</div>
        </div>

    </div>
</div>
</body>
</html>


[/#escape]