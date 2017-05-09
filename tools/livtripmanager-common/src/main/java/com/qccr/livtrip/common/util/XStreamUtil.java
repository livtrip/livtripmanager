package com.qccr.livtrip.common.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * Created by xierongli on 17/5/9.
 */
public class XStreamUtil {


    public static String convertObjectToXml(Class<?> classInstance){
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(classInstance);
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mar.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            StringWriter writer = new StringWriter();

            try {
                mar.marshal(classInstance.newInstance(), writer);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return writer.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return "";
    }
}
