package com.global_exception.controller;

import com.global_exception.entity.Student;
import com.global_exception.service.StudentImpl;
import com.global_exception.service.StudentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/crud")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/id/{id}")
    ResponseEntity<Student> getById(@PathVariable short id) {
        return ResponseEntity.ok(studentService.getById(id));
    }


    @GetMapping("/getAll")
    ResponseEntity<List<Student>> getAllStudent() {
        List<Student> getAllStudent = studentService.getAllStudents();
        if (!getAllStudent.isEmpty()) {
            return new ResponseEntity<>(getAllStudent, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/save")
    ResponseEntity<String> createStudent(@RequestBody @Valid Student student) {
        return ResponseEntity.ok(studentService.saveStudent(student));
    }


    @PutMapping("/updateStudent/{id}")
    ResponseEntity<?> updateStudent(@PathVariable Short id, @RequestBody @Valid Student student) {
        return ResponseEntity.ok(studentService.updateStudent(id, student));
    }

    @DeleteMapping("/id/{id}")
    ResponseEntity<Student> deleteUser(@PathVariable short id) {
        try {
            studentService.deleteStudent(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
}
