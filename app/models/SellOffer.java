package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Offer to sell a textbook in the store.
 * @author User1
 *
 */
public class SellOffer {
private long id = 0;
  
  private int offer = 0;
  
  private long expiration = 0;
  
  private String isbn = ""; 
  
  /** Student ID of the seller. **/
  private long sellerId;
  /** Email address of the seller. **/
  private String sellerEmail;
  
  /**
   * Initializes a SellOffer object.
   * @param id
   * @param isbn
   * @param offer
   * @param expiration
   * @param sellerEmail
   */
  public SellOffer(long id, String isbn, int offer, long expiration, String sellerEmail) {
    this.id = id;
    this.isbn = isbn;
    this.offer = offer;
    this.expiration = expiration;
    this.setSellerEmail(sellerEmail);
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

}
