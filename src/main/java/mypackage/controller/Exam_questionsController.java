package mypackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import mypackage.model.Exam_questions;
import mypackage.services.Exam_questionsService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = "*")

public class Exam_questionsController 
{
	@Autowired
	Exam_questionsService eservice;
	
	@PostMapping("api/addanswerdetails")
	public  String addexamquestiondetails(@RequestBody Exam_questions eq)
	{
		 eservice.AddExamQuestions(eq);
		 return "data added successfully";
		
	}
	
	
	@GetMapping("api/getdetailsbyexamid/{eid}")
	public List<Exam_questions> getdetailsbyexid(@PathVariable int eid)
	{
		return eservice.getDetailsByExamId(eid);
	}
	
}
