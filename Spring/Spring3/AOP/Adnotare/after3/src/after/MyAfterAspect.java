package after;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyAfterAspect {

  @AfterReturning("execution(* get*(..))")
  public void afterAdvice() {
    System.out.println(", dupa returnarea mesajului.");
  }
}
