package views.formdata;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.ValidationError;
import models.Student;
import models.StudentDB;

/**
 * Java backing class for Student's form data.
 * 
 * @author Rob Namahoe
 * 
 */
public class StudentFormData {
  /** The student's id. */
  public long id;
  /** The student's name. */
  public String name = "";
  /** The student's email. */
  public String email = "";
  /** The url to the students picture. */
  public String picUrl = "";

  /**
   * Default constructor method.
   */
  public StudentFormData() {
    // Default constructor method.
  }

  /**
   * Constructor method.
   * @param student An existing student.
   */
  public StudentFormData(Student student) {
    this.id = student.getId();
    this.name = student.getName();
    this.email = student.getEmail();
    this.picUrl = student.getPicUrl();
  }

  /**
   * Constructor method - used to initialize database.
   * @param id The id of the student.
   * @param name The name of the student.
   * @param email The students email address.
   * @param picUrl URL to a picture of the student.
   */
  public StudentFormData(long id, String name, String email, String picUrl) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.picUrl = picUrl;
  }
  
  /**
   * Checks that form fields are valid. Called by bindFormRequest().
   * @return null if valid, a list of ValidationErrors if problems are found.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
    
    if (name == null || name.length() == 0) {
      errors.add(new ValidationError("name", "Name is required."));
    }
    
    if (email == null || email.length() == 0) {
      errors.add(new ValidationError("email", "Email address is required."));
    }

    if (StudentDB.emailExists(id, email)) {
      errors.add(new ValidationError("email", "That email address is already in use."));
    }
    
    if (picUrl == null || picUrl.length() == 0) {
      errors.add(new ValidationError("picUrl", "Picture URL is required."));
    }
    
    return errors.isEmpty() ? null : errors;
    
  }


}
