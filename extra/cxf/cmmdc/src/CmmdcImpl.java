package server.cmmdc;
import javax.jws.WebService;

@WebService(endpointInterface = "server.cmmdc.Cmmdc",serviceName = "CmmdcService")
public class CmmdcImpl implements Cmmdc{
  public long cmmdc(long m, long n) {
    System.out.println(m+" "+n);
    long c,r;
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
