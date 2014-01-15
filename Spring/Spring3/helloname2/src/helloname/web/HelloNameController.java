package helloname.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import helloname.service.NumeManager;

public class HelloNameController implements Controller {
  private NumeManager nm;
  
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException {
    
    //NumeManager nm=new NumeManager();
		String myMessage = nm.sayHello();
		String myDate=(new java.util.Date()).toString();
		
		ModelAndView modelAndView = new ModelAndView("hello");
		modelAndView.addObject("message", myMessage);
		modelAndView.addObject("date", myDate);
		return modelAndView;
	}
	
	public void setNm(NumeManager nm){
  	this.nm=nm;
	}
	
}
