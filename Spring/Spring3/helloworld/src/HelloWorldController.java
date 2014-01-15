package helloworld.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
//import org.springframework.stereotype.Controller;

public class HelloWorldController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException {

		String myMessage = "Hello World MVC!";
		String myDate=(new java.util.Date()).toString();
		
		ModelAndView modelAndView = new ModelAndView("hello");
		modelAndView.addObject("message", myMessage);
		modelAndView.addObject("date", myDate);
		return modelAndView;
	}
}
