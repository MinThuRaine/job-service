package com.minthuraine.job.system.portfolio.job.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;


@Getter
@Builder
@AllArgsConstructor
public class JobSearchDto {

    private final BigDecimal salary;

    private final String salaryFilter;

    private final String jobTitle;

    private final String gender;

}
