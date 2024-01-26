package com.SBRestApi.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.SBRestApi.entities.Courses;

@Service
public class CoursesServiceImpl implements CoursesService {

	List<Courses> list;
	
	public CoursesServiceImpl() {
		list=new ArrayList<>();
		list.add(new Courses(145,"Core Java Courses","This Courses contain basics of core java..."));
		list.add(new Courses(150,"Spring Boot Courses","Creting Rest API using the Spring Boot.."));
		list.add(new Courses(155,"Advance Java","It's Contain All Advance Java realeted concepts..."));
	}
//	
	@Override
	public List<Courses> getCourses() {
		return list;
		
	}
	@Override
	public Courses getCourses(long coursesId) {
		Courses c=null;
		for(Courses course:list)
		{
			if(course.getId()==coursesId)
			{
				c=course;
				break;
			}
		}
		return c;
		
	}
// post:addting the data
	@Override
	public Courses addCourses(Courses course) 
	{
		list.add(course);
		return null;
	}

//	put:updating the data
	@Override
	public Courses updateCourses(Courses course) {
		list.forEach(e-> {
			if(e.getId() == course.getId()) {
				e.setTitle(course.getTitle());
			e.setDesciption(course.getDesciption());
			}
		});
		return course;
	}
	
//	delete:Delete the data
	@Override
	public void deleteCourses(long parseLong) {
		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		
	}

}
