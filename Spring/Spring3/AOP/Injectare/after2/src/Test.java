import target.MyMsg;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test{
  public static void main(String[] args){
    String[] paths = { "applicationContext.xml" };
    ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
    
    MyMsg obj = (MyMsg)ctx.getBean("msg");
    obj.getMessage();
  }
}
