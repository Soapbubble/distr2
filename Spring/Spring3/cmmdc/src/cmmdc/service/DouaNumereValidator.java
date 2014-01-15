package cmmdc.service;

import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

import cmmdc.model.DouaNumere;

public class DouaNumereValidator implements Validator {

  public boolean supports(Class clazz) {
      return DouaNumere.class.equals(clazz);
  }

  public void validate(Object obj, Errors errors) {
      DouaNumere data = (DouaNumere) obj;
      String sm=data.getSm();
      if ((sm == null)||(sm.equals(""))) {
          //errors.rejectValue("sm","Camp necompletat", null,"Camp necompletat");
          errors.rejectValue("sm",null,"Camp necompletat");
      }
      else {
        try{
          long m=Long.parseLong(sm);
        }
        catch(NumberFormatException e){
          //errors.rejectValue("sm","Nu este numar",null,"Nu este numar");
          errors.rejectValue("sm",null,"Nu este numar");
        }
      }
      String sn=data.getSn();
      if ((sn == null)||(sn.equals(""))) {
          //errors.rejectValue("sn","Camp necompletat",null,"Camp necompletat");
          errors.rejectValue("sn",null,"Camp necompletat");
      }
      else {
        try{
          long n=Long.parseLong(sn);
        }
        catch(NumberFormatException e){
          //errors.rejectValue("sn","Nu este numar",null,"Nu este numar");
          errors.rejectValue("sn",null,"Nu este numar");
        }
      }
  }
}