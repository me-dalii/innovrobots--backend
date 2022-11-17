package com.innov.innovrobots.services;

import com.innov.innovrobots.exceptions.FullCapacityException;
import com.innov.innovrobots.exceptions.NotFoundException;
import com.innov.innovrobots.models.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    Student getStudentById(Long id) throws NotFoundException;
    void saveStudent(Student student) throws FullCapacityException;
    void deleteStudent(Long id) throws NotFoundException;

    List<Student> getStudentsByEventId(Long id);
}
