package com.ptd.service;

import com.ptd.model.ClassDTO;

import java.util.List;

public interface ClassService {
    public List<ClassDTO> getClassByDepartment(int departmentId);
    public void addNewClass(int departmentId, int teacherId, String name);
    public void deleteClass(int classId);
}
