package adrese.model;

public class AppData{
  private String sid="";
  private String nume="";
  private String email="";
  private String operatia="";
  
  public void setSid(String sid){
    this.sid=sid;
  }
  public String getSid(){
    return sid;
  }
  
  public void setNume(String nume){
    this.nume=nume;
  }
  public String getNume(){
    return nume;
  }
  
  public void setEmail(String email){
    this.email=email;
  }
  public String getEmail(){
    return email;
  }
  
   public void setOperatia(String operatia){
    this.operatia=operatia;
  }
  public String getOperatia(){
    return operatia;
  }
}  
