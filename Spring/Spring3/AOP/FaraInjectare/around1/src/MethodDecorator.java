import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MethodDecorator implements MethodInterceptor {  
  public Object invoke(MethodInvocation invocation) throws Throwable {
    System.out.println("Succes pentru ");
    Object retVal = invocation.proceed();
    System.out.println(" Acesta este AOP !");
    return retVal;
  }
}
