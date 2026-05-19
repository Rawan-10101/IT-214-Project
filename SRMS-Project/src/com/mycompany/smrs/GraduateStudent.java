package com.mycompany.smrs;
public class GraduateStudent extends Student {
    private String thesisTitle;
    private String supervisor;

    public GraduateStudent(String studentId, String name, double gpa, String department, int year, String thesisTitle, String supervisor) {
        super(studentId, name, gpa, department, year);
        this.thesisTitle = thesisTitle;
        this.supervisor = supervisor;
    }

    public String getThesisTitle() { return thesisTitle; }
    public String getSupervisor() { return supervisor; }

    public void setThesisTitle(String thesisTitle) { this.thesisTitle = thesisTitle; }
    public void setSupervisor(String supervisor) { this.supervisor = supervisor; }

    @Override
    public String displayInfo() {
        return super.displayInfo() + 
               " | Thesis: " + thesisTitle + 
               " | Supervisor: " + supervisor;
    }

    @Override
    public String toFileString() {
        return super.toFileString() + "," + thesisTitle + "," + supervisor;
    }
}