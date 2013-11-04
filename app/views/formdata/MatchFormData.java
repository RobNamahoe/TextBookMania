package views.formdata;

/**
 * Java backing class for MatchPage form data.
 * @author Evan Komiyama
 */
public class MatchFormData {
  
  /**Student Email. **/
  public String email = "";
  
  /** Constructor method. **/
  public MatchFormData() {
    //Does Not Initialize Anything
  }
  
  /**
   * Constructor method.
   * @param email Email address of the student generating the report.
   */
  public MatchFormData(String email) {
    this.email = email;
  }
 
}
