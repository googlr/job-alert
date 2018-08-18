package com.myjobalert.demo;

import  java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="Job")
public class Job {
    private String jobId;
    private String jobTitle;
    private String jobCompany;
    private String jobUrl;

    private String jobCategory;
    private String jobEmploymentType;

    // to-be added
    // private String jobLocation City, State, Country
    // private String jobStatus; //filled, closed, open, etc

    private Date jobPostDate;

    public Job(){}

    public Job(String jobId, String jobTitle, String jobCompany, String jobUrl, String jobCategory, String jobEmploymentType) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobCompany = jobCompany;
        this.jobUrl = jobUrl;

        this.jobCategory = jobCategory;
        this.jobEmploymentType = jobEmploymentType;

        this.jobPostDate = new Date();
    }

    @DynamoDBHashKey(attributeName="jobId")
    public String getJobId(){
        return this.jobId;
    }

    @DynamoDBAttribute(attributeName="jobTitle")
    public String getJobTitle(){
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle){
        this.jobTitle = jobTitle;
    }

    @DynamoDBAttribute(attributeName="jobCompany")
    public String getJobCompany(){
        return this.jobCompany;
    }

    public void setJobCompany(String jobCompany){
        this.jobCompany = jobCompany;
    }

    @DynamoDBAttribute(attributeName="jobUrl")
    public String getjobUrl(){
        return this.jobUrl;
    }

    public void setjobUrl(String jobUrl){
        this.jobUrl = jobUrl;
    }

    @DynamoDBAttribute(attributeName="jobCategory")
    public String getJobCategory(){
        return this.jobCategory;
    }

    public void setJobCategory(String jobCategory){
        this.jobCategory = jobCategory;
    }

    @DynamoDBAttribute(attributeName="jobEmploymentType")
    public String getJobEmploymentType(){
        return this.jobEmploymentType;
    }

    public void setJobEmploymentType(String jobEmploymentType){
        this.jobEmploymentType = jobEmploymentType;
    }

    @DynamoDBAttribute(attributeName="jobPostDate")
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

    @DynamoDBIgnore
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