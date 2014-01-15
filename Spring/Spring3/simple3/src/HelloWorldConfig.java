package hello;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfig {
  public @Bean HelloWorld helloWorld(){
    HelloWorld bean=new HelloWorld();
    bean.setMessage("Cum va place Spring3?");
    return bean;
  }
}
