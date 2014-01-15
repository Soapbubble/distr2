package agendae;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import java.io.IOException;
import java.util.Date;
//import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignAgendaeServlet extends HttpServlet {
  //private static final Logger log=Logger.getLogger(SignGuestbookServlet.class.getName());

  public void doGet(HttpServletRequest req,HttpServletResponse res)
      throws IOException {
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();

    String agendae = req.getParameter("agendae");
    Key agendaeKey = KeyFactory.createKey("AgendaE", agendae);
    String name = req.getParameter("name");
    String email = req.getParameter("email");
   
    Entity item = new Entity("AgendaE", agendaeKey);
    item.setProperty("user", user);
    item.setProperty("name", name);
    item.setProperty("email", email);

    DatastoreService datastore =
            DatastoreServiceFactory.getDatastoreService();
    datastore.put(item);

    res.sendRedirect("/agendae.jsp?agendae="+agendae);
  }
  
  public void doPost(HttpServletRequest req,HttpServletResponse res)
      throws IOException {
    doGet(req,res);
  }    
}