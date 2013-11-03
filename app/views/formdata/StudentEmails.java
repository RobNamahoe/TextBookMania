package views.formdata;

import java.util.HashMap;
import java.util.Map;
import models.StudentDB;

/**
 * 
 * @author rckndn
 *
 */
public class StudentEmails {
  
  /**
   * Returns A newly initialized Map of student email addresses.
   * @return A map of email addresses initialized to false.
   */
  public static Map<String, Boolean> getEmails() {
    Map<String, Boolean> emailMap = new HashMap<String, Boolean>();
    for (String email : StudentDB.getEmailAddresses()) {
      emailMap.put(email, false);
    }
    return emailMap;
  }
 
  /**
   * Returns A newly initialized Map of email addresses with selected address indicated.
   * @param emailAddress The selected email address.
   * @return A map of mail addresses with the selected email set to true.
   */
  public static Map<String, Boolean> getEmails(String emailAddress) {
    Map<String, Boolean> emailMap = new HashMap<String, Boolean>();
    for (String email : StudentDB.getEmailAddresses()) {
      emailMap.put(email, false);
    }
    emailMap.put(emailAddress, true);
    return emailMap;
  }
   
  /**
   * Returns true if email address is a valid address.
   * @param emailAddress The selected email address.
   * @return true if the address exists in the database, false otherwise.
   */
  public static Boolean isEmail(String emailAddress) {
    return StudentDB.getEmailAddresses().contains(emailAddress);
  }
  
}