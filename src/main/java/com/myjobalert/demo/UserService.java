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
@RequestMapping(value="/rest/user")
class UserService implements UserServiceInterface {
    @RequestMapping(value="/",method = RequestMethod.GET)
    public List<User> getAllUsers(){
        List<User> userList = DemoApplication.dynamoDBMapper.scan(User.class, new DynamoDBScanExpression());

        return userList;
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public User addUser(@RequestParam(value="userId") String userId,
                        @RequestParam(value="userName") String userName,
                        @RequestParam(value="userEmail") String userEmail){
            //,@RequestParam(value="subject",defaultValue = "unknown") String subject){

        User userToAdd=new User(userId, userName, userEmail);
//        DemoApplication.hmUser.put(new Long(userToAdd.getUserId()),userToAdd);
        DemoApplication.dynamoDBMapper.save(userToAdd);
        return userToAdd;
    }

    @RequestMapping(value="/update",method = RequestMethod.PUT)
    public User updateUser(@RequestBody User userToUpdate) throws Exception {

        User userToBeUpdated = DemoApplication.dynamoDBMapper.load( userToUpdate );
        if( userToBeUpdated != null ){
            DemoApplication.dynamoDBMapper.save( userToUpdate );
        }else{
            throw new Exception("User "+userToUpdate.getUserId()+" does not exists");
        }

        return userToUpdate;
    }


    @RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
    public boolean deleteUser(@PathVariable long id) throws Exception {

        DynamoDB dynamoDB = new DynamoDB(DemoApplication.dynamoDBClient);

        Table table = dynamoDB.getTable("User");

        DeleteItemSpec deleteItemSpec = new DeleteItemSpec()
                .withPrimaryKey(new PrimaryKey("userId", String.valueOf(id) ));
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
    public User getUser(@PathVariable long id){
        return DemoApplication.dynamoDBMapper.load(User.class, String.valueOf(id));
    }
}