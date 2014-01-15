import org.apache.axiom.om.*;
import org.apache.axiom.om.impl.builder.*;
import java.util.*;
import javax.xml.stream.*;
import java.io.*;

public class TestOMReceiver {
  public static void analyze(OMElement root){
    Iterator children = root.getChildren();
    while(children.hasNext()){
      OMNode node = (OMNode)children.next();
      int type=node.getType();
      System.out.print(type+" ");
      switch(type){
        case OMNode.ELEMENT_NODE :  // 1
          OMElement elem=(OMElement)node;
          System.out.println(elem.getLocalName());
          analyze(elem);
          break;
        case OMNode.TEXT_NODE :  // 4
          OMText txt=(OMText)node;
          System.out.println(txt.getText());
          break;                      
        default :
           System.out.println("?");
      }
    }          
  }
    
  public static void main(String[] args) {
    String fileName=args[0];
    try {
      FileReader in=new FileReader(fileName);
      //create the parser
      XMLInputFactory inputFactory=XMLInputFactory.newInstance();
      XMLStreamReader parser=inputFactory.createXMLStreamReader(in);     
      StAXOMBuilder builder=new StAXOMBuilder(parser);
      OMElement root = builder.getDocumentElement();
      System.out.println("The name of the root is "+builder.getName());
      analyze(root);
      System.out.println();
      System.out.println(root.toStringWithConsume()); 
    }
    catch (Exception e) {
      System.out.println("Exception : "+e.getMessage());
    }
  }
}
