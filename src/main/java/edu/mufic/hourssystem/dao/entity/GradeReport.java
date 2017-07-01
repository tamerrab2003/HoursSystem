package edu.mufic.hourssystem.dao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "grade_report")
public class GradeReport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2407638096872484883L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String letterGrade;
	private Integer numericGrade;
	
	@ManyToOne
	@JoinColumn(name = "studen_id")
	private User student;
	
	@ManyToOne
	@JoinColumn(name = "section_id")
	private Section section;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLetterGrade() {
		return letterGrade;
	}

	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade;
	}

	public Integer getNumericGrade() {
		return numericGrade;
	}

	public void setNumericGrade(Integer numericGrade) {
		this.numericGrade = numericGrade;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
}
