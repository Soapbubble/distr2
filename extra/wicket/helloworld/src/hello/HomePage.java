package hello;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
//import org.apache.wicket.PageParameters;

public class HomePage extends WebPage {
  public HomePage(){ //final PageParameters parameters) {
    add(new Label("message", "Hello World !"));
  }
}
