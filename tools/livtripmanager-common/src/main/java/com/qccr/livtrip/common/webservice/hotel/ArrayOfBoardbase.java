
package com.qccr.livtrip.common.webservice.hotel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>ArrayOfBoardbase complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ArrayOfBoardbase"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Boardbase" type="{http://schemas.tourico.com/webservices/hotelv3}Boardbase" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfBoardbase", propOrder = {
    "boardbase"
})
public class ArrayOfBoardbase {

    @XmlElement(name = "Boardbase", nillable = true)
    protected List<Boardbase> boardbase;

    /**
     * Gets the value of the boardbase property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the boardbase property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBoardbase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Boardbase }
     * 
     * 
     */
    public List<Boardbase> getBoardbase() {
        if (boardbase == null) {
            boardbase = new ArrayList<Boardbase>();
        }
        return this.boardbase;
    }

}
