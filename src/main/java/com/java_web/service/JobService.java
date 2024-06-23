package com.java_web.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.java_web.dto.reuqest.JobDTO;
import com.java_web.model.Job;

public interface JobService {
	public List<JobDTO> getAllJob();
	public JobDTO getById(int id);
	public boolean deleteJob(int id);
	public boolean addJob(JobDTO jobDTO);
	public boolean updateJob(JobDTO jobDTO);
	public List<JobDTO> getJobBySkills(String skills);
	
	public boolean saveImage(MultipartFile file, JobDTO job) throws IOException;
}
