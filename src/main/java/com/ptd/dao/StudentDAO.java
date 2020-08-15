package com.ptd.dao;

import com.ptd.entity.Student;

import java.util.List;

public interface StudentDAO {
    public List<Student> getStudentsByClass(int classId);
    public Student getStudentById(int studentId);
    public void updateStudent(Student student);
    public void addStudent(Student student);
    public void deleteStudent(int studentId);
}
