<!DOCTYPE html>
<%--
Copyright 2015 Drew Bryant and Patrick Lathan
--%>
<html>
  <head>
    <%@ page contentType="text/html" %>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Homework 3</title>
    <link rel="stylesheet" href="styles/main/css" type="text/css">
  </head>
<%@ include file="/includes/header.html" %>
      <label>Investment Amount</label>
      <span>${calc.amount}</span>
      <br>
      <label>Yearly Interest Rate</label>
      <span>${calc.rate}</span>
      <br>
      <label>Number of Years</label>
      <span>${calc.years}</span>
      <br>
      
      
    <%@ taglib uri="/WEB-INF/tlds/murach.tld" prefix="elon" %>
    <table>
      <tr>
        <th>Year</th>
        <th>Value</th>
      </tr>
      <elon:currencyFormat>
        <tr>
          <td>${year}</td>
          <td>${amount}</td>
        </tr>
      </elon:currencyFormat>
    </table>
    <a href="index.jsp">Return to Calculator</a>
   
    <%@ include file="/includes/footer.html" %>
  </body>
</html>
