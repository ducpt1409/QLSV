package com.ptd.service.impl;

import com.ptd.dao.ClassDAO;
import com.ptd.dao.StudentDAO;
import com.ptd.entity.ClassEntity;
import com.ptd.entity.Student;
import com.ptd.model.ClassDTO;
import com.ptd.model.StudentDTO;
import com.ptd.service.StudentSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentSevice {

    @Autowired
    StudentDAO studentDAO;
    @Autowired
    ClassDAO classDAO;

    @Override
    public List<StudentDTO> getStudentsByClass(int classId) {
        List<Student> students = studentDAO.getStudentsByClass(classId);
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for(Student i : students){
            StudentDTO studentDTO = studentDTO = i.toDTO();
            studentDTOS.add(studentDTO);
        }
        return studentDTOS;
    }

    @Override
    public StudentDTO getStudentById(int studentId) {
        return studentDAO.getStudentById(studentId).toDTO();
    }

    @Override
    public void updateStudent(StudentDTO studentDTO) {
        Student student = studentDAO.getStudentById(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setCountry(studentDTO.getCountry());
        student.setDoB(studentDTO.getDoB());
        student.setAverage(studentDTO.getAverage());

        studentDAO.updateStudent(student);
    }

    @Override
    public void addStudent(StudentDTO studentDTO, int classId) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setCountry(studentDTO.getCountry());
        student.setAverage(studentDTO.getAverage());
        student.setDoB(studentDTO.getDoB());
        student.setClassEntity(classDAO.getClassById(classId));

        studentDAO.addStudent(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        studentDAO.deleteStudent(studentId);
    }


}
