package helloname.web;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
 
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
 
import helloname.model.Nume;
import helloname.service.NumeManager;
 
public class HelloNameController extends SimpleFormController {
  
  @Override
  protected Object formBackingObject(HttpServletRequest request) throws Exception {
  	Nume nume=new Nume();
  	nume.setNume("Hello World MVC!");
  	return nume;
  }
  
  @Override
  public ModelAndView onSubmit(Object command) throws ServletException {
  	NumeManager nm=new NumeManager();
  	Nume nume=(Nume)command;
    nm.setName(nume);	
  	
  	String myMessage = nm.sayHello();
    String myDate=(new java.util.Date()).toString();
    		
    ModelAndView modelAndView = new ModelAndView("hello");
    modelAndView.addObject("message", myMessage);
    modelAndView.addObject("date", myDate);
    return modelAndView;
  }
}
