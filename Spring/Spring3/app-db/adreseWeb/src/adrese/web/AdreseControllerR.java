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
import org.springframework.web.servlet.mvc.Controller;
  
import adrese.model.AppData;
import adrese.service.AdreseManager;
import adrese.dao.Adrese;
 
public class AdreseControllerR implements Controller{
  private AdreseManager am;
  
 
  @Override
  public ModelAndView handleRequest(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException,IOException{ 
    AppData data=new AppData();
    data.setOperatia("Lista inregistrarilor");   
    am.setData(data);	  
    am.executeSQL();
	  String myMessage = am.getMsg();
    List<Adrese>list=am.getList();
    Map<String, Object> myModel = new HashMap<String, Object>();
    myModel.put("listaAdrese",list);  
    ModelAndView modelAndView = new ModelAndView("adrese");
    modelAndView.addObject("message",myMessage);
    modelAndView.addObject("model",myModel);  
	  return modelAndView;
  } 
  
  public void setAm(AdreseManager am){
    this.am=am;
  }
}
