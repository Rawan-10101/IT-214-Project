package com.mycompany.smrs;
import java.util.ArrayList;
import java.io.IOException;


 
public class AutoSaveThread extends Thread {
    private ArrayList<Student> studentList;
    private FileManager fileManager; 

    // Constructor لتمرير البيانات 
    public AutoSaveThread(ArrayList<Student> list, FileManager fm) {

        this.studentList = list;
        this.fileManager = fm;
        this.setDaemon(true); // لإنهاء الخيط تلقائياً عند إغلاق البرنامج
    }

    @Override
    public void run() {

        try {
         while (true) {

        Thread.sleep(60000); // إيقاف مؤقت لمدة 60 ثانية 
      System.out.println("\n System:Background Auto-Save in progress..");
                
                try {
                    // استدعاء دالة لحفظ الملفات
                    fileManager.saveStudents(studentList);
                } 

        catch (IOException e) {

          System.out.println("Thread Error:Auto-save failed due to file error: " + e.getMessage());

             }
         }
    } 
        catch (InterruptedException e) {

         System.out.println("Auto-save thread stopped");

        }
    }
}