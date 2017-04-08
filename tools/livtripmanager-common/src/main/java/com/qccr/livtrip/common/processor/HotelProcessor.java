package com.qccr.livtrip.common.processor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import org.apache.commons.collections.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.qccr.livtrip.common.webservice.handler.HotelSOAPHandler;
import com.qccr.livtrip.common.webservice.hotel.*;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

/**
 *Hotel 处理器
 * @author xierongli
 * @version $Id:HotelProcessor.java v 0.1 2016年12月13日 16:14 xierongli
 */
public class HotelProcessor {



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

    /**
     * 
     * @name  根据destination 等信息查询酒店数据
     * @param  destinationIds 城市Id
     * @param checkIn 入住日期
     * @param checkOut 退房日期
     * @param arrayOfRoomInfo 入住人数信息 default(1 adult)
     * @return  
     * @author xierongli
     * @date 2016/12/13 16:58
     */
    public static List<Hotel> SearchHotelsByDestinationIds(List<Integer> destinationIds, String checkIn, String checkOut, ArrayOfRoomInfo arrayOfRoomInfo){
        if(CollectionUtils.isEmpty(destinationIds)){ return null;}
        try{
            SearchHotelsByDestinationIdsRequest request = new SearchHotelsByDestinationIdsRequest();
            ArrayOfDestinationIdInfo destinationIdsInfo = new ArrayOfDestinationIdInfo();
            for(Integer destinationId : destinationIds){
                DestinationIdInfo destinationIdInfo = new DestinationIdInfo();
                destinationIdInfo.setId(destinationId);
                destinationIdsInfo.getDestinationIdInfo().add(destinationIdInfo);
            }
            request.setDestinationIdsInfo(destinationIdsInfo);
            request.setCheckIn(transToTouricoFormate(checkIn));
            request.setCheckOut(transToTouricoFormate(checkOut));
            request.setRoomsInformation(arrayOfRoomInfo == null? defaultArrayOfRoomInfo() : arrayOfRoomInfo);

            request.setAvailableOnly(true);
            request.setMaxPrice(new BigDecimal(0));
            request.setPropertyType(PropertyType.HOTEL);
            request.setStarLevel(new BigDecimal(0));

            SearchResult result = port.searchHotelsByDestinationIds(request, null);
            return result.getHotelList().getHotel();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
    public static List<Hotel> searchHotelsById(List<Integer> hotelIds, String checkIn, String checkOut, ArrayOfRoomInfo arrayOfRoomInfo){
        long start = System.currentTimeMillis();
        try {
            SearchHotelsByIdRequest request = new SearchHotelsByIdRequest();

            ArrayOfHotelIdInfo hotelInfo = new ArrayOfHotelIdInfo();
            if(CollectionUtils.isNotEmpty(hotelIds)){
                for(Integer hotelId : hotelIds){
                    HotelIdInfo hotelIdInfo = new HotelIdInfo();
                    hotelIdInfo.setId(hotelId);
                    hotelInfo.getHotelIdInfo().add(hotelIdInfo);
                }
            }
            request.setHotelIdsInfo(hotelInfo);
            request.setCheckIn(transToTouricoFormate(checkIn));
            request.setCheckOut(transToTouricoFormate(checkOut));

            request.setRoomsInformation(arrayOfRoomInfo == null? defaultArrayOfRoomInfo() : arrayOfRoomInfo);
            SearchResult result = port.searchHotelsById(request, null);

            if(result != null){
                return result.getHotelList().getHotel();
            }
            System.out.print("cost " + (System.currentTimeMillis() - start) + "content :" + JSON.toJSONString(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static List<TWSHotelDetailsV3.Hotel> getHotelDetailsV3(List<Integer> hotelIds){
        try{
            ArrayOfHotelID arrayOfHotelID = new ArrayOfHotelID();
            if(CollectionUtils.isNotEmpty(hotelIds)){
                for(Integer hotelId : hotelIds){
                    HotelID id = new HotelID();
                    id.setId(hotelId);
                    arrayOfHotelID.getHotelID().add(id);
                }
            }
            GetHotelDetailsV3Response.GetHotelDetailsV3Result result = port.getHotelDetailsV3(arrayOfHotelID, null);
            TWSHotelDetailsV3 tWSHotelDetailsV3 = (TWSHotelDetailsV3) result.getAny();
            List lst = tWSHotelDetailsV3.getStatusCodeOrHotelOrHome();
            List<TWSHotelDetailsV3.Hotel> hotels = Lists.newArrayList();
            for(int i=0;i<lst.size(); i++){
                if (lst.get(i) instanceof TWSHotelDetailsV3.Hotel){
                    TWSHotelDetailsV3.Hotel hotel = (TWSHotelDetailsV3.Hotel) lst.get(i);
                    hotels.add(hotel);
                }
            }
            return hotels;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }


    /**
     * 
     * @name  默认的入住信息(1 room 1 adult)
     * @param
     * @return  
     * @author xierongli
     * @date 2016/12/13 17:46
     */
    public static ArrayOfRoomInfo defaultArrayOfRoomInfo(){
        ArrayOfRoomInfo arrayOfRoomInfo = new ArrayOfRoomInfo();
        RoomInfo roomInfo = new RoomInfo();
        roomInfo.setAdultNum(1);
        roomInfo.setChildNum(0);
        ArrayOfChildAge age = new ArrayOfChildAge();
        roomInfo.setChildAges(age);
        arrayOfRoomInfo.getRoomInfo().add(roomInfo);
        return  arrayOfRoomInfo;
    }

    /**
     *
     * @name  转换日期格式
     * @param date (yyyy-mm-dd)
     * @return
     * @author xierongli
     * @date 2016/12/13 17:12
     */
    public static XMLGregorianCalendarImpl transToTouricoFormate(String date){
        String[] dateArray = date.split("-");
        XMLGregorianCalendarImpl  xmlCalendar = new XMLGregorianCalendarImpl();
        xmlCalendar.setYear(Integer.parseInt(dateArray[0]));
        xmlCalendar.setMonth(Integer.parseInt(dateArray[1]));
        xmlCalendar.setDay(Integer.parseInt(dateArray[2]));
        return xmlCalendar;
    }


    public static void main(String[] args) {
        //根据hotelIds 查询
//        List<Integer> hotelIds = Lists.newArrayList();
//        hotelIds.add(2205);
//        List<Hotel> hotel = searchHotelsById(hotelIds, "2017-03-18","2017-03-19",null);
//        System.out.println(JSON.toJSONString(hotel));

        //根据destinationIds 查询
        List<Integer> destinationIds = Lists.newArrayList();
        destinationIds.add(7263); //new york
        List<Hotel> hotel1 = SearchHotelsByDestinationIds(destinationIds, "2017-04-22","2017-04-23",null);
        System.out.println(JSON.toJSONString(hotel1));

//           List<Integer> hotelIds = Lists.newArrayList();
//           hotelIds.add(2205);
//           List<TWSHotelDetailsV3.Hotel> hotels =getHotelDetailsV3(hotelIds);
//           for(TWSHotelDetailsV3.Hotel hotel : hotels){
//                hotel.getDescriptions();
//               hotel.getStarLevel();
//           }
//            System.out.println(JSON.toJSONString(hotels));
    }




}
