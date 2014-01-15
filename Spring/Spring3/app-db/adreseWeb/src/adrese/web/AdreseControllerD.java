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
  
import adrese.model.AppData;
import adrese.service.AdreseManager;
import adrese.dao.Adrese;
 
public class AdreseControllerD extends SimpleFormController{
  private AdreseManager am;
  
  @Override
  public ModelAndView onSubmit(Object command) throws ServletException{
    AppData data=(AppData)command;    
    data.setOperatia("Stergere");
    am.setData(data);	
    am.executeSQL();
    String myMessage = am.getMsg();
    ModelAndView modelAndView = new ModelAndView("adrese");
    modelAndView.addObject("message",myMessage);
    return modelAndView;
  }
	  
  public void setAm(AdreseManager am){
    this.am=am;
  }
}
