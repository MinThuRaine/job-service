package com.minthuraine.job.system.portfolio.job.data;

public class JobData {


    private final String timestamp;
    private final String employer;
    private final String location;
    private final String jobTitle;
    private final String yearsAtEmployer;
    private final String experience;
    private final String salary;
    private final String signingBonus;
    private final String annualBonus;
    private final String annualStockValue;
    private final String gender;
    private final String additionalComment;


    public JobData(String timestamp, String employer, String location, String jobTitle, String yearsAtEmployer, String experience, String salary, String signingBonus, String annualBonus, String annualStockValue, String gender, String additionalComment) {
        this.timestamp = timestamp;
        this.employer = employer;
        this.location = location;
        this.jobTitle = jobTitle;
        this.yearsAtEmployer = yearsAtEmployer;
        this.experience = experience;
        this.salary = salary;
        this.signingBonus = signingBonus;
        this.annualBonus = annualBonus;
        this.annualStockValue = annualStockValue;
        this.gender = gender;
        this.additionalComment = additionalComment;
    }

    private JobData(Builder builder) {
        timestamp = builder.timestamp;
        employer = builder.employer;
        location = builder.location;
        jobTitle = builder.jobTitle;
        yearsAtEmployer = builder.yearsAtEmployer;
        experience = builder.experience;
        salary = builder.salary;
        signingBonus = builder.signingBonus;
        annualBonus = builder.annualBonus;
        annualStockValue = builder.annualStockValue;
        gender = builder.gender;
        additionalComment = builder.additionalComment;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private String timestamp;
        private String employer;
        private String location;
        private String jobTitle;
        private String yearsAtEmployer;
        private String experience;
        private String salary;
        private String signingBonus;
        private String annualBonus;
        private String annualStockValue;
        private String gender;
        private String additionalComment;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder timestamp(String val) {
            timestamp = val;
            return this;
        }

        public Builder employer(String val) {
            employer = val;
            return this;
        }

        public Builder location(String val) {
            location = val;
            return this;
        }

        public Builder jobTitle(String val) {
            jobTitle = val;
            return this;
        }

        public Builder yearsAtEmployer(String val) {
            yearsAtEmployer = val;
            return this;
        }

        public Builder experience(String val) {
            experience = val;
            return this;
        }

        public Builder salary(String val) {
            salary = val;
            return this;
        }

        public Builder signingBonus(String val) {
            signingBonus = val;
            return this;
        }

        public Builder annualBonus(String val) {
            annualBonus = val;
            return this;
        }

        public Builder annualStockValue(String val) {
            annualStockValue = val;
            return this;
        }

        public Builder gender(String val) {
            gender = val;
            return this;
        }

        public Builder additionalComment(String val) {
            additionalComment = val;
            return this;
        }

        public JobData build() {
            return new JobData(this);
        }
    }
}
