package views.formdata;

import java.util.Arrays;
import java.util.List;

/**
 * Represents legal textbook condition types.
 * @author Rob Namahoe
 *
 */
public class ConditionTypes {

  /**
   * Provides a list of textbook conditions.
   * @return A list of textbook conditions.
   */
  public static List<String> getTypes() {
    String[] types = {"Excellent", "Good", "Fair", "Poor"};
    return Arrays.asList(types);
  }
  
}
