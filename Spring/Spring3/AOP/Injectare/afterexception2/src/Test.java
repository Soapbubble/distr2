import target.MyException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test{
  public static void main(String[] args){
    String[] paths = { "applicationContext.xml" };
    ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
    
    MyException obj = (MyException)ctx.getBean("msg");
    try{
      obj.getMessage();
    }
    catch(Exception e){
      System.out.println("Main Exception : "+e.getMessage());
    }
  }
}
