package client.cmmdc;

import java.util.*;


public class ADBClient {
    static long m = 1;
    static long n = 1;

    public static void main(java.lang.String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Primul numar:");
        m = Long.parseLong(scanner.next());
        System.out.println("Al doilea numar:");
        n = Long.parseLong(scanner.next());

        try {
            CmmdcServiceStub stub = new CmmdcServiceStub();
            System.out.println("Cmmdc=" + getCmmdc(stub));
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("\n\n\n");
        }
    }

    public static long getCmmdc(CmmdcServiceStub stub) {
        long cmmdc = 0;

        try {
            CmmdcServiceStub.GetCmmdc req = new CmmdcServiceStub.GetCmmdc();

            req.setParam0(m);
            req.setParam1(n);

            CmmdcServiceStub.GetCmmdcResponse res = stub.getCmmdc(req);
            cmmdc = res.get_return();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("\n\n\n");
        }

        return cmmdc;
    }
}
