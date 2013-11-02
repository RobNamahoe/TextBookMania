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
    this.coverUrl = coverUrl;
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
   * @return the condition
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


}
