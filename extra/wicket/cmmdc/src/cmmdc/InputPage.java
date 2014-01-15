package cmmdc;
import org.apache.wicket.markup.html.WebPage;

public class InputPage extends WebPage {
  InputForm inputForm=new InputForm("form");
  
  public InputPage(){
    add(inputForm);
  }    
}
