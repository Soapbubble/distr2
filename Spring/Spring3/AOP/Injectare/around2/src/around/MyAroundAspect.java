package around;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAroundAspect{
  public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
    System.out.print("Succes pentru ");
    try {
      return pjp.proceed();
    } 
    finally {
      System.out.println(" Acesta este AOP !");
    }
  }
}
