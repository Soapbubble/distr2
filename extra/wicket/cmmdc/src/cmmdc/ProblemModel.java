package cmmdc;
import java.io.Serializable;
public class ProblemModel implements Serializable{
  private String m="1";
  private String n="1";
  private String result;
  private String scop="CMMDC";
  
  public void setM(String m){
    this.m=m;
  }
  public String getM(){
    return m;
  }
  
  public void setN(String n){
    this.n=n;
  }
  public String getN(){
    return n;
  }
  
  public void setScop(String scop){
    this.scop=scop;
  }
  public String getScop(){
    return scop;
  }
  
  public String getResult(){
    long a=Long.parseLong(m);
    long b=Long.parseLong(n);
    long c=cmmdc(a,b);
    String result="";
    if(scop.equals("CMMDC"))
       result=(new Long(c)).toString();
    else
       result=(new Long(a*b/c)).toString();
    return result;
  }
  
  private long cmmdc(long m, long n){
    long r,c;
    do{
      c=n;
      r=m%n;
      m=n;
      n=r;
    }
    while(r!=0);
    return c;
  } 
    
}