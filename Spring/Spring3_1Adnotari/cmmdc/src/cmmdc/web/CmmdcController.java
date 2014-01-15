package cmmdc.web;
 
import cmmdc.model.DouaNumere;
import cmmdc.service.CmmdcManager;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import javax.validation.Valid;
//import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/cmmdcdata.htm")
public class CmmdcController {
  
	//prima pagina (in caz apel GET)
  @RequestMapping(method = RequestMethod.GET)
	protected String metodaInitiala(ModelMap modelMap) {
		DouaNumere data=new DouaNumere();
		data.setSm("1");
		data.setSn("1");
		modelMap.addAttribute("command", data);
		return "dataForm";
	}

	//dupa submit (in caz apel POST)
  @RequestMapping(method = RequestMethod.POST)
	//protected ModelAndView metodaDupaSubmit(@Valid @ModelAttribute("command") 
  //DouaNumere data, BindingResult result) {
  protected ModelAndView metodaDupaSubmit(@ModelAttribute("command") 
    DouaNumere data) {
		
		//obiectul result va contine erori in cazul in care datele 
    //introduse in formularul HTML 
		//nu pot fi convertite la tipul campurilor din clasa command DouaNumere
		/*
    if (result.hasErrors()){ 
      return new ModelAndView("dataForm"); 
    }
    */
		CmmdcManager cm=new CmmdcManager();
		cm.setData(data);	
  	
		String myMessage=cm.cmmdcService();
		ModelAndView modelAndView = new ModelAndView("cmmdc");
		modelAndView.addObject("message", myMessage);
		modelAndView.addObject("sm", data.getSm());
		modelAndView.addObject("sn", data.getSn());
		return modelAndView;
	}
}
