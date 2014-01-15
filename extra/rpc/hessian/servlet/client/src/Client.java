package hessianclient;
import com.caucho.hessian.client.HessianProxyFactory;
import hessianapp.MyService;
import java.util.Scanner;

public class Client{

  public static void main(String[] args) throws Exception {
    String url = "http://localhost:8080/hessian/hessianservice";
    HessianProxyFactory factory = new HessianProxyFactory();
    MyService myService = (MyService) factory.create(MyService.class, url);

    Scanner scanner=new Scanner(System.in);
    System.out.println("Introduceti numele:");
    String nume=scanner.next();
    System.out.println("Raspuns : "+myService.sayHello(nume));
    System.out.println("m=");
    long m=scanner.nextLong();
    System.out.println("n=");
    long n=scanner.nextLong();
    System.out.println("Raspuns : "+myService.cmmdc(m,n));
  }
}