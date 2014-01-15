import org.apache.axiom.om.*;
import javax.xml.stream.*;
import java.io.*;

public class TestOMSender {

    public static void main(String[] args) {
        try {
            OMFactory factory = OMAbstractFactory.getOMFactory();

            OMNamespace myNs = factory.createOMNamespace("http://distribuit", "distr");
			      OMElement root=factory.createOMElement("discipline",myNs);
            
            OMElement disciplina = factory.createOMElement("disciplina", myNs);
            
			      OMText an = factory.createOMText("Analiza Numerica");
			      disciplina.addChild(an);
            OMElement fondTimp= factory.createOMElement("fond-timp",myNs);
            
            OMElement curs=factory.createOMElement("curs",myNs);
            OMText oreCurs = factory.createOMText("2");
            curs.addChild(oreCurs);
            fondTimp.addChild(curs);
            
            OMElement seminar=factory.createOMElement("seminar",myNs);
            OMText oreSeminar = factory.createOMText("1");
            seminar.addChild(oreSeminar);
            fondTimp.addChild(seminar);
            
            OMElement laborator=factory.createOMElement("laborator",myNs);
            OMText oreLaborator = factory.createOMText("1");
            laborator.addChild(oreLaborator);
            fondTimp.addChild(laborator);
            
            disciplina.addChild(fondTimp);
            
            OMAttribute fel=factory.createOMAttribute("fel",myNs,"obligatoriu");
            disciplina.addAttribute(fel);
            
            root.addChild(disciplina);
            
            File f=new File("disc.xml");
            OutputStream out=new FileOutputStream(f);
            XMLOutputFactory outputFactory=XMLOutputFactory.newInstance();
            XMLStreamWriter writer =outputFactory.createXMLStreamWriter(out);
            root.serialize(writer); 
            
            writer.flush();
            out.close();
            System.out.println(root.toStringWithConsume()); 

        }
        catch (Exception e) {
          System.out.println("Exception : "+e.getMessage());
        } 
    }
}
