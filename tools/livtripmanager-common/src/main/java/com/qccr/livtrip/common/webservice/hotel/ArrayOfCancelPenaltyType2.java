
package com.qccr.livtrip.common.webservice.hotel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>ArrayOfCancelPenaltyType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCancelPenaltyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CancelPenaltyType" type="{http://schemas.tourico.com/webservices/hotelv3}CancelPenaltyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCancelPenaltyType", propOrder = {
    "cancelPenaltyType"
})
public class ArrayOfCancelPenaltyType2 {

    @XmlElement(name = "CancelPenaltyType", nillable = true)
    protected List<CancelPenaltyType2> cancelPenaltyType;

    /**
     * Gets the value of the cancelPenaltyType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cancelPenaltyType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCancelPenaltyType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CancelPenaltyType2 }
     * 
     * 
     */
    public List<CancelPenaltyType2> getCancelPenaltyType() {
        if (cancelPenaltyType == null) {
            cancelPenaltyType = new ArrayList<CancelPenaltyType2>();
        }
        return this.cancelPenaltyType;
    }

}
