package com.job-alert.domain;


import  java.util.Date;


public class Job {
    private String jobId;
    private String jobTitle;
    private String jobCompany;
    private Date jobPostDate;

    Job(String jobId, String jobTitle, String jobCompany) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobCompany = jobCompany;
        this.jobPostDate = new Date();
    }

}