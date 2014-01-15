package hello;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Main{
  public static void main(String[] args){
    XmlBeanFactory beanFactory = 
      new XmlBeanFactory(new ClassPathResource("HelloWorld.xml"));
		HelloWorld myBean = (HelloWorld) beanFactory.getBean("HelloWorldBean");
		System.out.println(myBean.sayHello());
  }
}
