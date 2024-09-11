package mypackage.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.FetchType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Topics")
public class Topics 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int topic_id;
	private String topic_name;
	
	@OneToMany(mappedBy = "Topics",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("Topics")
	private Set <Contents>contents;

	
	public Topics(int topic_id, String topic_name, Set<Contents> contents) {
		super();
		this.topic_id = topic_id;
		this.topic_name = topic_name;
		this.contents = contents;
	}
	
	public Topics() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}

	public String getTopic_name() {
		return topic_name;
	}

	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}

	public Set<Contents> getContents() {
		return contents;
	}

	public void setContents(Set<Contents> contents) {
		this.contents = contents;
	}
	
		
}
