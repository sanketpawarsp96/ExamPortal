package mypackage.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.Content_questions;
import mypackage.model.Contents;
import mypackage.model.Topics;
import mypackage.repository.Content_questionsRepository;
import mypackage.repository.TopicRepository;

@Service
public class Content_questionService 
{
	@Autowired
	Content_questionsRepository crepo;
	
	@Autowired
	TopicRepository trepo;
	
	public List <Content_questions>GetAllContentQuestions()
	{
		List<Content_questions>lst=new ArrayList<Content_questions>();
		for(Content_questions c:crepo.findAll())
		{
			Topics tp=trepo.getOne(c.getContents().getTopics().getTopic_id());
			Topics tt=new Topics(tp.getTopic_id(),tp.getTopic_name(),null);
			Contents cm=new Contents(c.getContents().getContent_id(),c.getContents().getContent_name(),null,tt);
			c.setContents(cm);
			c.setExam_questions(null);
			lst.add(c);
		}
		return lst;
	}
	
	
	
	public Content_questions GetContentQuestionById(int id)
	{
		Content_questions cq=crepo.findById(id).get();
		Content_questions obj=new Content_questions(cq.getQuestion_id(),cq.getQuestions(),cq.getOption1(),
				                 cq.getOption2(),cq.getOption3(),cq.getOption4(),cq.getCorrect_option(),null,null);
		return obj;
	}
	
	
	
	public String AddContentQuestion(Content_questions cont_q)
	{
		crepo.save(cont_q);
		return "Content Question Added";
		
	}
	
	
	
	public List<Content_questions> GetContentWiseQuestions(int id)
	{
		List<Content_questions>lst=new ArrayList<Content_questions>();
		for(Content_questions cq:crepo.findAll())
		{
			if(id==cq.getContents().getContent_id())
			{
				Content_questions obj=new Content_questions(cq.getQuestion_id(),cq.getQuestions(),cq.getOption1(),cq.getOption2()
						                                   ,cq.getOption3(),cq.getOption4(),cq.getCorrect_option(),null,null);
				
				lst.add(obj);
			}
			
		}
		return lst;
	}
	
	public List<Content_questions>GetTopicWiseQuestions(int t_id)
	{
		List<Content_questions>lst=new ArrayList<Content_questions>();
		for(Content_questions c:crepo.findAll())
		{
			if(c.getContents().getTopics().getTopic_id()==t_id)
			{
				Contents s=new Contents(c.getContents().getContent_id(),c.getContents().getContent_name(),null ,null);
				Content_questions cq=new Content_questions(c.getQuestion_id(),c.getQuestions(),c.getOption1(),c.getOption2(),c.getOption3(),c.getOption4(),c.getCorrect_option(),s,null);
				lst.add(cq);
			}
			
		}
		return lst;

	}
}
















