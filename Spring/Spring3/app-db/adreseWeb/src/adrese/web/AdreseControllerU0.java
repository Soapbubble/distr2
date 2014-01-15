package adrese.web;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
  
import adrese.model.AppData;
import adrese.service.AdreseManager;
import adrese.dao.Adrese;
 
public class AdreseControllerU0 extends SimpleFormController{
  
  private AdreseManager am;
  
  @Override
  public ModelAndView onSubmit(Object command) throws ServletException{
    AppData data=(AppData)command;    
    data.setOperatia("Actualizare");
    am.setData(data);	
    return new ModelAndView(new RedirectView(getSuccessView()));
  }
	  
  public void setAm(AdreseManager am){
    this.am=am;
  }
}
