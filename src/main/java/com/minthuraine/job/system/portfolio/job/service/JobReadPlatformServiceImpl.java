package com.minthuraine.job.system.portfolio.job.service;

import com.minthuraine.job.system.portfolio.job.api.dto.JobSearchDto;
import com.minthuraine.job.system.portfolio.job.data.JobData;
import com.minthuraine.job.system.portfolio.job.domain.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobReadPlatformServiceImpl implements JobReadPlatformService {

    @Autowired
    JobRepository jobRepository;

    @Override
    public List<JobData> readJob(JobSearchDto jobSearchDto) {

        List<JobData> jobDataList = jobRepository.readData(jobSearchDto);

        return jobDataList;
    }


}
