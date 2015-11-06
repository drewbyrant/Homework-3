<!DOCTYPE html>
<!--
Copyright 2015 Drew Bryant and Patrick Lathan
-->
<html>
  <head>
    <meta charset="utf-8" contentType="text/html">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Homework 3</title>
    <link rel="stylesheet" href="styles/main/css" type="text/css">
    <%@ page contentType="text/html" %>
  </head>
  <body>
    <%@ include file="/includes/header.html" %>
    <div>
      <form action="calculate" method="post">
        <input type="hidden" name="action" value="calculate">
        <label>Investment Amount</label>
        <br class="rwd">
        <input type="number" name="amount" min="0" value="${amount}" required>
        <br>
        <label>Yearly Interest Rate</label>
        <br class="rwd">
        <input type="number" name="rate" min="0" max="100" value="${rate}" required>
        <br>
        <label>Number of Years</label>
        <br class="rwd">
        <input type="number" name="years" min="0" 
               placeholder="Integer number of years" required>
        <br>
        <label class="noshow">Submit</label>
        <input type="submit" value="Calculate">
      </form>
    </div>
  <%@ include file="/includes/footer.html" %>
  </body>
</html>