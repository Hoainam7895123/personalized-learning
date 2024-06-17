package com.java_web.service;

import java.util.List;

import com.java_web.dto.reuqest.JobDTO;
import com.java_web.model.Job;

public interface JobService {
	public List<JobDTO> getAllJob();
	public boolean deleteJob(int id);
	public boolean addJob(JobDTO jobDTO);
	public boolean updateJob(int id, JobDTO jobDTO);
	public List<JobDTO> getJobBySkills(String skills);
}
