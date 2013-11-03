package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Offers to buy a certain textbook in the store.
 * @author User1
 *
 */
public class BuyOffer {
  private long id = 0;
 
  private int offer = 0;
  
  private long expiration = 0;
  
  private String isbn = "";
  
  /** Student ID of the buyer. **/
  private long buyerId;
  /** Email address of the buyer. **/
  private String buyerEmail;
  
  /**
   * Initializes a BuyOffer object.
   * @param id
   * @param isbn
   * @param offer
   * @param expiration
   * @param buyerEmail
   */
  public BuyOffer(long id, String isbn, int offer, long expiration, String buyerEmail) {
    this.id = id;
    this.setIsbn(isbn);
    this.offer = offer;
    this.expiration = expiration;
    this.setBuyerEmail(buyerEmail);
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
   * @param expiration
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

}
