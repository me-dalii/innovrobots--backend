package com.innov.innovrobots.controllers;

import com.innov.innovrobots.exceptions.FullCapacityException;
import com.innov.innovrobots.exceptions.NotFoundException;
import com.innov.innovrobots.models.Student;
import com.innov.innovrobots.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable(name = "id") Long id) throws NotFoundException {
        return studentService.getStudentById(id);
    }

    @PostMapping("/")
    public void saveStudent(@RequestBody Student student) throws FullCapacityException {
        studentService.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable(name = "id") Long id) throws NotFoundException {
        studentService.deleteStudent(id);
    }

    @GetMapping("/event/{id}")
    public List<Student> getStudentsByEventId(@PathVariable(name = "id") Long id) throws NotFoundException {
        return studentService.getStudentsByEventId(id);
    }
}
