package com.ptd.service.impl;

import com.ptd.dao.DepartmentDAO;
import com.ptd.entity.Department;
import com.ptd.model.DepartmentDTO;
import com.ptd.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDAO departmentDAO;

    @Override
    public List<DepartmentDTO> getAllDepartment() {
        List<Department> departments = departmentDAO.getAllDepartment();
        List<DepartmentDTO> departmentDTOS= new ArrayList<>();
        for(Department i : departments){
            DepartmentDTO departmentDTO = i.toDTO();
            departmentDTOS.add(departmentDTO);
        }
        return departmentDTOS;
    }
}
