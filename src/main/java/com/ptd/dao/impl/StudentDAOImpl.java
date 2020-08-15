package com.ptd.dao.impl;

import com.ptd.dao.StudentDAO;
import com.ptd.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Student> getStudentsByClass(int classId) {
        String jql = "select e from Student e where e.classEntity.id = " + classId;
        return entityManager.createQuery(jql, Student.class).getResultList();
    }

    @Override
    public Student getStudentById(int studentId) {
        return entityManager.find(Student.class, studentId);
    }

    @Override
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    public void addStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        Student student = entityManager.find(Student.class, studentId);
        entityManager.remove(student);
    }
}
