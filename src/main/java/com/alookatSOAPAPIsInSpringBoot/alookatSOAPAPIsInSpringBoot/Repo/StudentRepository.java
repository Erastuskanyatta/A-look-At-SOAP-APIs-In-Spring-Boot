package com.alookatSOAPAPIsInSpringBoot.alookatSOAPAPIsInSpringBoot.Repo;




import com.alookatSOAPAPIsInSpringBoot.alookatSOAPAPIsInSpringBoot.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Long> {
 Logger logger = LoggerFactory.getLogger(StudentRepository.class);

    Student findStudentByStudentId(long studentId);
}


