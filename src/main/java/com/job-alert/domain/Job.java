package com.job-alert.domain;


import  java.util.Date;


public class Job {
    private String jobId;
    private String jobTitle;
    private String jobCompany;
    private String jobDescription;
    private Date jobPostDate;

    public Job(String jobId, String jobTitle, String jobCompany, String jobDescription) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobCompany = jobCompany;
        this.jobDescription = jobDescription;
        this.jobPostDate = new Date();
    }

}