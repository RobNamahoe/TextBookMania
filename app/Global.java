import models.StudentDB;
import models.TextbookDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.StudentFormData;
import views.formdata.TextbookFormData;

/**
 * Global settings for the Play Application.
 * @author Rob Namahoe
 */
public class Global extends GlobalSettings { 
  
  /**
   * Initialize the database with initial values.
   * @param app The Play application.
   */
  public void onStart(Application app) {
    
    long id;
    String name;
    String email;
    String picUrl;
    
    id = 0;
    name = "Rob Namahoe";
    email = "rnamahoe@hawaii.edu";
    picUrl = "http://www.garyottley.com/sites/garyottley.com/files/styles/"
           + "gallery_thumbnail/public/images/gallery/faces028.jpg";
    
    StudentDB.addStudent(new StudentFormData(id, name, email, picUrl));
    
    id = 0;
    name = "Will Haines";
    email = "whaines@hawaii.edu";
    picUrl = "http://www.bloodyloud.com/wp-content/gallery/"
            + "black-white-faces-by-alexander-khokhlov/thumbs/thumbs_b_w_faces_6.jpg";
    
    StudentDB.addStudent(new StudentFormData(id, name, email, picUrl));
   
    String isbn;
    isbn = "9782132122474";
    TextbookDB.addTextbook(new TextbookFormData(0,isbn, isbn, isbn, isbn, "Excellent"));
    isbn = "9780470509470";
    TextbookDB.addTextbook(new TextbookFormData(0,isbn, isbn, isbn, isbn,"Good"));
    isbn = "9780073383095";
    TextbookDB.addTextbook(new TextbookFormData(0,isbn, isbn, isbn, isbn, "Fair"));
    isbn = "9780470128701";
    TextbookDB.addTextbook(new TextbookFormData(0,isbn, isbn, isbn, isbn, "Poor"));
    isbn = "131103628";
    TextbookDB.addTextbook(new TextbookFormData(0,isbn, isbn, isbn, isbn, "Excellent"));
    isbn = "9780321776402";
    TextbookDB.addTextbook(new TextbookFormData(0,isbn, isbn, isbn, isbn, "Good"));
    isbn = "9780131103627";
    TextbookDB.addTextbook(new TextbookFormData(0,isbn, isbn, isbn, isbn, "Fair"));
    isbn = "9780262033848";
    TextbookDB.addTextbook(new TextbookFormData(0,isbn, isbn, isbn, isbn, "Poor"));
    isbn = "10: 0123745144";
    TextbookDB.addTextbook(new TextbookFormData(0,isbn, isbn, isbn, isbn, "Excellent"));
    isbn = "13: 978-0123745149";
    TextbookDB.addTextbook(new TextbookFormData(0,isbn, isbn, isbn, isbn, "Good"));
    isbn = "978-1-59327-281-4";
    TextbookDB.addTextbook(new TextbookFormData(0,isbn, isbn, isbn, isbn, "Fair"));
    isbn = "9780131873254";
    TextbookDB.addTextbook(new TextbookFormData(0,isbn, isbn, isbn, isbn, "Poor"));
    isbn = "9781107027534";
    TextbookDB.addTextbook(new TextbookFormData(0,isbn, isbn, isbn, isbn, "Excellent"));
    isbn = "9781118063330";
    TextbookDB.addTextbook(new TextbookFormData(0,isbn, isbn, isbn, isbn, "Good"));
    isbn = "9781118129388";
    TextbookDB.addTextbook(new TextbookFormData(0,isbn, isbn, isbn, isbn, "Fair"));
    isbn = "9780132855532";
    TextbookDB.addTextbook(new TextbookFormData(0,isbn, isbn, isbn, isbn, "Poor"));
    isbn = "465051367";
    TextbookDB.addTextbook(new TextbookFormData(0,isbn, isbn, isbn, isbn, "Excellent"));
    isbn = "465067107";
    TextbookDB.addTextbook(new TextbookFormData(0,isbn, isbn, isbn, isbn, "Good"));
    isbn = "9780137144174";
    TextbookDB.addTextbook(new TextbookFormData(0,isbn, isbn, isbn, isbn, "Fair"));
    isbn = "9780123747310";
    TextbookDB.addTextbook(new TextbookFormData(0,isbn, isbn, isbn, isbn, "Poor"));


    
  }

}