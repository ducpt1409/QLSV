package com.ptd.service.impl;

import com.ptd.dao.TeacherDAO;
import com.ptd.entity.Teacher;
import com.ptd.model.TeacherDTO;
import com.ptd.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherDAO teacherDAO;


    @Override
    public List<TeacherDTO> getTeacherByDepartment(int departmentID) {
        List<Teacher> teachers = teacherDAO.getTeacherByDepartment(departmentID);
        List<TeacherDTO> teacherDTOS = new ArrayList<>();
        for(Teacher i : teachers){
            teacherDTOS.add(i.toDTO());
        }
        return teacherDTOS;
    }
}
