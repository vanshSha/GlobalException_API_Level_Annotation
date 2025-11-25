package com.global_exception.service;

import com.global_exception.entity.Student;
import com.global_exception.exceptionhandler.StudentAlreadyExists;
import com.global_exception.exceptionhandler.StudentDoesNotExist;
import com.global_exception.exceptionhandler.StudentNotFoundException;
import com.global_exception.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentImpl implements StudentService {

    @Autowired
    private StudentRepo repo;

    @Override
    public Student getById(short id) {
        return repo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with the given ID."));
    }

    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public String saveStudent(Student student) {
        Optional<Student> existingCustomer = repo.findById(student.getId());
        if (!existingCustomer.isPresent()) {
            repo.save(student);
            return "Student added successfully";
        } else {
            throw new StudentAlreadyExists("Customer already exists!");
        }
    }

    @Override
    public Student updateStudent(short id, Student student) {
        Optional<Student> existing1 = repo.findById(id);
        if (!existing1.isPresent()) {
            throw new StudentDoesNotExist("No Such Customer exists!!");
        } else {

            Student existing = repo.findById(id).orElseThrow();

            existing.setName(student.getName());
            existing.setAge(student.getAge());
            existing.setRollNo(student.getRollNo());
            existing.setZipCode(student.getZipCode());
            return repo.save(existing);
        }
    }

    @Override
    public void deleteStudent(short id) {
        repo.deleteById(id);
    }


}
