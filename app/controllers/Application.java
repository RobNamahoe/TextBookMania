package controllers;

import models.StudentDB;
import models.TextbookDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ConditionTypes;
import views.formdata.StudentFormData;
import views.formdata.TextbookFormData;
import views.html.Index;
import views.html.ManageStudent;
import views.html.ShowStudents;
import views.html.ManageTextbook;
import views.html.ShowTextbooks;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page.
   * @return The resulting home page.
   */
  public static Result index() {
    return ok(Index.render("Your new application is ready."));
  }
  
  ///////////////////////////////////////////////////////////////////////////////
  // STUDENT METHODS                            
  ///////////////////////////////////////////////////////////////////////////////
  /**
   * Returns ManageStudent view configured to add a new student.
   * @return The page to add a new student.
   */
  public static Result newStudent() {
    StudentFormData data = new StudentFormData();
    Form<StudentFormData> formData = Form.form(StudentFormData.class).fill(data);
    return ok(ManageStudent.render("NewStudent", formData));
  }
  
  /**
   * Handles the editing/managing of student data.
   * @param id The unique identifier for the student to display.
   * @return ManageStudent page for requested student with form data.
   */
  public static Result manageStudent(long id) {
    StudentFormData data = new StudentFormData(StudentDB.getStudent(id));
    Form<StudentFormData> formData = Form.form(StudentFormData.class).fill(data);
    return ok(ManageStudent.render("ManageStudent", formData));
  }
  
  /**
   * Handles the posting of form data by the user with validation.
   * @return ShowStudents page with form data if successful, ManageStudent page if not.
   */
  public static Result postStudent() {
    Form<StudentFormData> formData = Form.form(StudentFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      System.out.println("Errors found");
      return badRequest(ManageStudent.render("", formData));
    }
    else {
      StudentFormData data = formData.get();
      StudentDB.addStudent(data);
      return ok(ShowStudents.render(StudentDB.getStudents()));
    }
  }

  /**
   * Lists all students currently in the database.
   * @return ShowStudents page.
   */
  public static Result showStudents() {
    return ok(ShowStudents.render(StudentDB.getStudents()));
  }
  
  /**
   * Handles the deleting of a student from the database.
   * @param id The id of the student to delete.
   * @return ShowStudents page.
   */
  public static Result deleteStudent(long id) {
    StudentDB.deleteStudent(id);
    return ok(ShowStudents.render(StudentDB.getStudents()));
  }
  
  ///////////////////////////////////////////////////////////////////////////////
  // TEXTBOOK METHODS
  ///////////////////////////////////////////////////////////////////////////////
  /**
   * Returns ManageTextbook view configured to add a new textbook.
   * @return The page to add a new textbook.
   */
  public static Result newTextbook() {
    TextbookFormData data = new TextbookFormData();
    Form<TextbookFormData> formData = Form.form(TextbookFormData.class).fill(data);
    return ok(ManageTextbook.render("NewTextbook", formData, ConditionTypes.getTypes()));
  }
  
  /**
   * Handles the editing/managing of textbook data.
   * @param id The unique identifier for the textbook to display.
   * @return ManageTextbook page for requested textbook with form data.
   */
  public static Result manageTextbook(long id) {
    TextbookFormData data = new TextbookFormData(TextbookDB.getTextbook(id));
    Form<TextbookFormData> formData = Form.form(TextbookFormData.class).fill(data);
    return ok(ManageTextbook.render("ManageTextbook", formData, ConditionTypes.getTypes()));
  }
  
  /**
   * Handles the posting of form data by the user with validation.
   * @return ShowTextbooks page with form data if successful, ManageTextbook page if not.
   */
  public static Result postTextbook() {
    Form<TextbookFormData> formData = Form.form(TextbookFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      System.out.println("postTextbook(): Errors found");
      return badRequest(ManageTextbook.render("", formData, ConditionTypes.getTypes()));
    }
    else {
      TextbookFormData data = formData.get();
      TextbookDB.addTextbook(data);
      return ok(ShowTextbooks.render(TextbookDB.getTextbooks()));
    }
  }

  /**
   * Lists all textbooks currently in the database.
   * @return ShowTextbooks page.
   */
  public static Result showTextbooks() {
    return ok(ShowTextbooks.render(TextbookDB.getTextbooks()));
  }
  
  /**
   * Handles the deleting of a textbook from the database.
   * @param id The id of the textbook to delete.
   * @return ShowTextbooks page.
   */
  public static Result deleteTextbook(long id) {
    TextbookDB.deleteTextbook(id);
    return ok(ShowTextbooks.render(TextbookDB.getTextbooks()));
  }
}
