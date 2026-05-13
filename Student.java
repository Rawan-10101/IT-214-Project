public class Student {
  private String studentId;
  private String name;
  private double gpa ;
  private String department;
  private int year;

public Student(String studentId , String name , double gpa , String department , int year) {
  this.studentId = studentId ;
  this.name = name;
  this.gpa = gpa ;
  this.department = department ;
  this.year = year ;
}
  public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public double getGpa() { return gpa; }
    public String getDepartment() { return department; }
    public int getYear() { return year; }

    public void setName(String name) { this.name = name; }
    public void setGpa(double gpa) { this.gpa = gpa; }
    public void setDepartment(String department) { this.department = department; }
    public void setYear(int year) { this.year = year; }

public String displayInfo () {
  return "ID" + studntId + " | Name : " + name + " | GPA : " + gpa + " | Dept : " + department +" | YEAR : " + year ; }

public String toFileString () {
 return studentId + "," + name + "," + department + " ,"+ year; }
}




  
