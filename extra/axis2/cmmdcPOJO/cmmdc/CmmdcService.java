package cmmdc;

public class CmmdcService{

  public long getCmmdc(long m,long n) {
    long c,r;
    do{
      c=n;
      r=m % n;
      m=n;
      n=r;
    }
    while (r!=0);
    return c;
  } 
}
