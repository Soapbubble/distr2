package cmmdc.service;
import cmmdc.model.DouaNumere;

public class CmmdcManager{
  private DouaNumere data=null;
  
  public void setData(DouaNumere data){
    this.data=data;
  }
  
  public String cmmdcService(){
    long m=Long.parseLong(data.getSm());
    long n=Long.parseLong(data.getSn());
    return (new Long(cmmdc(m,n))).toString();
  }
  
  private long cmmdc(long m,long n){
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
  