package com.ptd.model;

public class StudentDTO {
    private int id;
    private String name;
    private String country;
    private String doB;
    private ClassDTO classDTO;
    private Double average;

    public StudentDTO() {
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

    public ClassDTO getClassDTO() {
        return classDTO;
    }

    public void setClassDTO(ClassDTO classDTO) {
        this.classDTO = classDTO;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", doB='" + doB + '\'' +
                ", classDTO=" + classDTO +
                ", average=" + average +
                '}';
    }
}
