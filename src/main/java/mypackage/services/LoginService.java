package mypackage.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.Login;
import mypackage.model.Student_details;
import mypackage.repository.Student_detailsRepository;

@Service
public class LoginService 
{
	@Autowired
	Student_detailsRepository studrepo;
	  
	public Student_details CheckLogin(Login d)
	{
		List<Student_details>lst=studrepo.findAll();
		Student_details st=null;
		for(Student_details s:lst)
		{
			if(s.getEmail_address().equals(d.getUsername()) && s.getPassword().equals(d.getPassword()))
			{
				st=s;
				break;
			}
			
		}  
		Student_details sd=new Student_details(st.getStudent_id(), st.getStudent_name(), st.getQualification(), st.getMobile(), st.getEmail_address(), st.getCity(), "", null);
		return sd;
	}
}
