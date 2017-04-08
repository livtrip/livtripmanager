package com.qccr.livtrip.web.result;

/**
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/8 14:19 Exp $$
 */
public interface CommonStateCode {
    public static final StateCode SUCCESS = new StateCode(Integer.valueOf(0), "成功");
    public static final StateCode ILLEGAL_PARAMETER = new StateCode(Integer.valueOf(-102), "无效的参数");
    public static final StateCode DUPLICATE_INVOKE = new StateCode(Integer.valueOf(-108), "重复调用");
    public static final StateCode PARAMETER_LACK = new StateCode(Integer.valueOf(-101), "请求参数缺失");
    public static final StateCode BODY_LACK = new StateCode(Integer.valueOf(-100), "post请求消息体缺失");
    public static final StateCode ILLEGAL_TOKEN = new StateCode(Integer.valueOf(-106), "非法的token");
    public static final StateCode NO_RELATED_DATA = new StateCode(Integer.valueOf(-107), "无相关数据");
    public static final StateCode FAILED = new StateCode(Integer.valueOf(-110), "操作失败");
    public static final StateCode OPERATE_UP_LIMIT = new StateCode(Integer.valueOf(-111), "操作上限");
    public static final StateCode DATA_EMPTY = new StateCode(Integer.valueOf(-302), "返回数据为空");
    public static final StateCode PARSE_ERROR = new StateCode(Integer.valueOf(-306), "参数解析失败");
    public static final StateCode DATA_ERROR = new StateCode(Integer.valueOf(-307), "返回数据格式错误");
    public static final StateCode ILLEGAL_SIGN = new StateCode(Integer.valueOf(-701), "无效的签名");
    public static final StateCode OVERDUE_TIME = new StateCode(Integer.valueOf(-702), "超时的时间戳");
    public static final StateCode ERROR_REQUEST = new StateCode(Integer.valueOf(-995), "错误的请求");
    public static final StateCode DB_ERROR = new StateCode(Integer.valueOf(-996), "数据库异常");
    public static final StateCode INNER_SERVER_ERROR = new StateCode(Integer.valueOf(-997), "非正常的内部服务");
    public static final StateCode SERVERS_LINK_ERROR = new StateCode(Integer.valueOf(-998), "服务器间通信异常");
}
