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
        <li><a href="gotoRepayInfo.html">借款管理</a></li>
        <li class="active">还款计划</li>
    </ol>
    <div style="margin-top:5px; padding:10px; border:1px solid #d1d1d1; text-align: center;height:80px;  border-radius:5px; ">
        <form class="form-inline" id="listForm" action="stripe.html" method="post" style="margin:25px auto; padding:0px;">
            <div class="form-group">
                <label  class="control-label" for="inputSuccess1">冲帐金额</label>
                <input type="text"  name="amount"  class="form-control" id="inputSuccess1"/>
                <input type="hidden"  name="repayInfoId" value="${repayInfoId}" />
            </div>
            <div class="form-group">
                <label  class="control-label" for="inputSuccess1">期数(逗号,分隔)</label>
                <input type="text"  name="periodsNum"   class="form-control" id="inputSuccess1"/>
            </div>
            <div class="form-group">
                <label  class="control-label" for="inputSuccess1">还款日期</label>
                <input type="text"  name="repayDate"   class="form-control" id="inputSuccess1"/>
            </div>

            <button type="submit" class="btn btn-primary" style="width:120px;">人工冲帐</button>
        </form>

    </div>
</div>

<div class="container" >
    <table class="table table-primary" style="margin:10px 0px;">
        <thead>
        <tr>
            <th>还款ID</th>
            <th>状态</th>
            <th>还款日期</th>
            <th>期数</th>

            <th>应还金额</th>
            <th>已还金额</th>
            <th>剩余金额</th>

            <th>本金</th>
            <th>利息</th>
            <th>手续费</th>
            <th>罚息</th>


            <th>已还本</th>
            <th>已还息</th>
            <th>已还手</th>
            <th>已还罚</th>

            <th>剩本</th>
            <th>剩息</th>
            <th>剩手</th>
            <th>剩罚</th>
        </tr>
        </thead>
        [#list repayPlans as repayPlan]
        <tr>
            <td>${repayPlan.id}</td>
            <td>
                [#if repayPlan.status==0]
                    未开始
                [#elseif repayPlan.status==1]
                    部分还款
                [#elseif repayPlan.status==2]
                    还款成功
                [#else]
                    还款异常
                [/#if]
            </td>
            <td>${repayPlan.repayDate?date}</td>
            <td>${repayPlan.periodNumber}</td>

            <td>${repayPlan.amount}</td>
            <td>${repayPlan.repayedAmount}</td>
            <td>${repayPlan.restAmount}</td>

            <td>${repayPlan.principal}</td>
            <td>${repayPlan.interest}</td>
            <td>${repayPlan.commissionCharge}</td>
            <td>${repayPlan.penaltyInterestAmount}</td>

            <td>${repayPlan.repayedPrincipal}</td>
            <td>${repayPlan.repayedInterest}</td>
            <td>${repayPlan.repayedCommissionCharge}</td>
            <td>${repayPlan.repayedPenaltyInterestAmount}</td>


            <td>${repayPlan.restPrincipal}</td>
            <td>${repayPlan.restInterest}</td>
            <td>${repayPlan.restCommissionCharge}</td>
            <td>${repayPlan.restPenaltyInterestAmount}</td>

        </tr>
        [/#list]
        </tbody>
    </table>

</div>

</body>
</html>
