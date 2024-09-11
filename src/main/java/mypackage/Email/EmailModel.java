package mypackage.Email;

public class EmailModel 
{
	private String Recipient;
	private String msgbody;
	private String subject;
	
	public EmailModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmailModel(String recipient, String msgbody, String subject) {
		super();
		Recipient = recipient;
		this.msgbody = msgbody;
		this.subject = subject;
	}
	public String getRecipient() {
		return Recipient;
	}
	public void setRecipient(String recipient) {
		Recipient = recipient;
	}
	public String getMsgbody() {
		return msgbody;
	}
	public void setMsgbody(String msgbody) {
		this.msgbody = msgbody;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
	
}
