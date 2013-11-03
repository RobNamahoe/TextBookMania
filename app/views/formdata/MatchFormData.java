package views.formdata;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.ValidationError;

public class MatchFormData {
  
  /**Student Email*/
  public String email = "";
  
  public MatchFormData() {
    //Does Not Initialize Anything
  }
  
  public MatchFormData(String email) {
    this.email = email;
  }
  

}
