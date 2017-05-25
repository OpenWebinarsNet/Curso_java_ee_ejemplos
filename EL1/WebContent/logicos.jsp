<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>JSP 2.0 Expression Language - Basic Comparisons</h1>
    <hr>
    This example illustrates basic Expression Language comparisons.
    The following comparison operators are supported:
    <ul>
      <li>Less-than (&lt; or lt)</li>
      <li>Greater-than (&gt; or gt)</li>
      <li>Less-than-or-equal (&lt;= or le)</li>
      <li>Greater-than-or-equal (&gt;= or ge)</li>
      <li>Equal (== or eq)</li>
      <li>Not Equal (!= or ne)</li>
    </ul>
    <blockquote>
      <u><b>Numeric</b></u>
      <code>
        <table border="1">
          <thead>
          <td><b>EL Expression</b></td>
          <td><b>Result</b></td>
          </thead>
          <tr>
            <td>\${1 &lt; 2}</td>
            <td>${1 < 2}</td>
          </tr>
          <tr>
            <td>\${1 lt 2}</td>
            <td>${1 lt 2}</td>
          </tr>
          <tr>
            <td>\${1 &gt; (4/2)}</td>
            <td>${1 > (4/2)}</td>
          </tr>
          <tr>
            <td>\${1 gt (4/2)}</td>
            <td>${1 gt (4/2)}</td>
          </tr>
          <tr>
            <td>\${4.0 &gt;= 3}</td>
            <td>${4.0 >= 3}</td>
          </tr>
          <tr>
            <td>\${4.0 ge 3}</td>
            <td>${4.0 ge 3}</td>
          </tr>
          <tr>
            <td>\${4 &lt;= 3}</td>
            <td>${4 <= 3}</td>
          </tr>
          <tr>
            <td>\${4 le 3}</td>
            <td>${4 le 3}</td>
          </tr>
          <tr>
            <td>\${100.0 == 100}</td>
            <td>${100.0 == 100}</td>
          </tr>
          <tr>
            <td>\${100.0 eq 100}</td>
            <td>${100.0 eq 100}</td>
          </tr>
          <tr>
            <td>\${(10*10) != 100}</td>
            <td>${(10*10) != 100}</td>
          </tr>
          <tr>
            <td>\${(10*10) ne 100}</td>
            <td>${(10*10) ne 100}</td>
          </tr>
        </table>
      </code>
      
    </blockquote>
  </body>
</html>
