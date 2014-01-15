package client;
import java.net.*;
import java.io.*;
import java.awt.Image;
import java.awt.Toolkit;

public class MyImageClient{
  public static void main(String args[]){
    if(args.length==0){
      System.out.println("Usage: java MyImageClient URI");
      System.exit(1);
    }
    String baseURI=args[0];
    try{
      Image image=httpGetImage(baseURI+"/jpg");
      ShowImage s=new ShowImage(image);
      s.show();
    }
    catch(Exception e){
      System.out.println("Exception message : "+e.getMessage());
    }
  }
    
  public static Image httpGetImage(String urlStr) throws IOException {
    URL url=new URL(urlStr);
    Image image=Toolkit.getDefaultToolkit().getImage(url);
    return image;
  }
}
