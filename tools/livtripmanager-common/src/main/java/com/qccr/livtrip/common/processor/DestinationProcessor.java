package com.qccr.livtrip.common.processor;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.qccr.livtrip.common.dto.StateDTO;
import com.qccr.livtrip.common.dto.StateJSON;


/**
 * destination 处理器
 * @author xierongli
 * @version $Id:DestinationProcessor.java v 0.1 2016年12月13日 16:19 xierongli
 */
public class DestinationProcessor {


    public static void main(String[] args) {
       // System.out.println(inputStream2String(DestinationProcessor.class.getResourceAsStream("/destination.text")));

        String  json = inputStream2String(DestinationProcessor.class.getResourceAsStream("/state/NewYork.json"));
        StateJSON stateDTO = JSON.parseObject(json,StateJSON.class);
        System.out.println(JSON.toJSONString(stateDTO));

        //getAllFiles();
    }

    public static  StateJSON getStateModelByFileName(String name){
        String  json = inputStream2String(DestinationProcessor.class.getResourceAsStream("/state/"+name+""));
        StateJSON stateDTO = JSON.parseObject(json,StateJSON.class);
        return stateDTO;
    }


    public static List<String> getAllFiles(){
        List<String> fileNames = Lists.newArrayList();
        String path = DestinationProcessor.class.getResource("/state/").getPath();
        File file = new File(path);
        File[] listFile = file.listFiles();
        for(File file1 : listFile){
            System.out.println(file1.getName());
        }
        return  null;
    }


    public static  String inputStream2String(InputStream is){
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        try {
            while ((line = in.readLine()) != null){
                buffer.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

}
