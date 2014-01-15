package adrese.dao;
import java.util.Collection;

public interface AdreseDAO {
  public void createAdrese(Adrese inreg);
  public void deleteAdrese(Adrese inreg);
  public void updateAdrese(Adrese inreg);
  public Collection getAdrese();
}
