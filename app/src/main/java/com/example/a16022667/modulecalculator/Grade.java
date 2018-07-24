package com.example.a16022667.modulecalculator;

import java.io.Serializable;

public class Grade implements Serializable {
    private String grade_id;
    private String grade;
    private String grade_name;
    private String module;

    public Grade(String grade_id, String grade, String grade_name){
        this.grade_id = grade_id;
        this.grade = grade;
        this.grade_name = grade_name;

    }

    public String getId() {
        return grade_id;
    }

    public String getGrade() {
        return grade;
    }

    public String getName() { return grade_name; }

    public void setGradeContent(String gradeContent){ this.grade = gradeContent;}

    public String toString() {
        return "ID:" + grade_id + ", " + grade;
    }

    public String getModule() {
        return module;
    }
}
