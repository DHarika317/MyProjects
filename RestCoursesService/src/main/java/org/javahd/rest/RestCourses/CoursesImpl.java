package org.javahd.rest.RestCourses;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.javahd.rest.bean.Courses;
import org.javahd.rest.dao.CoursesDao;
import org.javahd.rest.dao.DaoFactory;

@Path("courses")
public class CoursesImpl {
	CoursesDao dao = (CoursesDao)DaoFactory.getdao("CoursesDao");
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Courses> showAllCourses() {
        return dao.showCourses();
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public boolean addCourse(Courses course){
		return dao.addCourse(course);
	}
	
//	@DELETE
//	@Path("/queryparams")
//	public boolean deleteCourse(@QueryParam("cid") int cid){
//		return dao.deleteCourse(cid);
//		
//	}
	
	@DELETE
	@Path("/{cid}")
	public boolean deleteCourse(@PathParam("cid") int cid){
		return dao.deleteCourse(cid);
		
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public boolean editCourse(Courses course){
		return dao.editCourse(course);
		
	}
	
}
