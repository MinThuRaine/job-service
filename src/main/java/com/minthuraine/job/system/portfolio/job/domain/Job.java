package com.minthuraine.job.system.portfolio.job.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;


public class Job {

    @JsonProperty("Timestamp")
    private String timestamp;

    @JsonProperty("Employer")
    private String employer;

    @JsonProperty("Location")
    private String location;

    @JsonProperty("Job Title")
    private String jobTitle;

    @JsonProperty("Years at Employer")
    private String yearsAtEmployer;

    @JsonProperty("Years of Experience")
    private String experience;

    @JsonProperty("Salary")
    private String salary;

    private BigDecimal employerSalary;

    @JsonProperty("Signing Bonus")
    private String signingBonus;

    @JsonProperty("Annual Bonus")
    private String annualBonus;

    @JsonProperty("Annual Stock Value/Bonus")
    private String annualStockValue;

    @JsonProperty("Gender")
    private String gender;

    @JsonProperty("Additional Comments")
    private String additionalComment;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {

        if (StringUtils.isEmpty(employer)) {
            this.employer = "Jack";
        } else {
            this.employer = employer;
        }
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {

        if (StringUtils.isEmpty(jobTitle)) {
            this.jobTitle = "";
        } else {
            this.jobTitle = jobTitle;
        }
    }

    public String getYearsAtEmployer() {
        return yearsAtEmployer;
    }

    public void setYearsAtEmployer(String yearsAtEmployer) {
        this.yearsAtEmployer = yearsAtEmployer;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {

        if (StringUtils.isEmpty(salary)) {
            this.salary = "0";
            this.employerSalary = new BigDecimal("0");
        } else {

            String salarDigit = salary.replaceAll("[^0-9]", "");

            if (StringUtils.isEmpty(salarDigit)) {
                this.salary = "0";
                this.employerSalary = new BigDecimal("0");
            } else {
                this.salary = salarDigit;
                this.employerSalary = new BigDecimal(salarDigit);
            }
        }
    }

    public String getSigningBonus() {
        return signingBonus;
    }

    public void setSigningBonus(String signingBonus) {
        this.signingBonus = signingBonus;
    }

    public String getAnnualBonus() {
        return annualBonus;
    }

    public void setAnnualBonus(String annualBonus) {
        this.annualBonus = annualBonus;
    }

    public String getAnnualStockValue() {
        return annualStockValue;
    }

    public void setAnnualStockValue(String annualStockValue) {
        this.annualStockValue = annualStockValue;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (StringUtils.isEmpty(gender)) {
            this.gender = "";
        } else {
            this.gender = gender;
        }
    }

    public String getAdditionalComment() {
        return additionalComment;
    }

    public void setAdditionalComment(String additionalComment) {
        this.additionalComment = additionalComment;
    }

    public BigDecimal getEmployerSalary() {
        return employerSalary;
    }
}
