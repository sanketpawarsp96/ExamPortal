package mypackage.services;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.Exam_details;
import mypackage.model.Exam_questions;
import mypackage.model.Student_details;
import mypackage.repository.Exam_detailsRepository;
import mypackage.repository.Exam_questionsRepository;
import mypackage.repository.Student_detailsRepository;
@Service
public class Exam_detailsService 
{
	@Autowired
	Exam_detailsRepository erepo;
	
	@Autowired
	Exam_questionsRepository repo;
	
	@Autowired
	Student_detailsRepository srepo;
	
	public List<Exam_details> GetExamDetails()
	{
		List<Exam_details>lst=new ArrayList<Exam_details>();
		for(Exam_details d:erepo.findAll())
		{
			Exam_details dt=new Exam_details(d.getExam_id(),d.getExam_date(),d.getStart_time(),d.getEnd_time(),null,null);
			lst.add(dt);
		}
		return lst;
	}
	
	public String AddExamDetails(Exam_details dt)
	{
		Exam_details edetail = new Exam_details(0, dt.getExam_date(),dt.getStart_time(), dt.getEnd_time(), null, dt.getStudent_details());
		Exam_details id=erepo.save(edetail);
		for(Exam_questions q:dt.getExam_questions()) {
			q.setExam_details(id);
			repo.save(q);
		}
		return "submited exam";
	}
	
	public List<Exam_details>GetAllExamDetails()
	{
		List<Exam_details>lst=new ArrayList<Exam_details>();
		for(Exam_details d: erepo.findAll())
		{
			Exam_details ed=new Exam_details(d.getExam_id(),d.getEnd_time(),d.getExam_date(),d.getStart_time(),null,null);
			lst.add(ed);
		}
		return lst;
	}
	
	public List<Exam_details> GetExamDetailsByStudentId(int sid)
	{
		List<Exam_details>lst=new ArrayList<Exam_details>();
		for(Exam_details d:erepo.findAll())
		{
			if(d.getStudent_details().getStudent_id()==sid)
			{
				Student_details sd=new Student_details(d.getStudent_details().getStudent_id(),d.getStudent_details().getStudent_name(),d.getStudent_details().getQualification(),d.getStudent_details().getMobile(),d.getStudent_details().getEmail_address(),d.getStudent_details().getCity(),d.getStudent_details().getPassword(),null);
				Exam_details e=new Exam_details(d.getExam_id(),d.getEnd_time(),d.getExam_date(),d.getStart_time(),null,sd);
				lst.add(e);
			}
		}
		return lst;
	}
	
}
