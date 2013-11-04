package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Offers to buy a certain textbook in the store.
 * @author Evan Komiyama
 *
 */
public class BuyOffer {
  /** The id of the buy offer. **/
  private long id = 0;
  /** The value of the offer. **/
  private int offer = 0;
  /** The expiration date of the offer. **/
  private long expiration = 0;
  /** The ISBN number of the textbook. **/
  private String isbn = "";
  /** Student ID of the buyer. **/
  private long buyerId;
  /** Email address of the buyer. **/
  private String buyerEmail;
  /** Textbook title. **/
  private String title;
  
  
  /**
   * Initializes a BuyOffer object.
   * @param id The id of the buy offer.
   * @param isbn The isbn of the textbook.
   * @param offer The value of the offer ($)
   * @param expiration The expiration date of the offer.
   * @param buyerEmail The buyers email address.
   * @param title The title of the textbook.
   */
  public BuyOffer(long id, String isbn, int offer, long expiration, String buyerEmail, String title) {
    this.id = id;
    this.setIsbn(isbn);
    this.offer = offer;
    this.expiration = expiration;
    this.setBuyerEmail(buyerEmail);
    if (!title.equals("")) {
      this.title = title;
    }
    else {
      this.title = TextbookDB.getTitleFromIsbn(isbn);
    }
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
   * @return the offer
   */
  public int getOffer() {
    return offer;
  }


  /**
   * @param offer the offer to set
   */
  public void setOffer(int offer) {
    this.offer = offer;
  }


  /**
   * @return the offerTime
   */
  public long getExpiration() {
    return expiration;
  }


  /**
   * Sets the expiration time.
   * @param expiration The expiration date of the offer.
   */
  public void setExpiration(long expiration) {
    this.expiration = expiration;
  }
  
  /**
   * Returns expiration date in MM/dd/yyyy hh:mm:ss.SSS form.
   * @param expiration
   * @return String
   */
  public String getExpirationDate() {
    DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss.SSS");
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(expiration);
    
    return formatter.format(calendar.getTime());
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
   * @return the buyerId
   */
  public long getBuyerId() {
    return buyerId;
  }


  /**
   * @param buyerId the buyerId to set
   */
  public void setBuyerId(long buyerId) {
    this.buyerId = buyerId;
  }


  /**
   * @return the buyerEmail
   */
  public String getBuyerEmail() {
    return buyerEmail;
  }


  /**
   * @param buyerEmail the buyerEmail to set
   */
  public void setBuyerEmail(String buyerEmail) {
    this.buyerId = StudentDB.getIdFromEmail(buyerEmail);
    this.buyerEmail = buyerEmail;
    
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

}
