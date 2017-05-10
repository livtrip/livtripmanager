<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>借款详情</title>
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
        <li><a href="#">借款管理</a></li>
        <li class="active">借款详情</li>
    </ol>
    <div style="margin-top:5px; padding:10px; border:1px solid #d1d1d1; text-align: center;height:80px;  border-radius:5px; ">
        <form class="form-inline" id="listForm" action="addRepayPlan.html" method="post" style="margin:25px auto; padding:0px;">
            <div class="form-group">
                <label  class="control-label" for="inputSuccess1">借款金额</label>
                <input type="text"  name="amount"  class="form-control" id="inputSuccess1"/>
            </div>
            <div class="form-group">
                <label  class="control-label" for="inputSuccess1">年华收益率(%)</label>
                <input type="text"  name="yearRate"   class="form-control" id="inputSuccess1"/>
            </div>
            <div class="form-group">
                <label  class="control-label" for="inputSuccess1">还款方式</label>
                <input type="text"  name="repayType" value="等额本息" disabled="disabled"  class="form-control" id="inputSuccess1"/>
            </div>
            <div class="form-group">
                <label class="control-label" for="inputSuccess2">期限</label>
                <select name="term" class="form-control" id="inputSuccess2">
                    <option  value="-1">请选择</option>
                    <option  value="3" selected>3个月</option>
                    <option  value="6">6个月</option>
                    <option  value="12">12个月</option>
                    <option  value="24">24个月</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary" style="width:120px;">一键生成测试数据</button>
        </form>

    </div>
</div>

<div class="container" >
    <table class="table table-primary" style="margin:10px 0px;">
        <thead>
        <tr>
            <th>ID</th>
            <th>状态</th>
            <th>还款方式</th>
            <th>年利率</th>
            <th>期限</th>
            <th>应还金额</th>
            <th>已还金额</th>
            <th>剩余金额</th>

            <th>本金</th>
            <th>利息</th>
            <th>手续费</th>
            <th>罚息</th>

            <th>当前期数</th>
            <th>本期应还</th>
            <th width="5%">操作</th>
        </tr>
        </thead>
        [#list repayInfoList as repayInfo]
            <tr>
                <td>${repayInfo.id}</td>
                <td>
                    [#if repayInfo.status==0]
                        未开始
                    [#elseif repayInfo.status==1]
                        部分还款
                    [#elseif repayInfo.status==2]
                        还款成功
                    [#else]
                        还款异常
                    [/#if]
                </td>
                <td>等额本息</td>
                <td>${repayInfo.yearRate} %</td>
                <td>${repayInfo.term} 月</td>
                <td>${repayInfo.amount}</td>
                <td>${repayInfo.repayedAmount}</td>
                <td>${repayInfo.restAmount}</td>

                <td>${repayInfo.principal}</td>
                <td>${repayInfo.interest}</td>
                <td>${repayInfo.commissionCharge}</td>
                <td style="color: #ff0000;">${repayInfo.penaltyInterestAmount}</td>

                <td style="color: #ff0000;">${repayInfo.currentPeriod}</td>
                <td style="color: #ff0000;">${repayInfo.thisPeriodAmount}</td>
                <td align="right">
                    <div class="btn-group">
                        <button type="button" class="btn btn-bordered btn-primary" onclick="location.href='gotoRepayPlan?repayInfoId=${repayInfo.id}'">还款计划</button>
                    </div>
                </td>
            </tr>
        [/#list]
        </tbody>
    </table>

</div>

</body>
</html>
