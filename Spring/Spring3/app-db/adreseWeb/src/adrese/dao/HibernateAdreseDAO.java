package adrese.dao;
import org.springframework.orm.hibernate3.HibernateTemplate;
import java.util.Collection;

public class HibernateAdreseDAO implements AdreseDAO{
  HibernateTemplate hibernateTemplate;
  
  public Collection getAdrese(){
    return hibernateTemplate.find("from Adrese a order by a.nume");
  }
  
  public void createAdrese(Adrese inreg) {
    hibernateTemplate.saveOrUpdate(inreg);
  }
  
  public void updateAdrese(Adrese inreg) {
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