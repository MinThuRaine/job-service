package com.minthuraine.job.system.portfolio.job.api;


import com.minthuraine.job.system.infrastructure.serialization.ApiJsonSerializer;
import com.minthuraine.job.system.infrastructure.serialization.ApiRequestJsonSerializationSettings;
import com.minthuraine.job.system.portfolio.job.api.dto.JobSearchDto;
import com.minthuraine.job.system.portfolio.job.data.JobData;
import com.minthuraine.job.system.portfolio.job.handler.ResponseHandler;
import com.minthuraine.job.system.portfolio.job.service.JobReadPlatformService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1")
public class JobApiResource {


    private static final Set<String> JOB_RESPONSE_DATA_PARAMETERS =
            new HashSet<>(Arrays.asList("timestamp", "employer", "location", "jobTitle", "yearsAtEmployer", "experience", "salary"
                    , "signingBonus", "annualBonus", "annualStockValue", "gender", "additionalComment"));
    @Autowired
    JobReadPlatformService jobReadPlatformService;
    @Autowired
    ApiJsonSerializer apiJsonSerializer;

    @GetMapping("/job_data")
    public ResponseEntity<Object> getAgentById(@RequestParam(value = "salary", required = false, defaultValue = "0") String salary, @RequestParam(value = "filter", required = false, defaultValue = "") String filter, @RequestParam(value = "jobTitle", required = false, defaultValue = "") String jobTitle, @RequestParam(value = "gender", required = false, defaultValue = "") String gender, @RequestParam(value = "reqdt", required = false, defaultValue = "") String reqdt) {

        JobSearchDto jobSearchDto = JobSearchDto.builder().salary(new BigDecimal(salary)).salaryFilter(filter).jobTitle(jobTitle).gender(gender).build();

        List<JobData> jobData = jobReadPlatformService.readJob(jobSearchDto);

        ApiRequestJsonSerializationSettings jsonSerializationSettings = new ApiRequestJsonSerializationSettings(reqdt);
        String data = apiJsonSerializer.serialize(jsonSerializationSettings, jobData, JOB_RESPONSE_DATA_PARAMETERS);
        return new ResponseHandler().listJobRepository(data);
    }

}
