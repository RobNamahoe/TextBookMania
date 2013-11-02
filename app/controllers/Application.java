package controllers;

import models.StudentDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.StudentFormData;
import views.html.Index;
import views.html.ManageStudent;
import views.html.ShowStudents;

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
  
}
