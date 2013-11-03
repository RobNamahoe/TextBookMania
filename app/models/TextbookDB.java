package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.TextbookFormData;

/**
 * A simple in-memory repository for Textbooks.
 * @author Rob Namahoe
 *
 */
public class TextbookDB {

    private static Map<Long, Textbook> textbooks = new HashMap<>();
    
    /**
     * Add a textbook to the database of textbooks.
     * @param formData Textbook data.
     * @return A new textbook.
     */
    public static Textbook addTextbook(TextbookFormData formData) {
      long id = (formData.id == 0) ? textbooks.size() + 1 : formData.id;
      Textbook textbook = new Textbook(id, formData.title, formData.author, formData.isbn, 
                                       formData.coverUrl, formData.condition);
      textbooks.put(id, textbook);
      return textbook;
    }
    
    /**
     * Returns a list of textbooks.
     * @return list of textbooks.
     */
    public static List<Textbook> getTextbooks() {
      return new ArrayList<>(textbooks.values());
    }
    
    /**
     * Returns the textbook associated with the passed id.
     * @param id The textbooks id.
     * @return The requested textbook.
     */
    public static Textbook getTextbook(long id) {
      Textbook textbook = textbooks.get(id);
      return textbook;
    }
    
    /**
     * Deletes the textbook with the associated id.
     * @param id The textbooks id.
     */
    public static void deleteTextbook(long id) {
      textbooks.remove(id);
    }
    
    /**
     * Checks if the isbn entered by the user already exists in the database.
     * @param id The id of the current textbook.
     * @param isbn The ISBN the student is attempting to register.
     * @return true if the isbn already exists in the database, false otherwise.
     */
    public static boolean isbnExists(long id, String isbn) {
      boolean result = false;
      for (Map.Entry<Long, Textbook> textbook : textbooks.entrySet()) {
        if (isbn.equals(textbook.getValue().getIsbn())) {
          result = true;
          if (id == textbook.getKey()) {
            return false;
          }
        }
      }
      return result;
    }
    
    /**
     * Checks if the title entered by the user already exists in the database.
     * @param id The id of the current textbook.
     * @param title The title the student is attempting to register.
     * @return true if the title already exists in the database, false otherwise.
     */
    public static boolean titleExists(long id, String title) {
      boolean result = false;
      for (Map.Entry<Long, Textbook> textbook : textbooks.entrySet()) {
        if (title.equals(textbook.getValue().getTitle())) {
          result = true;
          if (id == textbook.getKey()) {
            return false;
          }
        }
      }
      return result;
    }
    
    
}
