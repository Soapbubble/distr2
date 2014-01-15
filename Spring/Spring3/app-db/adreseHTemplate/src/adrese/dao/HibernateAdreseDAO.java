package adrese.dao;
import org.springframework.orm.hibernate3.HibernateTemplate;
import java.util.Collection;

public class HibernateAdreseDAO implements AdreseDAO{
  HibernateTemplate hibernateTemplate;
  
  public Adrese getAdreseById(int inregId) {
    return (Adrese)hibernateTemplate.get(Adrese.class, new Integer(inregId));
  }
  
  public Collection getAdrese(){
    return hibernateTemplate.find("from Adrese a order by a.nume");
  }
  
  public Collection getAdreseByName(String nume) {
    return hibernateTemplate.find("from Adrese a where a.nume =\'"+ nume+"\'");
  }
  
  public Collection getAdreseByEmail(String email) {
    return hibernateTemplate.find("from Adrese a where a.email =\'"+ email+"\'");
  }
  
  public void createAdrese(Adrese inreg) {
    hibernateTemplate.saveOrUpdate(inreg);
  }
  
  public void updateAdrese(Adrese inreg){
    hibernateTemplate.saveOrUpdate(inreg);
  }
  
  public void deleteAdrese(Adrese inreg) {
    hibernateTemplate.delete(inreg);
  }
  /*
  public HibernateTemplate getHibernateTemplate() {
    return hibernateTemplate;
  }
  */
  public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
    this.hibernateTemplate = hibernateTemplate;
  }
}