package com.ptd.dao;

import com.ptd.entity.Department;

import java.util.List;

public interface DepartmentDAO {
    public List<Department> getAllDepartment();
    public Department getDepartmentById(int id);
}
