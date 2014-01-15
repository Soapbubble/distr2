package actions;
import java.io.*;
import javax.servlet.ServletContext;
//import org.apache.struts2.util.ServletContextAware;
//import com.opensymphony.xwork2.ActionSupport;
//import com.opensymphony.xwork2.Result;
import org.apache.struts2.dispatcher.StreamResult; 
import com.opensymphony.xwork2.ActionContext; 
import org.apache.struts2.ServletActionContext;

import org.apache.struts2.convention.annotation.Result;
//import org.apache.struts2.convention.annotation.Results;

@Result(name="success",type="stream", params={"inputName","inputStream","bufferSize","2048","contentType","application/octet-stream"})


public class DownloadAction{// extends ActionSupport implements ServletContextAware{
  private String file;
  //private ServletContext servletContext;
  private InputStream inputStream;
  
  /*
  public void setServletContext(ServletContext servletContext){
    this.servletContext = servletContext;
  }
  */
  public void setFile(String file) {
    //System.out.println(file);
    this.file=file;
  }
  
  public String execute() throws Exception{
    ServletContext servletContext = 
      ServletActionContext.getServletContext();  
    //try{  
    /*
      com.opensymphony.xwork2.Result result = 
        ActionContext.getContext().getActionInvocation().getResult();
      // Setarea ContentDisposition are ca efect afisarea numelui 
      // fisierului in fereastra de dialog de descarcare
      if (result!=null && result instanceof StreamResult){  
        StreamResult streamResult = (StreamResult) result;
        streamResult.setContentDisposition("attachment;filename="+file);
      }
     */      
      inputStream=servletContext.getResourceAsStream("resources/"+file);
      return "success";
    /*
    }
    catch(Exception e){
      System.out.println("DownloadException : "+e.getMessage());
      return("success");
    }
    */
  }
 
  public InputStream getInputStream(){     
    /*
    ServletContext servletContext = 
      ServletActionContext.getServletContext();  
    // Setarea ContentDisposition are ca efect afisarea numelui 
    // fisierului in fereastra de dialog de descarcare
    com.opensymphony.xwork2.Result result = 
      ActionContext.getContext().getActionInvocation().getResult();
    if (result!=null && result instanceof StreamResult){
      StreamResult streamResult = (StreamResult) result;
      streamResult.setContentDisposition("attachment;filename="+file);
    } 
    return servletContext.getResourceAsStream("resources/"+file);
    */
    return inputStream;
  }
  
  /*
  public void setInputStream(InputStream inputStream){
    this.inputStream=inputStream;
  }
  */
}
