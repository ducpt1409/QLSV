package com.ptd.dao;

import com.ptd.entity.Teacher;

import java.util.List;

public interface TeacherDAO {
    public List<Teacher> getTeacherByDepartment(int departmentId);
    public Teacher getTeacherById(int id);
}
