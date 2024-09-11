package mypackage.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Contents")
public class Contents 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int content_id;
	private String content_name;
	
	@ManyToOne(fetch=FetchType.LAZY,optional = false)
	@JoinColumn(name = "topic_id",nullable = false)
	private Topics Topics;
	
	@OneToMany(mappedBy = "Contents",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("Contents")
	private Set <Content_questions>content_questions;

	
	
	public Contents() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contents(int content_id, String content_name,
			Set<Content_questions> content_questions,mypackage.model.Topics topics) {
		super();
		this.content_id = content_id;
		this.content_name = content_name;
		Topics = topics;
		this.content_questions = content_questions;
	}

	public int getContent_id() {
		return content_id;
	}

	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}

	public String getContent_name() {
		return content_name;
	}

	public void setContent_name(String content_name) {
		this.content_name = content_name;
	}

	public Topics getTopics() {
		return Topics;
	}

	public void setTopics(Topics topics) {
		Topics = topics;
	}

	public Set<Content_questions> getContent_questions() {
		return content_questions;
	}

	public void setContent_questions(Set<Content_questions> content_questions) {
		this.content_questions = content_questions;
	}

	
	
	
	
	
	
}








