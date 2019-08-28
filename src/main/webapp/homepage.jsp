<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
	<h1>Bentornato</h1>
	<h3>Seleziona l'azione da compiere:</h3>
	<%=request.getAttribute("successo")%>
	
	<form action="/homepage">

		<h5>Modifica o aggiungi una nuova transazione</h5>
		<a href="/modificaTransazioni.jsp">Modifica le tue transazioni</a>

		<h5>Controlla le tue finanze ormai al verde:</h5>
		<a href="/visualizzaTransazioni.jsp">Visualizza le tue transazioni</a>

		<h5>Modifica le categorie di spesa o di guadagno</h5>
		<a href="/modificacategorie.jsp">Modifica categorie</a>


	</form>
</body>
</html>
