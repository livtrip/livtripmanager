
package com.qccr.livtrip.common.webservice.hotel;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.8
 * 2016-12-05T13:14:54.922+08:00
 * Generated source version: 3.1.8
 */

@WebFault(name = "WSFault", targetNamespace = "http://schemas.tourico.com/webservices/faults")
public class IHotelFlowSearchHotelsByIdWSFaultFaultMessage extends Exception {
    
    private WSFault wsFault;

    public IHotelFlowSearchHotelsByIdWSFaultFaultMessage() {
        super();
    }
    
    public IHotelFlowSearchHotelsByIdWSFaultFaultMessage(String message) {
        super(message);
    }
    
    public IHotelFlowSearchHotelsByIdWSFaultFaultMessage(String message, Throwable cause) {
        super(message, cause);
    }

    public IHotelFlowSearchHotelsByIdWSFaultFaultMessage(String message, WSFault wsFault) {
        super(message);
        this.wsFault = wsFault;
    }

    public IHotelFlowSearchHotelsByIdWSFaultFaultMessage(String message, WSFault wsFault, Throwable cause) {
        super(message, cause);
        this.wsFault = wsFault;
    }

    public WSFault getFaultInfo() {
        return this.wsFault;
    }
}