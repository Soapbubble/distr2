import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Client{
  public static void main(String args[]){
    Scanner scanner=new Scanner(System.in);
    try{
      System.out.println("Numele");
      String nume=URLEncoder.encode(scanner.next(),"UTF-8");
      String tip=URLEncoder.encode("text/plain","UTF-8");      
      String urlStr="http://localhost:8080/Hello/resources/hello";
      String param="nume="+nume+"&tip="+tip;
      System.out.println(param);
      String rezultat=httpGetText(urlStr,param);
      System.out.println(rezultat);
    }
    catch(Exception e){
      e.printStackTrace();
      System.out.println("ExceptionMessage "+e.getMessage());
    }
    System.out.println();
  }  
    
  public static String httpGetText(String urlStr,String param)throws IOException{
    URL url=new URL(urlStr);
    HttpURLConnection conn=(HttpURLConnection) url.openConnection();
    conn.setRequestMethod("POST");
    conn.setUseCaches(false);
    conn.setDoInput(true);
    conn.setDoOutput(true);
    conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
    PrintWriter pw=new PrintWriter(conn.getOutputStream());   
    pw.println(param);
    pw.flush();
    pw.close();
    if (conn.getResponseCode() != 200) {
      throw new IOException(conn.getResponseMessage());
    }
    
    // Buffer the result into a string
    BufferedReader rd = new BufferedReader(
      new InputStreamReader(conn.getInputStream()));
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = rd.readLine()) != null) {
      sb.append(line+"\n");
    }
    rd.close();
  
    conn.disconnect();
    return sb.toString();
  }
}
