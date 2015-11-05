/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import business.Calculator;
import business.Test;
import java.text.DecimalFormat;


/**
 *
 * @author drewbryant
 */
public class CurrencyFormatTag extends BodyTagSupport{
  private Iterator iterator;
  private ArrayList<Double> amountArray;
  private double amount;
  private int year = 1;
  @Override
  public int doStartTag(){
    Calculator calc = (Calculator) pageContext.findAttribute("calc");
    amountArray = calc.getFutureAmounts();
    /*double amount = calc.getFutureAmount();
    DecimalFormat formatter = new DecimalFormat("#,###.00");
    String amountString = formatter.format(amount);
    amountString = "$" + amountString;
    
    try{
     JspWriter out = pageContext.getOut();
      out.print(amountString);
    }catch(IOException ioe){
      System.out.println(ioe);
    }
    */
    //year = 0;
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
    /*Product p = item.getProduct();
    pageContext.setAttribute(
      "productCode", p.getCode());
    pageContext.setAttribute(
      "productDescription", p.getDescription());
    pageContext.setAttribute(
      "productPrice", p.getPriceCurrencyFormat());
    pageContext.setAttribute(
      "quantity", new Integer(item.getQuantity()));
    pageContext.setAttribute(
      "total", item.getTotalCurrencyFormat());
    */
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
