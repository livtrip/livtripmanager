package com.qccr.livtrip.web.result;

/**
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/8 11:14 Exp $$
 */
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Map;

class Result<T> implements Serializable {
    private static final long serialVersionUID = -3887725517645851694L;
    private T data;
    private StateCode stateCode;
    private String statusText;
    private Map<String, String> extData;
    private String appMsg;

    public T getData()
    {
        return this.data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public boolean isSuccess()
    {
        return this.stateCode.getCode() >= 0;
    }

    public boolean isFailed()
    {
        return !isSuccess();
    }

    public boolean isBizFailed()
    {
        return (isFailed()) && (!isSystemError());
    }

    public boolean isSystemError()
    {
        int code = getStateCode().getCode();
        return (code <= -900) && (code > -1000);
    }

    public StateCode getStateCode()
    {
        return this.stateCode;
    }

    public void setStateCode(StateCode stateCode)
    {
        this.stateCode = stateCode;
    }

    public String getStatusText()
    {
        return this.statusText;
    }

    public void setStatusText(String statusText)
    {
        this.statusText = statusText;
    }

    public Map<String, String> getExtData()
    {
        return this.extData;
    }

    public void setExtData(Map<String, String> extData)
    {
        this.extData = extData;
    }



    public String getAppMsg()
    {
        return this.appMsg;
    }

    public void setAppMsg(String appMsg)
    {
        this.appMsg = appMsg;
    }

    public String toString()
    {
        MoreObjects.ToStringHelper toString = MoreObjects.toStringHelper(this);
        return toString.add("data", this.data).add("stateCode", this.stateCode).add("statusText", this.statusText).add("extData", this.extData).add("appMsg", this.appMsg).omitNullValues().toString();
    }
}

