package mypackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import mypackage.model.Exam_details;
import mypackage.model.Exam_questions;
import mypackage.services.Exam_detailsService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = "*")

public class Exam_detailsController 
{
	@Autowired
	Exam_detailsService eservice;
	
	@PostMapping("api/submitexam")
	public Exam_details SubmitExam(@RequestBody Exam_details st) 
	{
		System.out.println(st.getExam_date()+"  "+st.getStart_time()+" to "+st.getEnd_time());
		for(Exam_questions q :st.getExam_questions())
		{
			System.out.println(q.getContent_questions().getQuestion_id()+" "+q.getSubmitted_option_number());
		}
		return st;
	}
	
	@PostMapping("api/addexamdetail")
	public String addexamdetails(@RequestBody Exam_details ds)
	{
		return eservice.AddExamDetails(ds);
		
	}
	
	@GetMapping("api/getexamdetails")
	public List<Exam_details>getallexamdetails()
	{
		return eservice.GetAllExamDetails();
	}
	@GetMapping("api/getexamdetailsbystudentid/{id}")
	public List<Exam_details> examdetailsbyid(@PathVariable int id)
	{
		return eservice.GetExamDetailsByStudentId(id);
	}
	
		
}
