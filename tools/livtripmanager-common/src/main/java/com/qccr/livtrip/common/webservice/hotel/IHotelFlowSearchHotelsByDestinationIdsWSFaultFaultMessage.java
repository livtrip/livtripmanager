
package com.qccr.livtrip.common.webservice.hotel;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.8
 * 2016-12-05T13:14:54.981+08:00
 * Generated source version: 3.1.8
 */

@WebFault(name = "WSFault", targetNamespace = "http://schemas.tourico.com/webservices/faults")
public class IHotelFlowSearchHotelsByDestinationIdsWSFaultFaultMessage extends Exception {
    
    private WSFault wsFault;

    public IHotelFlowSearchHotelsByDestinationIdsWSFaultFaultMessage() {
        super();
    }
    
    public IHotelFlowSearchHotelsByDestinationIdsWSFaultFaultMessage(String message) {
        super(message);
    }
    
    public IHotelFlowSearchHotelsByDestinationIdsWSFaultFaultMessage(String message, Throwable cause) {
        super(message, cause);
    }

    public IHotelFlowSearchHotelsByDestinationIdsWSFaultFaultMessage(String message, WSFault wsFault) {
        super(message);
        this.wsFault = wsFault;
    }

    public IHotelFlowSearchHotelsByDestinationIdsWSFaultFaultMessage(String message, WSFault wsFault, Throwable cause) {
        super(message, cause);
        this.wsFault = wsFault;
    }

    public WSFault getFaultInfo() {
        return this.wsFault;
    }
}
