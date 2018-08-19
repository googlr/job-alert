package com.myjobalert.demo;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.HashMap;
import java.util.Date;


@SpringBootApplication
public class DemoApplication {
	private String getUniqueJobId(){
		//to-do
		return "to-do";
	}

//	public static HashMap<Long,Job> hmJob;
//	public static HashMap<Long,User> hmUser;


	public static AmazonDynamoDB dynamoDBClient;
	public static DynamoDBMapper dynamoDBMapper;

	public DemoApplication(){
		//this.dynamoDBClient = AmazonDynamoDBClientBuilder.defaultClient();
		//this.dynamoDBMapper = new DynamoDBMapper(dynamoDBClient);

	}

	private void createTableInDynamoDB(Class<?> classT){
		//final AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder.defaultClient();

		//DynamoDBMapper mapper = new DynamoDBMapper(dynamoDBClient);

		try {
			CreateTableRequest req = dynamoDBMapper.generateCreateTableRequest(classT);
			// Table provision throughput is still required since it cannot be specified in your POJO
			req.setProvisionedThroughput(new ProvisionedThroughput(5L, 5L));
			// Fire off the CreateTableRequest using the low-level client
			CreateTableResult result = dynamoDBClient.createTable(req);

			System.out.println(result.getTableDescription().getTableName());
		} catch (AmazonServiceException e) {
			System.err.println(e.getErrorMessage());
			System.exit(1);
		}

		System.out.println("Create Table: %s.\n");
	}

	private void deleteTableInDynamoDB(String tableName){
		try {
			dynamoDBClient.deleteTable(tableName);
		} catch (AmazonServiceException e) {
			System.err.println(e.getErrorMessage());
			System.exit(1);
		}
	}

	private void loadSampleDateIntoDynamoDB(){
		Job firstJobInstance = new Job("0000000001",
				"Data Scientist/Quantitative Analyst, Engineering, University Graduate",
				"Google",
				"https://careers.google.com/jobs#!t=jo&jid=/google/data-scientist-quantitative-analyst-1600-amphitheatre-pkwy-mountain-view-ca-2495140088&",
				"Software Engineering",
				"Full-Time"
		);

		Job secondJobInstance = new Job("0000000002",
				"Research Scientist, Google Brain (United States)",
				"Google",
				"https://careers.google.com/jobs#!t=jo&jid=/google/research-scientist-google-brain-united-76-9th-ave-new-york-ny-10011-usa-2144790060&",
				"Software Engineering",
				"Full-Time"
		);

		Job thirdJobInstance = new Job("0000000003",
				"Technical Program Manager, University Graduate",
				"Google",
				"https://careers.google.com/jobs#!t=jo&jid=/google/technical-program-manager-university-1600-amphitheatre-pkwy-mountain-view-ca-3631710107&",
				"Technical Infrastructure",
				"Full-Time"
		);

		dynamoDBMapper.save(firstJobInstance);
		dynamoDBMapper.save(secondJobInstance);
		dynamoDBMapper.save(thirdJobInstance);


		User firstUserInstance = new User("0000000001",
				"googlr",
				"googlr@gmail.com"
		);

		User secondUserInstance = new User("0000000002",
				"Kaira",
				"kaira.Knightley@gmail.com"
		);

		dynamoDBMapper.save(firstUserInstance);
		dynamoDBMapper.save(secondUserInstance);
	}

	public static void main(String[] args) {

		dynamoDBClient = AmazonDynamoDBClientBuilder.defaultClient();
		dynamoDBMapper = new DynamoDBMapper(dynamoDBClient);

		SpringApplication.run(DemoApplication.class, args);

		// DemoApplication demoApplication = new DemoApplication();
		// Create User Table
		// Create Job Table
		//demoApplication.createTableInDynamoDB(User.class);
		//demoApplication.createTableInDynamoDB(Job.class);

		// Load Sample data into DynamoDB
		// demoApplication.loadSampleDateIntoDynamoDB();

		// Create User Table
		// Create Job Table
		//demoApplication.deleteTableInDynamoDB("User");
		//demoApplication.deleteTableInDynamoDB("Job");




		// hmJob = new HashMap<Long,Job>();
		// hmJob.put(new Long(firstJobInstance.getJobId()),firstJobInstance);
		// hmJob.put(new Long(secondJobInstance.getJobId()),secondJobInstance);
		// hmJob.put(new Long(thirdJobInstance.getJobId()),thirdJobInstance);





		// hmUser = new HashMap<Long,User>();
		// hmUser.put(new Long(firstUserInstance.getUserId()),firstUserInstance);
		// hmUser.put(new Long(secondUserInstance.getUserId()),secondUserInstance);
	}
}