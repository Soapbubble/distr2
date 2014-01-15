package judete.service;
import judete.model.Judet;
import java.util.*;
import java.io.*;

public class JudeteManager{
  private HashMap<String,Judet> refJudete=null;
  private List<String> lstJud=null;
  
  JudeteManager(){
    refJudete=new HashMap<String,Judet>();
    lstJud=new LinkedList<String>(); 
    try{
      InputStream is=new FileInputStream("/JavaApp/apache-tomcat-7.0.23/webapps/judete/judete.txt");
      InputStreamReader isr=new InputStreamReader(is);
      BufferedReader br=new BufferedReader(isr);
      String s="";
      do{
        s=br.readLine();
        String[] ts=s.split(" ");
        Judet jud=new Judet();
        jud.setNume(ts[0]);
        jud.setCapitala(ts[1]);
        jud.setAbreviere(ts[2]);
        refJudete.put(ts[0],jud);
        lstJud.add(ts[0]);
        System.out.println(ts[0]+" "+ts[1]+" "+ts[2]);
      }
      while(s!=null);
      br.close();
      isr.close();
      is.close();
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
  
  public HashMap<String,Judet> getRefJudete(){
    return refJudete;
  } 
  
  public List<String> getLstJud(){
    return lstJud;
  }
}  
  