package com.SBRestApi.Service;

import java.util.List;

import com.SBRestApi.entities.Courses;

public interface CoursesService {

	public List<Courses> getCourses(); 
	
	public Courses getCourses(long coursesId);                               
	
	public Courses addCourses(Courses course);

	public Courses updateCourses(Courses course);

	public void deleteCourses(long parseLong);                               

}
