package com.minthuraine.job.system.portfolio.job.domain;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minthuraine.job.system.portfolio.job.api.dto.JobSearchDto;
import com.minthuraine.job.system.portfolio.job.data.JobData;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@Slf4j
public class JobRepository {

    public static List<Job> jobDataSet = new ArrayList<>();

    public List<JobData> readData(JobSearchDto jobSearchDto) {

        List<JobData> jobDataList = new ArrayList<>();

        List<Job> jobb = jobDataSet.stream()
                .filter(Filter.salary(jobSearchDto.getSalary(), jobSearchDto.getSalaryFilter()))
                .filter(Filter.jobtitle(jobSearchDto.getJobTitle()))
                .filter(Filter.gender(jobSearchDto.getGender()))
                .collect(Collectors.toList());

        for (Job data : jobb) {
            JobData job = new JobData(data.getTimestamp(), data.getEmployer(), data.getLocation(), data.getJobTitle(), data.getYearsAtEmployer(), data.getExperience(), data.getSalary(), data.getSigningBonus(), data.getAnnualBonus(), data.getAnnualStockValue(), data.getGender(), data.getAdditionalComment());
            jobDataList.add(job);
        }

        return jobDataList;
    }

    @PostConstruct
    public void init() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            File is = new ClassPathResource("/salary_survey-3.json").getFile();

            jobDataSet = objectMapper.readValue(is, new TypeReference<List<Job>>() {
            });

        } catch (IOException ioException) {
            log.info(ioException.getMessage());
        }

    }


    class Filter {
        public static Predicate<Job> salary(BigDecimal salary, String filter) {
            return new Predicate<Job>() {
                @Override
                public boolean test(Job t) {

                    if (StringUtils.isEmpty(filter)) {
                        return true;
                    }

                    if (filter.equals("gt")) {
                        return t.getEmployerSalary().compareTo(salary) > 0;
                    } else if (filter.equals("gteq")) {
                        return t.getEmployerSalary().compareTo(salary) >= 0; //
                    } else if (filter.equals("ls")) {
                        return t.getEmployerSalary().compareTo(salary) < 0;
                    } else if (filter.equals("lseq")) {
                        return t.getEmployerSalary().compareTo(salary) <= 0;
                    } else if (filter.equals("eq")) {
                        return t.getEmployerSalary().compareTo(salary) == 0;
                    } else if (filter.equals("nq")) {
                        return t.getEmployerSalary().compareTo(salary) != 0;
                    }

                    return true;
                }
            };
        }


        public static Predicate<Job> jobtitle(String data) {
            return new Predicate<Job>() {
                @Override
                public boolean test(Job t) {
                    Boolean xx = StringUtils.isEmpty(t.getJobTitle());
                    Boolean xxx = t.getJobTitle().equals(data);
                    return StringUtils.isEmpty(data) || t.getJobTitle().equals(data);
                }
            };
        }

        public static Predicate<Job> gender(String data) {
            return new Predicate<Job>() {
                @Override
                public boolean test(Job t) {
                    Boolean xx = StringUtils.isEmpty(t.getJobTitle());
                    return StringUtils.isEmpty(data) || t.getGender().equals(data);
                }
            };
        }

    }


}
