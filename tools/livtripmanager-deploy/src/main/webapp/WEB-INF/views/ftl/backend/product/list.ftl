[#escape x as x?html]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>产品管理</title>
    <link rel="stylesheet" href="${base}/resources/style/admin.css"/>
    <link rel="stylesheet" href="http://g.alicdn.com/sui/sui3/0.0.2/old/css/icons.min.css"/>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="http://g.alicdn.com/sui/sui3/0.0.18/css/sui.min.css">
    <script type="text/javascript" src="http://g.alicdn.com/sj/lib/jquery/dist/jquery.min.js"></script>
    <script type="text/javascript" src="http://g.alicdn.com/sui/sui3/0.0.18/js/sui.min.js"></script>
    <script src='http://maps.google.cn/maps/api/js?key=AIzaSyAjNbgkCbR5VzzBw2VsJagYKBASIJoa2iw' type="text/javascript"></script>
</head>

<body>
<div class="container">
    <ol class="breadcrumb">
        <li><a href="#">后台管理</a></li>
        <li class="active">产品列表</li>
    </ol>
    <div style="margin-top:5px; padding:0px; border:1px solid #d1d1d1; height:80px; border-radius:5px; text-align:center">
        <form class="form-inline" style="margin:25px auto; padding:0px;">
            <div class="form-group">
                <label  class="control-label" for="inputSuccess1">产品名称</label>
                <input type="text"  name="search"  class="form-control" id="inputSuccess1"/>
            </div>
            <div class="form-group">
                <label class="control-label" for="inputSuccess2">品牌</label>
                <select class="form-control" id="inputSuccess2">
                    <option value="0">请选择</option>
                    <option value="1">Hampton Hotels</option>
                    <option value="1">Park Hyatt</option>
                    <option value="1">Best Western</option>
                </select>
            </div>
            <div class="form-group">
                <label class="control-label" for="inputSuccess2">星级</label>
                <select class="form-control" id="inputSuccess2">
                    <option value="0">请选择</option>
                    <option value="1">1星级</option>
                    <option value="1">2星级</option>
                    <option value="1">3星级</option>
                </select>
            </div>
            <div class="form-group">
                <label class="control-label" for="inputSuccess2">采集状态</label>
                <select class="form-control" id="inputSuccess2">
                    <option value="0">请选择</option>
                    <option value="1">已采集</option>
                    <option value="1">未采集</option>

                </select>
            </div>
            <button type="submit" class="btn btn-primary" style="width:120px">查询</button>
        </form>
    </div>
</div>

<div class="container" >
    <table class="table table-primary" style="margin:10px 0px;">
        <thead>
        <tr>
            <th>产品名称</th>
            <th>酒店ID</th>
            <th>精品</th>
            <th>星级</th>
            <th>房间数</th>
            <th width="15%">操作</th>
        </tr>
        </thead>
        <tbody>
        [#list page.list as product]
        <tr>
            <td>${product.name}</td>
            <td>${product.hotelId}</td>
            <td>
            [#if product.isBest == 1]
                是
            [#else]
                否
            [/#if]
            </td>
            <td>${product.startLevel}</td>
            <td>${product.rooms}</td>
            <td align="right">
                <div class="btn-group">
                    <button class="btn btn-bordered btn-primary">详情</button>
                    <button class="btn btn-bordered btn-danger">删除</button>
                </div>
            </td>
        </tr>
        [/#list]

        </tbody>
    </table>
</div>
</body>
</html>
[/#escape]