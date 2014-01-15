package upload;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import java.io.InputStream;
import java.io.File;
import java.io.FileOutputStream;
//import javax.servlet.http.HttpSession;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

public class UploadBean implements java.io.Serializable{
  private UploadedFile uploadedFile;
  private String uploadedFileName;

  public UploadedFile getUploadedFile(){
    return uploadedFile;
  }

  public void setUploadedFile(UploadedFile uploadedFile) {
    this.uploadedFile = uploadedFile;
  }
  
  public String getUploadedFileName(){
    return uploadedFileName;
  }
  
  /*
  private void uploadFile(){
    try{
      FacesContext context = FacesContext.getCurrentInstance();
      String dirPath=
        ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("uploads");
      System.out.println(dirPath);    
      InputStream is = uploadedFile.getInputStream();
      long fileSize = uploadedFile.getSize();
      byte[] buffer = new byte[(int)fileSize];
      is.read(buffer,0,(int)fileSize);
      is.close();      
      File f = new File(uploadedFile.getName());       
      String g = uploadedFile.getName();     
      String fs=System.getProperty("file.separator");      
      int i  = g.lastIndexOf(fs);
      uploadedFileName = g.substring(i+1);
      System.out.println(uploadedFileName);
      File file = new File(dirPath+fs+uploadedFileName); 
      FileOutputStream fop=new FileOutputStream(file);      
      fop.write(buffer);
      fop.flush();
      fop.close();
      System.out.println("Informatia a fost scrisa");
    }
    catch (Exception e) {
       System.out.println("Upload Exception : "+e.getMessage()); 
       uploadedFileName="";
    }
  }
  */
  
  public String uploadFile(){
    try {
      FacesContext context = FacesContext.getCurrentInstance();     
      String dirPath=
        ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("uploads");    
      System.out.println(dirPath);
      InputStream is = uploadedFile.getInputStream();
      long fileSize = uploadedFile.getSize();
      byte [] buffer = new byte[(int)fileSize];
      is.read(buffer,0,(int)fileSize);
      is.close();    
      File file = new File(uploadedFile.getName());   
      String fileName=uploadedFile.getName();
      String fs=System.getProperty("file.separator");  
      int i=fileName.lastIndexOf(fs);
      uploadedFileName=fileName.substring(i+1);
      File outputFile = new File(dirPath+fs+uploadedFileName);
      FileOutputStream fos=new FileOutputStream(outputFile);      
      fos.write(buffer);
      fos.flush();
      fos.close();
      System.out.println("Informatia a fost scrisa");
      return "OK";
    } 
    catch (Exception e) {
      System.out.println("Upload Exception : "+e.getMessage()); 
    }
    return "ERROR";      
  }
}