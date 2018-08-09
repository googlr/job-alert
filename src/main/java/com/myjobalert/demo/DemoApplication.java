package com.myjobalert.demo;

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

	public static HashMap<Long,Job> hmJob;

	public static void main(String[] args) {
		hmJob = new HashMap<Long,Job>();

		Job firstJobInstance = new Job("0000000001",
			"Data Scientist/Quantitative Analyst, Engineering, University Graduate",
				"Google",
				"https://careers.google.com/jobs#!t=jo&jid=/google/data-scientist-quantitative-analyst-1600-amphitheatre-pkwy-mountain-view-ca-2495140088&",
				"Software Engineering",
				"Full-Time"
		);
		hmJob.put(new Long(firstJobInstance.getJobId()),firstJobInstance);

		SpringApplication.run(DemoApplication.class, args);

		Job secondJobInstance = new Job("0000000002",
				"Research Scientist, Google Brain (United States)",
				"Google",
				"https://careers.google.com/jobs#!t=jo&jid=/google/research-scientist-google-brain-united-76-9th-ave-new-york-ny-10011-usa-2144790060&",
				"Software Engineering",
				"Full-Time"
		);
		hmJob.put(new Long(secondJobInstance.getJobId()),secondJobInstance);

		Job thirdJobInstance = new Job("0000000003",
				"Technical Program Manager, University Graduate",
				"Google",
				"https://careers.google.com/jobs#!t=jo&jid=/google/technical-program-manager-university-1600-amphitheatre-pkwy-mountain-view-ca-3631710107&",
				"Technical Infrastructure",
				"Full-Time"
				);
		hmJob.put(new Long(thirdJobInstance.getJobId()),thirdJobInstance);


	}
}