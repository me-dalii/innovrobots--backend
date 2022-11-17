package com.innov.innovrobots.controllers;

import com.innov.innovrobots.exceptions.FullCapacityException;
import com.innov.innovrobots.exceptions.NotFoundException;
import com.innov.innovrobots.models.Teacher;
import com.innov.innovrobots.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/")
    public List<Teacher> getTeachers(){
        return teacherService.getTeachers();
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable(name = "id") Long id) throws NotFoundException {
        return teacherService.getTeacherById(id);
    }

    @PostMapping("/")
    public void saveTeacher(@RequestBody Teacher teacher) throws FullCapacityException {
        teacherService.saveTeacher(teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable(name = "id") Long id) throws NotFoundException {
        teacherService.deleteTeacher(id);
    }

    @GetMapping("/event/{id}")
    public List<Teacher> getTeachersByEventId(@PathVariable(name = "id") Long id) throws NotFoundException {
        return teacherService.getTeachersByEventId(id);
    }
}
