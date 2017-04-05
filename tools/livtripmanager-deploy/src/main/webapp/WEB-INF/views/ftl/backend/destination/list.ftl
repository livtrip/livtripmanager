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
    <link rel="stylesheet" href="${base}/resources/js/page.js"/>
</head>

<body>
<div class="container">
    <ol class="breadcrumb">
        <li><a href="#">后台管理</a></li>
        <li class="active">城市列表</li>
    </ol>
    <div style="margin-top:5px; padding:0px; border:1px solid #d1d1d1; height:80px; border-radius:5px; text-align:center">
        <form class="form-inline"  id="listForm" action="list.html" method="post" style="margin:25px auto; padding:0px;">
            <div class="form-group">
                <label  class="control-label" for="inputSuccess1">城市名称</label>
                <input type="text"  name="cityName" value="${cityQuery.cityName}"  class="form-control" id="inputSuccess1"/>
            </div>
            <div class="form-group">
                <label  class="control-label" for="inputSuccess1">所属州</label>
                <input type="text"  name="stateName" value="${cityQuery.stateName}" class="form-control" id="inputSuccess1"/>
            </div>
            <div class="form-group">
                <label  class="control-label" for="inputSuccess1">DestinationID</label>
                <input type="text"  name="destinationId" value="${cityQuery.destinationId}"  class="form-control" id="inputSuccess1"/>
            </div>
            <div class="form-group">
                <label  class="control-label" for="inputSuccess1">DestinationCode</label>
                <input type="text"  name="destinationCode" value="${cityQuery.destinationCode}"  class="form-control" id="inputSuccess1"/>
            </div>
            <button type="submit" class="btn btn-primary" style="width:120px">查询</button>
    </div>
</div>

<div class="container" >
    <table class="table table-primary" style="margin:10px 0px;">
        <thead>
        <tr>
            <th>城市名称</th>
            <th>DestinationID</th>
            <th>DestinationCode</th>
            <th>所属州</th>
            <th>州名简称</th>
            <th width="15%">操作</th>
        </tr>
        </thead>
        <tbody>
            [#list page.list as destination]
            <tr>
                <td>${destination.cityName}</td>
                <td>${destination.destinationId}</td>
                <td>${destination.destinationCode}</td>
                <td>${destination.stateName}</td>
                <td>${destination.stateShort}</td>
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
    [@pagination pageNumber = page.pageNumber totalPages = page.totalPages]
        [#include "pagination_admin.ftl"]
    [/@pagination]
    </form>
</div>

</body>
</html>
[/#escape]