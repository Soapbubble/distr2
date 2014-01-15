package adrese.dao;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import java.util.Collection;

public class HibernateAdreseDAO extends HibernateDaoSupport 
   implements AdreseDAO{
  
  public Adrese getAdreseById(int inregId) {
    return (Adrese)getHibernateTemplate().get(Adrese.class,new Integer(inregId));
  }
  
  public Collection getAdrese(){
    return getHibernateTemplate().find("from Adrese a order by a.nume");
  }
  
  public Collection getAdreseByName(String nume) {
    return getHibernateTemplate().find("from Adrese a where a.nume like ?", nume + "%");
  }
  
  public Collection getAdreseByEmail(String email) {
    return getHibernateTemplate().find("from Adrese a where a.email like ?", email + "%");
  }
  
  public void createAdrese(Adrese inreg){
    getHibernateTemplate().saveOrUpdate(inreg);
  }
  
  public void updateAdrese(Adrese inreg){
    getHibernateTemplate().saveOrUpdate(inreg);
  }
  
  public void deleteAdrese(Adrese inreg){
    getHibernateTemplate().delete(inreg);
  }
}
