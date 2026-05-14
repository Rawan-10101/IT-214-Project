import java.io.*;
import java.util.*;

public class FileManager {
    
    private String fileName;
    
    public FileManager(String fileName) {
        this.fileName = fileName;
    }
   public void saveStudents(List<Student> students) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
    for (Student s : students) {
        writer.write(s.getId() + "," + s.getName() + "," + s.getGpa() + "," + s.getDepartment() + "," + s.getYear());
        writer.newLine();
    } 
      writer.close();
    System.out.println("Saved successfully!");
}
}