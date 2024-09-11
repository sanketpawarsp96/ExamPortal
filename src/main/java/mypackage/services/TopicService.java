package mypackage.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.Topics;
import mypackage.repository.TopicRepository;

@Service
public class TopicService 
{
	@Autowired
	TopicRepository tservice;
	
	public Topics AddTopics(Topics ts)
	{
		return tservice.save(ts);		
	}
	
	
	public List<Topics>getallTopics()
	{
		  List<Topics>lst=new ArrayList<Topics>();
		  for(Topics c:tservice.findAll())
		  {
			  Topics cm=new Topics(c.getTopic_id(),c.getTopic_name(),null);
			  lst.add(cm);
		  }
		  return lst;
		}
	
	public Topics GetTopicsById(int id)
	{
		Topics ts=tservice.findById(id).get();
		Topics t= new Topics(ts.getTopic_id(), ts.getTopic_name(), null);
		return t;
	}
	
	
	

}
