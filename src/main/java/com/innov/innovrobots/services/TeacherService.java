package com.innov.innovrobots.services;

import com.innov.innovrobots.exceptions.FullCapacityException;
import com.innov.innovrobots.exceptions.NotFoundException;
import com.innov.innovrobots.models.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getTeachers();
    Teacher getTeacherById(Long id) throws NotFoundException;
    void saveTeacher(Teacher teacher) throws FullCapacityException;
    void deleteTeacher(Long id) throws NotFoundException;

    List<Teacher> getTeachersByEventId(Long id);
}
