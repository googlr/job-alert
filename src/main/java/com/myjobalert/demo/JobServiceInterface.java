package com.myjobalert.demo;

import java.util.HashMap;

public interface JobServiceInterface {

    HashMap<Long,Job> getAllStudents();

    Job addJob(String jobId,
               String jobTitle,
               String jobCompany,
               String jobUrl,
               String jobCategory,
               String jobEmploymentType);

    Job updateJob(Job jobToUpdate) throws Exception;


    Job deleteJob( long id) throws Exception;

    Job getStudent( long id);
}
