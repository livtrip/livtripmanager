
package com.qccr.livtrip.common.webservice.hotel;

import javax.xml.bind.annotation.*;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CostAmendResult" type="{http://schemas.tourico.com/webservices/hotelv3}AmendResult" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "costAmendResult"
})
@XmlRootElement(name = "CostAmendResponse", namespace = "http://tourico.com/webservices/hotelv3")
public class CostAmendResponse {

    @XmlElement(name = "CostAmendResult", namespace = "http://tourico.com/webservices/hotelv3")
    protected AmendResult costAmendResult;

    /**
     * 获取costAmendResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AmendResult }
     *     
     */
    public AmendResult getCostAmendResult() {
        return costAmendResult;
    }

    /**
     * 设置costAmendResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AmendResult }
     *     
     */
    public void setCostAmendResult(AmendResult value) {
        this.costAmendResult = value;
    }

}
