package com.ptd.service.impl;

import com.ptd.dao.ClassDAO;
import com.ptd.dao.DepartmentDAO;
import com.ptd.dao.TeacherDAO;
import com.ptd.entity.ClassEntity;
import com.ptd.entity.Department;
import com.ptd.entity.Teacher;
import com.ptd.model.ClassDTO;
import com.ptd.model.DepartmentDTO;
import com.ptd.model.TeacherDTO;
import com.ptd.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassDAO classDAO;
    @Autowired
    TeacherDAO teacherDAO;
    @Autowired
    DepartmentDAO departmentDAO;

    @Override
    public List<ClassDTO> getClassByDepartment(int departmentId) {
        List<ClassEntity> classEntities = classDAO.getClassByDepartment(departmentId);
        List<ClassDTO> classDTOS = new ArrayList<>();
        for(ClassEntity i : classEntities){
            ClassDTO classDTO = i.toDTO();
            classDTOS.add(classDTO);
        }
        return classDTOS;
    }

    @Override
    public void addNewClass(int departmentId, int teacherId, String name) {
        ClassEntity classEntity = new ClassEntity();
        classEntity.setName(name);
        classEntity.setDepartment(departmentDAO.getDepartmentById(departmentId));
        classEntity.setTeacher(teacherDAO.getTeacherById(teacherId));
        classDAO.addNewClass(classEntity);
    }

    @Override
    public void deleteClass(int classId) {
        classDAO.deleteClass(classId);
    }
}
