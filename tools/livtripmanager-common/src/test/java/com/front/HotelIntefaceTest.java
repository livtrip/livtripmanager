package com.front;

import com.alibaba.fastjson.JSON;
import com.qccr.livtrip.model.webservice.handler.HotelSOAPHandler;
import com.qccr.livtrip.model.webservice.hotel.*;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangdu on 2016/12/5.
 */
public class HotelIntefaceTest {

    public static void main(String args[]) throws Exception {
        HotelFlow ss = new HotelFlow();
        ss.setHandlerResolver(new HandlerResolver() {
            @Override
            public List<Handler> getHandlerChain(PortInfo portInfo) {
                List<Handler> handlerList = new ArrayList<Handler>();
                handlerList.add(new HotelSOAPHandler());
                return handlerList;
            }
        });
        IHotelFlow port = ss.getBasicHttpBindingIHotelFlow();
        查询房间(port);
    }

    public static void 查询房间(IHotelFlow port) {

        try {
            SearchHotelsByIdRequest request = new SearchHotelsByIdRequest();
            ArrayOfHotelIdInfo hotelInfo = new ArrayOfHotelIdInfo();
            HotelIdInfo hotelIdInfo = new HotelIdInfo();
            hotelIdInfo.setId(2205);
            hotelInfo.getHotelIdInfo().add(hotelIdInfo);
            request.setHotelIdsInfo(hotelInfo);

            request.setCheckIn(javax.xml.datatype.DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar("2016-12-13T22:02:20.934+08:00"));
            request.setCheckOut(javax.xml.datatype.DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar("2016-12-14T22:02:20.935+08:00"));

            ArrayOfRoomInfo rooInfo = new ArrayOfRoomInfo();
            RoomInfo roomInfo = new RoomInfo();
            roomInfo.setAdultNum(1);
            roomInfo.setChildNum(0);
            ArrayOfChildAge age = new ArrayOfChildAge();
            roomInfo.setChildAges(age);
            rooInfo.getRoomInfo().add(roomInfo);
            request.setRoomsInformation(rooInfo);

            ArrayOfFeature feture = new ArrayOfFeature();
            Feature feature = new Feature();
            feature.setName("Name1241558267");
            feature.setValue("Value-1989205584");
            feture.getFeature().add(feature);
            long s = System.currentTimeMillis();
            for (int i = 0; i < 1; i++) {
                SearchResult result = port.searchHotelsById(request, null);
                System.out.println("searchHotelsById.result=" + JSON.toJSONString(result));
            }
            System.out.println("exec time " + (System.currentTimeMillis() - s));
        } catch (IHotelFlowSearchHotelsByIdWSFaultFaultMessage e) {
            System.out.println(
                    "Expected exception: IHotelFlow_SearchHotelsByDestinationIds_WSFault_FaultMessage has occurred.");
            System.err.println(e.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
