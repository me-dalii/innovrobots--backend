package com.innov.innovrobots.services.impl;

import com.innov.innovrobots.exceptions.FullCapacityException;
import com.innov.innovrobots.exceptions.NotFoundException;
import com.innov.innovrobots.models.Company;
import com.innov.innovrobots.models.Teacher;
import com.innov.innovrobots.repositories.TeacherRepository;
import com.innov.innovrobots.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getTeachers() {
        return this.teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(Long id) throws NotFoundException {
        if(this.teacherRepository.findById(id).isPresent()) {
            return this.teacherRepository.findById(id).get();
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public void saveTeacher(Teacher teacher) throws FullCapacityException {
        long savedTeachersNumber =this.teacherRepository.count();
        if (savedTeachersNumber < teacher.getEvent().getNumberOfAllowedTeachers())
            this.teacherRepository.save(teacher);
        else
            throw new FullCapacityException();
    }

    @Override
    public void deleteTeacher(Long id) throws NotFoundException {
        if(this.teacherRepository.existsById(id)) {
            this.teacherRepository.deleteById(id);
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public List<Teacher> getTeachersByEventId(Long id) {
        return this.teacherRepository.findAllByEventId(id);
    }
}
