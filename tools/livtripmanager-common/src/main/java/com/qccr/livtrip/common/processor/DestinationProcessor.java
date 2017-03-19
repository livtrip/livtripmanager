package com.qccr.livtrip.common.processor;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import com.qccr.livtrip.common.webservice.handler.HotelSOAPHandler;
import com.qccr.livtrip.common.webservice.hotel.HotelFlow;
import com.qccr.livtrip.common.webservice.hotel.IHotelFlow;
/**
 * destination 处理器
 * @author xierongli
 * @version $Id:DestinationProcessor.java v 0.1 2016年12月13日 16:19 xierongli
 */
public class DestinationProcessor {

    private static IHotelFlow port = null;

    static{
        HotelFlow ss = new HotelFlow();
        ss.setHandlerResolver(new HandlerResolver() {
            @Override
            public List<Handler> getHandlerChain(PortInfo portInfo) {
                List<Handler> handlerList = new ArrayList<Handler>();
                handlerList.add(new HotelSOAPHandler());
                return handlerList;
            }
        });
        port = ss.getBasicHttpBindingIHotelFlow();
    }

    public static void main(String[] args) {
//        InputStream inputStream =  DestinationProcessor.class.getResourceAsStream("/des_ws.xml");
//        System.out.println(convertStreamToString(inputStream));

}


    public static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }






}
