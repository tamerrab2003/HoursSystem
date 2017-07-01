package edu.mufic.hourssystem.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "section")
public class Section implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9077591538379662256L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String code;
	private String name;

	@ManyToOne
	@JoinColumn(name = "instructor_id")
	private User instructor;
	
	@ManyToOne
	@JoinColumn(name = "semester_id")
	private Semester semester;
	private Date year;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	private String courseCode;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getInstructor() {
		return instructor;
	}
	public void setInstructor(User instructor) {
		this.instructor = instructor;
	}
	public Semester getSemester() {
		return semester;
	}
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
}
