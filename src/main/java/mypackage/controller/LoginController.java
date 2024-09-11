package mypackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mypackage.model.Login;
import mypackage.model.Student_details;
import mypackage.services.LoginService;
import mypackage.services.Student_detailsService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = "*")
public class LoginController 
{
	@Autowired
	LoginService lservice;
	
	@PostMapping("api/login")
	public Student_details LoginApi(@RequestBody Login d)
	{
		Student_details s=lservice.CheckLogin(d);
		return s;
	}
}
