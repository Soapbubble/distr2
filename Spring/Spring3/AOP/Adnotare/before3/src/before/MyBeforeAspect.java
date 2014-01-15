package before;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyBeforeAspect {

  @Before("execution(* get*(..))")
  public void beforeAdvice() {
    System.out.println("Succes pentru ");
  }
}
