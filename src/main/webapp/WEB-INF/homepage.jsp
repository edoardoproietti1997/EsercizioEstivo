<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Homepage</title>
</head>
<body>
<h1>Bentornato, <%=request.getParameter("username")%></h1>
<h3>seleziona l'azione da compiere</h3>

<form action="/homepage" method= "POST">
  <select name="option">
    <option value="visualizza transazioni">Visulizza transazione</option>
    <option value="modifica transazione(Create Read Update Delete)">Modifica transazione</option>
  </select>
   <br><br>
  <input type="submit">
</form>
</body>
</html>
