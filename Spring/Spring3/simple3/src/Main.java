package hello;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main{
  public static void main(String[] args){
    AnnotationConfigApplicationContext context = 
      new AnnotationConfigApplicationContext(HelloWorldConfig.class);
		//Retrieve the bean from Container
		HelloWorld myBean = (HelloWorld)context.getBean("helloWorld");
		System.out.println(myBean.sayHello());
  }
}
