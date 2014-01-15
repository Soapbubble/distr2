package adrese;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

import adrese.dao.*;
public class DAOClient {
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    AdreseDAO dao = (AdreseDAO)ctx.getBean("adreseDao");
    Adrese inreg = new Adrese();
    
    String ch="Y";
    int prel,id;
    String nume,email;
    Adrese entity=null;
    Collection rez=null;
    
    Scanner scanner=new Scanner(System.in);
    while(ch.startsWith("Y")){
      do{
         System.out.println("Continue ? (Y/N)");
         ch=scanner.next().toUpperCase();
      }
      while((!ch.startsWith("Y"))&&(!ch.startsWith("N")));
      if(ch.startsWith("Y")){
        System.out.println("Natura prelucrarii ?");
        System.out.println("Adaugare                     : 1 ");
        System.out.println("Actualizare                  : 2 ");
        System.out.println("Stergere                     : 3 ");
        System.out.println("Cautare dupa cheie)          : 4 ");       
        System.out.println("Cautare dupa Nume            : 5 ");
        System.out.println("Cautare dupa Email           : 6 ");
        System.out.println("Lista inregistrarilor        : 7 ");
        prel=scanner.nextInt();
        
        switch(prel){
          case 1 :
            System.out.println("ADAUGARE");
            System.out.println("Numele:");
            nume=scanner.next().trim();
            System.out.println("Adresa e-mail:");
            email=scanner.next().trim();
            entity=new Adrese();
            entity.setNume(nume);
            entity.setEmail(email);
            try{
              dao.createAdrese(entity);
              System.out.println("Operatia a fost executata cu succes !");
            }
            catch(Exception e){
              System.out.println("Exceptie : "+e.getMessage());
            }
            break;
          case 2 :
            System.out.println("ACTUALIZARE");
            System.out.println("Id");
            id=scanner.nextInt();
            System.out.println("Numele:");
            nume=scanner.next().trim();
            System.out.println("Adresa e-mail:");
            email=scanner.next().trim();
            entity=new Adrese();
            if(id!=0) entity.setId(id);
            entity.setNume(nume);
            entity.setEmail(email);
            try{
              dao.createAdrese(entity);
              System.out.println("Operatia a fost executata cu succes !");
            }
            catch(Exception e){
              System.out.println("Exceptie : "+e.getMessage());
            }
            break;
          case 3 :
            System.out.println("STERGERE");
            System.out.println("Id:");
            id=scanner.nextInt();
            entity=new Adrese();
            entity.setId(id);           
            try{
              dao.deleteAdrese(entity);         
              System.out.println("Operatia a fost executata cu succes !");
            }
            catch(Exception e){
              System.out.println("Exceptie : "+e.getMessage());
            }
            break; 
          case 4 :
            System.out.println("CAUTARE DUPA CHEIE");
            System.out.println("Id:");
            id=scanner.nextInt();
            try{
              entity=dao.getAdreseById(id);  
              if(entity!=null){
                System.out.println(entity.getId()+" : "+entity.getNume()+" : "+entity.getEmail());
              }
              else{
                System.out.println("Inregistrare absenta");
              }
            }
            catch(Exception e){
              System.out.println("Exceptie : "+e.getMessage());
            }
            break;
          case 5 :
            System.out.println("CAUTARE DUPE NUME");
            System.out.println("Numele");
            nume=scanner.next().trim();
            try{
              rez=dao.getAdreseByName(nume);  
              Iterator<Adrese> iter=rez.iterator();
              while(iter.hasNext()){
                entity=(Adrese)iter.next();
                System.out.println(entity.getId()+" : "+entity.getNume()+" : "+entity.getEmail());
              }
            }
            catch(Exception e){
              System.out.println("Exceptie : "+e.getMessage());
            }
            break;
          case 6 :
            System.out.println("CAUTARE DUPE EMAIL");
            System.out.println("Adresa de Email");
            email=scanner.next().trim();
            try{
              rez=dao.getAdreseByEmail(email);  
              Iterator<Adrese> iter=rez.iterator();
              while(iter.hasNext()){
                entity=(Adrese)iter.next();
                System.out.println(entity.getId()+" : "+entity.getNume()+" : "+entity.getEmail());
              }
            }
            catch(Exception e){
              System.out.println("Exceptie : "+e.getMessage());
            }
            break;    
          case 7 :
            System.out.println("Lista");
            try{
              rez=dao.getAdrese();  
              Iterator<Adrese> iter=rez.iterator();
              while(iter.hasNext()){
                entity=(Adrese)iter.next();
                System.out.println(entity.getId()+" : "+entity.getNume()+" : "+entity.getEmail());
              }
            }
            catch(Exception e){
              System.out.println("Exceptie : "+e.getMessage());
            }
            break;                     
          default: System.out.println("Comanda eronata");
        }
      }
      else
        System.exit(0);
    }
  }
}
