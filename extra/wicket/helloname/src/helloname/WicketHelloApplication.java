package helloname;
import org.apache.wicket.protocol.http.WebApplication;

public class WicketHelloApplication extends WebApplication{    

  public WicketHelloApplication(){}
  
  public Class getHomePage(){
    return InputPage.class;
  }
}
