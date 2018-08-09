package com.myjobalert.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

@RestController
@RequestMapping(value="/rest/user")
class UserService {
    @RequestMapping(value="/",method = RequestMethod.GET)
    public HashMap<Long,User> getAllUsers(){
        return DemoApplication.hmUser;
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public User addUser(@RequestParam(value="userId") String userId,
                        @RequestParam(value="userName") String userName,
                        @RequestParam(value="userEmail") String userEmail){
            //,@RequestParam(value="subject",defaultValue = "unknown") String subject){

        User userToAdd=new User(userId, userName, userEmail);
        DemoApplication.hmUser.put(new Long(userToAdd.getUserId()),userToAdd);
        return userToAdd;
    }

    @RequestMapping(value="/update",method = RequestMethod.PUT)
    public User updateUser(@RequestBody User userToUpdate) throws Exception {

        if(DemoApplication.hmUser.containsKey(new Long(userToUpdate.getUserId()))){
            DemoApplication.hmUser.put(new Long(userToUpdate.getUserId()),userToUpdate);
        }else{
            throw new Exception("User "+userToUpdate.getUserId()+" does not exists");
        }

        return userToUpdate;
    }


    @RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable long id) throws Exception {

        User userToDelete;

        if(DemoApplication.hmUser.containsKey(new Long(id))){
            userToDelete = DemoApplication.hmUser.get(new Long(id));
            DemoApplication.hmUser.remove(new Long(id));
        }else{
            throw new Exception("User "+id+" does not exists");
        }
        return userToDelete;
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable long id){
        return DemoApplication.hmUser.get(new Long(id));
    }
}