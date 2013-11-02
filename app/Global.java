import models.StudentDB;
import models.Textbook;
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
   
    
    String title;
    String isbn;
    String author;
    String coverUrl;
    String condition;
    
    //#1 is missing
    
    //#2
    title = "Java Concepts: Compatible with Java 5, 6 and 7";
    isbn = "0470509473";
    author = "Cay S. Horstmann";
    coverUrl = "";
    condition = "Excellent";
    TextbookDB.addTextbook(new TextbookFormData(id, title, author, isbn, coverUrl, condition));
    
    //#3
    title = "Discrete Mathematics and Its Applications";
    isbn = "0073383090";
    author = "Kenneth Rosen";
    condition = "Good";
    TextbookDB.addTextbook(new TextbookFormData(id, title, author, isbn, coverUrl, condition));
    
    //#4
    title = "Data Structures: Abstraction and Design Using Java";
    isbn = "0470128704";
    author = "Elliot B. Koffman, Paul A. T. Wolfgang";
    condition = "Fair";
    TextbookDB.addTextbook(new TextbookFormData(id, title, author, isbn, coverUrl, condition));
    
    //#5
    title = "C Programming Language (2nd Edition)";
    isbn = "0131103628";
    author = "Brian W. Kernighan, Dennis M. Ritchie";
    condition = "Poor";
    TextbookDB.addTextbook(new TextbookFormData(id, title, author, isbn, coverUrl, condition));
    
    //#6
    title = "C++ Primer Plus (6th Edition) ";
    isbn = "0321776402";
    author = "Stephen Prata";
    condition = "Excellent";
    TextbookDB.addTextbook(new TextbookFormData(id, title, author, isbn, coverUrl, condition));
    
    //#7
    title = "C Programming Language (2nd Edition)";
    isbn = "0131103628";
    author = "Brian W. Kernighan, Dennis M. Ritchie";
    condition = "Good";
    TextbookDB.addTextbook(new TextbookFormData(id, title, author, isbn, coverUrl, condition));
    
    //#8
    title = "Introduction to Algorithms";
    isbn = "0262033844";
    author = "Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein";
    condition = "Fair";
    TextbookDB.addTextbook(new TextbookFormData(id, title, author, isbn, coverUrl, condition));
    
    //#9
    title = "Programming Language Pragmatics, Third Edition";
    isbn = "0123745144";
    author = "Michael L. Scott";
    condition = "Poor";
    TextbookDB.addTextbook(new TextbookFormData(id, title, author, isbn, coverUrl, condition));
    
    // #10
    title = "Programming Language Pragmatics, Third Edition";
    isbn = "0123745144";
    author = "Michael L. Scott";
    condition = "Excellent";
    TextbookDB.addTextbook(new TextbookFormData(id, title, author, isbn, coverUrl, condition));
    
    //#11
    title = "Land of Lisp: Learn to Program in Lisp, One Game at a Time!";
    isbn = "1593272812";
    author = "Conrad Barski";
    condition = "Good";
    TextbookDB.addTextbook(new TextbookFormData(id, title, author, isbn, coverUrl, condition));
    
    //#12
    title = "Database Systems: The Complete Book (2nd Edition)";
    isbn = "0131873253";
    author = "Hector Garcia-Molina, Jeffrey D. Ullman, Jennifer Widom";
    condition = "Fair";
    TextbookDB.addTextbook(new TextbookFormData(id, title, author, isbn, coverUrl, condition));
    
    //#13
    title = "Digital Logic Design: A Rigorous Approach";
    isbn = "1107027535";
    author = "Guy Even, Moti Medina";
    condition = "Poor";
    TextbookDB.addTextbook(new TextbookFormData(id, title, author, isbn, coverUrl, condition));
    
    //#14
    title = "Operating System Concepts";
    isbn = "1118063333";
    author = "Abraham Silberschatz, Peter B. Galvin, Greg Gagne";
    condition = "Excellent";
    TextbookDB.addTextbook(new TextbookFormData(id, title, author, isbn, coverUrl, condition));
    
    //#15
    title = "Operating System Concepts";
    isbn = "1118129385";
    author = "Abraham Silberschatz, Greg Gagne, Peter B. Galvin";
    condition = "Good";
    TextbookDB.addTextbook(new TextbookFormData(id, title, author, isbn, coverUrl, condition));
    
    //#16
    title = "Ethics for the Information Age (5th Edition)";
    isbn = "0132855534";
    author = "Mike Quinn";
    condition = "Fair";
    TextbookDB.addTextbook(new TextbookFormData(id, title, author, isbn, coverUrl, condition));
    
    //#17
    title = "Emotional Design: Why We Love (or Hate) Everyday Things";
    isbn = "0465051367";
    author = "Don Norman";
    condition = "Poor";
    TextbookDB.addTextbook(new TextbookFormData(id, title, author, isbn, coverUrl, condition));
    
    //#18
    title = "The Design of Everyday Things";
    isbn = "0465067107";
    author = "Donald A. Norman";
    condition = "Excellent";
    TextbookDB.addTextbook(new TextbookFormData(id, title, author, isbn, coverUrl, condition));

    //#19
    title = "Presenting to Win: The Art of Telling Your Story, Updated and Expanded Edition";
    isbn = "0137144172";
    author = "Jerry Weissman";
    condition = "Good";
    TextbookDB.addTextbook(new TextbookFormData(id, title, author, isbn, coverUrl, condition));
    
    //#20
    title = "Artificial Intelligence for Games";
    isbn = "0123747317";
    author = "Ian Millington, John Funge";
    condition = "Fair";
    TextbookDB.addTextbook(new TextbookFormData(id, title, author, isbn, coverUrl, condition));
    
  }

}