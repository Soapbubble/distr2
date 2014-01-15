package xmlrpcserver;

public class MyService{
  public long cmmdc(long m,long n){
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

  /*
  public String sayHello(String str) {
      return "Hi " + str+" !";
  }
  */
}
