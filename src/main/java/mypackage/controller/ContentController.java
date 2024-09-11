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

import mypackage.model.Contents;
import mypackage.model.Topics;
import mypackage.services.ContentService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = "*")

public class ContentController 
{
	@Autowired
	ContentService cservice;
	
	@GetMapping("api/allcontents")
	public List<Contents>GetAllContents()
	{
		return cservice.GetAllContents();
	}
	
	@PostMapping("api/addcontent")
	public String Addcontent(@RequestBody Contents ctt)
	{
		return cservice.AddContent(ctt);
	}
	
	@GetMapping("api/contentbyid/{id}")
	public Contents topicsbyid(@PathVariable int id)
	{
		return cservice.ContentById(id);
	}
	
	@GetMapping("api/topicwisecontent/{id}")
	public List<Contents> topicwisecontent(@PathVariable int id)
	{
		return cservice.getTopicWiseContent(id);
	}

}




