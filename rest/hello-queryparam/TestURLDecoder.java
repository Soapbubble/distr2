import java.net.URLDecoder;
public class TestURLDecoder{
  public static void main(String[] args){
    String cod="text%2Fplain";
	try{
      System.out.println(URLDecoder.decode(cod,"UTF-8"));
	}
    catch(Exception e){
	  System.out.println(e.getMessage());
    }	
  }
}