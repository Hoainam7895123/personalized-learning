package com.java_web.dto.reuqest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class JobDTO {
	
	private String name;
	private String require;
	private String links;
	private String skills;
	private String description;
	private String createdTime;
	private String modifiedTime;
	private Boolean deleted;
	private String responsibilities;
	private String qualifications;
	private String offer;
	private String area;
	private String title;
	private String experienceLevel;
	private String employer;
}
