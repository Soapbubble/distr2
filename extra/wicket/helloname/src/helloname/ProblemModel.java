package helloname;
public class ProblemModel implements java.io.Serializable{
  private String name="";
  private String answer;
  
  public void setName(String name){
    this.name=name;
  }
  public String getName(){
    return name;
  }
    
  public String getAnswer(){
    return "Hello "+name+" !";
  }
}