package com.global_exception.service;

import com.global_exception.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    // find by id
    Student getById(short id);

    // get All student
    List<Student> getAllStudents();

    // create student
    String saveStudent(Student student);

    // update student this is not working
    Student updateStudent(short id, Student student);

    // delete student
    void deleteStudent(short id);



}
