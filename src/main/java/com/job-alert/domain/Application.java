package com.job-alert.domain;


import java.util.Date;


public class Application {
    private String userId;
    private String companyId;
    private Date applicationDate;

    Application(String userId, String companyId) {
        this.userId = userId;
        this.companyId = companyId;
        this.applicationDate = new Date();
    }

}