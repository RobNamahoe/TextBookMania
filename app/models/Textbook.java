package models;

/**
 * A model for a Textbook.
 * @author Rob Namahoe
 *
 */
public class Textbook {
  /** The textbook id. */
  private long id;
  /** The textbooks title. */
  private String title;
  /** The textbooks author. */
  private String author;
  /** The textbooks ISBN number. */
  private String isbn;
  /** The url to the textbooks cover. */
  private String coverUrl;
  /** The condition of the textbook. */
  private String condition;
  
  /**
   * Constructs a new Textbook.
   * @param id The textbook's id.
   * @param title The textbooks title.
   * @param author The textbooks author.
   * @param isbn The textbooks isbn.
   * @param coverUrl The url to the textbooks cover.
   * @param condition The condition of the textbook.
   */
  public Textbook(long id, String title, String author, String isbn, String coverUrl, String condition) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    if (coverUrl == null || coverUrl.length() == 0) {
      this.coverUrl = getCoverUrlAddress(isbn);
    }
    else {
      this.coverUrl = coverUrl;
    }
    this.condition = condition;
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

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @return the author
   */
  public String getAuthor() {
    return author;
  }

  /**
   * @param author the author to set
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * @return the isbn
   */
  public String getIsbn() {
    return isbn;
  }

  /**
   * @param isbn the isbn to set
   */
  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  /**
   * @return the coverUrl
   */
  public String getCoverUrl() {
    return coverUrl;
  }

  /**
   * @param coverUrl the coverUrl to set
   */
  public void setCoverUrl(String coverUrl) {
    this.coverUrl = coverUrl;
  }

  /**
   * @return the condition of the textbook.
   */
  public String getCondition() {
    return condition;
  }

  /**
   * @param condition the condition to set
   */
  public void setCondition(String condition) {
    this.condition = condition;
  }
  
  /**
   * Generate url to book cover on Amazon.
   * @param isbn The ISBN of the book.
   * @return The url to the book cover on Amazon.
   */
   public String getCoverUrlAddress(String isbn) {
     final int ISBN_DIGIT_COUNT = 10;
     String coverUrlAddress = "";
     if (this.isbn.length() == ISBN_DIGIT_COUNT) {
       coverUrlAddress = "http://images.amazon.com/images/P/" + isbn + ".01.jpg";
     }
     return coverUrlAddress;
   }

}
