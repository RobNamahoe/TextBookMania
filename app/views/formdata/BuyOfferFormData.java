package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.BuyOffer;
import models.TextbookDB;
import play.data.validation.ValidationError;

/**
 * Java backing class for Buy Offer form data.
 * @author Evan Komiyama
 */
public class BuyOfferFormData {
  
  /** Offer id. */
  public long id = 0;
  /** Dollar amount of bid.*/
  public int offer = 0;
  /** Expiration Date. **/
  public long expiration = 0;
  /** ISBN of the book to buy. **/
  public String isbn = "";
  /** Email address of the buyer. **/
  public String buyerEmail;
  /** Textbook Title. **/
  public String title; 
  
  
  /**
   * 
   */
  public BuyOfferFormData() {
    //Nothing is Initialized
  }
  
  /**
   * Constructor method.
   * @param offer The buy offer.
   */
  public BuyOfferFormData(BuyOffer offer) {
    this.id = offer.getId();
    this.isbn = offer.getIsbn();
    this.offer = offer.getOffer();
    this.expiration = offer.getExpiration();
    this.buyerEmail = offer.getBuyerEmail();
    this.title = offer.getTitle();
  }

  /**
   * 
   * @param id The id.
   * @param isbn The isbn.
   * @param offer the offer.
   * @param buyerEmail The buyers email address.
   */
  public BuyOfferFormData(long id, String isbn, int offer, String buyerEmail) {
    this.id = id;
    this.isbn = isbn;
    this.offer = offer;
    this.buyerEmail = buyerEmail;
    this.title = TextbookDB.getTitleFromIsbn(isbn);
  }
  
  /**
   * Checks that form fields are valid. Called by bindFormRequest().
   * @return null if valid, a list of ValidationErrors if problems are found.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
    
    long index = 1;
    boolean found = false;
    while (index <= TextbookDB.getTextbooks().size() && !found) {
      if (isbn.equals(TextbookDB.getTextbook(index).getIsbn())) {
        found = true;
      }
      index++;
    }
    
    if (title == null || title.length() == 0) {
      errors.add(new ValidationError("title", "Textbook title is required."));
    }
    
    if (offer != (int) offer) {
      errors.add(new ValidationError("offer", "Offer Should Only be a Whole Number."));
    }
    
    if (errors.isEmpty()) {
      return null;
    }
    
    return errors;
    
  }
  

}
