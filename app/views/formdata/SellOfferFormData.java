package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.SellOffer;
import models.TextbookDB;
import play.data.validation.ValidationError;

public class SellOfferFormData {

  /** Offer id*/
  public long id = 0;
  
  /** Dollar amount of bid.*/
  public int offer = 0;
  
  /** Time this offer expires.*/
  public long expiration = 0;
  
  /**Book ISBN*/
  public String isbn = "";
  
  /**Condition of the book.*/
  public String condition = "";
  
  public SellOfferFormData() {
    //Nothing is Initialized
  }
  
  public SellOfferFormData(SellOffer offer) {
    this.id = offer.getId();
    this.isbn = offer.getIsbn();
    this.offer = offer.getOffer();
    this.expiration = offer.getExpiration();
    this.condition = offer.getCondition();
  }

  
  public SellOfferFormData(long id, String isbn, int offer, long expiration, String condition) {
    this.id = id;
    this.isbn = isbn;
    this.offer = offer;
    this.expiration = expiration;
    this.condition = condition;
  }
  
  
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
    
    long index = 0;
    boolean found = false;
    while(index < TextbookDB.getTextbooks().size() && found != true) {
      if(isbn.equals(TextbookDB.getTextbook(index))) {
        found = true;
      }
      index++;
    }
    
    if(isbn == "") {
      errors.add(new ValidationError("isbn", "Textbook ISBN is Required.")); 
    }else if(! found) {
      errors.add(new ValidationError("isbn", "Textbook ISBN is not valid."));
    }
    if(offer != (int)offer) {
      errors.add(new ValidationError("offer", "Offer Should Only be a Whole Number."));
    }
    if(expiration == 0) {
      errors.add(new ValidationError("offerTime", "No Expiration Time Specified."));
    }
    if(condition == "") {
      errors.add(new ValidationError("condition", "Condition Needs to be Specified."));
    }
    
    return errors;
    
  }
}
