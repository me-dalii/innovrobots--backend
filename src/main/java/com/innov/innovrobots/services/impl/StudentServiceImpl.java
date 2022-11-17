package com.innov.innovrobots.services.impl;

import com.innov.innovrobots.exceptions.FullCapacityException;
import com.innov.innovrobots.exceptions.NotFoundException;
import com.innov.innovrobots.models.Student;
import com.innov.innovrobots.repositories.StudentRepository;
import com.innov.innovrobots.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) throws NotFoundException {
        if(this.studentRepository.findById(id).isPresent()) {
            return this.studentRepository.findById(id).get();
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public void saveStudent(Student student) throws FullCapacityException {
        long savedStudentsNumber =this.studentRepository.count();
        if (savedStudentsNumber < student.getEvent().getNumberOfAllowedStudents())
            this.studentRepository.save(student);
        else
            throw new FullCapacityException();
    }

    @Override
    public void deleteStudent(Long id) throws NotFoundException {
        if(this.studentRepository.existsById(id)) {
            this.studentRepository.deleteById(id);
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public List<Student> getStudentsByEventId(Long id) {
        return this.studentRepository.findAllByEventId(id);
    }
}
