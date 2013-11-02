import models.StudentDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.StudentFormData;

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
    
  }

}