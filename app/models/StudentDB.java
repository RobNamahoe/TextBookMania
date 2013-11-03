package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.StudentFormData;

/**
 * A simple in-memory repository for Students.
 * @author Rob Namahoe
 *
 */
public class StudentDB {

    private static Map<Long, Student> students = new HashMap<>();
    
    /**
     * Add a student to the database of students.
     * @param formData Student data.
     * @return A new student.
     */
    public static Student addStudent(StudentFormData formData) {
      long id = (formData.id == 0) ? students.size() + 1 : formData.id;
      Student student = new Student(id, formData.name, formData.email, formData.picUrl);
      students.put(id, student);
      System.out.println(id + ": " + formData.name + " added.");
      return student;
    }
   
    
    /**
     * Returns a list of students.
     * @return list of students.
     */
    public static List<Student> getStudents() {
      return new ArrayList<>(students.values());
    }
    
    /**
     * Returns a list of the students email addresses.
     * @return A list of email addresses.
     */
    public static List<String> getEmailAddresses() {
      List<String> addresses = new ArrayList<>();
      for (Map.Entry<Long, Student> student : students.entrySet()) {
        addresses.add(student.getValue().getEmail());
      }
      return addresses;
    }
    
    /**
     * Returns the student associated with the passed id.
     * @param id The students id.
     * @return The requested student.
     */
    public static Student getStudent(long id) {
      Student student = students.get(id);
      return student;
    }
    
    
    /**
     * Get a student id from an email address.
     * @param email The email address of the student.
     * @return id The id of the student with the associated email.
     */
    public static long getIdFromEmail(String email) {
      for (Map.Entry<Long, Student> student : students.entrySet()) {
        if (email.equals(student.getValue().getEmail())) {
          return student.getKey();
        }
      }
      return 0;
    }
    
    /**
     * Deletes a student with the associated id.
     * @param id The students id.
     */
    public static void deleteStudent(long id) {
      students.remove(id);
    }
    
    /**
     * Checks if the email address entered by the user already exists in the database.
     * @param id The id of the current student.
     * @param email The email address the student is attempting to register.
     * @return true if the email already exists in the database, false otherwise.
     */
    public static boolean emailExists(long id, String email) {
      boolean result = false;
      for (Map.Entry<Long, Student> entry : students.entrySet()) {
        if (email.equals(entry.getValue().getEmail())) {
          result = true;
          if (id == entry.getKey()) {
            return false;
          }
        }
      }
      return result;
    }
}
