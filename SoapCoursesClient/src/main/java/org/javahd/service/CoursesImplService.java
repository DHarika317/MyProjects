
package org.javahd.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CoursesImplService", targetNamespace = "http://service.javahd.org/", wsdlLocation = "http://desktop-jermest:8080/SoapCourses/CoursesImplService?wsdl")
public class CoursesImplService
    extends Service
{

    private final static URL COURSESIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException COURSESIMPLSERVICE_EXCEPTION;
    private final static QName COURSESIMPLSERVICE_QNAME = new QName("http://service.javahd.org/", "CoursesImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://desktop-jermest:8080/SoapCourses/CoursesImplService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        COURSESIMPLSERVICE_WSDL_LOCATION = url;
        COURSESIMPLSERVICE_EXCEPTION = e;
    }

    public CoursesImplService() {
        super(__getWsdlLocation(), COURSESIMPLSERVICE_QNAME);
    }

    public CoursesImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), COURSESIMPLSERVICE_QNAME, features);
    }

    public CoursesImplService(URL wsdlLocation) {
        super(wsdlLocation, COURSESIMPLSERVICE_QNAME);
    }

    public CoursesImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, COURSESIMPLSERVICE_QNAME, features);
    }

    public CoursesImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CoursesImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CoursesIntf
     */
    @WebEndpoint(name = "CoursesImplPort")
    public CoursesIntf getCoursesImplPort() {
        return super.getPort(new QName("http://service.javahd.org/", "CoursesImplPort"), CoursesIntf.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CoursesIntf
     */
    @WebEndpoint(name = "CoursesImplPort")
    public CoursesIntf getCoursesImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.javahd.org/", "CoursesImplPort"), CoursesIntf.class, features);
    }

    private static URL __getWsdlLocation() {
        if (COURSESIMPLSERVICE_EXCEPTION!= null) {
            throw COURSESIMPLSERVICE_EXCEPTION;
        }
        return COURSESIMPLSERVICE_WSDL_LOCATION;
    }

}
