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
  public static Result newStudent() {
    StudentFormData data = new StudentFormData();
    Form<StudentFormData> formData = Form.form(StudentFormData.class).fill(data);
    return ok(ManageStudent.render("NewStudent", formData));
  }
  
  public static Result manageStudent(long id) {
    StudentFormData data = new StudentFormData(StudentDB.getStudent(id));
    Form<StudentFormData> formData = Form.form(StudentFormData.class).fill(data);
    return ok(ManageStudent.render("ManageStudent", formData));
  }
  
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

  public static Result showStudents() {
    return ok(ShowStudents.render(StudentDB.getStudents()));
  }
  
  public static Result deleteStudent(long id) {
    StudentDB.deleteStudent(id);
    return ok(ShowStudents.render(StudentDB.getStudents()));
  }
  
  ///////////////////////////////////////////////////////////////////////////////
  // TEXTBOOK METHODS
  ///////////////////////////////////////////////////////////////////////////////
  public static Result newTextbook() {
    TextbookFormData data = new TextbookFormData();
    Form<TextbookFormData> formData = Form.form(TextbookFormData.class).fill(data);
    return ok(ManageTextbook.render("NewTextbook", formData, ConditionTypes.getTypes()));
  }
  
  public static Result manageTextbook(long id) {
    TextbookFormData data = new TextbookFormData(TextbookDB.getTextbook(id));
    Form<TextbookFormData> formData = Form.form(TextbookFormData.class).fill(data);
    return ok(ManageTextbook.render("ManageTextbook", formData, ConditionTypes.getTypes()));
  }
  
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

  public static Result showTextbooks() {
    return ok(ShowTextbooks.render(TextbookDB.getTextbooks()));
  }
  
  public static Result deleteTextbook(long id) {
    TextbookDB.deleteTextbook(id);
    return ok(ShowTextbooks.render(TextbookDB.getTextbooks()));
  }
}
