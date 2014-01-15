package cmmdc;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.markup.html.form.Form; 
//import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.ListChoice;
//import org.apache.wicket.markup.html.form.ChoiceRenderer; 
import org.apache.wicket.model.PropertyModel; 

import java.util.*;
public class InputForm extends Form{
  
  public InputForm(String id) {
    super(id);
    ProblemModel pm=new ProblemModel();
    CompoundPropertyModel cpm=new CompoundPropertyModel(pm);
    setModel(cpm);
    List<String> options=Arrays.asList(new String[]{"CMMDC","CMMMC"});
    ListChoice choice=new ListChoice("scop",options);
    choice.setMaxRows(2);
    /*
    List<ScopType> options=Arrays.asList(new ScopType[]{
       new ScopType("CMMDC"),new ScopType("CMMMC")});
    DropDownChoice choice=new DropDownChoice("scop",
      new PropertyModel(pm,"scop"),
      options,
      new ChoiceRenderer("text","id"));   
    */  
    add(choice);
    add(new TextField("m"));
    add(new TextField("n"));
  }   

  @Override 
  protected void onSubmit(){
    ProblemModel pm=(ProblemModel)getModelObject();
    setResponsePage(new OutputPage(pm));
  }  
}
