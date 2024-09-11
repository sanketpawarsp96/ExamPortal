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

import mypackage.model.Topics;
import mypackage.services.TopicService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = "*")
public class TopicController 
{
	@Autowired
	TopicService tservice;
	
	@GetMapping("api/alltopics")
	public List<Topics>getalltopics()
	{
		return tservice.getallTopics();
	}
	
	@PostMapping("api/addtopic")
	public Topics addtopics(@RequestBody Topics ts)
	{
		return tservice.AddTopics(ts);
	}
	
	@GetMapping("api/topicbyid/{id}")
	public Topics topicsbyid(@PathVariable int id)
	{
		return tservice.GetTopicsById(id);
	}

}
