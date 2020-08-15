package com.ptd.dao.impl;

import com.ptd.dao.DepartmentDAO;
import com.ptd.entity.Department;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DepartmentDAOImpl implements DepartmentDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Department> getAllDepartment() {
        String jql = "select e from Department e";
        return entityManager.createQuery(jql,Department.class).getResultList();
    }

    @Override
    public Department getDepartmentById(int id) {
        return entityManager.find(Department.class,id);
    }
}
