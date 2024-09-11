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
import javax.persistence.Table;

@Entity
@Table(name = "Exam_questions")
public class Exam_questions
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int exam_question_id;
	
	private int submitted_option_number;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "question_id",nullable = false)
	private Content_questions Content_questions;
	
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "exam_id",nullable = false)
	private Exam_details exam_details;


	public Exam_questions() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Exam_questions(int exam_question_id, int submitted_option_number, Content_questions content_questions,
			Exam_details exam_details) {
		super();
		this.exam_question_id = exam_question_id;
		this.submitted_option_number = submitted_option_number;
		this.Content_questions = content_questions;
		this.exam_details = exam_details;
	}


	public int getExam_question_id() {
		return exam_question_id;
	}


	public void setExam_question_id(int exam_question_id) {
		this.exam_question_id = exam_question_id;
	}


	public int getSubmitted_option_number() {
		return submitted_option_number;
	}


	public void setSubmitted_option_number(int submitted_option_number) {
		this.submitted_option_number = submitted_option_number;
	}


	public Content_questions getContent_questions() {
		return Content_questions;
	}


	public void setContent_questions(Content_questions content_questions) {
		this.Content_questions = content_questions;
	}


	public Exam_details getExam_details() {
		return exam_details;
	}


	public void setExam_details(Exam_details exam_details) {
		this.exam_details = exam_details;
	}
	
	
	
	
}















