package com.myjobalert.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

@RestController
@RequestMapping(value="/rest/student")
class StudentService{

    @RequestMapping(value="/",method = RequestMethod.GET)
    public HashMap<Long,Student> getAllStudents(){
        return DemoApplication.hmStudent;
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public Student addStudent(@RequestParam(value="name") String name
            ,@RequestParam(value="subject",defaultValue = "unknown") String subject){

        Student student=new Student(name,subject);
        DemoApplication.hmStudent.put(new Long(student.getId()),student);
        return student;

    }

    @RequestMapping(value="/update",method = RequestMethod.PUT)
    public Student updateStudent(@RequestBody Student student) throws Exception {

        if(DemoApplication.hmStudent.containsKey(new Long(student.getId()))){
            DemoApplication.hmStudent.put(new Long(student.getId()),student);
        }else{
            throw new Exception("Student "+student.getId()+" does not exists");
        }

        return student;
    }


    @RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
    public Student deleteStudent(@PathVariable long id) throws Exception {

        Student student;

        if(DemoApplication.hmStudent.containsKey(new Long(id))){
            student=DemoApplication.hmStudent.get(new Long(id));
            DemoApplication.hmStudent.remove(new Long(id));
        }else{
            throw new Exception("Student "+id+" does not exists");
        }
        return student;
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Student getStudent(@PathVariable long id){
        return DemoApplication.hmStudent.get(new Long(id));
    }
}