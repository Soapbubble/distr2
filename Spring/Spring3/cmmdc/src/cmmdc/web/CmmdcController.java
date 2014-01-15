package cmmdc.web;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
 
//import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

 
import cmmdc.model.DouaNumere;
import cmmdc.service.CmmdcManager;
 
public class CmmdcController extends SimpleFormController {
  
  @Override
  protected Object formBackingObject(HttpServletRequest request)
      throws Exception{
  	DouaNumere data=new DouaNumere();
  	data.setSm("1");
  	data.setSn("1");
  	return data;
  }
  
  @Override
  public ModelAndView onSubmit(Object command) 
      throws ServletException {
  	CmmdcManager cm=new CmmdcManager();
  	DouaNumere data=(DouaNumere)command;
  	cm.setData(data);	
  	
  	String myMessage=cm.cmmdcService();
    ModelAndView modelAndView = new ModelAndView("cmmdc");
    modelAndView.addObject("message", myMessage);
    modelAndView.addObject("sm", data.getSm());
    modelAndView.addObject("sn", data.getSn());
    return modelAndView;
  }
}
