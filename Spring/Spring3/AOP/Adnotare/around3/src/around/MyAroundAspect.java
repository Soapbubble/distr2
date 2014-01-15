package around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyAroundAspect {

  @Around("execution(* get*(..))")
  public Object aroundGreeting(ProceedingJoinPoint pjp) throws Throwable {

    System.out.print("Succes pentru ");
    try {
      return pjp.proceed();
    } finally {
      System.out.println(" Acesta este POA !");
    }

  }
}
