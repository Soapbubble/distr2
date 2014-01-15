package cmmdc.model;

//import org.hibernate.validator.constraints.NotEmpty;
//import javax.validation.constraints.Min;

public class DouaNumere{

  //@NotEmpty(message= "Camp necompletat")
  //@Min(value=1, message="Nu este numar")
  private String sm="";

  //@NotEmpty(message= "Camp necompletat")
  //@Min(value=1, message="Nu este numar")
  private String sn="";
  
  public void setSm(String sm){
    this.sm=sm;
  }
  
  public String getSm(){
    return sm;
  }
  
  public void setSn(String sn){
    this.sn=sn;
  }
  
  public String getSn(){
    return sn;
  }
}  
