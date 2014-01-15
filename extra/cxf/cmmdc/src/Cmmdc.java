package server.cmmdc;
import javax.jws.WebService;

@WebService
public interface Cmmdc{
    long cmmdc(long m,long n);
}
