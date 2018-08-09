package com.myjobalert.demo;

import  java.util.Date;


public class Job {
    private final String jobId;
    private String jobTitle;
    private String jobCompany;
    private String jobUrl;

    private String jobCategory;
    private String jobEmploymentType;

    private Date jobPostDate;

    public Job(String jobId, String jobTitle, String jobCompany, String jobUrl, String jobCategory, String jobEmploymentType) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobCompany = jobCompany;
        this.jobUrl = jobUrl;

        this.jobCategory = jobCategory;
        this.jobEmploymentType = jobEmploymentType;

        this.jobPostDate = new Date();
    }

    public String getJobId(){
        return this.jobId;
    }

    public String getJobTitle(){
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle){
        this.jobTitle = jobTitle;
    }

    public String getJobCompany(){
        return this.jobCompany;
    }

    public void setJobCompany(String jobCompany){
        this.jobCompany = jobCompany;
    }

    public String getjobUrl(){
        return this.jobUrl;
    }

    public void setjobUrl(String jobUrl){
        this.jobUrl = jobUrl;
    }

    public String getJobCategory(){
        return this.jobCategory;
    }

    public void setJobCategory(String jobCategory){
        this.jobCategory = jobCategory;
    }

    public String getJobEmploymentType(){
        return this.jobEmploymentType;
    }

    public void setJobEmploymentType(String jobEmploymentType){
        this.jobEmploymentType = jobEmploymentType;
    }

    public Date getJobPostDate(){
        return this.jobPostDate;
    }

    public void setJobTitle(Date jobPostDate){
        this.jobPostDate = jobPostDate;
    }



    //to-do
    // @Override
    // toString()
    // hashCode()

    @Override
    public String toString(){
        return "Job {" +
                "jobId=" + jobId +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobCompany='" + jobCompany + '\'' +
                ", jobUrl='" + jobUrl + '\'' +
                ", jobCategory='" + jobCategory + '\'' +
                ", jobEmploymentType='" + jobEmploymentType + '\'' +
                ", jobPostDate='" + jobPostDate + '\'' +
                '}';
    }


}