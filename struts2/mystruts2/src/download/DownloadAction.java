package download;
import javax.servlet.ServletContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Result;
import org.apache.struts2.dispatcher.StreamResult; 
import com.opensymphony.xwork2.ActionContext; 
import org.apache.struts2.ServletActionContext;
import java.io.InputStream;

public class DownloadAction extends ActionSupport{
  private String file;
  public void setFile(String file) {
    this.file=file;
  }
  
  public InputStream getInputStream() throws Exception {             
    // Setarea ContentDisposition are ca efect afisarea numelui 
    // fisierului in fereastra de dialog de descarcare
    ServletContext servletContext = 
      ServletActionContext.getServletContext();
    Result result = 
      ActionContext.getContext().getActionInvocation().getResult();
    if (result!=null && result instanceof StreamResult){
      StreamResult streamResult = (StreamResult) result;
      streamResult.setContentDisposition("attachment;filename="+file);
    } 
    return servletContext.getResourceAsStream("resources/"+file);
  }
}
