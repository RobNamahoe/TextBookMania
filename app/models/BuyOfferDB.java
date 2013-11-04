package models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.BuyOfferFormData;

/**
 * In-memory database of Buy Offers.
 * @author Evan Komiyama
 *
 */
public class BuyOfferDB {
  
  /** Maximum number of characters in ISBN. */
  private static final int EXPIRATION_DAYS = 30;
  
  private static Map<Long, BuyOffer> offers = new HashMap<>();
  
  /**
   * Adds a buy offer to the list.
   * @param formData Buy Offer form data.
   * @return SellOffer The sell offer.
   */
  public static BuyOffer addOffer(BuyOfferFormData formData) {
    
    long id = (formData.id == 0) ? offers.size() + 1 : formData.id;
    Calendar currentDate = Calendar.getInstance();
    Calendar expirationDate = currentDate;
    expirationDate.add(Calendar.DAY_OF_MONTH, EXPIRATION_DAYS);
    String isbn = "";
    if (formData.isbn == null) {
      isbn = TextbookDB.getIsbnFromTitle(formData.title);
    }
    else {
      isbn = formData.isbn;
    }
    BuyOffer buyOffer = new BuyOffer(id, isbn, formData.offer, expirationDate.getTimeInMillis(),
                                     formData.buyerEmail, formData.title);
    offers.put(id, buyOffer);
    return buyOffer;
  }
  
  /**
   * Returns the whole buy offer list.
   * @return A list of buy offers.
   */
  public static List<BuyOffer> getOffers() {
    return new ArrayList<>(offers.values());
  }
  
  /**
   * Returns an offer with the given id.
   * @param id The id of the buy offer to return.
   * @return The requested buy offer.
   */
  public static BuyOffer getOffer(long id) {
    BuyOffer buyOffer = offers.get(id);
    return buyOffer;
  }
  
  /**
   * Deletes an offer with a given id.
   * @param id The id of the buy offer to delete.
   */
  public static void deleteOffer(long id) {
    offers.remove(id);
  }
}
