package com.myjobalert.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;


import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;

import java.util.List;

@RestController
@RequestMapping(value="/rest/job")
class JobService implements JobServiceInterface {

    @RequestMapping(value="/",method = RequestMethod.GET)
    public List<Job> getAllJobs(){
        List<Job> jobList = DemoApplication.dynamoDBMapper.scan(Job.class, new DynamoDBScanExpression());

        return jobList;
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public Job addJob(@RequestParam(value="jobId") String jobId,
                      @RequestParam(value="jobTitle") String jobTitle,
                      @RequestParam(value="jobCompany") String jobCompany,
                      @RequestParam(value="jobUrl") String jobUrl,
                      @RequestParam(value="jobCategory") String jobCategory,
                      @RequestParam(value="jobEmploymentType") String jobEmploymentType){

        Job jobToAdd = new Job(jobId, jobTitle, jobCompany, jobUrl, jobCategory, jobEmploymentType);
//        DemoApplication.hmJob.put(new Long(jobToAdd.getJobId()),jobToAdd);
        DemoApplication.dynamoDBMapper.save(jobToAdd);
        return jobToAdd;
    }

    @RequestMapping(value="/update",method = RequestMethod.PUT)
    public Job updateJob(@RequestBody Job jobToUpdate) throws Exception {

        Job jobToBeUpdated = DemoApplication.dynamoDBMapper.load( jobToUpdate );
        if( jobToBeUpdated != null ){
            DemoApplication.dynamoDBMapper.save( jobToUpdate );

//        if(DemoApplication.hmJob.containsKey(new Long(jobToUpdate.getJobId()))){
//            DemoApplication.hmJob.put(new Long(jobToUpdate.getJobId()),jobToUpdate);
        } else {
            throw new Exception("Job "+ jobToUpdate.getJobId() + " does not exists");
        }

        return jobToBeUpdated;
    }


    @RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
    public boolean deleteJob(@PathVariable long id) throws Exception {

        DynamoDB dynamoDB = new DynamoDB(DemoApplication.dynamoDBClient);

        Table table = dynamoDB.getTable("Job");

        DeleteItemSpec deleteItemSpec = new DeleteItemSpec()
                .withPrimaryKey(new PrimaryKey("jobId", String.valueOf(id) ));
        // Conditional delete

        try {
            System.out.println("Attempting a conditional delete...");
            table.deleteItem(deleteItemSpec);
            System.out.println("DeleteItem succeeded");
            return true;
        }
        catch (Exception e) {
            System.err.println("Unable to delete item: %s" + String.valueOf(id) );
            System.err.println(e.getMessage());
            return false;
        }
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Job getJob(@PathVariable long id){
        return DemoApplication.dynamoDBMapper.load(Job.class, String.valueOf(id));
    }
}