package com.mycompany.smrs;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        FileManager fileManager = new FileManager("students.txt");

        ReportGenerator reportGenerator = new ReportGenerator();

        AutoSaveThread autoSave = new AutoSaveThread(students, fileManager);
        autoSave.start();

        int choice;

        do {

            System.out.println("\n===== Student Record Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Save Students");
            System.out.println("4. Load Students");
            System.out.println("5. Delete Student");
            System.out.println("6. Update Student");
            System.out.println("7. GPA Report");
            System.out.println("8. Department Report");
            System.out.println("9. Year Report");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    String id = input.nextLine();

                    System.out.print("Enter Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter GPA: ");
                    double gpa = input.nextDouble();
                    input.nextLine();

                    System.out.print("Enter Department: ");
                    String department = input.nextLine();

                    System.out.print("Enter Year: ");
                    int year = input.nextInt();
                    input.nextLine();

                    Student student = new Student(id, name, gpa, department, year);

                    students.add(student);

                    System.out.println("Student added successfully!");

                    break;

                case 2:

                    System.out.println("\n--- Students List ---");

                    for (Student s : students) {

                        System.out.println(s.displayInfo());

                    }

                    break;

                case 3:

                    try {

                        fileManager.saveStudents(students);

                    } catch (IOException e) {

                        System.out.println("Error while saving students.");

                    }

                    break;

                case 4:

                    try {

                        students = new ArrayList<>(fileManager.loadStudents());

                        System.out.println("Students loaded successfully!");

                    } catch (IOException e) {

                        System.out.println("Error while loading students.");

                    }

                    break;

                case 5:

                    System.out.print("Enter Student ID to delete: ");

                    String deleteId = input.nextLine();

                    try {

                        fileManager.deleteStudent(students, deleteId);

                    } catch (IOException e) {

                        System.out.println("Error while deleting student.");

                    }

                    break;

                case 6:

                    System.out.print("Enter Student ID to update: ");

                    String updateId = input.nextLine();

                    System.out.print("Enter New Name: ");

                    String newName = input.nextLine();

                    System.out.print("Enter New GPA: ");

                    double newGpa = input.nextDouble();
                    input.nextLine();

                    try {

                        fileManager.updateStudent(students, updateId, newName, newGpa);

                    } catch (IOException e) {

                        System.out.println("Error while updating student.");

                    }

                    break;

                case 7:

                    System.out.print("Enter minimum GPA: ");

                    double minGpa = input.nextDouble();
                    input.nextLine();

                    reportGenerator.generateGPAStatusReport(students, minGpa);

                    break;

                case 8:

                    System.out.print("Enter Department Name: ");

                    String deptName = input.nextLine();

                    reportGenerator.generateDepartmentReport(students, deptName);

                    break;

                case 9:

                    System.out.print("Enter Academic Year: ");

                    int reportYear = input.nextInt();
                    input.nextLine();

                    reportGenerator.generateYearlyReport(students, reportYear);

                    break;

                case 0:

                    System.out.println("Program closed.");

                    break;

                default:

                    System.out.println("Invalid choice.");

            }

        } while (choice != 0);

        input.close();
    }
}
