import java.lang.reflect.Method;

import target.MyMsg;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class BeforeAdvice implements MethodBeforeAdvice {
  public static void main(String[] args) {
    // create the proxy
    ProxyFactory pf = new ProxyFactory();
  
    // add advice
    pf.addAdvice(new BeforeAdvice());
  
    // target class
    MyMsg target = new MyMsg();
    
    // setTarget
    pf.setTarget(target);
  
    MyMsg proxy = (MyMsg) pf.getProxy();
    proxy.getMessage();
  }
  
  public void before(Method method, Object[] args, Object target) 
      throws Throwable{
    System.out.println("Succes pentru");
  }
}
