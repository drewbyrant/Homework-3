/*
Copyright 2015 Drew Bryant and Patrick Lathan
 */
package tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import business.Calculator;

public class CurrencyFormatTag extends BodyTagSupport{
  private Iterator iterator;
  private ArrayList<Double> amountArray;
  private double amount;
  private int year = 1;
  @Override
  public int doStartTag(){
    Calculator calc = (Calculator) pageContext.findAttribute("calc");
    amountArray = calc.getFutureAmounts();
    if(amountArray.size() <= 0){
      return SKIP_BODY;
    }else{
      return EVAL_BODY_BUFFERED;
    }
  }
  
  @Override
  public void doInitBody() throws JspException {
    iterator = amountArray.iterator();
    
    if (iterator.hasNext()) {
      //year++;
      amount = (Double) iterator.next();
      this.setDoubleAttributes(amount);
    }
  }

  private void setDoubleAttributes(Double amount) {
    pageContext.setAttribute(
      "year", year);
    pageContext.setAttribute(
      "amount", amount);
  }

  @Override
  public int doAfterBody() throws JspException {
    try {
      if (iterator.hasNext()) {
        year++;
        amount = (Double) iterator.next();
        this.setDoubleAttributes(amount);
        return EVAL_BODY_AGAIN;
      } else {
        year = 1;
        JspWriter out = bodyContent.getEnclosingWriter();
        bodyContent.writeOut(out);
        return SKIP_BODY;
      }
    } catch (IOException ioe) {
      System.err.println("error in doAfterBody " + ioe.getMessage());
      return SKIP_BODY;
    }
  }
}
