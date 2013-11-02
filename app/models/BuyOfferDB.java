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

  private static Map<Long, BuyOffer> offers = new HashMap<>();
  
  /**
   * Adds a buy offer to the list.
   * @param formData
   * @return SellOffer
   */
  public static BuyOffer addOffer(BuyOfferFormData formData) {
    long id = (formData.id == 0) ? offers.size() + 1 : formData.id;
    Calendar currentDate = Calendar.getInstance();
    Calendar expirationDate = currentDate;
    expirationDate.add(Calendar.DAY_OF_MONTH, 30);
    BuyOffer buyOffer = new BuyOffer(id, formData.isbn, formData.offer, expirationDate.getTimeInMillis());
    offers.put(id, buyOffer);
    System.out.println(id + ": " + formData.id + " added.");
    return buyOffer;
  }
  
  /**
   * Returns the whole buy offer list.
   * @return
   */
  public static List<BuyOffer> getOffers() {
    return new ArrayList<>(offers.values());
  }
  
  /**
   * Returns an offer with the given id.
   * @param id
   * @return
   */
  public static BuyOffer getOffer(long id) {
    BuyOffer buyOffer = offers.get(id);
    return buyOffer;
  }
  
  /**
   * Deletes an offer with a given id.
   * @param id
   */
  public static void deleteOffer(long id) {
    offers.remove(id);
  }
}
