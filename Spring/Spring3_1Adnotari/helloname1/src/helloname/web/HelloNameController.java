package helloname.web;
 
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import helloname.model.Nume;
import helloname.service.NumeManager;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
 
@Controller
//@SessionAttributes("command") //obiectul ce se pune pe sesiune
public class HelloNameController {

	//VARIANTA 1 pentru prima pagina:
	//prima pagina (in caz apel GET)
    /*
	@RequestMapping(value = "/newname.htm", method = RequestMethod.GET)
	public ModelAndView metodaPrimaPagina() {
	  	Nume nume=new Nume();
		nume.setNume("Hello World MVC!");
		
		ModelAndView modelAndView = new ModelAndView("nameForm");
		modelAndView.addObject("command", nume); //daca in JSP nu se specifica numele variabilei command, implicit e "command"
		return modelAndView;
	}
	*/
	
	//VARIANTA 2 pentru prima pagina:
	//prima pagina (in caz apel GET)
  @RequestMapping(value = "/newname.htm", method = RequestMethod.GET)
  public String metodaPrimaPagina(ModelMap modelMap) {
    Nume nume=new Nume();
    nume.setNume("Hello World MVC!");
		
    modelMap.addAttribute("command", nume); 
    //daca in JSP nu se specifica numele variabilei command,
    //implicit e "command"
    return "nameForm";
  }

	//a 2-a pagina (in caz apel POST)
  @RequestMapping(value = "/newname.htm", method = RequestMethod.POST)
	public ModelAndView metodaADouaPagina(@ModelAttribute("command") Nume nume) {
	  NumeManager nm=new NumeManager();
		nm.setName(nume);
		
		String myMessage = nm.sayHello();
		String myDate=(new java.util.Date()).toString();
		
		ModelAndView modelAndView = new ModelAndView("hello");
		modelAndView.addObject("message", myMessage);
		modelAndView.addObject("date", myDate);
		return modelAndView;
	}
}
