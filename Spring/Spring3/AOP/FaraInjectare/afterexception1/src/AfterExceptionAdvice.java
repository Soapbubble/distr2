import java.lang.reflect.Method;

import target.MyException;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class AfterExceptionAdvice implements ThrowsAdvice {

  public static void main(String[] args) {  
    // create the proxy
    ProxyFactory pf = new ProxyFactory();
  
    // add advice
    pf.addAdvice(new AfterExceptionAdvice());
  
    // target class
    MyException target = new MyException();
    
    // setTarget
    pf.setTarget(target);
  
    MyException proxy = (MyException) pf.getProxy();
    try{
      proxy.getMessage();
    }
    catch(Exception e){
      System.out.println("Main Exception : "+e.getMessage());
    }
  }
  
  public void afterThrowing(Method method, Object[] args, Object target, 
      Exception ex) throws Throwable{
    System.out.println("Exception Capture : " + ex.getClass().getName());
    System.out.println("Method Capture    : " + method.getName());
  } 
}
