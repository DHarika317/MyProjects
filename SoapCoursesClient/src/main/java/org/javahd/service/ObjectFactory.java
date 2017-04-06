
package org.javahd.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.javahd.service package. 
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

    private final static QName _ShowCourses_QNAME = new QName("http://service.javahd.org/", "showCourses");
    private final static QName _Courses_QNAME = new QName("http://service.javahd.org/", "courses");
    private final static QName _ShowCoursesResponse_QNAME = new QName("http://service.javahd.org/", "showCoursesResponse");
    private final static QName _AddCourse_QNAME = new QName("http://service.javahd.org/", "addCourse");
    private final static QName _DeleteCourse_QNAME = new QName("http://service.javahd.org/", "deleteCourse");
    private final static QName _DeleteCourseResponse_QNAME = new QName("http://service.javahd.org/", "deleteCourseResponse");
    private final static QName _AddCourseResponse_QNAME = new QName("http://service.javahd.org/", "addCourseResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.javahd.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ShowCourses }
     * 
     */
    public ShowCourses createShowCourses() {
        return new ShowCourses();
    }

    /**
     * Create an instance of {@link Courses }
     * 
     */
    public Courses createCourses() {
        return new Courses();
    }

    /**
     * Create an instance of {@link ShowCoursesResponse }
     * 
     */
    public ShowCoursesResponse createShowCoursesResponse() {
        return new ShowCoursesResponse();
    }

    /**
     * Create an instance of {@link AddCourse }
     * 
     */
    public AddCourse createAddCourse() {
        return new AddCourse();
    }

    /**
     * Create an instance of {@link DeleteCourse }
     * 
     */
    public DeleteCourse createDeleteCourse() {
        return new DeleteCourse();
    }

    /**
     * Create an instance of {@link DeleteCourseResponse }
     * 
     */
    public DeleteCourseResponse createDeleteCourseResponse() {
        return new DeleteCourseResponse();
    }

    /**
     * Create an instance of {@link AddCourseResponse }
     * 
     */
    public AddCourseResponse createAddCourseResponse() {
        return new AddCourseResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowCourses }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.javahd.org/", name = "showCourses")
    public JAXBElement<ShowCourses> createShowCourses(ShowCourses value) {
        return new JAXBElement<ShowCourses>(_ShowCourses_QNAME, ShowCourses.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Courses }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.javahd.org/", name = "courses")
    public JAXBElement<Courses> createCourses(Courses value) {
        return new JAXBElement<Courses>(_Courses_QNAME, Courses.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowCoursesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.javahd.org/", name = "showCoursesResponse")
    public JAXBElement<ShowCoursesResponse> createShowCoursesResponse(ShowCoursesResponse value) {
        return new JAXBElement<ShowCoursesResponse>(_ShowCoursesResponse_QNAME, ShowCoursesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCourse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.javahd.org/", name = "addCourse")
    public JAXBElement<AddCourse> createAddCourse(AddCourse value) {
        return new JAXBElement<AddCourse>(_AddCourse_QNAME, AddCourse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCourse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.javahd.org/", name = "deleteCourse")
    public JAXBElement<DeleteCourse> createDeleteCourse(DeleteCourse value) {
        return new JAXBElement<DeleteCourse>(_DeleteCourse_QNAME, DeleteCourse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCourseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.javahd.org/", name = "deleteCourseResponse")
    public JAXBElement<DeleteCourseResponse> createDeleteCourseResponse(DeleteCourseResponse value) {
        return new JAXBElement<DeleteCourseResponse>(_DeleteCourseResponse_QNAME, DeleteCourseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCourseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.javahd.org/", name = "addCourseResponse")
    public JAXBElement<AddCourseResponse> createAddCourseResponse(AddCourseResponse value) {
        return new JAXBElement<AddCourseResponse>(_AddCourseResponse_QNAME, AddCourseResponse.class, null, value);
    }

}
