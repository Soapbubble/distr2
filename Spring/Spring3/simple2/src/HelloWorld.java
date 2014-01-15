package hello;
public class HelloWorld {
  private String message;
  public void setMessage(String message) {
    this.message = message;
  }
  
  public String sayHello() {
    return "Hello! " + message;
  }
}
