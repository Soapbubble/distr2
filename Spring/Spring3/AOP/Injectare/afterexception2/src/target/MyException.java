package target;

public class MyException{
  public void getMessage() throws Exception{
    System.out.println("lansez o exceptie...");
    throw new Exception("... acesta este mesajul meu de exceptie");
  }
}
