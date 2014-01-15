package helloname.web;
 
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.stereotype.Controller; 
import helloname.model.Nume;
import helloname.service.NumeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/newname.htm")
public class NewNameController {
  @Autowired
	private NumeManager nm;
    	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView metodaCerereInitiala() {
		Nume nume=new Nume();
    nume.setNume("Hello World MVC!");
		
		ModelAndView modelAndView=new ModelAndView("nameForm");
		modelAndView.addObject("command", nume);
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView metodaDupaSubmit(@ModelAttribute("command") Nume nume) {
		System.out.println(nume.getNume());
    nm.setName(nume);
    return new ModelAndView(new RedirectView("helloworld.htm"));
  }
}
