import target.MyMsg;
import org.springframework.aop.framework.ProxyFactory;

public class AroundAdvice {
  public static void main(String[] args) {  
    // create the proxy
    ProxyFactory pf = new ProxyFactory();
  
    // add advice
    pf.addAdvice(new MethodDecorator());
  
     // target class
    MyMsg target = new MyMsg();
  
    // setTarget
    pf.setTarget(target);
  
    MyMsg proxy = (MyMsg) pf.getProxy();
    proxy.getMessage();
  }
}
