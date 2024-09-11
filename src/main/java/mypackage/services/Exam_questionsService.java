package mypackage.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.Content_questions;
import mypackage.model.Contents;
import mypackage.model.Exam_details;
import mypackage.model.Exam_questions;
import mypackage.model.Topics;
import mypackage.repository.Content_questionsRepository;
import mypackage.repository.Exam_detailsRepository;
import mypackage.repository.Exam_questionsRepository;

@Service
public class Exam_questionsService 
{
	@Autowired
	Exam_questionsRepository erepo;
	
	@Autowired
	Content_questionsRepository trepo;
	
	@Autowired
	Exam_detailsRepository edrepo;
	
	public Exam_questions AddExamQuestions(Exam_questions eq)
	{
		return erepo.save(eq);
	}
	
	public List<Exam_questions> getDetailsByExamId(int eid)
	{
		List<Exam_questions>lst=new ArrayList<Exam_questions>();
		
		for(Exam_questions q:erepo.findAll())
		{
			if(q.getExam_details().getExam_id()==eid)
			{
				Exam_details ed=new Exam_details(q.getExam_details().getExam_id(),q.getExam_details().getStart_time(),q.getExam_details().getEnd_time(),q.getExam_details().getExam_date(),null,null);
				Content_questions cq=new Content_questions(q.getContent_questions().getQuestion_id(),q.getContent_questions().getCorrect_option(),q.getContent_questions().getOption1(),q.getContent_questions().getOption2(),q.getContent_questions().getOption3(),q.getContent_questions().getOption4(),q.getContent_questions().getQuestions(),null,null);
				Exam_questions eq=new Exam_questions(q.getExam_question_id(),q.getSubmitted_option_number(),cq,ed);
				lst.add(eq);
//				System.out.println(eq.getExam_question_id());
//				System.out.println(eq.getSubmitted_option_number());
//				System.out.println(cq.getQuestion_id());
//				System.out.println(ed.getExam_id());
//				System.out.println(q.getExam_details().getExam_id());
			}
		}
		
		return lst;
	}

}
