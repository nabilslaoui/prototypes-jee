
package com.slaoui.enterprise.prototypes.soap.jaxws;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.slaoui.enterprise.prototypes.soap.jaxws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.slaoui.enterprise.prototypes.soap.jaxws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListIdsEmployes }
     * 
     */
    public ListIdsEmployes createListIdsEmployes() {
        return new ListIdsEmployes();
    }

    /**
     * Create an instance of {@link CreateEmpployesRequest }
     * 
     */
    public CreateEmpployesRequest createCreateEmpployesRequest() {
        return new CreateEmpployesRequest();
    }

    /**
     * Create an instance of {@link Employe }
     * 
     */
    public Employe createEmploye() {
        return new Employe();
    }

    /**
     * Create an instance of {@link GetEmployesByIDRequest }
     * 
     */
    public GetEmployesByIDRequest createGetEmployesByIDRequest() {
        return new GetEmployesByIDRequest();
    }

    /**
     * Create an instance of {@link ListEmployes }
     * 
     */
    public ListEmployes createListEmployes() {
        return new ListEmployes();
    }

    /**
     * Create an instance of {@link CreateEmpployesResponse }
     * 
     */
    public CreateEmpployesResponse createCreateEmpployesResponse() {
        return new CreateEmpployesResponse();
    }

    /**
     * Create an instance of {@link GetAllEmployesResponse }
     * 
     */
    public GetAllEmployesResponse createGetAllEmployesResponse() {
        return new GetAllEmployesResponse();
    }

    /**
     * Create an instance of {@link GetAllEmployesRequest }
     * 
     */
    public GetAllEmployesRequest createGetAllEmployesRequest() {
        return new GetAllEmployesRequest();
    }

    /**
     * Create an instance of {@link GetEmployesByIDResponse }
     * 
     */
    public GetEmployesByIDResponse createGetEmployesByIDResponse() {
        return new GetEmployesByIDResponse();
    }

}
