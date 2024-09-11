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
@Table(name = "Exam_details")
public class Exam_details 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int exam_id;
	private String exam_date;
	private String start_time;
	private String end_time;
	
	
	@OneToMany(mappedBy = "exam_details",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("exam_details")
	private Set<Exam_questions>exam_questions;
	
	
	@ManyToOne(fetch=FetchType.LAZY,optional =false )
	@JoinColumn(name = "student_id",nullable = false)
	private Student_details student_details;


	public Exam_details() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Exam_details(int exam_id, String exam_date, String start_time, String end_time,
			Set<Exam_questions> exam_questions, Student_details student_details) {
		super();
		this.exam_id = exam_id;
		this.exam_date = exam_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.exam_questions = exam_questions;
		this.student_details = student_details;
	}


	public int getExam_id() {
		return exam_id;
	}


	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}


	public String getExam_date() {
		return exam_date;
	}


	public void setExam_date(String exam_date) {
		this.exam_date = exam_date;
	}


	public String getStart_time() {
		return start_time;
	}


	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}


	public String getEnd_time() {
		return end_time;
	}


	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}


	public Set<Exam_questions> getExam_questions() {
		return exam_questions;
	}


	public void setExam_questions(Set<Exam_questions> exam_questions) {
		this.exam_questions = exam_questions;
	}


	public Student_details getStudent_details() {
		return student_details;
	}


	public void setStudent_details(Student_details student_details) {
		this.student_details = student_details;
	}
	
	
	
	
}
