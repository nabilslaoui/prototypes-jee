
package com.slaoui.enterprise.prototypes.soap.jaxws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListEmployes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListEmployes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="employe" type="{http://jaxws.soap.prototypes.enterprise.slaoui.com/}Employe" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListEmployes", propOrder = {
    "employe"
})
public class ListEmployes {

    protected List<Employe> employe;

    /**
     * Gets the value of the employe property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the employe property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEmploye().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Employe }
     * 
     * 
     */
    public List<Employe> getEmploye() {
        if (employe == null) {
            employe = new ArrayList<Employe>();
        }
        return this.employe;
    }

}
