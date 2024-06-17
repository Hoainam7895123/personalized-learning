package com.java_web.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tbljob")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_id")
	private int id;
	@Column(name="job_name")
	private String name;
	@Column(name="job_require")
	private String require;
	@Column(name="job_links")
	private String links;
	@Column(name="job_skills")
	private String skills;
	@Column(name="job_description")
	private String description;
	@Column(name="job_created_time")
	private String createdTime;
	@Column(name="job_modified_time")
	private String modifiedTime;
	@Column(name="job_deleted")
	private Boolean deleted;
	@Column(name="job_responsibilities")
	private String responsibilities;
	@Column(name="job_qualifications")
	private String qualifications;
	@Column(name="job_offer")
	private String offer;
	@Column(name="job_area")
	private String area;
	@Column(name="job_title")
	private String title;
	@Column(name="job_experience_level")
	private String experienceLevel;
	@Column(name="job_employer")
	private String employer;
}