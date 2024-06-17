package com.java_web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java_web.dto.reuqest.JobDTO;
import com.java_web.model.Job;
import com.java_web.repository.JobRepository;
import com.java_web.service.JobService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService{
	
	private final JobRepository jobRepository;
	
	public Job mapToEntity(JobDTO jobDTO) {
		Job job = new Job();
		
		job.setName(jobDTO.getName());
		job.setRequire(jobDTO.getRequire());
		job.setDescription(jobDTO.getDescription());
		job.setCreatedTime(jobDTO.getCreatedTime());
		job.setModifiedTime(jobDTO.getModifiedTime());
		job.setDeleted(jobDTO.getDeleted());
		job.setSkills(jobDTO.getSkills());
		job.setResponsibilities(jobDTO.getResponsibilities());
		job.setQualifications(jobDTO.getQualifications());
		job.setOffer(jobDTO.getOffer());
		job.setArea(jobDTO.getArea());
		job.setTitle(jobDTO.getTitle());
		job.setExperienceLevel(jobDTO.getExperienceLevel());
		job.setLinks(jobDTO.getLinks());
		job.setEmployer(jobDTO.getEmployer());
		
		return job;
	}
	
	public JobDTO mapToDTO(Job job) {
		JobDTO jobDTO = new JobDTO();
		
		jobDTO.setName(job.getName());
		jobDTO.setRequire(job.getRequire());
		jobDTO.setDescription(job.getDescription());
		jobDTO.setCreatedTime(job.getCreatedTime());
		jobDTO.setModifiedTime(job.getModifiedTime());
		jobDTO.setDeleted(job.getDeleted());
		jobDTO.setSkills(job.getSkills());
		jobDTO.setResponsibilities(job.getResponsibilities());
		jobDTO.setQualifications(job.getQualifications());
		jobDTO.setOffer(job.getOffer());
		jobDTO.setArea(job.getArea());
		jobDTO.setTitle(job.getTitle());
		jobDTO.setExperienceLevel(job.getExperienceLevel());
		jobDTO.setLinks(job.getLinks());
		jobDTO.setEmployer(job.getEmployer());
		
		return jobDTO;
	}
	
	@Override
	public List<JobDTO> getAllJob() {
		List<JobDTO> list = new ArrayList<JobDTO>();
		List<Job> rawList = jobRepository.findAll();
		
		rawList.forEach(i -> {
			list.add(mapToDTO(i));
		});
				
		return list;
	}
	@Override
	public boolean deleteJob(int id) {
		if (jobRepository.existsById(id)) {
			jobRepository.deleteById(id);
			return true;
		}
		
		return false;
	}
	@Override
	public boolean addJob(JobDTO jobDTO) {
		Job job = mapToEntity(jobDTO);
		if (jobRepository.save(job)!=null) {
				return true;
		}

		return false;
	}
	@Override
	public boolean updateJob(int id, JobDTO jobDTO) {
		Job job = jobRepository.getReferenceById(id);
		
		job.setName(jobDTO.getName());
		job.setRequire(jobDTO.getRequire());
		job.setDescription(jobDTO.getDescription());
		job.setCreatedTime(jobDTO.getCreatedTime());
		job.setModifiedTime(jobDTO.getModifiedTime());
		job.setDeleted(jobDTO.getDeleted());
		job.setSkills(jobDTO.getSkills());
		job.setResponsibilities(jobDTO.getResponsibilities());
		job.setQualifications(jobDTO.getQualifications());
		job.setOffer(jobDTO.getOffer());
		job.setArea(jobDTO.getArea());
		job.setTitle(jobDTO.getTitle());
		job.setExperienceLevel(jobDTO.getExperienceLevel());
		job.setLinks(jobDTO.getLinks());
		job.setEmployer(jobDTO.getEmployer());
		
		jobRepository.save(job);
		
		if (jobRepository.save(job)!=null) {
			return true;
		}
	
		return false;
	}
	@Override
	public List<JobDTO> getJobBySkills(String skills) {
		List<Job> list = jobRepository.findBySkills(skills);
		List<JobDTO> listDTO = new ArrayList<JobDTO>();
		
		list.forEach(i -> {
			listDTO.add(mapToDTO(i));
		});
		
		return listDTO;
	}
	
}
