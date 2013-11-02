package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SellOffer {
private long id = 0;
  
  private int offer = 0;
  
  private long expiration = 0;
  
  private String isbn = "";
  
  private String condition = "";
  
  
  public SellOffer(long id, String isbn, int offer, long expiration, String condition) {
    this.id = id;
    this.isbn = isbn;
    this.offer = offer;
    this.expiration = expiration;
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
   * @param offerTime the offerTime to set
   */
  public void setExpiration(long expiration) {
    this.expiration = expiration;
  }
  
  /**
   * @param expiration
   * @return
   */
  public String getExpirationDate(long expiration) {
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
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
