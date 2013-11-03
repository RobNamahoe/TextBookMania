package views.formdata;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.ValidationError;
import models.Textbook;
import models.TextbookDB;

/**
 * Java backing class for Textbook's form data.
 * 
 * @author Rob Namahoe
 * 
 */
public class TextbookFormData {
 
  /** Maximum number of characters in ISBN. */
  private static final int ISBN_NUM_CHARS = 10;
  
  /** The textbook id. */
  public long id;
  /** The textbooks title. */
  public String title;
  /** The textbooks author. */
  public String author;
  /** The textbooks ISBN number. */
  public String isbn;
  /** The url to the textbooks cover. */
  public String coverUrl;
  /** The condition of the textbook. */
  public String condition;
  
  /**
   * Default constructor method.
   */
  public TextbookFormData() {
    // Default constructor method.
  }

  /**
   * Constructor method.
   * @param textbook An existing textbook.
   */
  public TextbookFormData(Textbook textbook) {
    this.id = textbook.getId();
    this.title = textbook.getTitle();
    this.author = textbook.getAuthor();
    this.isbn = textbook.getIsbn();
    this.coverUrl = textbook.getCoverUrl();
    this.condition = textbook.getCondition();
  }

  /**
   * Constructor method - used to initialize database.
   * @param id The id of the textbook.
   * @param title The title of the textbook.
   * @param author The author of the textbook.
   * @param isbn The ISBN of the textbook.
   * @param coverUrl The URL to the cover of the textbook.
   * @param condition The condition of the textbook.
   */
  public TextbookFormData(long id, String title, String author, String isbn, String coverUrl, String condition) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.coverUrl = coverUrl;
    this.condition = condition;
  }
  
  /**
   * Checks that form fields are valid. Called by bindFormRequest().
   * @return null if valid, a list of ValidationErrors if problems are found.
   */
  public List<ValidationError> validate() {
    
    List<ValidationError> errors = new ArrayList<>();
    
    if (title == null || title.length() == 0) {
      errors.add(new ValidationError("title", "Title is required."));
    }
    
    if (author == null || author.length() == 0) {
      errors.add(new ValidationError("author", "Author is required."));
    }
    
    if (isbn == null || isbn.length() == 0) {
      errors.add(new ValidationError("isbn", "ISBN is required."));
    }
    else if (isbn.length() != ISBN_NUM_CHARS) {
      errors.add(new ValidationError("isbn", "ISBN must be 10 characters in length."));
    }
    
    if (!isbn.matches("[0-9]+")) {
      errors.add(new ValidationError("isbn", "Invalid entry. Numeric characters only."));
    }
    
    if (condition == null || condition.length() == 0) {
      errors.add(new ValidationError("condition", "Condition is required."));
    }
    
    //ISBN cannot be duplicated
    if (TextbookDB.isbnExists(id, isbn)) {
      errors.add(new ValidationError("isbn", "That ISBN is already in use and cannot be duplicated."));
    }
        
    //Title cannot be duplicated
    if (TextbookDB.titleExists(id, title)) {
      errors.add(new ValidationError("title", "That title is already in use and cannot be duplicated."));
    }
    
    return errors.isEmpty() ? null : errors;
    
  }


}
