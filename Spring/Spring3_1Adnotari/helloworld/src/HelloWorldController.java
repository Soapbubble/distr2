package helloworld.web;

import java.io.IOException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	@RequestMapping("/helloworld.htm")
	public ModelAndView handleRequest() {

		String myMessage = "Hello World MVC!";
		String myDate=(new java.util.Date()).toString();
		
		ModelAndView modelAndView = new ModelAndView("hello");
		modelAndView.addObject("message", myMessage);
		modelAndView.addObject("date", myDate);
		return modelAndView;
	}
}
