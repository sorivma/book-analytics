package com.example.bookanalytics.dtos;

public class BookGradeDto {
    String name;
    Double grade;

    public BookGradeDto(String name, Double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public Double getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "BookGradeDto{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
