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
  
  /**Book ISBN*/
  public String isbn = "";
  
  /** Email address of the seller. **/
  public String sellerEmail;
  
  /** Textbook Title. **/
  public String title; 
  
  public SellOfferFormData() {
    //Nothing is Initialized
  }
  
  public SellOfferFormData(SellOffer offer) {
    this.id = offer.getId();
    this.isbn = offer.getIsbn();
    this.offer = offer.getOffer();
    this.sellerEmail = offer.getSellerEmail();
    this.title = offer.getTitle();
  }

  
  public SellOfferFormData(long id, String isbn, int offer, String sellerEmail) {
    this.id = id;
    this.isbn = isbn;
    this.offer = offer;
    this.sellerEmail = sellerEmail;
    this.title = TextbookDB.getTitleFromIsbn(isbn);
  }
  
  
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
    
    long index = 1;
    boolean found = false;
    while(index <= TextbookDB.getTextbooks().size() && found != true) {
      if(isbn.equals(TextbookDB.getTextbook(index).getIsbn())) {
        found = true;
      }
      index++;
    }
    
    if (title == null || title.length() == 0) {
      errors.add(new ValidationError("title", "Textbook title is required."));
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
