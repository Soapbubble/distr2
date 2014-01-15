import java.lang.reflect.Method;

import target.MyMsg;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class AfterAdvice implements AfterReturningAdvice {

  public static void main(String[] args) {  
    // create the proxy
    ProxyFactory pf = new ProxyFactory();
  
    // add advice
    pf.addAdvice(new AfterAdvice());
  
    // target class
    MyMsg target = new MyMsg();
    
    // setTarget
    pf.setTarget(target);
  
    MyMsg proxy = (MyMsg) pf.getProxy();
    proxy.getMessage();
  }
  
  public void afterReturning(Object returnValue,Method method,Object[] args,Object target) 
     throws Throwable{
    System.out.println(", dupa returnarea mesajului.");
  }
}
