package com.ptd.service;

import com.ptd.entity.Student;
import com.ptd.model.StudentDTO;

import java.util.List;

public interface StudentSevice {
    public List<StudentDTO> getStudentsByClass(int classId);

    public StudentDTO getStudentById(int studentId);

    public void updateStudent(StudentDTO studentDTO);

    public void addStudent(StudentDTO studentDTO, int classId);

    public void deleteStudent(int studentId);
}
