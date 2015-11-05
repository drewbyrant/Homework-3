/*
Copyright 2015 Drew Bryant and Patrick Lathan
 */
package business;

import java.util.ArrayList;

/**
 *
 * @author drewbryant
 */
public class Calculator {
  private double amount;
  private double rate;
  private double futureAmount;
  private int years;
  private ArrayList<Double> futureAmounts;
  
  public Calculator(){
    amount = 0;
    rate = 0;
    years = 0;
    futureAmount = 0;
    futureAmounts = new ArrayList<>(years);
  }
  public Calculator(double newAmount, double newRate, int newYears){
    this.amount = newAmount;
    this.rate = newRate;
    this.years = newYears;
    this.futureAmount = 0;
    this.futureAmounts = new ArrayList<>(years);
  }
  /**
   * Sets amount if param is >= 0
   * @param newAmount 
   */
  public void setAmount(double newAmount){
    if(newAmount >= 0){
      this.amount = newAmount;
      return;
    }
    this.amount = 0;
  }
  /**
   * 
   * @return amount
   */
  public double getAmount(){
    return this.amount;
  }
  public void setRate(double rate){
    if(rate >= 0 && rate <= 100){
      this.rate = rate;
      return;
    }
    this.rate = 0;
  }
  public double getRate(){
    return this.rate;
  }
  public void setYears(int years){
    if(years >= 0){
      this.years = years;
      return;
    }
    this.years = 0;
  }
  public int getYears(){
    return this.years;
  }
  public void setFutureAmount(double future){
    this.futureAmount = future;
  }
  public double getFutureAmount(){
    return this.futureAmount;
  }
  public void setFutureAmounts(ArrayList<Double> amounts){
    this.futureAmounts = amounts;
  }
  public ArrayList<Double> getFutureAmounts(){
    return this.futureAmounts;
  }
  /**
   * Calculates the future value based on the investment amount, interest rate
   * and number of years
   * @return The amount of money in the account after the specified number of 
   * years
   */
  public double calculate(){
    int intAmount;
    double newRate = rate/100;
    futureAmount = amount;
    for(int i = 1; i <= years; i++){
      futureAmount += futureAmount * newRate;
      futureAmount = futureAmount * 100;
      intAmount = (int)futureAmount;
      futureAmount = (double)intAmount / 100;
      futureAmounts.add(futureAmount);
    }
    
    return futureAmount;
  }
}
