package com.front;

import com.qccr.livtrip.model.webservice.destination.*;
import com.qccr.livtrip.model.webservice.handler.DestinationPHandler;
import com.qccr.livtrip.model.webservice.hotel.IHotelFlow;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangdu on 2016/12/8.
 */
public class DestinationIntefaceTest {
    public static void main(String args[]) throws Exception {
        WSDestinationService service = new WSDestinationService();
        service.setHandlerResolver(new HandlerResolver() {
            @Override
            public List<Handler> getHandlerChain(PortInfo portInfo) {
                List<Handler> handlerList = new ArrayList<Handler>();
                handlerList.add(new DestinationPHandler());
                return handlerList;
            }
        });
        IDestinationContracts port = service.getIISDestinationHosting();
        Destination destination=new Destination();
        destination.setCity("Madrid");
        destination.setContinent("Europe");
        destination.setCountry("Spain");

        Providers providers = new Providers();
        Provider provider = new Provider();
        provider.setValue("Default");
        providers.getProviderType().add(provider);
        destination.setProviders(providers);

        DestinationResult result= port.getDestination(destination);
        System.out.println(result);


    }

    public static void query(IHotelFlow port) {

    }
}
