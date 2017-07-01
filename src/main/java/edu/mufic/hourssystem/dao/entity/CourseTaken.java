package edu.mufic.hourssystem.dao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course_taken")
public class CourseTaken implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -947406034584902661L;

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String code;
	private Boolean completed;
	private Integer gradeEarned;
	private Integer creditHours;
	private String courseLevel;
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
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	public Integer getGradeEarned() {
		return gradeEarned;
	}
	public void setGradeEarned(Integer gradeEarned) {
		this.gradeEarned = gradeEarned;
	}
	public Integer getCreditHours() {
		return creditHours;
	}
	public void setCreditHours(Integer creditHours) {
		this.creditHours = creditHours;
	}
	public String getCourseLevel() {
		return courseLevel;
	}
	public void setCourseLevel(String courseLevel) {
		this.courseLevel = courseLevel;
	}
	
}
