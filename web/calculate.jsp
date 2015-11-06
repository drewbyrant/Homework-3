<!DOCTYPE html>
<%--
Copyright 2015 Drew Bryant and Patrick Lathan
--%>
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
   
      <script>
        var content = document.querySelector('link[rel="import"]').import;
        var footerLine = content.querySelector('#footerLine');
        document.body.appendChild(footerLine.cloneNode(true));
      </script>
  </body>
</html>
