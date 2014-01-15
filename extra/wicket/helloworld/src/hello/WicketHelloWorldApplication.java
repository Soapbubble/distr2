package hello;
import org.apache.wicket.protocol.http.WebApplication;

public class WicketHelloWorldApplication extends WebApplication{    

  public WicketHelloWorldApplication(){}
  
  public Class getHomePage(){
    return HomePage.class;
  }
}
