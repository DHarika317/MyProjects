package org.javahd.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.javahd.rest.bean.Courses;

public class CoursesDao extends MainDao {
	PreparedStatement ps1,ps2,ps3,ps4;
	CoursesDao(){	
		try {
			Connection con=getConnection();
			ps1 = con.prepareStatement("select * from courses");  // all courses
			ps2 = con.prepareStatement("insert into courses values (?,?,?,?)");  //adding a course
			ps3 = con.prepareStatement("delete from courses where courseid=?");  //deleting a course
			ps4 = con.prepareStatement("update courses set coursename=?, duration=?, fee=? where courseid=?"); //selecting a course on basis of coursename
		} catch (SQLException e) {e.printStackTrace();}
		
	}
	
	public ArrayList<Courses> showCourses(){
		ArrayList<Courses> list = new ArrayList<>();
		try {
			ResultSet rs = ps1.executeQuery();
			while(rs.next()){
				int cid = rs.getInt(1);
				String cname = rs.getString(2);
				int dur = rs.getInt(3);
				int fee = rs.getInt(4);
				Courses c = new Courses(cid,cname,dur,fee);
				list.add(c);
			}
		} catch (SQLException e) {e.printStackTrace();}
		return list;
		
	}
	
	public boolean addCourse(Courses course){
		try {
			PreparedStatement ps = con.prepareStatement("select max(courseid) from courses");
			ResultSet rs = ps.executeQuery();
			rs.next();
			int id = rs.getInt(1);
			ps2.setInt(1, id+1);
			ps2.setString(2, course.getCourseName());
			ps2.setInt(3, course.getDuration());
			ps2.setInt(4, course.getFee());
			ps2.execute();
			return true;
		} catch (SQLException e) {e.printStackTrace(); return false;}
		
	}
	
	public boolean deleteCourse(int courseid){
		try {
			ps3.setInt(1, courseid);
			ps3.execute();
			return true;
		} catch (SQLException e) {e.printStackTrace(); return false;}
		
	}
	
	public boolean editCourse(Courses course){
		try {
			ps4.setString(1, course.getCourseName());
			ps4.setInt(2, course.getDuration());
			ps4.setInt(3, course.getFee());
			ps4.setInt(4, course.getCourseId());
			ps4.execute();
			return true;
		} catch (SQLException e) {e.printStackTrace();return false;}
		
	}

}
