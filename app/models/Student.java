package models;

/**
 * A model for a Student.
 * @author Rob Namahoe
 *
 */
public class Student {
  /** The student's id. */
  private long id;
  /** The student's name. */
  private String name;
  /** The student's email. */
  private String email;
  /** The student's picture url. */
  private String picUrl;

  /**
   * Constructs a new Student.
   * @param id The student's id.
   * @param name The students's name.
   * @param email The student's email address.
   * @param picUrl The url to the Student's picture.
   */
  public Student(long id, String name, String email, String picUrl) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.picUrl = picUrl;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the picUrl
   */
  public String getPicUrl() {
    return picUrl;
  }

  /**
   * @param picUrl the picUrl to set
   */
  public void setPicUrl(String picUrl) {
    this.picUrl = picUrl;
  }

  /**
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(long id) {
    this.id = id;
  }
}
