package com.qccr.livtrip.web.result;

/**
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/8 11:15 Exp $$
 */
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.google.common.hash.HashCode;
import java.io.Serializable;
import java.util.Map;

public  class StateCode implements Serializable
{
    private static final long serialVersionUID = -8555384052154889733L;
    private static final Map<Integer, StateCode> lookup = Maps.newHashMap();
    private Integer code;
    private String desc;

    public StateCode(Integer code, String desc)
    {
        this.code = code;
        this.desc = desc;
        if ((code != null) && (lookup.put(code, this) != null)) {
            throw new IllegalArgumentException(String.format("duplicated code[%d]", new Object[] { code }));
        }
    }

    public static StateCode get(int code, Class<?> clazz)
    {
        register(clazz);
        StateCode stateCode = (StateCode)lookup.get(Integer.valueOf(code));
        if (stateCode == null) {
            throw new IllegalArgumentException(String.format("invalid code[%d]", new Object[] { Integer.valueOf(code) }));
        }
        return stateCode;
    }

    public static void register(Class<?> clazz)
    {
        try
        {
            Class.forName(clazz.getName());
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static boolean is(int code, StateCode stateCode)
    {
        if (stateCode == null) {
            throw new IllegalArgumentException("stateCode is null");
        }
        return stateCode.equals(get(code, StateCode.class));
    }

    public int getCode()
    {
        return this.code.intValue();
    }

    public String getDesc()
    {
        return this.desc;
    }

    public boolean equals(Object obj)
    {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        StateCode other = (StateCode)obj;

        return Objects.equal(this.code, other.code);
    }

    public int hashCode()
    {
        return HashCode.fromInt(this.code.intValue()).asInt();
    }

    public String toString()
    {
        return MoreObjects.toStringHelper(this).add("code", this.code).add("desc", this.desc).toString();
    }
}
