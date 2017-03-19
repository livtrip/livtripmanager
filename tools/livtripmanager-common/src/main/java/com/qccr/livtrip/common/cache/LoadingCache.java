package com.qccr.livtrip.common.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author xierongli
 * @version $$Id: livtripmanager-parent, v 0.1 2017/2/25 15:59 user Exp $$
 * @name cache 封装
 */
public class LoadingCache {

    private static Cache<String, Object> cacheFormCallable = null;

    {
        try {
            callableCached();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 对需要延迟处理的可以采用这个机制；(泛型的方式封装)
     * @param <K>
     * @param <V>
     * @return V
     * @throws Exception
     */
    public  <K,V> Cache<K , V> callableCached() throws Exception {
        Cache<K, V> cache = CacheBuilder
                .newBuilder()
                .maximumSize(10000)
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .build();
        return cache;
    }

    public static  Object getCallableCache(String key) {
        try {
            //Callable只有在缓存值不存在时，才会调用
            return cacheFormCallable.get(key, new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    return null;
                }
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }



}
