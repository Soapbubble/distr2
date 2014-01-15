//import java.net.URL;

//import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
//import javax.xml.soap.SOAPConnection;
//import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPPart;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.Name;
import java.util.Iterator;
import java.io.FileInputStream;
import org.w3c.dom.Node;

public class MsgSOAPReceiver{
  public static void analyze(SOAPElement rootElement){
    Iterator iterator=rootElement.getChildElements();
    while(iterator.hasNext()){
      //SOAPBodyElement element = (SOAPBodyElement) iterator.next();
      SOAPElement element = (SOAPElement) iterator.next();
      short nodeType=element.getNodeType();
      System.out.println(nodeType);     
      Name name=element.getElementName();
      System.out.println("name : "+name.getLocalName());
      System.out.println("value : " + element.getValue());  
      if(nodeType==Node.ENTITY_NODE)analyze(element);
      //if(nodeType!=Node.TEXT_NODE)analyze(element);
    }
  }
 
  public static void main(String[] args) {
    try {
      //SOAPConnectionFactory sfc = SOAPConnectionFactory.newInstance();
      //SOAPConnection connection = sfc.createConnection();
      FileInputStream fis=new FileInputStream("MySOAPMessage.xml");
      
      MessageFactory mf = MessageFactory.newInstance();
      SOAPMessage soapMsg = mf.createMessage(null,fis);
      //QName bodyName = new QName("http://YourSOAPServer.com", "GetQuote", "d");
      //URL endpoint = new URL("http://myEndpoint");
      //SOAPMessage response = connection.call(sm, endpoint);
      SOAPPart part=soapMsg.getSOAPPart();
      SOAPEnvelope envelope=part.getEnvelope();
      SOAPBody body=envelope.getBody(); 
      analyze(body);      
    } 
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}