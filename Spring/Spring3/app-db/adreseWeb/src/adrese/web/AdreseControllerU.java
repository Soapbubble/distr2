package adrese.web;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
  
import adrese.model.AppData;
import adrese.service.AdreseManager;
import adrese.dao.Adrese;
 
public class AdreseControllerU extends SimpleFormController{
  private AdreseManager am;
  
  @Override
  protected Object formBackingObject(HttpServletRequest request)throws Exception{
    String sid=am.getData().getSid();
    System.out.println(sid);
    int myId=Integer.parseInt(sid);
    Adrese entity=am.getAdreseById(myId);
    /*
    AppData data=new AppData();
    data.setOperatia("Lista inregistrarilor");
    am.setData(data);
    am.executeSQL();
    List<Adrese> lst=am.getList();
    Iterator<Adrese> iter=lst.iterator();
    String nume="",email="";
    while(iter.hasNext()){
      Adrese entity=iter.next();
      System.out.println("itt "+entity.getId());
      if(entity.getId()==myId){
        nume=entity.getNume();
        email=entity.getEmail();
      }
      break;
    }
    */
    AppData data=new AppData();
    data.setNume(entity.getNume());
    data.setEmail(entity.getEmail());
    data.setOperatia("Actualizare");
    data.setSid(sid);
    am.setData(data);
    return data;
  }
  
  @Override
  public ModelAndView onSubmit(Object command) throws ServletException{
    AppData data=(AppData)command;    
    data.setOperatia("Actualizare");
    AppData d=am.getData();
    data.setSid(d.getSid());
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
