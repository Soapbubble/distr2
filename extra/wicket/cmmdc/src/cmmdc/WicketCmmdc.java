package cmmdc;
import org.apache.wicket.protocol.http.WebApplication;

public class WicketCmmdc extends WebApplication{    

  public WicketCmmdc(){}
  
  public Class getHomePage(){
    return InputPage.class;
  }
}
