package adrese.dao;
import java.util.Collection;

public interface AdreseDAO {
  public void createAdrese(Adrese inreg);
  public void updateAdrese(Adrese inreg);
  public void deleteAdrese(Adrese inreg);
  public Adrese getAdreseById(int inregId);
  public Collection getAdreseByName(String nume);
  public Collection getAdreseByEmail(String email);
  public Collection getAdrese();
}
