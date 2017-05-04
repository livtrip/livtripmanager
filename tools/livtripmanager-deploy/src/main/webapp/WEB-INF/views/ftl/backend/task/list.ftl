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
        <li class="active">定时任务</li>
    </ol>
    <div style="margin-top:5px; padding:0px; border:1px solid #d1d1d1; height:80px; border-radius:5px; text-align:center">
        <form class="form-inline" id="listForm" action="list.html" method="post" style="margin:25px auto; padding:0px;">
            <div class="form-group">
                <label  class="control-label" for="inputSuccess1">任务名称</label>
                <input type="text"  name="taskCode" value="${taskCode}"  class="form-control" id="inputSuccess1"/>
            </div>
            <div class="form-group">
                <label  class="control-label" for="inputSuccess1">状态</label>
                <input type="text"  name="state" value="${state}"  class="form-control" id="inputSuccess1"/>
            </div>
            <div class="form-group">
                <label class="control-label" for="inputSuccess2">状态</label>
                <select name="state" class="form-control" id="inputSuccess2">
                    <option [#if state==null]selected="selected"[/#if] value="-1">请选择</option>
                    <option [#if state=='U']selected="selected"[/#if] value="U">启动</option>
                    <option [#if state=='O']selected="selected"[/#if] value="O">停用</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary" style="width:100px">查询</button>
            <button type="reset" class="btn btn-primary" style="width:100px">重置</button>
    </div>
</div>

<div class="container" >
    <table class="table table-primary" style="margin:10px 0px;">
        <thead>
        <tr>
            <th>任务名称</th>
            <th>任务类型</th>
            <th>状态</th>
            <th>实现类</th>
            <th>表达式</th>
            <th width="15%">操作</th>
        </tr>
        </thead>
        <tbody>
            [#list page.list as task]
            <tr>
                <td>${task.taskCode}</td>
                <td>${task.taskType}</td>
                <td>
                    [#if task.state == 'U']
                        启用
                    [#else]
                        停用
                    [/#if]
                </td>
                <td>${task.taskImplClass}</td>
                <td>${task.taskExpress}</td>
                <td align="right">
                    <div class="btn-group">
                        <button type="button" class="btn btn-bordered btn-primary" onclick="location.href='edit.html?taskId=${task.id}'">详情</button>
                        <button type="button" class="btn btn-bordered btn-danger" onclick="javascript:if(confirm('确实要删除该内容吗?'))location='delete.html?productId=${product.id}'">删除</button>
                    </div>
                </td>
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