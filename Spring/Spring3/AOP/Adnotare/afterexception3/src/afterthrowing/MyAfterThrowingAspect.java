package afterthrowing;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect 
public class MyAfterThrowingAspect{
  @AfterThrowing("execution(* get*(..))") 
  public void afterException(){
    System.out.println("Exception !");
  }
}
