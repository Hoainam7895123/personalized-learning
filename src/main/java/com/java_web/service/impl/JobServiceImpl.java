package com.java_web.service.impl;

import com.java_web.dto.response.JobResponse;
import com.java_web.dto.reuqest.JobDTO;
import com.java_web.dto.reuqest.JobDetailDTO;
import com.java_web.dto.reuqest.StatDTO;
import com.java_web.model.Job;
import com.java_web.model.JobDetail;
import com.java_web.repository.JobDetailRepository;
import com.java_web.repository.JobRepository;
import com.java_web.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepository statisticRepository;
    private final JobDetailRepository jobDetailRepository;

    @Override
    public List<StatDTO> getAvgScore() {
        List<StatDTO> list = new ArrayList<StatDTO>();

        List<Object[]> rawList = statisticRepository.getAvgScore();
        for (Object[] rawItem : rawList) {

            int id = (Integer) rawItem[0];
            String name = (String) rawItem[1];
            BigDecimal rscore = (BigDecimal) rawItem[2];
            float score = rscore.floatValue();
            Long rtotal = (Long) rawItem[3];
            int total = rtotal.intValue();

            StatDTO item = new StatDTO(id, name, score, total);

            list.add(item);
        }

        return list;
    }

    public Page<JobResponse> getJobs(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Job> jobPage = statisticRepository.findAll(pageable);

        return jobPage.map(this::convertToJobResponse);
    }

    private JobResponse convertToJobResponse(Job job) {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(job.getId());
        jobDTO.setSkills(job.getSkills());
        jobDTO.setName(job.getName());
        jobDTO.setLinks(job.getLinks());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setRequire(job.getRequire());
        // Gán các thuộc tính khác của JobDTO

        JobDetail jobDetail = jobDetailRepository.findById(job.getId()).get();
        System.out.println(jobDetail);
        JobDetailDTO jobDetailDTO = new JobDetailDTO();
        if (jobDetail != null) {
            jobDetailDTO.setId(jobDetail.getId());
            jobDetailDTO.setCoding(jobDetail.getCoding());
            jobDetailDTO.setInteract(jobDetail.getInteract());
            jobDetailDTO.setReliability(jobDetail.getReliability());
            jobDetailDTO.setDesigning(jobDetail.getDesigning());
            jobDetailDTO.setLogicalThinking(jobDetail.getLogicalThinking());
            // Gán các thuộc tính khác của JobDetailDTO
        }
        System.out.println(jobDetailDTO.getId());

        JobResponse jobResponse = new JobResponse();
        jobResponse.setJobDTO(jobDTO);
        jobResponse.setJobDetailDTO(jobDetailDTO);

        return jobResponse;
    }
}
