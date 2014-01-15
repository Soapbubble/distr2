package cmmdc;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class OutputPage extends WebPage{
  public OutputPage(ProblemModel pm){
    add(new Label("m",pm.getM()));
    add(new Label("n",pm.getN()));
    add(new Label("scop",pm.getScop()));
    add(new Label("result",pm.getResult()));
  }
}
