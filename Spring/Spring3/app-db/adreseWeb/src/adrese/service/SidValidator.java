package adrese.service;

import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

import adrese.model.AppData;

public class SidValidator implements Validator {

  public boolean supports(Class clazz) {
      return AppData.class.equals(clazz);
  }

  public void validate(Object obj, Errors errors) {
    AppData data = (AppData) obj;
    //String operatia=data.getOperatia();
    String errorMsg;
    errorMsg=verifSid(data.getSid());
    if(!errorMsg.equals("")){     
      errors.rejectValue("sid",null,errorMsg);
    }
  }
  
  private String verifSid(String sid){
    String msg="";
    if ((sid == null)||(sid.equals(""))) {
       msg="Camp necompletat";
    }
    else {
      try{
        int id=Integer.parseInt(sid);
      }
      catch(NumberFormatException e){
        msg="Nu este numar";
      }
    }
    return msg;
  }
}