import java.net.*;
import java.io.*;

public class  ReadHTTP{
  public static void main(String[] args){
    try{
      String adr="http://localhost:8080/myrestlet/html";
      URL url=new URL(adr);
      InputStream in=url.openStream();
      InputStreamReader isr=new InputStreamReader(in);
      BufferedReader br=new BufferedReader(isr);
      String s;
      do{
        s=br.readLine();
        if(s!=null)
          System.out.println(s);
      }
      while(s!=null);
      br.close();
      isr.close();
      in.close();
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
}
