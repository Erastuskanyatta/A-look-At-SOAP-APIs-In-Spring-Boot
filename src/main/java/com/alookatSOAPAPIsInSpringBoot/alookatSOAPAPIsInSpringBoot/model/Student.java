package com.alookatSOAPAPIsInSpringBoot.alookatSOAPAPIsInSpringBoot.model;


import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student  {
   @Id
    @SequenceGenerator(name = "sequence-name")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public  Long  studentId;
    public  String name;
    public  int age;
    public  String reg_number;
    public String course;

}

