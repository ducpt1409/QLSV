package com.ptd.dao;

import com.ptd.entity.ClassEntity;

import java.util.List;

public interface ClassDAO {
    public List<ClassEntity> getClassByDepartment(int departmentId);
    public ClassEntity getClassById(int id);
    public void addNewClass(ClassEntity classEntity);
    public void deleteClass(int classId);
}
