package com.ptd.entity;

import com.ptd.model.TeacherDTO;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "teacher", schema = "qlsv_simple")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "doB")
    private String doB;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Teacher() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDoB() {
        return doB;
    }

    public void setDoB(String doB) {
        this.doB = doB;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public TeacherDTO toDTO() {
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setId(this.id);
        teacherDTO.setName(this.name);
        teacherDTO.setDoB(this.doB);
        teacherDTO.setDepartmentDTO(this.department.toDTO());
        return teacherDTO;
    }
}
