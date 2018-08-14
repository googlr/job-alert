package com.myjobalert.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

@RestController
@RequestMapping(value="/rest/job")
class JobService{

    @RequestMapping(value="/",method = RequestMethod.GET)
    public HashMap<Long,Job> getAllStudents(){
        return DemoApplication.hmJob;
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public Job addJob(@RequestParam(value="jobId") String jobId,
                      @RequestParam(value="jobTitle") String jobTitle,
                      @RequestParam(value="jobCompany") String jobCompany,
                      @RequestParam(value="jobUrl") String jobUrl,
                      @RequestParam(value="jobCategory") String jobCategory,
                      @RequestParam(value="jobEmploymentType") String jobEmploymentType){

        Job jobToAdd = new Job(jobId, jobTitle, jobCompany, jobUrl, jobCategory, jobEmploymentType);
        DemoApplication.hmJob.put(new Long(jobToAdd.getJobId()),jobToAdd);
        return jobToAdd;
    }

    @RequestMapping(value="/update",method = RequestMethod.PUT)
    public Job updateJob(@RequestBody Job jobToUpdate) throws Exception {

        if(DemoApplication.hmJob.containsKey(new Long(jobToUpdate.getJobId()))){
            DemoApplication.hmJob.put(new Long(jobToUpdate.getJobId()),jobToUpdate);
        }else{
            throw new Exception("Job "+jobToUpdate.getJobId()+" does not exists");
        }

        return jobToUpdate;
    }


    @RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
    public Job deleteJob(@PathVariable long id) throws Exception {

        Job jobToDelete;

        if(DemoApplication.hmJob.containsKey(new Long(id))){
            jobToDelete = DemoApplication.hmJob.get(new Long(id));
            DemoApplication.hmJob.remove(new Long(id));
        }else{
            throw new Exception("Job "+id+" does not exists");
        }
        return jobToDelete;
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Job getStudent(@PathVariable long id){
        return DemoApplication.hmJob.get(new Long(id));
    }
}