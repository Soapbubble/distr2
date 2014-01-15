package helloname.service;
import helloname.model.Nume;

public class NumeManager{
  private Nume name=null;
  
  public void setName(Nume name){
    this.name=name;
  }
  
  public String sayHello(){
    return "Hi "+name.getNume();
  }
}  
  