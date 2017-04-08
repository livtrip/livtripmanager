package com.qccr.livtrip.web.result;

/**
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/8 11:14 Exp $$
 */
import com.google.common.base.Preconditions;

abstract class Results
{
    public static <T> Result<T> newSuccessResult(T data)
    {
        return newSuccessResult(data, CommonStateCode.SUCCESS.getDesc());
    }

    public static <T> Result<T> newSuccessResult(T data, String statusText)
    {
        return newResult(data, CommonStateCode.SUCCESS, statusText);
    }

    public static <T> Result<T> newSuccessResult(T data, String statusText, String appMsg)
    {
        return newResult(data, CommonStateCode.SUCCESS, statusText, appMsg);
    }

    public static <T> Result<T> newFailedResult(StateCode failedCode)
    {
        return newFailedResult(null, failedCode);
    }

    public static <T> Result<T> newFailedResult(StateCode failedCode, String statusText)
    {
        return newFailedResult(null, failedCode, statusText);
    }

    public static <T> Result<T> newFailedResult(StateCode failedCode, String statusText, String appMsg)
    {
        return newFailedResult(null, failedCode, statusText, appMsg);
    }

    public static <T> Result<T> newFailedResult(T data, StateCode failedCode)
    {
        return newFailedResult(data, failedCode, failedCode.getDesc());
    }

    public static <T> Result<T> newFailedResult(T data, StateCode failedCode, String statusText)
    {
        return newFailedResult(data, failedCode, statusText, null);
    }

    public static <T> Result<T> newFailedResult(T data, StateCode failedCode, String statusText, String appMsg)
    {
        Preconditions.checkNotNull(failedCode);
        Preconditions.checkArgument(failedCode.getCode() < 0, "invalid code, for failed result, code must be negative integers");


        return newResult(data, failedCode, statusText, appMsg);
    }

    public static <T> Result<T> newResult(StateCode code)
    {
        return newResult(null, code, code.getDesc());
    }

    public static <T> Result<T> newResult(T data, StateCode failedCode, String statusText)
    {
        return newResult(data, failedCode, statusText, null);
    }

    public static <T> Result<T> newResult(T data, StateCode failedCode, String statusText, String appMsg)
    {
        Result<T> result = new Result();
        result.setData(data);
        result.setStateCode(failedCode);
        result.setStatusText(statusText);
        result.setAppMsg(appMsg);
        return result;
    }
}
