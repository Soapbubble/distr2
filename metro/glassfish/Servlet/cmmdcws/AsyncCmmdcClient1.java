package cmmdc.client;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import java.rmi.RemoteException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.xml.ws.BindingProvider;
import com.sun.xml.ws.developer.JAXWSProperties;
import java.util.Scanner;

public class AsyncCmmdcClient1{
  public static void main(String[] args) {
    System.out.println("Invocare asincrona (Polling technique)");
    Scanner scanner=new Scanner(System.in);
    System.out.println("m=");
    long m=scanner.nextLong();
    System.out.println("n=");
    long n=scanner.nextLong();
    
    try{
      CmmdcWS port=new CmmdcWSService().getCmmdcWSPort();
      int timeout = 30000;
      ((BindingProvider)port).getRequestContext().put(JAXWSProperties.REQUEST_TIMEOUT, timeout);
      Response<CmmdcResponse> resp = port.cmmdcAsync(m,n);
        
      while (!resp.isDone()) {
        System.out.println("Fara raspuns. Astept 1 secunda");
        Thread.sleep(1000);
      }
      CmmdcResponse output = resp.get();
      System.out.println("Cmmdc = "+output.getReturn());
    }  
    catch (Exception e) {
      System.out.printf("AnException : "+e.getMessage());
    }
  }
}
