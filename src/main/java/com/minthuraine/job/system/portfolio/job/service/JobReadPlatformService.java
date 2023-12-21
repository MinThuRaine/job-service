package com.minthuraine.job.system.portfolio.job.service;

import com.minthuraine.job.system.portfolio.job.api.dto.JobSearchDto;
import com.minthuraine.job.system.portfolio.job.data.JobData;

import java.util.List;

public interface JobReadPlatformService {

    List<JobData> readJob(JobSearchDto jobSearchDto);

}
