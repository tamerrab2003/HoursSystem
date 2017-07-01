package edu.mufic.hourssystem.dao.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "applicant_required_info")
public class ApplicantInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1200474811925797864L;

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	// Could be changed as FK from defined college table
	private String collegeName;
	
	private Date startDate;
	private Date endDate;
	
	@Enumerated(EnumType.ORDINAL)
	private Degree degree;
	
	// All required information to register for postgraduates
	private String workAcceptanceImageUrl;
	private String graduationLicenseImageUrl;
	private String allYearsScoreImageUrl;
	private String militaryServiceStatusImageUrl;
	private String birthLicenseImageUrl;
	private String EquivalentLicenseImageUrl;
	private String personalImageUrl;
	private String idImageUrl;
	
	private String masterLicenseImageUrl;
	private String preMasterCoursesImageUrl;
	
	private Boolean passedEnglishTest = false;
	private Boolean passedComputerTest = false;
	
	@OneToOne
	@JoinColumn(name = "student_id")
	private User student;
	
	@ManyToMany
	@JoinTable(name = "previous_college_info_course_taken", 
		joinColumns = @JoinColumn(name = "previousColegeInfo_id"), inverseJoinColumns = @JoinColumn(name = "takenCourse_id"))
	private Set<CourseTaken> takenCourses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public Set<CourseTaken> getTakenCourses() {
		return takenCourses;
	}

	public void setTakenCourses(Set<CourseTaken> takenCourses) {
		this.takenCourses = takenCourses;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public String getWorkAcceptanceImageUrl() {
		return workAcceptanceImageUrl;
	}

	public void setWorkAcceptanceImageUrl(String workAcceptanceImageUrl) {
		this.workAcceptanceImageUrl = workAcceptanceImageUrl;
	}

	public String getGraduationLicenseImageUrl() {
		return graduationLicenseImageUrl;
	}

	public void setGraduationLicenseImageUrl(String graduationLicenseImageUrl) {
		this.graduationLicenseImageUrl = graduationLicenseImageUrl;
	}

	public String getAllYearsScoreImageUrl() {
		return allYearsScoreImageUrl;
	}

	public void setAllYearsScoreImageUrl(String allYearsScoreImageUrl) {
		this.allYearsScoreImageUrl = allYearsScoreImageUrl;
	}

	public String getMilitaryServiceStatusImageUrl() {
		return militaryServiceStatusImageUrl;
	}

	public void setMilitaryServiceStatusImageUrl(String militaryServiceStatusImageUrl) {
		this.militaryServiceStatusImageUrl = militaryServiceStatusImageUrl;
	}

	public String getBirthLicenseImageUrl() {
		return birthLicenseImageUrl;
	}

	public Boolean getPassedEnglishTest() {
		return passedEnglishTest;
	}

	public void setPassedEnglishTest(Boolean passedEnglishTest) {
		this.passedEnglishTest = passedEnglishTest;
	}

	public Boolean getPassedComputerTest() {
		return passedComputerTest;
	}

	public void setPassedComputerTest(Boolean passedComputerTest) {
		this.passedComputerTest = passedComputerTest;
	}

	public void setBirthLicenseImageUrl(String birthLicenseImageUrl) {
		this.birthLicenseImageUrl = birthLicenseImageUrl;
	}

	public String getEquivalentLicenseImageUrl() {
		return EquivalentLicenseImageUrl;
	}

	public void setEquivalentLicenseImageUrl(String equivalentLicenseImageUrl) {
		EquivalentLicenseImageUrl = equivalentLicenseImageUrl;
	}

	public String getPersonalImageUrl() {
		return personalImageUrl;
	}

	public void setPersonalImageUrl(String personalImageUrl) {
		this.personalImageUrl = personalImageUrl;
	}

	public String getIdImageUrl() {
		return idImageUrl;
	}

	public void setIdImageUrl(String idImageUrl) {
		this.idImageUrl = idImageUrl;
	}

	public String getMasterLicenseImageUrl() {
		return masterLicenseImageUrl;
	}

	public void setMasterLicenseImageUrl(String masterLicenseImageUrl) {
		this.masterLicenseImageUrl = masterLicenseImageUrl;
	}

	public String getPreMasterCoursesImageUrl() {
		return preMasterCoursesImageUrl;
	}

	public void setPreMasterCoursesImageUrl(String preMasterCoursesImageUrl) {
		this.preMasterCoursesImageUrl = preMasterCoursesImageUrl;
	}

}
