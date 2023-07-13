package com.alookatSOAPAPIsInSpringBoot.alookatSOAPAPIsInSpringBoot.services;



import com.alookatSOAPAPIsInSpringBoot.alookatSOAPAPIsInSpringBoot.Repo.StudentRepository;
import com.alookatSOAPAPIsInSpringBoot.alookatSOAPAPIsInSpringBoot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    public StudentRepository studentRepository;
    public Student createStudent(Student student) {
      return    studentRepository.save(student);

    }


    public List<Student> findAllStudents() {
        return  studentRepository.findAll();
    }


    public Student updateStudent(Student student) {



        return  studentRepository.save(student);
    }

    public Student findStudentByStudentId(long studentId) {
        return  studentRepository.findStudentByStudentId(studentId);
    }


    public void delete(Student student) {
        studentRepository.delete(student);
    }
}
