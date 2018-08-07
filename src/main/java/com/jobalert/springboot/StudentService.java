package com.jobalert.springboot;

@RestController
@RequestMapping(value="/rest/student")
class StudentService{

    @RequestMapping(value="/",method = RequestMethod.GET)
    public HashMap<Long,Student> getAllStudents(){
        return Application.hmStudent;
    }
}