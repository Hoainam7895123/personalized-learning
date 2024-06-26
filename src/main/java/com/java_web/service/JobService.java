package com.java_web.service;

import com.java_web.dto.response.JobResponse;
import com.java_web.dto.reuqest.StatDTO;
import com.java_web.model.Job;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;

import java.util.List;

public interface JobService {
    public List<StatDTO> getAvgScore();

    public Page<JobResponse> getJobs(int page, int size);


}
