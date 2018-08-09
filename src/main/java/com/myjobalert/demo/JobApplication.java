package com.myjobalert.demo;

import java.util.Date;

public class JobApplication {
    private Job jobApplied;
    private User applicant;
    private Date applicationDate;
    private String applicationProgress; // progress ( submitted, underReview, OA, PhoneInterview, onSite ) + Date
    private String applicationStatus; // expired or not, may hide expired application

    public JobApplication( Job jobApplied,
                           User applicant,
                           Date applicationDate,
                           String applicationProgress,
                           String applicationStatus ) {
        this.jobApplied = jobApplied;
        this.applicant = applicant;
        this.applicationDate = applicationDate;
        this.applicationProgress = applicationProgress;
        this.applicationStatus = applicationStatus;
    }

    public Job getJobApplied(){
        return jobApplied;
    }

    public void setJobApplied(Job jobApplied){
        this.jobApplied = jobApplied;
    }

    public User  getApplicant(){
        return applicant;
    }

    public void setApplicant(User applicant){
        this.applicant = applicant;
    }

    public Date getApplicationDate(){
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate){
        this.applicationDate = applicationDate;
    }

    public String getApplicationProgress(){
        return applicationProgress;
    }

    public void setApplicationProgress(String applicationProgress){
        this.applicationProgress = applicationProgress;
    }

    public String getApplicationStatus(){
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus){
        this.applicationStatus = applicationStatus;
    }

    @Override
    public String toString() {
        return "JobApplication {" +
                "jobApplied=" + jobApplied +
                ", applicant='" + applicant + '\'' +
                ", applicationDate='" + applicationDate + '\'' +
                ", applicationProgress='" + applicationProgress + '\'' +
                ", applicationStatus='" + applicationStatus + '\'' +
                '}';
    }
}
