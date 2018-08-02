package com.jobalert.domain;


import java.util.Date;


public class Application {
    private String userId;
    private String companyId;
    private Date applicationDate;

    public Application(String userId, String companyId) {
        this.userId = userId;
        this.companyId = companyId;
        this.applicationDate = new Date();
    }

    public Application(String userId, String companyId, Date applicationDate) {
        this.userId = userId;
        this.companyId = companyId;
        this.applicationDate = applicationDate;
    }

    // User is allowed to correct the date of his/her application
    public void setApplicationDate(Date newApplicationDate){
        this.applicationDate = newApplicationDate;
    }

}