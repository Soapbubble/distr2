package cmmdc.client;
//import java.util.Scanner;

public class CmmdcClient {
  public static void main(String[] args) {
    try {
      CmmdcWSService service=new CmmdcWSService();
      CmmdcWSServicePortType port=service.getCmmdcWSServiceHttpSoap12Endpoint();
      /*
      Scanner scanner=new Scanner(System.in);
      System.out.println("m=");
      long m=scanner.nextLong();
      System.out.println("n=");
      long n=scanner.nextLong();
      */
      long m=Long.parseLong(args[0]);
      long n=Long.parseLong(args[1]);
      long result=port.cmmdc(m,n);
      System.out.println("Cmmdc="+result);
    }
    catch (Exception e) {
      System.out.printf("AnException : "+e.getMessage());
    }
  }
}
