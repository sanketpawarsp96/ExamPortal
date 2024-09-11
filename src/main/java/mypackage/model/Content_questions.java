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
@Table(name = "Content_questions")
public class Content_questions 	
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int question_id;
	
	private String questions;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String correct_option;
	

	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "content_id",nullable = false)
	private Contents Contents;
	
	@OneToMany(mappedBy = "Content_questions",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("Content_questions")
	private Set<Exam_questions> exam_questions;

	
	public Content_questions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Content_questions(int question_id, String questions, String option1, String option2, String option3,
			String option4, String correct_option, mypackage.model.Contents contents,
			Set<Exam_questions> exam_questions) {
		super();
		this.question_id = question_id;
		this.questions = questions;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correct_option = correct_option;
		Contents = contents;
		this.exam_questions = exam_questions;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCorrect_option() {
		return correct_option;
	}

	public void setCorrect_option(String correct_option) {
		this.correct_option = correct_option;
	}

	public Contents getContents() {
		return Contents;
	}

	public void setContents(Contents contents) {
		Contents = contents;
	}

	public Set<Exam_questions> getExam_questions() {
		return exam_questions;
	}

	public void setExam_questions(Set<Exam_questions> exam_questions) {
		this.exam_questions = exam_questions;
	}

	
	
	
	
	
	
}
