
package com.slaoui.enterprise.prototypes.soap.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idsCreatedEmploye" type="{http://jaxws.soap.prototypes.enterprise.slaoui.com/}ListIdsEmployes"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "errorCode",
    "idsCreatedEmploye"
})
@XmlRootElement(name = "createEmpployesResponse")
public class CreateEmpployesResponse {

    @XmlElement(required = true)
    protected String errorCode;
    @XmlElement(required = true)
    protected ListIdsEmployes idsCreatedEmploye;

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorCode(String value) {
        this.errorCode = value;
    }

    /**
     * Gets the value of the idsCreatedEmploye property.
     * 
     * @return
     *     possible object is
     *     {@link ListIdsEmployes }
     *     
     */
    public ListIdsEmployes getIdsCreatedEmploye() {
        return idsCreatedEmploye;
    }

    /**
     * Sets the value of the idsCreatedEmploye property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListIdsEmployes }
     *     
     */
    public void setIdsCreatedEmploye(ListIdsEmployes value) {
        this.idsCreatedEmploye = value;
    }

}
