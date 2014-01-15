package adrese.dao;
import java.io.Serializable;

public class Adrese implements Serializable{
  private int id;
  private String nume;
  private String email;
  
  public Adrese(){}
  
  public String getNume() {
    return nume;
  }
  public void setNume(String nume) {
    this.nume = nume;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
}
