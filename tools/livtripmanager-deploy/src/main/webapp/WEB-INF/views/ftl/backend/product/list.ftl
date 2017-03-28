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
        <form class="form-inline" action="list.html" method="post" style="margin:25px auto; padding:0px;">
            <div class="form-group">
                <label  class="control-label" for="inputSuccess1">产品名称</label>
                <input type="text"  name="name"  class="form-control" id="inputSuccess1"/>
            </div>
            <div class="form-group">
                <label  class="control-label" for="inputSuccess1">城市</label>
                <input type="text"  name="city"  class="form-control" id="inputSuccess1"/>
            </div>
            <div class="form-group">
                <label  class="control-label" for="inputSuccess1">酒店ID</label>
                <input type="text"  name="hotelId"  class="form-control" id="inputSuccess1"/>
            </div>
            <div class="form-group">
                <label class="control-label" for="inputSuccess2">精品</label>
                <select name="isBest" class="form-control" id="inputSuccess2">
                    <option value="-1">请选择</option>
                    <option value="0">否</option>
                    <option value="1">是</option>
                </select>
            </div>
            <div class="form-group">
                <label class="control-label" for="inputSuccess2">星级</label>
                <select name="" class="form-control" id="inputSuccess2">
                    <option value="-1">请选择</option>
                    <option value="1">1星级</option>
                    <option value="1.5">1.5星级</option>
                    <option value="2">2星级</option>
                    <option value="2.5">2.5星级</option>
                    <option value="3">3星级</option>
                    <option value="3.5">3.5星级</option>
                    <option value="4">4星级</option>
                    <option value="4.5">4.5星级</option>
                    <option value="5">5星级</option>
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
            <th>州</th>
            <th>城市</th>
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
            <td>${product.state}</td>
            <td>${product.city}</td>
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
                    <button class="btn btn-bordered btn-primary" onclick="location='edit.html?productId=${product.id}'">详情</button>
                    <button class="btn btn-bordered btn-danger" onclick="javascript:if(confirm('确实要删除该内容吗?'))location='delete.html?productId=${product.id}'">删除</button>
                </div>
            </td>
        </tr>
        [/#list]
        </tbody>
    </table>
    <div class="page">
        <form id="listForm" action="list.jhtml" method="post" >
            <input type="hidden" name="name" value="${name}"/>
            <input type="hidden" name="city" value="${city}"/>
            <input type="hidden" name="hotelId" value="${hotelId}"/>
            <input type="hidden" name="isBest" value="${isBest}"/>
            <input type="hidden" name="starLevel" value="${starLevel}"/>
            [@pagination pageNumber = page.pageNumber totalPages = page.totalPages]
                [#include "pagination_admin.ftl"]
            [/@pagination]
        </form>
    </div>
</div>

</body>
</html>
[/#escape]