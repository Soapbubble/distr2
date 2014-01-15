package helloname;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

public class InputPage extends WebPage {
  HelloName inputForm=new HelloName("form");
  
  public InputPage(){
    add(inputForm);
    FeedbackPanel feedbackPanel=new FeedbackPanel("answer");
    add(feedbackPanel);
  }    
}
