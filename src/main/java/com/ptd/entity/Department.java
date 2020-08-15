package com.ptd.entity;

import com.ptd.model.DepartmentDTO;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "department", schema = "qlsv_simple")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ClassEntity> classEntities;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Teacher> teachers;

    public Department() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ClassEntity> getClassEntities() {
        return classEntities;
    }

    public void setClassEntities(List<ClassEntity> classEntities) {
        this.classEntities = classEntities;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public DepartmentDTO toDTO(){
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(this.id);
        departmentDTO.setName(this.name);
        departmentDTO.setDescription(this.description);
        return departmentDTO;
    }

}
