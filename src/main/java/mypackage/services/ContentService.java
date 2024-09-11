package mypackage.services;
import mypackage.model.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mypackage.repository.ContentRepository;

@Service
public class ContentService 
{
	@Autowired
	
	ContentRepository crepo;
	
	public String AddContent(Contents ctt)
	{
		crepo.save(ctt);
		return "data added successfully";
	}
	
	
	public List<Contents>GetAllContents()
	{
		  List<Contents>lst=new ArrayList<Contents>();
		  for(Contents c:crepo.findAll())
		  {
			  Topics t= new Topics(c.getTopics().getTopic_id(), c.getTopics().getTopic_name(),null);
			  Contents cm=new Contents(c.getContent_id(),c.getContent_name(),null,t);
			  lst.add(cm);
		  }
		  return lst;
		}
	
	public Contents ContentById(int id)
	{
		Contents ts=crepo.findById(id).get();
		Contents t=new Contents(ts.getContent_id(),ts.getContent_name(),null,null);
		return t;
	}
	
	
	public List<Contents>getTopicWiseContent(int id)
	{
		List<Contents>lst=new ArrayList<Contents>();
		for (Contents cnt:crepo.findAll())
		{
			if(id==cnt.getTopics().getTopic_id())
			{
				Contents ct=new Contents(cnt.getContent_id(),cnt.getContent_name(),null,null);
				lst.add(ct);
			}
		}
		return lst;
	}
	
}
