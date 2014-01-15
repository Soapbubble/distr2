package cmmdc.client;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import java.rmi.RemoteException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.xml.ws.BindingProvider;
import com.sun.xml.ws.developer.JAXWSProperties;
import java.util.Scanner;

public class AsyncCmmdcClient2 {
  static private CmmdcWS port;

  public static void main(String[] args) {
    System.out.println("Invocare asincrona (Callback technique)");
    Scanner scanner=new Scanner(System.in);
    System.out.println("m=");
    long m=scanner.nextLong();
    System.out.println("n=");
    long n=scanner.nextLong();
    try{
      port=new CmmdcWSService().getCmmdcWSPort();
      CmmdcCallbackHandler callbackHandler = new CmmdcCallbackHandler();
      Future<?> response = port.cmmdcAsync(m,n,callbackHandler);

      Thread.sleep(5000);
      if(response.isDone()) {
        CmmdcResponse output = callbackHandler.getResponse();
        System.out.println("Cmmdc = "+output.getReturn());
      } 
      else{
        System.out.println("Fara raspuns dupa 5 secunde");
      }       
    }
    catch (Exception e) {
      System.out.printf("AnException : "+e.getMessage());
    }
  }    

  /**
   * Async callback handler
   */
  private static class CmmdcCallbackHandler implements AsyncHandler<CmmdcResponse> {
    private CmmdcResponse output;

    /*
    * @see javax.xml.ws.AsyncHandler#handleResponse(javax.xml.ws.Response)
    */
    public void handleResponse(Response<CmmdcResponse> response) {
      System.out.println("Received Response from the service");
      try {
        output = response.get();
      } 
      catch (ExecutionException e) {
        e.printStackTrace();
      } 
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    
    CmmdcResponse getResponse() {
      return output;
    }
  }
}
