package cmmdc;
import org.apache.axiom.om.*;

public class CmmdcService {
  long cmmdc(long m,long n){
    long r, c;
    do {
      c = n;
      r = m % n;
      m = n;
      n = r;
    }
    while (r != 0);
    return c;
  }
      
  public OMElement calculeazaCmmdc(OMElement in){
    try {
      long m = 0, n = 0;
      in.build();
      
      String parts[] = in.getText().split(",");
      m = Long.parseLong(parts[0]);
      n = Long.parseLong(parts[1]);

      long c=cmmdc(m,n);
      OMFactory factory = OMAbstractFactory.getOMFactory();
      OMNamespace omNs = factory.createOMNamespace("http://cmmdc", "cmmdc");

      OMElement result = factory.createOMElement("result", omNs);
      OMText text = factory.createOMText((new Long(c)).toString());
      result.addChild(text);

      return result;
    } 
    catch (Exception e) {
      System.out.println("Cmmdc service exception : "+e.getMessage());
      return null;
    }
  }
}
