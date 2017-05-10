[#escape x as x?html]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>定时任务定义管理</title>
    <link rel="stylesheet" href="${base}/resources/style/admin.css"/>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="http://g.alicdn.com/sui/sui3/0.0.18/css/sui.min.css">
    <script type="text/javascript" src="http://g.alicdn.com/sj/lib/jquery/dist/jquery.min.js"></script>
    <script type="text/javascript" src="http://g.alicdn.com/sui/sui3/0.0.18/js/sui.min.js"></script>
    <script src='http://maps.google.cn/maps/api/js?key=AIzaSyAjNbgkCbR5VzzBw2VsJagYKBASIJoa2iw' type="text/javascript"></script>
    <script type="text/javascript" src="${base}/resources/js/page.js"></script>
</head>

<body>
<div class="container">
    <ol class="breadcrumb">
        <li><a href="#">后台管理</a></li>
        <li class="active">定时任务日志</li>
    </ol>
    <div style="margin-top:5px; padding:0px; border:1px solid #d1d1d1; height:80px; border-radius:5px; text-align:center">
        <form class="form-inline" id="listForm" action="logs.do" method="post" style="margin:25px auto; padding:0px;">
            <div class="form-group">
                <label class="control-label" for="inputSuccess2">任务名称</label>
                <select name="taskId" class="form-control" id="inputSuccess2">
                    <option value="-1">请选择</option>
                    <option value="1">产品采集任务</option>
                    <option value="2">酒店价格定时任务</option>
                </select>
            </div>
            <div class="form-group">
                <label class="control-label" for="inputSuccess2">运行状态</label>
                <select name="state" class="form-control" id="inputSuccess2">
                    <option value="-1">请选择</option>
                    <option value="R">运行中</option>
                    <option value="O">已结束</option>
                    <option value="E">异常</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary" style="width:120px">查询</button>
    </div>
</div>

<div class="container" >
    <table class="table table-primary" style="margin:10px 0px;">
        <thead>
        <tr>
            <th>任务名称</th>
            <th>任务ID</th>
            <th>运行状态</th>
            <th>创建人</th>
            <th>创建时间</th>
        </tr>
        </thead>
        <tbody>
            [#list page.list as taskLog]
            <tr>
                <td>${taskLog.taskCode}</td>
                <td>${taskLog.taskId}</td>
                <td>${taskLog.state}</td>
                <td>${taskLog.createPerson}</td>
                <td>${taskLog.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>

            </tr>
            [/#list]
        </tbody>
    </table>
    [@pagination pageNumber = page.pageNumber totalPages = page.totalPages]
        [#include "pagination_admin.ftl"/]
    [/@pagination]
    </form>
</div>

</body>
</html>
[/#escape]