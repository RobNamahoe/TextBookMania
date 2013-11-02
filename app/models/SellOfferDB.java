package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.SellOfferFormData;

/**
 * In-memory database of Sell Offers.
 * @author Evan Komiyama
 *
 */
public class SellOfferDB {

  private static Map<Long, SellOffer> offers = new HashMap<>();
  
  /**
   * Adds a sell offer to the list.
   * @param formData
   * @return SellOffer
   */
  public static SellOffer addOffer(SellOfferFormData formData) {
    long id = (formData.id == 0) ? offers.size() + 1 : formData.id;
    SellOffer sellOffer = new SellOffer(formData.id, formData.isbn, formData.offer, formData.expiration, formData.condition);
    offers.put(id, sellOffer);
    System.out.println(id + ": " + formData.isbn + " added.");
    return sellOffer;
  }
  
  /**
   * Returns the whole sell offer list.
   * @return
   */
  public static List<SellOffer> getOffers() {
    return new ArrayList<>(offers.values());
  }
  
  /**
   * Returns an offer with the given id.
   * @param id
   * @return
   */
  public static SellOffer getOffer(long id) {
    SellOffer sellOffer = offers.get(id);
    return sellOffer;
  }
  
  /**
   * Deletes an offer with a given id.
   * @param id
   */
  public static void deleteOffer(long id) {
    offers.remove(id);
  }
  
}
