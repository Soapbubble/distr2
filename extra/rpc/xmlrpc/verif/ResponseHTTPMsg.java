import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ResponseHTTPMsg{
  public static void main(String[] args){
    String reqPOST="POST / HTTP/1.1\r\n"+
    "Content-Type: text/xml\r\n"+
    "User-Agent: Apache XML RPC 3.1.3 (Sun HTTP Transport)\r\n"+
    "Cache-Control: no-cache\r\n"+
    "Pragma: no-cache\r\n"+
    "Host: localhost:9090\r\n"+
    "Accept: text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2\r\n"+
    "Connection: keep-alive\r\n"+
    "Content-Length: 275\r\n"+
    "\r\n"+
    "<?xml version=\"1.0\" encoding=\"UTF-8\"?><methodCall xmlns:ex=\"http://ws.apache.org/xmlrpc/namespaces/extensions\"><methodName>MyService.cmmdc</methodName><params><param><value><ex:i8>56</ex:i8></value></param><param><value><ex:i8>48</ex:i8></value></param></params></methodCall>\n\r";

    
    try(
      Socket socket=new Socket("localhost",8080);
      InputStreamReader isr=new InputStreamReader(socket.getInputStream());
      BufferedReader br=new BufferedReader(isr);
      FileWriter fw=new FileWriter("output.txt",true);
      BufferedWriter bw=new BufferedWriter(fw);
      PrintWriter pw=new PrintWriter(socket.getOutputStream(),true)
    ){
      pw.println(reqPOST);
      for(;;){
        String s=br.readLine();
        if(s==null)break;
        System.out.println(s);
        bw.write(s);
        bw.newLine();
      }  
    }
    catch(Exception e){
      System.out.println("Exception : "+e.getMessage());
    }
   
  }
}
