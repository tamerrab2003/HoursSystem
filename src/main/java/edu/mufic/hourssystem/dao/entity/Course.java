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
@Table(name = "course")
public class Course implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9211808127040468286L;

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String prefix;
	private int number;
	private String name;
	private String description;
	private Integer semesterHours;
	private String courseLevel;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	public Course() {
		this.semesterHours = 0;
	}
	
	public Course(String prefix, int number, String name, int hours) {
		this.prefix = prefix;
		this.number = number;
		this.name = name;
		this.semesterHours = hours;
	}
	
	public String shortName() {
		return this.prefix + " " + this.number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setCode(String prefix) {
		this.prefix = prefix;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSemesterHours() {
		return semesterHours;
	}

	public void setSemesterHours(Integer semesterHours) {
		this.semesterHours = semesterHours;
	}

	public String getCourseLevel() {
		return courseLevel;
	}

	public void setCourseLevel(String courseLevel) {
		this.courseLevel = courseLevel;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
}
