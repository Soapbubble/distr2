import java.net.URLDecoder;
public class TestURLDecoder{
  public static void main(String[] args){
    String cod="text%2Fplain";
    System.out.println(URLDecoder.decode(cod));
  }
}