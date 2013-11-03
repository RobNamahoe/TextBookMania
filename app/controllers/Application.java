package controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.BuyOffer;
import java.util.HashMap;
import java.util.Map;
import models.BuyOfferDB;
import models.SellOffer;
import models.SellOfferDB;
import models.StudentDB;
import models.TextbookDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.BuyOfferFormData;
import views.formdata.ConditionTypes;
import views.formdata.MatchFormData;
import views.formdata.SellOfferFormData;
import views.formdata.StudentEmails;
import views.formdata.StudentFormData;
import views.formdata.TextbookFormData;
import views.html.Index;
import views.html.ManageStudent;
import views.html.ShowStudents;
import views.html.ManageTextbook;
import views.html.ShowTextbooks;
import views.html.ManageBuyOffer;
import views.html.ManageSellOffer;
import views.html.ShowBuyOffers;
import views.html.ShowSellOffers;
import views.html.MatchPage;

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
  // STUDENT METHODS                                                           //
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
  // TEXTBOOK METHODS                                                          //
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
  
  
   ///////////////////////////////////////////////////////////////////////////////
   // BUY OFFER METHODS                                                         //
   ///////////////////////////////////////////////////////////////////////////////
  public static Result newBuyOffer() {
    Map<String, Boolean> emailMap =  new HashMap<>();
    emailMap = StudentEmails.getEmails();
    BuyOfferFormData data = new BuyOfferFormData();
    Form<BuyOfferFormData> formData = Form.form(BuyOfferFormData.class).fill(data);
    return ok(ManageBuyOffer.render("NewBuyOffer", formData, emailMap));
  }
  
  public static Result manageBuyOffer(long id) {
    Map<String, Boolean> emailMap =  new HashMap<>();
    BuyOfferFormData data = new BuyOfferFormData(BuyOfferDB.getOffer(id));
    Form<BuyOfferFormData> formData = Form.form(BuyOfferFormData.class).fill(data);
    emailMap = StudentEmails.getEmails(data.buyerEmail);
    return ok(ManageBuyOffer.render("ManageBuyOffer", formData, emailMap));
  }
  
  public static Result postBuyOffer() {
    Map<String, Boolean> emailMap =  new HashMap<>();
    Form<BuyOfferFormData> formData = Form.form(BuyOfferFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      System.out.println("Errors found");
      emailMap = StudentEmails.getEmails();
      return badRequest(ManageBuyOffer.render("", formData, emailMap));
    }
    else {
      BuyOfferFormData data = formData.get();
      BuyOfferDB.addOffer(data);
      emailMap = StudentEmails.getEmails(data.buyerEmail);
      return ok(ShowBuyOffers.render(BuyOfferDB.getOffers()));
    }
  }

  public static Result showBuyOffers() {
    return ok(ShowBuyOffers.render(BuyOfferDB.getOffers()));
  }
  
  public static Result deleteBuyOffer(long id) {
    BuyOfferDB.deleteOffer(id);
    return ok(ShowBuyOffers.render(BuyOfferDB.getOffers()));
  }
  
  
   ///////////////////////////////////////////////////////////////////////////////
   // SELL OFFER METHODS                                                        //
   ///////////////////////////////////////////////////////////////////////////////
  public static Result newSellOffer() {
    Map<String, Boolean> emailMap =  new HashMap<>();
    emailMap = StudentEmails.getEmails();
    SellOfferFormData data = new SellOfferFormData();
    Form<SellOfferFormData> formData = Form.form(SellOfferFormData.class).fill(data);
    return ok(ManageSellOffer.render("NewSellOffer", formData, emailMap));
  }
  
  public static Result manageSellOffer(long id) {
    Map<String, Boolean> emailMap =  new HashMap<>();
    SellOfferFormData data = new SellOfferFormData(SellOfferDB.getOffer(id));
    Form<SellOfferFormData> formData = Form.form(SellOfferFormData.class).fill(data);
    emailMap = StudentEmails.getEmails(data.sellerEmail);
    return ok(ManageSellOffer.render("ManageSellOffer", formData, emailMap));
  }
  
  public static Result postSellOffer() {
    Map<String, Boolean> emailMap =  new HashMap<>();
    Form<SellOfferFormData> formData = Form.form(SellOfferFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      System.out.println("Errors found");
      emailMap = StudentEmails.getEmails();
      return badRequest(ManageSellOffer.render("", formData, emailMap));
    }
    else {
      SellOfferFormData data = formData.get();
      SellOfferDB.addOffer(data);
      return ok(ShowSellOffers.render(SellOfferDB.getOffers()));
    }
  }

  public static Result showSellOffers() {
    return ok(ShowSellOffers.render(SellOfferDB.getOffers()));
  }
  
  public static Result deleteSellOffer(long id) {
    SellOfferDB.deleteOffer(id);
    return ok(ShowSellOffers.render(SellOfferDB.getOffers()));
  }
  
  
  
   ///////////////////////////////////////////////////////////////////////////////
   // MATCH METHODS                                                             //
   ///////////////////////////////////////////////////////////////////////////////
   public static Result showMatches(String email) {
     Map<String, Boolean> emails = new HashMap<>();
     List<BuyOffer> buyOffers = new ArrayList<>();
     List<SellOffer> sellOffers = new ArrayList<>();
     long currentDate = Calendar.getInstance().getTimeInMillis();
     
     Form<MatchFormData> formData = Form.form(MatchFormData.class).bindFromRequest();
     if (formData.hasErrors()) {
       System.out.println("Errors found");
       return badRequest(MatchPage.render(formData, emails, buyOffers, sellOffers));
     }
     else {
       MatchFormData data = formData.get();
       email = data.email;
     
     for(int i=1; i <= StudentDB.getStudents().size(); i++) {
       emails.put(StudentDB.getStudent(i).getEmail(), false);
     }
     
     if(email != "") {
       boolean isStudent = false;
       int index = 1;
       long studentID = 0;
       while(index <= StudentDB.getStudents().size() && isStudent) {
         if(StudentDB.getStudent(index).getEmail().equals(email)) {
           studentID = StudentDB.getStudent(index).getId();
         }
       }
       
       for(int i=1; i <= BuyOfferDB.getOffers().size(); i++) {
         if(BuyOfferDB.getOffer(i).getExpiration() <= currentDate && BuyOfferDB.getOffer(i).getBuyerId() == studentID) {
           buyOffers.add(BuyOfferDB.getOffer(i));
         }
       }
     
       for(int i=1; i <= SellOfferDB.getOffers().size(); i++) {
         if(SellOfferDB.getOffer(i).getExpiration() <= currentDate && SellOfferDB.getOffer(i).getSellerId() == studentID) {
           sellOffers.add(SellOfferDB.getOffer(i));
         }
       }
     }
     
     }
     
     return ok(MatchPage.render(formData, emails, buyOffers, sellOffers));
     
   }
  
  
}
