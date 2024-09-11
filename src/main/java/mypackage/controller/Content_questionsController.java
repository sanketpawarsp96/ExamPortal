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

import mypackage.model.Content_questions;
import mypackage.services.Content_questionService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = "*")

public class Content_questionsController 
{
	@Autowired
	Content_questionService cservice;
	
	@GetMapping("api/allquestions")
	public List<Content_questions>getallquestions()
	{
		return cservice.GetAllContentQuestions();
	}
	
	@PostMapping("api/addquestion")
	public String addquestions(@RequestBody Content_questions cq)
	{
		return cservice.AddContentQuestion(cq);
		
	}
	
	@GetMapping("api/questionbyid/{id}")
	public Content_questions getquestionbyid(@PathVariable int id)
	{
		return cservice.GetContentQuestionById(id);
	}
	
	
	@GetMapping("api/contentwisequestion/{id}")
	public List<Content_questions>getcontentwisequestions(@PathVariable int id)
	{
		return cservice.GetContentWiseQuestions(id);
	}
	
	@GetMapping("api/topicwisequestions/{id}")
	public List<Content_questions>gettopicwisequestions(@PathVariable int id)
	{
		return cservice.GetTopicWiseQuestions(id);
	}
	
}
