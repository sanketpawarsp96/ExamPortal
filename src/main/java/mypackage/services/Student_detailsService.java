package mypackage.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.Email.EmailModel;
import mypackage.Email.EmailServiceImplementation;
import mypackage.model.Student_details;
import mypackage.repository.Student_detailsRepository;

@Service
public class Student_detailsService 
{
	@Autowired
	Student_detailsRepository srepo;
	
	@Autowired
	EmailServiceImplementation emailservice;
	
	public List<Student_details> GetAllStudentDetails()
	{
		List<Student_details>lst=new ArrayList<Student_details>();
		for(Student_details s:srepo.findAll())
		{
			Student_details sd=new Student_details(s.getStudent_id(),s.getStudent_name(),s.getQualification(),s.getMobile(),s.getEmail_address(),s.getCity(),s.getPassword(),null);
			lst.add(sd);
		}
		return lst;
	}
	
	public Student_details AddStudentDetails(Student_details s)
	{
		String pass=GeneratePassword(8);
		s.setPassword(pass);
		Student_details st=srepo.save(s);
		String subject="Student Registration Comfirmation";
		String msgbody="Dear "+s.getStudent_name()+" your registrations has been completed successfully you can access your acount using following details Email address : "+s.getEmail_address()+"                              and password : "+pass;
		
		EmailModel e=new EmailModel(s.getEmail_address(),msgbody,subject);
		emailservice.SendSimpleMail(e);
		return st;
	}
	
	public Student_details GetStudentDetailById(int id)
	{
		Student_details st=srepo.findById(id).get();
		Student_details sd=new Student_details(st.getStudent_id(),st.getStudent_name(),st.getQualification(),st.getMobile(),st.getEmail_address(),st.getCity(),st.getPassword(),null);
		return sd;
	}
		
	
	public String GeneratePassword(int size)
	{
		String data="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$";
		String password="";
		Random r=new Random();
		for(int i=0;i<size;i++)
		{
			int p=r.nextInt(data.length()-1);
			password+=data.charAt(p);
		}
		return password;
	}
	
}











