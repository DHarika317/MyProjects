package org.javahd.service;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

public class Main {

	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub
		CoursesImplService service = new CoursesImplService();
	    CoursesIntf soap = service.getCoursesImplPort();
	    //System.out.println(soap.addCourse("Python", 120, 10000));
	    List<Courses> list = soap.showCourses();
	    for(Courses c: list){
	    	System.out.println(c.getCourseId()+" "+c.getCourseName()+" "+c.getDuration()+" "+c.getFee());
	    }

	}

}
