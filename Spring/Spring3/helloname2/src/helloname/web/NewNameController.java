package helloname.web;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
 
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
 
import helloname.model.Nume;
import helloname.service.NumeManager;
 
public class NewNameController extends SimpleFormController {
    private NumeManager nm;
    
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
    	Nume nume=new Nume();
    	nume.setNume("Hello World MVC!");
    	return nume;
  	}
  	
    @Override
    public ModelAndView onSubmit(Object command) throws ServletException {
    	Nume nume=(Nume)command;
    	System.out.println(nume.getNume());
    	nm.setName(nume);
    	return new ModelAndView(new RedirectView(getSuccessView()));
    }
    
    public void setNm(NumeManager nm){
  	  this.nm=nm;
	  }
    
}
