package judete.model;

public class Judet{
  private String nume="";
  private String capitala="";
  private String abreviere="";   
  
  public void setNume(String nume){
    this.nume=nume;
  } 
  public String getNume(){
    return nume;
  }
  
  public void setAbreviere(String abreviere){
    this.abreviere=abreviere;
  }
  public String getAbreviere(){
    return abreviere;
  }
  
  public void setCapitala(String capitala){
    this.capitala=capitala;
  }
  public String getCapitala(){
    return capitala;
  }
}  
