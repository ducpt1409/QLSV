package com.ptd.entity;

import com.ptd.model.StudentDTO;

import javax.persistence.*;

@Entity
@Table(name = "student", schema = "qlsv_simple")
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "doB")
    private String doB;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity classEntity;


    @Column(name = "average")
    private double average;

    public Student() {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDoB() {
        return doB;
    }

    public void setDoB(String doB) {
        this.doB = doB;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public StudentDTO toDTO(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(this.id);
        studentDTO.setName(this.name);
        studentDTO.setCountry(this.country);
        studentDTO.setDoB(this.doB);
        studentDTO.setAverage(this.getAverage());
        studentDTO.setClassDTO(this.classEntity.toDTO());

        return studentDTO;
    }
}
