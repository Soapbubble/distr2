package judete.web;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
 
//import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import java.util.Map;
import java.util.HashMap;
 
import judete.model.Judet;
import judete.service.JudeteManager;
 
public class JudeteController extends SimpleFormController {
  private JudeteManager jm;
  
  @Override
  protected Map referenceData(HttpServletRequest request) throws Exception {
    	Map<Object, Object> dataMap = new HashMap<Object, Object>();
    	dataMap.put("lstJud", jm.getLstJud());
    	return dataMap;
  }
  
  @Override
  public ModelAndView onSubmit(Object command) throws ServletException {
  	Judet jud=(Judet)command;
  	String nume=jud.getNume();	
  	HashMap refJudete=jm.getRefJudete();
  	jud=(Judet)refJudete.get(nume);
  	
    ModelAndView modelAndView = new ModelAndView("judete");
    modelAndView.addObject("nume",nume);
    modelAndView.addObject("capitala", jud.getCapitala());
    modelAndView.addObject("abrevierea",jud.getAbreviere());
    return modelAndView;
  }
  
  public void setJm(JudeteManager jm){
    this.jm=jm;
  } 
}
