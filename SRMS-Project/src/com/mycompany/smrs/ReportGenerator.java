package com.mycompany.smrs;
import java.util.ArrayList;

/**
 * كلاس تقارير الطلاب
 */
public class ReportGenerator {

    // تقرير الطلاب حسب المعدل الأكاديمي (GPA)
    public void generateGPAStatusReport(ArrayList<Student> students, double minGpa) {

        System.out.println("\n---Report of the Students with GPA >= " + minGpa + " ---");
        boolean found = false;
        
        for (Student s : students) {
          if (s.getGpa() >= minGpa) {
     System.out.println(s.displayInfo()); // استدعاء لبيانات الطالب
                found = true;
            }
        }
        if (!found) System.out.println("There is no students found in this GPA range!");
    }

    // تقرير الطلاب حسب القسم الأكاديمي
    public void generateDepartmentReport(ArrayList<Student> students, String deptName) {

        System.out.println("\n---Report of the Students in Department: " + deptName + " ---");
        boolean found = false;
        
        for (Student s : students) {
            if (s.getDepartment().equalsIgnoreCase(deptName)) {
                System.out.println(s.displayInfo());
                found = true;
            }
        }
        if (!found) System.out.println("There is no students found for department: " + deptName);
    }

    // تقرير الطلاب حسب  السنة الدراسية
    public void generateYearlyReport(ArrayList<Student> students, int year) {

        System.out.println("\n---Report of the Students registered in Year: " + year + " ---");
        boolean found = false;
        
        for (Student s : students) {
            if (s.getYear() == year) {
                System.out.println(s.displayInfo());
                found = true;
            }
        }
        if (!found) System.out.println("There is no students found for academic year " + year);
    }
}