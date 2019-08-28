<%@page import="it.dstech.db.DBConnection"%>
<%@page import="javax.swing.text.StyledEditorKit.ForegroundAction"%>
<%@page import="it.dstech.model.Transazioni"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
<form action="/visualizzaTransazioni">
<% DBConnection db = new DBConnection();
String username =(String)request.getAttribute("username");
int id = db.recoverId(username);
List<Transazioni> lista = db.transazioneObjectBySQL(id);
for(int i = 0 ; i < lista.size() ; i++) { %>
	<%=lista.get(i).toString()%>
<%}%>
</form>
</body>
</html>