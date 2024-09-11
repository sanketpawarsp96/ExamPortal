package mypackage.Email;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImplementation implements EmailService 
{
	@Autowired
	private JavaMailSender javamailsender;
	
	@Value("${spring.mail.username}") 
	private String sender;
	
	public String SendSimpleMail(EmailModel details)
	{
		try
		{
			SimpleMailMessage mailMessage=new SimpleMailMessage();
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getRecipient());
			mailMessage.setText(details.getMsgbody());
			mailMessage.setSubject(details.getSubject());
			javamailsender.send(mailMessage);
			return "mail sent successfully";
		}
		catch (Exception e) 
		{
			return e.getMessage();
		}
	}

}
