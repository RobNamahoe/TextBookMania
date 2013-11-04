package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Offer to sell a textbook in the store.
 * @author Evan Komiyama
 *
 */
public class SellOffer {
  /** The id of the sell offer. **/
  private long id = 0;
  /** The value of the offer. **/
  private int offer = 0;
  /** The expiration date of the offer. **/
  private long expiration = 0;
  /** The ISBN number of the textbook. **/
  private String isbn = ""; 
  /** Student ID of the seller. **/
  private long sellerId;
  /** Email address of the seller. **/
  private String sellerEmail;
  /** Textbook title. **/
  private String title;
  
  /**
   * Initializes a SellOffer object.
   * @param id The id of the sell offer.
   * @param isbn The ISBN of the textbook being sold.
   * @param offer The value of the offer in dollars.
   * @param expiration The expiration date of the offer.
   * @param sellerEmail The sellers email address.
   * @param title The title of the textbook being sold.
   */
  public SellOffer(long id, String isbn, int offer, long expiration, String sellerEmail, String title) {
    this.id = id;
    this.isbn = isbn;
    this.offer = offer;
    this.expiration = expiration;
    this.setSellerEmail(sellerEmail);
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
   * Returns the expiration date in MM/dd/yyyy hh:mm:ss.SSS format.
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
   * @return the sellerId
   */
  public long getSellerId() {
    return sellerId;
  }


  /**
   * @param sellerId the sellerId to set
   */
  public void setSellerId(long sellerId) {
    this.sellerId = sellerId;
  }


  /**
   * @return the sellerEmail
   */
  public String getSellerEmail() {
    return sellerEmail;
  }


  /**
   * @param sellerEmail the sellerEmail to set
   */
  public void setSellerEmail(String sellerEmail) {
    this.sellerId = StudentDB.getIdFromEmail(sellerEmail);
    this.sellerEmail = sellerEmail;
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
