package com.myjobalert.demo;

import java.util.List;

public interface JobServiceInterface {

    List<Job> getAllJobs();

    Job addJob(String jobId,
               String jobTitle,
               String jobCompany,
               String jobUrl,
               String jobCategory,
               String jobEmploymentType);

    Job updateJob(Job jobToUpdate) throws Exception;


    boolean deleteJob(String id) throws Exception;

    Job getJob(String id);

    List<Job> searchJob(String searchInput);
}
