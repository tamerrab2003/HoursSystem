package edu.mufic.hourssystem.dao.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "semester")
public class Semester {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToMany
	@JoinTable(name = "semester_course", 
	joinColumns = @JoinColumn(name = "semester_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses;
	
	private int courseCount;
	private int year;
	private int hours;
	
	@Enumerated(EnumType.ORDINAL)
	private Season season;
	
	
	public Semester() {
		courses = new ArrayList<Course>();
		year = 0;
		hours = 0;
		season = Season.SEASON_A;
		courseCount = 0;
	}
	
	public Semester(int ye, int hou, Season sea) {
		this.year = ye;
		this.hours = hou;
		this.season = sea;
	}
	
	public void setYear(int x) { 
		this.year = x;
	}
	
	public void setSeason(Season s) {
		this.season = s;
	}
	
	public int getHours() {
		return this.hours;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public Season getSeason() {
		return this.season;
	}
	
	public String getInfo() {
		return season+" "+year;
	}
	
	public boolean addCourse(String code, int number, String name, int hours) {
		Course newCourse = new Course(code, number, name, hours);
		this.courses.add(newCourse);
		courseCount++;
		hours += newCourse.getSemesterHours();
		return true;
	}
	
	public void printCourses() {
		String ESC = "\033[";
		System.out.print(ESC + "2J"); 
		System.out.println("*************************");
		for (int i = 0; i < courseCount; i++) {
			String s = courses.get(i).shortName();
			System.out.print("* " + i+1 + ". ");
			int whitespace = 20-s.length();
			System.out.print(s);
			for (int j = 0; j < whitespace; j++) {
				System.out.print(" ");
			}
			System.out.print("*\n");
		}
		System.out.println("*************************");
	}
	
}
