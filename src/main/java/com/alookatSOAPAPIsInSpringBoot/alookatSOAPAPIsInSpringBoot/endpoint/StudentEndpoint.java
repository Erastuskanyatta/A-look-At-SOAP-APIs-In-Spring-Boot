package com.alookatSOAPAPIsInSpringBoot.alookatSOAPAPIsInSpringBoot.endpoint;


import com.alookatSOAPAPIsInSpringBoot.alookatSOAPAPIsInSpringBoot.model.Student;


import com.alookatSOAPAPIsInSpringBoot.alookatSOAPAPIsInSpringBoot.services.StudentService;
import com.alookatsoapapisinspringboot.school.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;


@Endpoint
public class StudentEndpoint {
    Logger logger = LoggerFactory.getLogger(StudentEndpoint.class);

    private static final String url = "http://www.alookatSOAPAPIsInSpringBoot.com/school";

    @Autowired
    private StudentService studentService;
    // create Student
    @PayloadRoot(namespace = url, localPart = "UploadStudentRequest")
    @ResponsePayload
    public UploadStudentResponse getStudent(@RequestPayload UploadStudentRequest request) {
        UploadStudentResponse response = new UploadStudentResponse();
        Student student = new Student();
        ServiceStatus serviceStatus = new ServiceStatus();

        student.setName(request.getName());
        student.setAge(request.getAge());
        student.setCourse(request.getCourse());
        student.setReg_number(request.getRegNumber());

        response.setUploadStudentInfo(studentService.createStudent(student));

        serviceStatus.setStatusCode(String.valueOf(HttpStatus.ACCEPTED.value()));
        serviceStatus.setMessage("Student Details Uploaded Successfully!");

      response.setServiceStatus(serviceStatus);
        return response;
    }

    //getAllStudents
    @PayloadRoot(namespace = url, localPart = "getAllStudentRequest")
    @ResponsePayload
    public GetAllStudentResponse getAllStudentResponse (@RequestPayload GetAllStudentRequest request){

        GetAllStudentResponse response = new GetAllStudentResponse();
        List<UploadStudentInfo> articleInfoList = new ArrayList<>();

        List<Student> findAll = studentService.findAllStudents();

        for (int i = 0; i < findAll.size(); i++) {
            UploadStudentInfo ob = new UploadStudentInfo();
            BeanUtils.copyProperties(findAll.get(i), ob);
            articleInfoList.add(ob);
        }

        response.getUploadStudentResponse().addAll(articleInfoList);
        return  response;
    }

    //update student
    @PayloadRoot(namespace = url, localPart = "updateStudentRequest")
    @ResponsePayload
    public UpdateStudentResponse updateStudentResponse(@RequestPayload UpdateStudentRequest  request){
        System.out.println(request.getStudentId());
       Student student = studentService.findStudentByStudentId(1);
//       BeanUtils.copyProperties(request.getUploadStudentInfo(), student);

        Student feedback = studentService.updateStudent(student);
        System.out.println(">>>>>> " + feedback);

        UpdateStudentResponse response =new UpdateStudentResponse();
        ServiceStatus serviceStatus = new ServiceStatus();


        serviceStatus.setMessage("Updated");
        serviceStatus.setStatusCode(String.valueOf(HttpStatus.CREATED.value()));

        response.setServiceStatus(serviceStatus);

        return  response;

    }

    //delete student
    @PayloadRoot(namespace = url, localPart = "deleteStudentRequest")
    @ResponsePayload
    public  DeleteStudentResponse deleteStudentResponse(@RequestPayload DeleteStudentRequest delete){

        Student student =  studentService.findStudentByStudentId(delete.getStudentId());

        ServiceStatus serviceStatus = new ServiceStatus();
        if (student ==  null){
            serviceStatus.setMessage("Student with " + delete.getStudentId() +  " does not exist");
            serviceStatus.setStatusCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
        }else {
            studentService.delete(student);
            serviceStatus.setStatusCode(String.valueOf(HttpStatus.OK.value()));
            serviceStatus.setMessage("Deleted Successfully");
        }
        DeleteStudentResponse del = new DeleteStudentResponse();
        del.setServiceStatus(serviceStatus);
        return del;
    }

    //getStudent By StudentId
    @PayloadRoot(namespace = url,localPart = "getStudentByIdRequest")
    @ResponsePayload
    public  GetStudentByIdResponse getStudentByIdResponse (@RequestPayload GetStudentByIdRequest getStudentByIdRequest){
        Student student = studentService.findStudentByStudentId(getStudentByIdRequest.getStudentId());
        ServiceStatus serviceStatus = new ServiceStatus();
        GetStudentByIdResponse response = new GetStudentByIdResponse();

        response.setUploadStudentResponse(student);
        return  response;
    }

}




