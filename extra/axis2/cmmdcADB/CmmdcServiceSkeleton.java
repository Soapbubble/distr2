
/**
 * CmmdcServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */
    package cmmdc;
    /**
     *  CmmdcServiceSkeleton java skeleton for the axisService
     */
    public class CmmdcServiceSkeleton implements CmmdcServiceSkeletonInterface{
        
       public long cmmdc(long m,long n) {
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
  
        /**
         * Auto generated method signature
         * 
                                     * @param getCmmdc0
         */
        
                 public cmmdc.xsd.GetCmmdcResponse getCmmdc
                  (
                  cmmdc.xsd.GetCmmdc getCmmdc0
                  )
            {
                //TODO : fill this with the necessary business logic
                /*
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#getCmmdc");
                */
        long m=getCmmdc0.getParam0();
        long n=getCmmdc0.getParam1();
        long c=cmmdc(m,n);
        cmmdc.xsd.GetCmmdcResponse res=new cmmdc.xsd.GetCmmdcResponse();
        res.set_return(c);
        return res;      
        }
     
    }
    