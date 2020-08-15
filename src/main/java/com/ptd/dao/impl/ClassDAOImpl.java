package com.ptd.dao.impl;

import com.ptd.dao.ClassDAO;
import com.ptd.entity.ClassEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ClassDAOImpl implements ClassDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<ClassEntity> getClassByDepartment(int departmentId) {
        String jql = "select e from ClassEntity e where e.department.id = " + departmentId;
        return entityManager.createQuery(jql, ClassEntity.class).getResultList();
    }

    @Override
    public ClassEntity getClassById(int id) {
        return entityManager.find(ClassEntity.class, id);
    }

    @Override
    public void addNewClass(ClassEntity classEntity) {
        entityManager.persist(classEntity);
    }

    @Override
    public void deleteClass(int classId) {
        ClassEntity classEntity = entityManager.find(ClassEntity.class, classId);
        entityManager.remove(classEntity);
    }
}
