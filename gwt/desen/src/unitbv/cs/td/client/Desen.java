package unitbv.cs.td.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import org.gwtwidgets.client.style.Color;
import org.gwtwidgets.client.wrap.JsGraphicsPanel;

class MyFunction{
  double a=-Math.PI/10;
  double b=Math.PI/10;
  
  double fct(double x){
    return Math.sin(1/x);
  }
}

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Desen implements EntryPoint {
  
  int[][] pregatire(int width,int height,int n){
    MyFunction myf=new MyFunction();
    double h=(myf.b-myf.a)/n;
    double[] x=new double[n+1];
    double[] y=new double[n+1];
    for(int i=0;i<=n;i++){
      x[i]=myf.a+i*h;
      y[i]=myf.fct(x[i]);
    }
    double min=y[0],max=y[0];
    for(int i=1;i<=n;i++){
      if(y[i]<min)min=y[i];
      if(y[i]>max)max=y[i];
    }
    int[][] r=new int[2][n+1];
    for(int i=0;i<=n;i++){
      r[0][i]=(int)Math.round(width*(x[i]-x[0])/(x[n]-x[0]));
      r[1][i]=(int)Math.round(height*(y[i]-min)/(max-min));
    }
    return r;
  }
  
  /**
   * This is the entry point method.
   */
  public void onModuleLoad(){
    JsGraphicsPanel p = new JsGraphicsPanel("g");

    int width=350;
    int height=290;
    int n=100;
    int[][] data=pregatire(width,height,n);
    //int[][] data={{10,60,90,120,150},{10,80,100,20,150}};
    
    int[] xPoints = new int[n+1];
    int[] yPoints = new int[n+1];

    // Valoarea 151 adaugata la ordonata s-a determinat prin incercari
    // in modul gazduit (hosted)
    for (int i = 0; i <= n; i++) {
      xPoints[i] = data[0][i];
      yPoints[i] = height-data[1][i]+151;
    }

    p.setColor(Color.BLUE);
    p.setStrokeWidth(2);
    p.drawPolyline(xPoints, yPoints);
    p.paint();
    RootPanel.get().add(p);
  }
}
