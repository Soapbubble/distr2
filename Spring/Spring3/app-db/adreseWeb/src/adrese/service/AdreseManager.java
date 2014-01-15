package adrese.service;
import adrese.model.AppData;
import adrese.dao.*;
import java.util.*;

public class AdreseManager{
  private AdreseDAO dao=null;
  private List<Adrese> list=null;
  private AppData data;
  private String msg;
  
  public void setDao(AdreseDAO dao){
    this.dao=dao;
  }
  
  public void setData(AppData data){
    this.data=data;
  }
 
  public AppData getData(){
    return data;
  }
  
  public void executeSQL(){
    System.out.println(data.getSid()+":"+data.getNume()+":"+data.getEmail()+":"+data.getOperatia());
    String operatia=data.getOperatia();
    int prel=0;
    if(operatia.equals("Creare")) prel=1;
    if(operatia.equals("Stergere")) prel=2;
    if(operatia.equals("Actualizare")) prel=3;
    if(operatia.equals("Lista inregistrarilor")) prel=4;
    Adrese entity;
    int id;
    String nume,email;
    switch(prel){
      case 1:
        list=null;
        entity=new Adrese();
        entity.setNume(data.getNume());
        entity.setEmail(data.getEmail());
        try{
          dao.createAdrese(entity);
          msg="Operatia a fost executata cu succes !";
        }
        catch(Exception e){
          msg="Exceptie : "+e.getMessage();
        }
        break;
      case 2:
        list=null;
        id=Integer.parseInt(data.getSid());
        entity=new Adrese();
        entity.setId(id);
        try{
          dao.deleteAdrese(entity);         
          msg="Operatia a fost executata cu succes !";
        }
        catch(Exception e){
          msg="Exceptie : "+e.getMessage();
        }
        break;
      case 3:
        list=null;
        entity=new Adrese();
        entity.setNume(data.getNume());
        entity.setEmail(data.getEmail());
        entity.setId(Integer.parseInt(data.getSid()));
        try{
          dao.updateAdrese(entity);
          msg="Operatia a fost executata cu succes !";
        }
        catch(Exception e){
          msg="Exceptie : "+e.getMessage();
        }
        break; 
      case 4:
        try{
          list=(List<Adrese>)dao.getAdrese(); 
          msg="Operatia a fost executata cu succes !";  
          /*
           Iterator<Adrese> iter=list.iterator();
              while(iter.hasNext()){
                entity=(Adrese)iter.next();
                System.out.println(entity.getId()+" : "+entity.getNume()+" : "+entity.getEmail());
              }
          */
        }
        catch(Exception e){
          msg="Exceptie : "+e.getMessage();
        }
        break;   
    }
  }
  
  public List<Adrese> getList(){
    return list;
  }
  
  public String getMsg(){
    return msg;
  }
  
  public Adrese getAdreseById(int id){
    List<Adrese> lst=(List<Adrese>)dao.getAdrese();
    Iterator<Adrese> iter=lst.iterator();
    Adrese entity,myEntity=null;
    while(iter.hasNext()){
      entity=iter.next();
     //System.out.println("itt "+entity.getId());
      if(entity.getId()==id){
        myEntity=entity;
        break;
      }
    }
    return myEntity;
  }
}  
  