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
        writer.write(s.getStudentId() + "," + s.getName() + "," + s.getGpa() + "," + s.getDepartment() + "," + s.getYear());
        writer.newLine();
    } 
      writer.close();
    System.out.println("Saved successfully!");
}
public List<Student> loadStudents() throws IOException {
    List<Student> students = new ArrayList<>();
    File file = new File(fileName);
    if (!file.exists()) {
        throw new FileNotFoundException("File not found: " + fileName);
    }
 BufferedReader reader = new BufferedReader(new FileReader(fileName));
    String line;
    while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        Student s = new Student(parts[0], parts[1], Double.parseDouble(parts[2]), parts[3], Integer.parseInt(parts[4]));
        students.add(s);
    }
    reader.close();
    return students;
}
public void deleteStudent(List<Student> students, String id) throws IOException {
    students.removeIf(s -> s.getStudentId().equals(id));
    saveStudents(students);
System.out.println("Deleted successfully!");
}

public void updateStudent(List<Student> students, String id, String newName, double newGpa) throws IOException {
    for (Student s : students) {
        if (s.getStudentId().equals(id)) {
            s.setName(newName);
            s.setGpa(newGpa);
            break;
        }
    }
    saveStudents(students);
    System.out.println("Updated successfully!");
}
}
