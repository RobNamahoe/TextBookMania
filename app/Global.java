import models.BuyOfferDB;
import models.SellOfferDB;
import models.StudentDB;
import models.TextbookDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.BuyOfferFormData;
import views.formdata.SellOfferFormData;
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
    
    // Initialize the database with 2 students.
    id = 0;
    name = "Rob Namahoe";
    email = "rnamahoe@gmail.com";
    picUrl = "http://www.clker.com/cliparts/a/p/U/V/U/z/blue-smile-th.png";
    
    StudentDB.addStudent(new StudentFormData(id, name, email, picUrl));
    
    id = 0;
    name = "Evan Komiyama";
    email = "evkomiyama@gmail.com";
    picUrl = "http://ecx.images-amazon.com/images/I/31LgWpZpj-L._SL500_SS100_.jpg";
    
    StudentDB.addStudent(new StudentFormData(id, name, email, picUrl));
   
    // Initialize the database with 20 books
    String title;
    String isbn;
    String author;
    String coverUrl;
    String condition;
    
    //#1 ISBN was invalid, used Play for Java instead.
    title = "Play for Java, Covers Play 2";
    isbn = "1617290904";
    author = "Nicolas Leroux and Sietse de Kaper";
    coverUrl = "";
    condition = "Excellent";
    TextbookDB.addTextbook(new TextbookFormData(id, title, author, isbn, coverUrl, condition));
    
    //#2
    title = "Java Concepts: Compatible with Java 5, 6 and 7";
    isbn = "0470509473";
    author = "Cay S. Horstmann";
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
    
    // Initialize the database with 5 buy offers
    int offer = 15;
    
    email = "rnamahoe@gmail.com";
    isbn = "0465051367";
    BuyOfferDB.addOffer(new BuyOfferFormData(1, isbn, offer, email));
    
    offer = 17;
    isbn = "0123747317";
    BuyOfferDB.addOffer(new BuyOfferFormData(2, isbn, offer, email));
    
    offer = 32;
    isbn = "1118063333";
    BuyOfferDB.addOffer(new BuyOfferFormData(3, isbn, offer, email));
    
    
    email = "evkomiyama@gmail.com";
    offer = 20;
    isbn = "0470128704";
    BuyOfferDB.addOffer(new BuyOfferFormData(4, isbn, offer, email));
    
    
    offer = 12;
    isbn = "0073383090";
    BuyOfferDB.addOffer(new BuyOfferFormData(5, isbn, offer, email));
    
    // Initialize the database with 5 sell offers
    
    
    email = "evkomiyama@gmail.com";
    isbn = "0465051367";
    SellOfferDB.addOffer(new SellOfferFormData(1, isbn, offer, email));
    
    offer = 17;
    isbn = "0123747317";
    SellOfferDB.addOffer(new SellOfferFormData(2, isbn, offer, email));
    
    offer = 32;
    isbn = "1118063333";
    SellOfferDB.addOffer(new SellOfferFormData(3, isbn, offer, email));
    
    
    email = "rnamahoe@gmail.com";
    offer = 22;
    isbn = "0470128704";
    SellOfferDB.addOffer(new SellOfferFormData(4, isbn, offer, email));
    
    offer = 12;
    isbn = "0073383090";
    SellOfferDB.addOffer(new SellOfferFormData(5, isbn, offer, email));
    
  }

}