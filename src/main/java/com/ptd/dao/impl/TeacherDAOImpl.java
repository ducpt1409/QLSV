package com.ptd.dao.impl;

import com.ptd.dao.TeacherDAO;
import com.ptd.entity.Teacher;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TeacherDAOImpl implements TeacherDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Teacher> getTeacherByDepartment(int departmentId) {
        String jql = "select e from Teacher e where e.department.id = " + departmentId;
        return  entityManager.createQuery(jql,Teacher.class).getResultList();
    }

    @Override
    public Teacher getTeacherById(int id) {
        return entityManager.find(Teacher.class, id);
    }
}
