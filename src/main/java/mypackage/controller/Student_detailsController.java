package mypackage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mypackage.model.Student_details;
import mypackage.services.Student_detailsService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = "*")
public class Student_detailsController 
{
	@Autowired
	Student_detailsService sdservice;
	
	
	@GetMapping("api/allstudentsdetails")
	public List<Student_details>getallstudentdetails()
	{
		return sdservice.GetAllStudentDetails();
		
	}
	@PostMapping("api/addstudentdetails")
	public String addstudentdetail(@RequestBody Student_details s)
	{
		sdservice.AddStudentDetails(s);
		return "details added successfully";
	}
	
	@GetMapping("api/getstudentdetailbyid/{id}")
	public Student_details getstudentdetailsbyid(@PathVariable int id)
	{
		return sdservice.GetStudentDetailById(id);
	}
}
