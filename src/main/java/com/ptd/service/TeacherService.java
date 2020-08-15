package com.ptd.service;

import com.ptd.model.TeacherDTO;

import java.util.List;

public interface TeacherService {
    public List<TeacherDTO> getTeacherByDepartment(int departmentID);
}
