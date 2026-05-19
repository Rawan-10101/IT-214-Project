package com.mycompany.smrs;
import java.util.ArrayList;

public class Department {
     private String departmentName;
    private String departmentCode;
    private ArrayList<Student> students;

    public Department(String departmentName, String departmentCode) {
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.students = new ArrayList<>();
    }

    public String getDepartmentName() { return departmentName; }
    public String getDepartmentCode() { return departmentCode; }

    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
    public void setDepartmentCode(String departmentCode) { this.departmentCode = departmentCode; }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String studentId) {
        students.removeIf(s -> s.getStudentId().equals(studentId));
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void displayDepartmentInfo() {
        System.out.println("Department: " + departmentName + " | Code: " + departmentCode);
        System.out.println("Total Students: " + students.size());
    }
}

