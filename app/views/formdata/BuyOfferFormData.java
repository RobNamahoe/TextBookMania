package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.BuyOffer;
import models.SellOfferDB;
import models.TextbookDB;
import play.data.validation.ValidationError;

public class BuyOfferFormData {
  
  /** Offer id*/
  public long id = 0;
  
  /** Dollar amount of bid.*/
  public int offer = 0;
  
  public long expiration = 0;
  
  public String isbn = "";
  
  
  public BuyOfferFormData() {
    //Nothing is Initialized
  }
  
  public BuyOfferFormData(BuyOffer offer) {
    this.id = offer.getId();
    this.isbn = offer.getIsbn();
    this.offer = offer.getOffer();
    this.expiration = offer.getExpiration();
  }

  
  public BuyOfferFormData(long id, String isbn, int offer) {
    this.id = id;
    this.isbn = isbn;
    this.offer = offer;
  }
  
  
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
    
    long index = 1;
    boolean forSale = false;
    boolean found = false;
    while(index <= TextbookDB.getTextbooks().size() && found != true) {
      if(isbn.equals(TextbookDB.getTextbook(index).getIsbn())) {
        found = true;
      }
      index++;
    }
    
    if(found) {
    index = 1;
    while(index <= SellOfferDB.getOffers().size() && forSale != true) {
      if(isbn.equals(SellOfferDB.getOffer(index).getIsbn())) {
        forSale = true;
      }
      index++;
    }
    }
    
    if(isbn =="") {
      errors.add(new ValidationError("isbn", "Textbook ISBN is Required."));
    }else if(! found) {
      errors.add(new ValidationError("isbn", "Textbook ISBN is not valid."));
    }else if(! forSale) {
      errors.add(new ValidationError("isbn", "No Textbook With This ISBN is Currently Being Sold."));
    }
    if(offer != (int)offer) {
      errors.add(new ValidationError("offer", "Offer Should Only be a Whole Number."));
    }
    
    if(errors.isEmpty()) {
      return null;
    }
    
    return errors;
    
  }
  

}
