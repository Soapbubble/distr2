package helloname;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.markup.html.form.Form; 
//import org.apache.wicket.markup.html.form.DropDownChoice;
//import org.apache.wicket.markup.html.form.ListChoice;
//import org.apache.wicket.markup.html.form.ChoiceRenderer; 
//import org.apache.wicket.model.PropertyModel; 

//import java.util.*;
public class HelloName extends Form{
  
  public HelloName(String id) {
    super(id);
    ProblemModel pm=new ProblemModel();
    CompoundPropertyModel cpm=new CompoundPropertyModel(pm);
    setModel(cpm);
    add(new TextField("name"));
    //add(new TextField("answer"));
  }   

  @Override 
  protected void onSubmit(){
    ProblemModel pm=(ProblemModel)getModelObject();
    //setResponsePage(new OutputPage(pm));
    info(pm.getAnswer());
  }  
}
