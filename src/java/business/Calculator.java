/*
Copyright 2015 Drew Bryant and Patrick Lathan
 */
package business;

import java.util.ArrayList;

/**
 * Calculator JavaBean with no-argument constructor and getters/setters for all
 * private instance variables
 * @author drewbryant
 */
public class Calculator {
  private double amount;
  private double rate;
  private double futureAmount;
  private int years;
  private ArrayList<Double> futureAmounts;
  
  /**
   * No-argument constructor for Calculator; sets all variables to 0
   */
  public Calculator(){
    amount = 0;
    rate = 0;
    years = 0;
    futureAmount = 0;
    futureAmounts = new ArrayList<>(years);
  }
  /**
   * 3-argument constructor
   * @param newAmount Amount of money being deposited
   * @param newRate Interest rate on the money
   * @param newYears Number of years the money will remain in the bank
   */
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
   * Getter for amount
   * @return amount
   */
  public double getAmount(){
    return this.amount;
  }
  /**
   * Sets rate if param is >= 0
   * @param rate 
   */
  public void setRate(double rate){
    if(rate >= 0 && rate <= 100){
      this.rate = rate;
      return;
    }
    this.rate = 0;
  }
  /**
   * Getter for rate
   * @return rate
   */
  public double getRate(){
    return this.rate;
  }
  /**
   * Sets years if param >= 0
   * @param years 
   */
  public void setYears(int years){
    if(years >= 0){
      this.years = years;
      return;
    }
    this.years = 0;
  }
  /**
   * Getter for years
   * @return years
   */
  public int getYears(){
    return this.years;
  }
  /**
   * Setter for futureAmount
   * @param future 
   */
  public void setFutureAmount(double future){
    this.futureAmount = future;
  }
  /**
   * Getter for futureAmount
   * @return futureAmount
   */
  public double getFutureAmount(){
    return this.futureAmount;
  }
  /**
   * Setter for futureAmounts
   * @param amounts 
   */
  public void setFutureAmounts(ArrayList<Double> amounts){
    this.futureAmounts = amounts;
  }
  /**
   * Getter for futureAmounts
   * @return futureAmounts
   */
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
