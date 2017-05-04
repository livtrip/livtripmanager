[#escape x as x?html]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>定时任务详情页</title>
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

<div class="container">
    <ol class="breadcrumb">
        <li><a href="#">后台管理</a></li>
        <li><a href="javascription.hsitory(-1);">产品列表</a></li>
        <li class="active">任务详情页</li>
    </ol>

    <form class="form-horizontal" style="margin:20px 0px;" action="">
        <div class="form-group">
            <label for="taskId" class="col-sm-2 control-label">任务ID</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="taskId" value="${task.id}">
            </div>
        </div>
        <div class="form-group form-group-sm">
            <label class="col-sm-2 control-label" for="taskCode">任务名称</label>
            <div class="col-sm-10">
                <input class="form-contro form-group-sm" disabled="disabled" name="taskCode" value="${task.taskCode}" type="text" id="taskCode" />
            </div>
        </div>
        <div class="form-group form-group-sm">
            <label class="col-sm-2 control-label" for="state">状态</label>
            <div class="col-sm-10">
                <input class="form-contro form-group-sm" name="state" value="${task.state}" type="text" id="state" />
            </div>
        </div>
        <div class="form-group form-group-sm">
            <label class="col-sm-2 control-label" for="taskExpress">表达式</label>
            <div class="col-sm-10">
                <input class="form-contro form-group-sm" type="text" name="taskExpress" value="${task.taskExpress}" id="taskExpress" />
            </div>
        </div>
        <div class="form-group form-group-sm">
            <label class="col-sm-2 control-label" for=""taskImplClass>实现类</label>
            <div class="col-sm-10">
                <input class="form-contro form-group-sm" type="text" name="taskImplClass" value="${taks.taskImplClass}" id="taskImplClass" />
            </div>
        </div>

        <button type="submit" class="btn btn-primary" style=" margin-left:150px;">提 交</button>
    </form>
</div>
</body>
</html>


[/#escape]