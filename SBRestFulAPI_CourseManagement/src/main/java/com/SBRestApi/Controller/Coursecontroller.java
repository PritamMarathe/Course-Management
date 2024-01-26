package com.SBRestApi.Controller;

import java.util.List;

//import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SBRestApi.Service.CoursesService;
import com.SBRestApi.entities.Courses;

@RestController
public class Coursecontroller {
	
	@Autowired
	private CoursesService coursesService;
	
	@GetMapping("/home")
	public String home() {
		return "This from the Pritam Home Page in RsetFul Application...";
	}
	
//	Get the Courses
	@GetMapping("/courses")
	public List<Courses> getCourses() {
		return  this.coursesService.getCourses();
		
	}
	
//	Single Courses get
	@GetMapping("/courses/{coursesId}")
	public Courses getCourses(@PathVariable String coursesId) {
		return this.coursesService.getCourses(Long.parseLong(coursesId));
	}
	
//	use to add the coursess
	@PostMapping("/courses")
	public Courses addCourses(@RequestBody Courses course)
	{
		return this.coursesService.addCourses(course) ;
	}

//	Updating the data 
	@PutMapping("/courses")
	public Courses updateCourses(@RequestBody Courses course)
	{
		return this.coursesService.updateCourses(course) ;
	}
	
//	delete the datapost
//	@DeleteMapping("/courses/{coursesId}")
//	public Courses deleteCourses(@PathVariable String coursesId) {
//		return this.coursesService.deleteCourses(Long.parseLong(coursesId));
//	}
//	
//	OR
	
	@DeleteMapping("/courses/{coursesId}")
	public ResponseEntity<HttpStatus> deleteCourses(@PathVariable String coursesId)
	{
		try {
			this.coursesService.deleteCourses(Long.parseLong(coursesId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
